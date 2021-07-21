package com.hang.app.message.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hang.app.JDBC;
import com.hang.app.message.MessageService;
import com.hang.app.message.MessageVO;

@Repository("messageDAO")
public class MessageDAO implements MessageService {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<MessageVO> getMessageList(MessageVO vo) {
		String sql = "select * from message";
		System.out.println("getMessageList() : 동작 시작");
		MessageVO data = null;
		ArrayList<MessageVO> list = new ArrayList<MessageVO>();
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				data = new MessageVO();
				data.setMid(Integer.parseInt(rs.getString("mid")));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("getMessageList() : 동작 종료");
		return list;
	}

	@Override
	public MessageVO getMessage(MessageVO vo) {
		String sql = "select * from Message where mid=?";
		System.out.println("getMessage() : 동작 시작");
		MessageVO data = null;
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new MessageVO();
				data.setMid(Integer.parseInt(rs.getString("mid")));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

		System.out.println("getMessage() : 동작 종료");
		return data;
	}

	@Override
	public void insertMessage(MessageVO vo) {
		String sql = "insert into message(mid,writer,content) values((select nvl(max(mid),0)+1 from message),?,?)";
		System.out.println("insertMessage() : 동작 시작");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("insertMessage() : 동작 종료");
	}

	@Override
	public void updateMessage(MessageVO vo) {
		String sql = "update message set writer=?,content=? where mid=?";
		System.out.println("updateMessage() : 동작 시작");
		System.out.println("DAO messageVO : "+vo);
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, vo.getMid());
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateMessage() : 동작 종료");
	}

	@Override
	public void deleteMessage(MessageVO vo) {
		String sql = "delete from message where mid=?";
		System.out.println("deleteMessage() : 동작 시작");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("deleteMessage() : 동작 종료");
	}

}
