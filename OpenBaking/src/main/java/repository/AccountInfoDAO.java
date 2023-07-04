package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import DTO.AccountInfoDTO;

public class AccountInfoDAO {
    private DataSource ds;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String id = null, memberId = null, accountNumber = null, accountPassword = null,
            nickname = null, bankCode = null;
    int balance = 0, accountType = 1, accountStatus;
    Date regDate = null;

    public AccountInfoDAO() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 계좌 리스트 전부 불러오는 함수
    public ArrayList<AccountInfoDTO> getAllList() {
        ArrayList<AccountInfoDTO> dtos = new ArrayList<AccountInfoDTO>();
        
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM ACCOUNT_INFO");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getString("ID");
                memberId = rs.getString("MEMBER_ID");
                accountNumber = rs.getString("ACCOUNT_NUMBER");
                accountPassword = rs.getString("ACCOUNT_PASSWORD");
                balance = rs.getInt("BALANCE");
                nickname = rs.getString("NICKNAME");
                accountType = rs.getInt("ACCOUNT_TYPE");
                accountStatus = rs.getInt("ACCOUNT_STATUS");
                bankCode = rs.getString("BANK_CODE");
                regDate = rs.getDate("REG_DATE");

                AccountInfoDTO dto =
                        new AccountInfoDTO(id, memberId, accountNumber, accountPassword, balance,
                                nickname, accountType, accountStatus, bankCode, regDate);
                dtos.add(dto);
                System.out.println(dto);
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
        return dtos;
    }
}