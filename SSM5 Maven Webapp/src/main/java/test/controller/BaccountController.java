package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.BaccountMapper;
import test.entity.Baccount;


@Controller
@RequestMapping("/baccount")
public class BaccountController {
	@Autowired
	private BaccountMapper baccountMapper;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public List<Baccount> list(){
		return baccountMapper.list();
	}
}
