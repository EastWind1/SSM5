package test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.PayMapper;
import test.dao.PaydetailMapper;
import test.entity.Pay;
import test.entity.Paydetail;

@Controller
@RequestMapping("pay")
public class PayController {
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private PaydetailMapper paydetailMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Pay> list(@Nullable String begin, @Nullable String end) {
        HashMap params = new HashMap();
        if (begin != null && end != null) {
            params.put("begin", begin);
            params.put("end", end);
        }
        return payMapper.list(params);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Pay selectById(@PathVariable String id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int save(@RequestBody Pay pay) {
        if (pay.getId() != null) {
            paydetailMapper.deleteByPayId(pay.getId());
            if (payMapper.selectByPrimaryKey(pay.getId()) != null)
                payMapper.deleteByPrimaryKey(pay.getId());
            payMapper.insertSelective(pay);

            for (Paydetail paydetail : pay.getPaydetails()) {
                paydetailMapper.insertSelective(paydetail);
                paydetailMapper.insertToLink(pay.getId(), paydetail.getId());
            }
        }
        return 1;
    }
}
