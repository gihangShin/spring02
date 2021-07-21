package com.hang.app.members;

import java.util.List;

public interface MembersService {
	public MembersVO getMembers(MembersVO vo);

	public List<MembersVO> getMembersList(MembersVO vo);

	public void insertMembers(MembersVO vo);

	public void deleteMembers(MembersVO vo);

	public void updateMembers(MembersVO vo);
}
