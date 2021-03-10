package com.easymall.service;

import com.easymall.mapper.MallOrderMapper;
import com.easymall.pojo.MallOrderItemPOJO;
import com.easymall.pojo.MallOrderPOJO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@Service
public class MallOrderService {

    @Resource
    MallOrderMapper mallOrderMapper;

    public List<MallOrderPOJO> selectMallOrderAll() {

        return mallOrderMapper.selectMallOrderAll();
    }

    public List<MallOrderPOJO> selectMallOrderByUserId(String userId) {

       return mallOrderMapper.selectMallOrderByUserId( userId);
    }

    public List<MallOrderItemPOJO> selectMallOrderItemByUserId(String userId) {

        return mallOrderMapper.selectMallOrderItemByUserId(userId);
    }

    public List<MallOrderItemPOJO> selectMallOrderItemByOrderId(String orderId) {

        return mallOrderMapper.selectMallOrderItemByOrderId(orderId);
    }

    public int insertMallOrder(List<MallOrderPOJO> mallOrderList) {

        return mallOrderMapper.insertMallOrder(mallOrderList);
    }

    public int insertMallOrderItem(List<MallOrderItemPOJO> mallOrderItemList) {

        return mallOrderMapper.insertMallOrderItem(mallOrderItemList);
    }

    public int updateMallOrder(MallOrderPOJO mallOrder) {

        return mallOrderMapper.updateMallOrder(mallOrder);
    }

    public int updateMallOrderItem(MallOrderItemPOJO mallOrderItem) {

        return mallOrderMapper.updateMallOrderItem(mallOrderItem);
    }

    public int deleteMallOrderItemByOrderItemIds(String[] orderItemIds) {

        return mallOrderMapper.deleteMallOrderItemByOrderItemIds(orderItemIds);
    }

    public int deleteMallOrderByOrderIds(String[] orderIds) {

        return mallOrderMapper.deleteMallOrderByOrderIds(orderIds);
    }
}
