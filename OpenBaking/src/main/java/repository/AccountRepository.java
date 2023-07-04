package repository;

import DTO.AccountInfoDTO;
import DTO.AccountTransferInfoDTO;

public interface AccountRepository {
    AccountInfoDTO getAccount(String accountNumber);
    void update(AccountInfoDTO account);
    void insertTransferInfo(AccountTransferInfoDTO transferInfo);
}