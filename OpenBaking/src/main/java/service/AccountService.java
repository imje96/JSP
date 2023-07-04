package service;

import DTO.AccountInfoDTO;
import DTO.AccountTransferInfoDTO;

public interface AccountService {
    void transfer(AccountInfoDTO fromAccount, AccountInfoDTO toAccount, int amount, AccountTransferInfoDTO transferInfo);
}