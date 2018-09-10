package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.BankMapper;
import test.dao.InterestMapper;
import test.dao.LinterestMapper;
import test.entity.Bank;
import test.entity.Interest;
import test.entity.Linterest;

@Controller("bankController")
@RequestMapping("bank")
public class BankController {
	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private InterestMapper interestMapper;
	@Autowired
	private LinterestMapper linterestMapper;
	
	@RequestMapping("list")
	@ResponseBody
	public List<Bank> list(){
		return bankMapper.list();
	}
	
	@RequestMapping(value="interest",params="bId",method=RequestMethod.POST)
	@ResponseBody
	public int addInterest(Integer bId,@RequestBody Interest interest){
		interestMapper.insertSelective(interest);
		return interestMapper.insertToLink(bId, interest.getiId());
	}
	
	@RequestMapping(value="interest",params="iId",method=RequestMethod.GET)
	@ResponseBody
	public Interest getInterest(Integer iId){
		return interestMapper.selectByPrimaryKey(iId);
	}
	
	@RequestMapping(value="interest",params="iId",method=RequestMethod.POST)
	@ResponseBody
	public int updateInterest(@RequestBody Interest interest){
		return interestMapper.updateByPrimaryKeySelective(interest);
	}
	
	@RequestMapping(value="interest",params="iId",method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteInterest(Integer iId){
		return interestMapper.deleteByPrimaryKey(iId);
	}
	
	@RequestMapping(value="linterest",method=RequestMethod.POST)
	@ResponseBody
	public int addLinterest(@RequestBody Linterest linterest){
		return linterestMapper.insertSelective(linterest);
	}
	
	@RequestMapping(value="linterest",method=RequestMethod.GET)
	@ResponseBody
	public List<Linterest> getLinterestList(){
		return linterestMapper.list();
	}
	
	
	@RequestMapping(value="linterest",params="lId",method=RequestMethod.GET)
	@ResponseBody
	public Linterest getLinterest(Integer lId){
		return linterestMapper.selectByPrimaryKey(lId);
	}
	
	@RequestMapping(value="linterest",params="lId",method=RequestMethod.POST)
	@ResponseBody
	public int updateLnterest(@RequestBody Linterest linterest){
		return linterestMapper.updateByPrimaryKeySelective(linterest);
	}
	
	@RequestMapping(value="linterest",params="lId",method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteLinterest(Integer lId){
		return linterestMapper.deleteByPrimaryKey(lId);
	}
}
