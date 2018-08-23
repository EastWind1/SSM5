package test.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.entity.Account;
import test.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Account> list(){
		return accountService.getAccounts();
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Account add(@RequestBody Account account){
		try{
			accountService.addAccount(account);
		}
		catch(Exception e){
			account = null;
		}
		return account;
	}
	
	@RequestMapping("/audit")
	@ResponseBody
	public boolean audit(String ids,Integer state){
		String[] idslist = ids.split(",");
		int[] idlist = new int[idslist.length];
		for(int i = 0; i< idslist.length; i++){
			if(!idslist.equals(""))
				idlist[i] = Integer.parseInt(idslist[i]);
		}
		
		boolean result = false;
		try{
			for(int id:idlist){
				Account account = new Account();
				account.setId(id);
				account.setState(state);
				accountService.audit(account);
			}
			result = true;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
}
