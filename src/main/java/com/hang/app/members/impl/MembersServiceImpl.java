package com.hang.app.members.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hang.app.members.MembersService;
import com.hang.app.members.MembersVO;

@Service("MembersService")
public class MembersServiceImpl implements MembersService {

	@Autowired
	MembersDAO membersDAO;

	@Override
	public MembersVO getMembers(MembersVO vo) {
		return membersDAO.getMembers(vo);
	}

	@Override
	public List<MembersVO> getMembersList(MembersVO vo) {
		return membersDAO.getMembersList(vo);
	}

	@Override
	public void insertMembers(MembersVO vo) {
		membersDAO.insertMembers(vo);
	}

	@Override
	public void deleteMembers(MembersVO vo) {
		membersDAO.deleteMembers(vo);
	}

	@Override
	public void updateMembers(MembersVO vo) {
		membersDAO.updateMembers(vo);
	}

}
