package service;


import DTO.AccountInfoDTO;
import DTO.AccountTransferInfoDTO;
import repository.AccountDAO;



public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;
    public AccountServiceImpl() {
        this.accountDAO = new AccountDAO();
    }
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void transfer(AccountInfoDTO fromAccount, AccountInfoDTO toAccount, int amount, AccountTransferInfoDTO transferInfo) {
        // 출금
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountDAO.update(fromAccount);

        // 입금
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDAO.update(toAccount);
        
        
        // 출금 계좌의 거래 정보 생성 및 저장
        AccountTransferInfoDTO fromTransferInfo = new AccountTransferInfoDTO();
        
        fromTransferInfo.setAccountNumber1(transferInfo.getAccountNumber1());
        fromTransferInfo.setAccountNumber2(transferInfo.getAccountNumber2());
        fromTransferInfo.setTranAmt(amount);
        fromTransferInfo.setContent("Transfer to " + toAccount.getAccountNumber());
        fromTransferInfo.setInoutType("O"); // 출금
        accountDAO.insertTransferInfo(fromTransferInfo);

        // 입금 계좌의 거래 정보 생성 및 저장
        AccountTransferInfoDTO toTransferInfo = new AccountTransferInfoDTO();
        
        toTransferInfo.setAccountNumber1(transferInfo.getAccountNumber2());
        toTransferInfo.setAccountNumber2(transferInfo.getAccountNumber1());
        toTransferInfo.setTranAmt(amount);
        toTransferInfo.setContent("Transfer from " + fromAccount.getAccountNumber());
        toTransferInfo.setInoutType("I"); // 입금
        
        accountDAO.insertTransferInfo(toTransferInfo);
    }
}