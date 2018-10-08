package test.controller;

import java.math.BigDecimal;
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

import test.dao.DeliveryMapper;
import test.dao.MaterialMapper;
import test.dao.SaleOrderMapper;
import test.entity.Delivery;
import test.entity.Material;
import test.entity.SaleOrder;

@Controller
@RequestMapping("saleorder")
public class SaleOrderColtroller {
    @Autowired
    private SaleOrderMapper saleOrderMapper;
    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String, Object> list(@Nullable Date begin, @Nullable Date end) {
        List<SaleOrder> result = null;
        HashMap<String, Date> paramsMap = new HashMap<String, Date>();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        paramsMap.put("begin", begin);
        paramsMap.put("end", end);
        result = saleOrderMapper.list(paramsMap);

        resultMap.put("data", result);
        return resultMap;
    }

    @RequestMapping("add")
    @ResponseBody
    public int add() {
        SaleOrder saleOrder = new SaleOrder();

        return saleOrderMapper.insert(saleOrder);
    }

    @RequestMapping("detail")
    @ResponseBody
    public HashMap<String, Object> getDetail(String id) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("data", saleOrderMapper.selectByPrimaryKey(id));
        return resultMap;
    }

    @RequestMapping("delete")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public void remove(@RequestBody String[] ids) {
        for (String id : ids) {
            SaleOrder saleOrder = saleOrderMapper.selectByPrimaryKey(id);
            for (Material material : saleOrder.getWl()) {
                materialMapper.deleteByPrimaryKey(material.getWlnm());
            }
            for (Delivery delivery : saleOrder.getJh()) {
                deliveryMapper.deleteByPrimaryKey(delivery.getJhnm());
            }
            saleOrderMapper.deleteByPrimaryKey(id);
        }
    }

    @RequestMapping("save")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public boolean save(@RequestBody SaleOrder saleOrder) {
        boolean result = false;

        try {
            materialMapper.deleteByOrder(saleOrder.getDdnm());
            deliveryMapper.deleteByOrder(saleOrder.getDdnm());
            saleOrderMapper.deleteByPrimaryKey(saleOrder.getDdnm());

            saleOrderMapper.insertSelective(saleOrder);
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (Material material : saleOrder.getWl()) {
                materialMapper.insert(material);
                materialMapper.insertToLink(saleOrder.getDdnm(), material.getWlnm());
                totalAmount = totalAmount.add(material.getZdj().multiply(material.getZsl()));
            }

            saleOrder.setZje(totalAmount);
            saleOrderMapper.updateByPrimaryKeySelective(saleOrder);

            for (Delivery delivery : saleOrder.getJh()) {
                deliveryMapper.insert(delivery);
                deliveryMapper.insertToLink(saleOrder.getDdnm(), delivery.getJhnm());
            }

            result = true;
        } catch (Exception e) {
            throw e;
        }

        return result;
    }
}
