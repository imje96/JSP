package com.daodto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
    
	private String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
	private String uid = "scott";
	private String upw = "tiger";

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<MemberDTO> memberAllSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	   public MemberDTO memberSelect(String uId) {
	        
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        MemberDTO dto = null;
	        try {
	            conn = DriverManager.getConnection(url, uid, upw);
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("select * from member where id = '" + uId + "'");
	            
	            while(rs.next()) {
	                String name = rs.getString("name");
	                String id = rs.getString("id");
	                String pw = rs.getString("pw");
	                String phone1 = rs.getString("phone1");
	                String phone2 = rs.getString("phone2");
	                String phone3 = rs.getString("phone3");
	                String gender = rs.getString("gender");
	                
	                dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
	                
	            }
	            
	        } catch(Exception e) {
	            
	        } finally {
	            try {
	                
	                if(rs != null) rs.close();
	                if(stmt != null) stmt.close();
	                if(conn != null) conn.close();
	            } catch(Exception e) {
	                e.printStackTrace();
	            }
	        }
	        
	        return dto;
	    }
	   public void memberInsert(MemberDTO memberDTO) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        String name = memberDTO.getName();
	        String id = memberDTO.getId();
	        String pw = memberDTO.getPw();
	        String phone1 = memberDTO.getPhone1();
	        String phone2 = memberDTO.getPhone2();
	        String phone3 = memberDTO.getPhone3();
	        String gender = memberDTO.getGender();
	        String query =
	                "insert into member(id, pw, name, phone1, phone2, phone3, gender)  values( ?, ?, ?, ?, ?, ?, ? )";

	        try {
	            // conn = DriverManager.getConnection(url, uid, upw);
	        	conn = DriverManager.getConnection(url, uid, upw);
	        	pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, id);
	            pstmt.setString(2, pw);
	            pstmt.setString(3, name);
	            pstmt.setString(4, phone1);
	            pstmt.setString(5, phone2);
	            pstmt.setString(6, phone3);
	            pstmt.setString(7, gender);
	            int iResult = pstmt.executeUpdate();

	            if (iResult >= 1) {
	                System.out.println("insert success");

	            } else {
	                System.out.println("insert fail");
	            }
	        } catch (Exception e) {

	        } finally {
	            try {
	                if (rs != null)
	                    rs.close();
	                if (pstmt != null)
	                    pstmt.close();
	                if (conn != null)
	                    conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	    }

	   	
	   
	    public boolean loginCheck(String ckId, String ckPw) {
	        boolean status = false;

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        MemberDTO dto = null;
	        try {
	            // conn = DriverManager.getConnection(url, uid, upw);
	        	conn = DriverManager.getConnection(url, uid, upw);
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * FROM member");

	            while (rs.next()) {
	                String id = rs.getString("ID");
	                String pw = rs.getString("PW");
	                String name = rs.getString("NAME");
	                if (ckId.equals(id)&& ckPw.equals(pw)) {

	                    status = true;

	                } else {
	                    System.out.println("login fail");
	                   
	                }
	            }

	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        } finally {
	            try {

	                if (rs != null)
	                    rs.close();
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return status;
	    }


	   
	   
	public void memberUpdate(MemberDTO memberDTO) {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String name = memberDTO.getName();
        String id = memberDTO.getId();
        String pw = memberDTO.getPw();
        String phone1 = memberDTO.getPhone1();
        String phone2 = memberDTO.getPhone2();
        String phone3 = memberDTO.getPhone3();
        String gender = memberDTO.getGender();
        String query = "update member set pw = ?, phone1 = ?, phone2 = ?, phone3 = ?, gender = ?  where id = ?";
        
        try {
            conn = DriverManager.getConnection(url, uid, upw);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pw);
            pstmt.setString(2, phone1);
            pstmt.setString(3, phone2);
            pstmt.setString(4, phone3);
            pstmt.setString(5, gender);
            pstmt.setString(6, id);
            
            int iResult = pstmt.executeUpdate();
            
            if( iResult >=  1 ) {
                System.out.println("update success");
                
            } else {
                System.out.println("update fail");
            }
        } catch(Exception e) {
            
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}