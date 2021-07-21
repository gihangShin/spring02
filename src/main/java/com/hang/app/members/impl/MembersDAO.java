package com.hang.app.members.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hang.app.JDBC;
import com.hang.app.members.MembersService;
import com.hang.app.members.MembersVO;

@Repository("membersDAO")
public class MembersDAO implements MembersService {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public MembersVO getMembers(MembersVO vo) {
		String sql = "select * from members where id=?,pw=?";
		System.out.println("getMembers() : 동작 시작");
		MembersVO data = null;
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new MembersVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

		System.out.println("getMembers() : 동작 종료");
		return data;
	}

	@Override
	public List<MembersVO> getMembersList(MembersVO vo) {
		String sql = "select * from members";
		System.out.println("getMembersList() : 동작 시작");
		MembersVO data = null;
		ArrayList<MembersVO> list = new ArrayList<MembersVO>();
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				data = new MembersVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("getMembersList() : 동작 종료");
		return list;
	}

	@Override
	public void insertMembers(MembersVO vo) {
		String sql = "insert into members(id,password,role) values(?,?,?)";
		System.out.println("insertMembers() : 동작 시작");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getRole());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("insertMembers() : 동작 종료");
	}

	@Override
	public void deleteMembers(MembersVO vo) {
		String sql = "delete from members where id=?";
		System.out.println("deleteMembers() : 동작 시작");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("deleteMembers() : 동작 종료");
	}

	@Override
	public void updateMembers(MembersVO vo) {
		String sql = "update members set password=?,role=? where id=?";
		System.out.println("updateMembers() : 동작 시작");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getRole());
			pstmt.setString(3, vo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateMembers() : 동작 종료");
	}
}
