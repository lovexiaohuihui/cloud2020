package com.bochao.service;

import com.bochao.dao.AccountDao;
import com.bochao.domain.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     * 扣钱操作
     * */
    public void deductMoney(String userId, Double money) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Account account = accountDao.getAccountByUserId(userId);
        account.setUsed(account.getUsed() + money);
        account.setResidue(account.getResidue() - money);
        accountDao.deductMoney(account);
    }
}
