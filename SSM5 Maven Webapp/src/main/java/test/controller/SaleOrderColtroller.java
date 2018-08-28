package test.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.SaleOrderMapper;
import test.entity.SaleOrder;

@Controller
@RequestMapping("saleorder")
public class SaleOrderColtroller {
	@Autowired
	private SaleOrderMapper saleOrderMapper;
	
	@RequestMapping("list")
	@ResponseBody
	public HashMap<String, Object> list(@Nullable Date begin,@Nullable Date end){
		List<SaleOrder> result = null ;
		HashMap<String,Date> paramsMap = new HashMap<String, Date>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		paramsMap.put("begin", begin);
		paramsMap.put("end", end);
		result = saleOrderMapper.list(paramsMap);
		
		resultMap.put("data", result);
		return resultMap;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public int add(){
		SaleOrder saleOrder=new SaleOrder();

		return saleOrderMapper.insert(saleOrder);
	}
	
	@RequestMapping("detail")
	@ResponseBody
	public HashMap<String, Object> getDetail(String id){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("data", saleOrderMapper.selectByPrimaryKey(id));
		return resultMap;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	@Transactional
	public void remove(@RequestBody String[] ids){
		for(String id : ids){
			saleOrderMapper.deleteByPrimaryKey(id);
		}
	}
}
