package test.service;

import java.util.List;

import test.entity.Account;

public interface AccountService {
	public List<Account> getAccounts();
	public boolean audit(Account account);
	public boolean addAccount(Account account);
}
