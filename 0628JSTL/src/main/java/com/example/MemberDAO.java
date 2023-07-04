package com.example;
package com.daodto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	String url = "jdbc:oracle:thin:@dinkdb_medium?TNS_ADMIN=C:/oracle/Wallet_DinkDB";
	String uid = "DA2316";
	String upw = "Data2316";

	// private DataSource ds;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		}
		/*
		 * Context ctx = new InitialContext(); ds = (DataSource)
		 * ctx.lookup("java:comp/env/jdbc/Oracle11g");
		 */
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> allSelectMember() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM userdb");

			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String rights = rs.getString("rights");

				MemberDTO dto = new MemberDTO(name, id, pw, phone, email, status, rights);
				dtos.add(dto);
			}
		} catch (Exception e) {

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

		return dtos;
	}

	public ArrayList<MemberDTO> adminSelectMember() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM userdb WHERE rights LIKE 'user'");

			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String rights = rs.getString("rights");

				MemberDTO dto = new MemberDTO(name, id, pw, phone, email, status, rights);
				dtos.add(dto);
			}
		} catch (Exception e) {

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

		return dtos;
	}
	
	public MemberDTO selectMember(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		String query = "SELECT * FROM  userdb WHERE id = '" + id + "'";
		int result = 0;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// int iResult = pstmt.executeUpdate();

			while (rs.next()) {
				String name = rs.getString("name");
				String newId = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String rights = rs.getString("rights");

				dto = new MemberDTO(name, newId, pw, phone, email, status, rights);

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

		return dto;
	}

	
	
	public int memberInsert(MemberDTO memberDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		String name = memberDTO.getName();
		String id = memberDTO.getId();
		String pw = memberDTO.getPw();
		String phone = memberDTO.getPhone();
		String email = memberDTO.getEmail();
		// String status = memberDTO.getStatus();
		// String rights = memberDTO.getRights();
		String status = "승인대기"; //
		String rights = "user";
		memberDTO.setStatus(status);
		memberDTO.setRights(rights);
		String query = "INSERT INTO userdb(id, pw, name, phone, email, status, rights) VALUES( ?, ?, ?, ?, ?, ?, ? )";

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, status);
			pstmt.setString(7, rights);
			result = pstmt.executeUpdate();

			if (result >= 1) {
				System.out.println("요청이 완료되었습니다.");

			} else {
				System.out.println("요청을 실패했습니다.");
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
		return result;

	}

	// 승인 요청 중인 회원을 조회하는 메서드 status=승인대기
	public ArrayList<MemberDTO> getPendingMembers() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> pendingMembers = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			stmt = conn.createStatement();

			String query = "SELECT * FROM userdb WHERE status LIKE '승인대기'";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String rights = rs.getString("rights");

				MemberDTO dto = new MemberDTO(name, id, pw, phone, email, status, rights);
				dtos.add(dto);
			}

		} catch (Exception e) {

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

		return dtos;
	}

	// 관리자가 회원 상태(status)를 업데이트하는 메서드
	public boolean approveMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success = false;

		String query = "UPDATE userdb SET status = ? WHERE id = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "정상");
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	public boolean checkUserLogin(String id, String pw) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isValidLogin = false;
		String query = "SELECT * FROM userdb WHERE id = ? AND pw = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isValidLogin = true;

			} else {
				System.out.println("login fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return isValidLogin;
	}

	public boolean checkAdminLogin(String id, String pw) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isValidLogin = false;
		String query = "SELECT * FROM userdb WHERE id = ? AND pw = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 로그인 성공 조건
				String dbId = rs.getString("id");
				String dbPw = rs.getString("pw");
				if (dbId.equals("admin") && dbPw.equals("admin1234"))
					isValidLogin = true;

			} else {
				System.out.println("login fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return isValidLogin;
	}

	// join
	public boolean joinCheck(String name, String id, String pw, String phone, String email) {
		boolean ck = false;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		try {

			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM userdb");

			while (rs.next()) {
				String ckId = rs.getString("id");
				String status = rs.getString("status");

				if (!id.equals(ckId) && status.equals("2")) {

					ck = true;

				} else {
					System.out.println("join fail");

				}
			}

		} catch (Exception e) {
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
		return ck;
	}

	// 회원 탈퇴 신청 
	public int withdrawlRequest(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "UPDATE userdb SET status = ? WHERE id = ?";

		int result = 0;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, "탈퇴요청");
			pstmt.setString(2, id);
			// SQL 쿼리 실행
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// 회원 탈퇴 신청 회원 리스트 조회
		public ArrayList<MemberDTO> deleteList() {
			ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<MemberDTO> deleteList = new ArrayList<>();

			try {
				conn = DriverManager.getConnection(url, uid, upw);
				// conn = ds.getConnection();
				stmt = conn.createStatement();

				String query = "SELECT * FROM userdb WHERE status LIKE '일시정지'";

				rs = stmt.executeQuery(query);

				while (rs.next()) {
					String name = rs.getString("name");
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String status = rs.getString("status");
					String rights = rs.getString("rights");

					MemberDTO dto = new MemberDTO(name, id, pw, phone, email, status, rights);
					dtos.add(dto);
				}

			} catch (Exception e) {

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

			return dtos;
		}

	
	public int deleteMemeber(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "DELETE FROM userdb WHERE id = ?";
		int result = 0;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, id);
			// SQL 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return result;
	}

	public int updateMember(MemberDTO memberDTO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String name = memberDTO.getName();
		String id = memberDTO.getId();
		String pw = memberDTO.getPw();
		String phone = memberDTO.getPhone();
		String email = memberDTO.getEmail();
		String status = memberDTO.getStatus();
		String rights = memberDTO.getRights();
		String query = "UPDATE userdb SET name = ?, pw = ?, phone = ?, email = ?, status = ?, rights = ? where id = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			// conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, status);
			pstmt.setString(6, rights);
			pstmt.setString(7, id);

			int Result = pstmt.executeUpdate();

			if (Result >= 1) {
				System.out.println("update success");

			} else {
				System.out.println("update fail");
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
		return 0;
	}
}