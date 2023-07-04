package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.AccountInfoDTO;
import DTO.AccountTransferInfoDTO;

public class AccountRepositoryImpl implements AccountRepository {
    private final String DB_URL = "jdbc:oracle:thin:@192.168.119.119:1521:db";  // your database url
    private final String USER = "scott";  // your database username
    private final String PASS = "tiger";  // your database password
    public AccountRepositoryImpl() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public AccountInfoDTO getAccount(String accountNumber) {
        AccountInfoDTO account = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM account_info WHERE account_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account = new AccountInfoDTO();
                // populate account object from ResultSet
                account.setAccountNumber(rs.getString("account_number"));
                account.setMemberId(rs.getString("member_id"));
                account.setAccountPassword(rs.getString("account_password"));
                account.setBalance(rs.getInt("balance"));
                account.setNickname(rs.getString("nickname"));
                account.setAccountType(rs.getInt("account_type"));
                account.setAccountStatus(rs.getInt("account_status"));
                account.setBankCode(rs.getString("bank_code"));
                account.setRegDate(rs.getDate("reg_date"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void update(AccountInfoDTO account) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){

            String query = "UPDATE account_info SET balance = ? WHERE account_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, account.getBalance());
            pstmt.setString(2, account.getAccountNumber());

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertTransferInfo(AccountTransferInfoDTO transferInfo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){

            String query = "INSERT INTO account_transfer_info " +
                    "(id, account_number1, account_number2, tran_amt, content, inout_type) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, transferInfo.getId());
            pstmt.setString(2, transferInfo.getAccountNumber1());
            pstmt.setString(3, transferInfo.getAccountNumber2());
            pstmt.setInt(4, transferInfo.getTranAmt());
            pstmt.setString(5, transferInfo.getContent());
            pstmt.setString(6, transferInfo.getInoutType());
            

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}