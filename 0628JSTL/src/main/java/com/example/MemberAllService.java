package com.example;


import java.util.ArrayList;
import com.example.*;

public class MemberAllService implements Service {

	public MembersAllService() {

	}
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO mDAO = MemberDAO.getInstance();

		return mDAO.memberAllService();

	}
}
