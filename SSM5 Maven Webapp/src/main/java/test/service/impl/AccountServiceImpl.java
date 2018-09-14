package test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.AccountMapper;
import test.entity.Account;
import test.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper accountMapper;
	@Override
	public List<Account> getAccounts() {
		return accountMapper.selectAccounts();
	}

	@Override
	public boolean audit(Account account) {
		accountMapper.updateByPrimaryKeySelective(account);
		return true;
	}

	@Override
	public boolean addAccount(Account account) {
		accountMapper.insert(account);
		return true;
	}

}
