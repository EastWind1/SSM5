package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.FundMapper;
import test.entity.Fund;


@Controller
@RequestMapping("/fund")
public class FundConroller {
    @Autowired
    private FundMapper fundMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Fund> list() {
        return fundMapper.list();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public int insert(@RequestBody Fund fund) {
        return fundMapper.insertSelective(fund);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public int update(@RequestBody Fund fund) {
        return fundMapper.updateByPrimaryKey(fund);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(@PathVariable String id) {
        return fundMapper.deleteByPrimaryKey(id);
    }
}
