package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import test.dao.BaccountMapper;
import test.dao.CaccountMapper;
import test.entity.Baccount;
import test.entity.Caccount;

@Controller
@RequestMapping("/baccount")
public class BaccountController {
	@Autowired
	private BaccountMapper baccountMapper;
	@Autowired
	private CaccountMapper caccountMapper;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public List<Baccount> list(){
		return baccountMapper.list();
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Baccount baccount){
		if(baccountMapper.selectByPrimaryKey(baccount.getId())!=null){
			baccountMapper.updateByPrimaryKey(baccount);
		}
		else{
			baccountMapper.insert(baccount);
		}
		for (Caccount caccount: baccount.getCaccounts()) {
			if(caccountMapper.selectByPrimaryKey(caccount.getCid())!=null){
				caccountMapper.updateByPrimaryKey(caccount);
			}
			else{
				caccountMapper.insert(caccount);
			}
		}
	}
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public int delete(@PathVariable String id){
		return baccountMapper.deleteByPrimaryKey(id);
	}
}
