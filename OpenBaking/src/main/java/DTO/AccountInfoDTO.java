package DTO;

import java.util.Date;

public class AccountInfoDTO {
    private String accountNumber;
    private String memberId;
    private String accountPassword;
    private int balance;
    private String nickname;
    private int accountType;
    private int accountStatus;
    private String bankCode;
    private Date regDate;
    
    
	public AccountInfoDTO(String id, String memberId2, String accountNumber2, String accountPassword2, int balance2,
			String nickname2, int accountType2, int accountStatus2, String bankCode2, Date regDate2) {
		// TODO Auto-generated constructor stub
	}
	public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getAccountPassword() {
        return accountPassword;
    }
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getAccountType() {
        return accountType;
    }
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
    public int getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    
}