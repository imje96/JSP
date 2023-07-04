package com.example;

import java.util.ArrayList;

public interface Service {
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response);
		
}
