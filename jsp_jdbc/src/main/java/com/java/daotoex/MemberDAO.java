package com.java.daotoex;

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
		
		public ArrayList<MemberDTO> memberSelect() {
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
		// id 1개 값을 받아서 값을 가져오는 기능 구현 
		public MemberDTO getMemberById(String id) {
		    MemberDTO member = null;
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    
		    try {
		        conn = DriverManager.getConnection(url, uid, upw);
		        
		        String query = "SELECT * FROM members WHERE id=?";
		        pstmt = conn.prepareStatement(query);
		        pstmt.setString(1, id);
		        
		        rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
		            String name = rs.getString("name");
		            String pw = rs.getString("pw");
		            String phone1 = rs.getString("phone1");
		            String phone2 = rs.getString("phone2");
		            String phone3 = rs.getString("phone3");
		            String gender = rs.getString("gender");
		            
		            member = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pstmt != null) pstmt.close();
		            if (conn != null) conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    
		    return member;
		}

			
			
		
		// 조회한 값을 수정하는 부분을 넣기 
		//그냥 업데이트 쿼리 (String id ,~~~~) 
		
		public void modifyMember(String name, String id, String pw, String phone1, String phone2, String phone3, String gender) {
			Connection conn = null;
			Statement stmt = null;
			String query = "update member set name='" + name + "', phone1='" + phone1 + "', phone2='" + phone2 + "', phone3='" + phone3 + "', gender='" + gender + "' where id='" + id + "'";
			System.out.println("query: " + query);
			
			try {
				conn = DriverManager.getConnection(url, uid, upw);
				stmt = conn.createStatement();
				int rtValue = stmt.executeUpdate(query);
				
			} catch(Exception e) {
				
			} finally {
				try {
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	}