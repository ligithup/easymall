package com.easymall.mapper;

import com.easymall.pojo.MallOrderItemPOJO;
import com.easymall.pojo.MallOrderPOJO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
public interface MallOrderMapper {

    List<MallOrderPOJO> selectMallOrderAll();

    List<MallOrderPOJO> selectMallOrderByUserId(@Param("userId") String userId);

    List<MallOrderItemPOJO> selectMallOrderItemByUserId(@Param("userId") String userId);

    List<MallOrderItemPOJO> selectMallOrderItemByOrderId(@Param("orderId") String orderId);

    int insertMallOrder(List<MallOrderPOJO> mallOrderList);

    int insertMallOrderItem(List<MallOrderItemPOJO> mallOrderItemList);

    int updateMallOrder(MallOrderPOJO mallOrder);

    int updateMallOrderItem(MallOrderItemPOJO mallOrderItem);

    int deleteMallOrderItemByOrderItemIds(String[] orderIds);

    int deleteMallOrderByOrderIds(String[] orderIds);

    MallOrderPOJO selectMallOrderByOrderId(@Param("orderId") String orderId);

    MallOrderItemPOJO selectMallOrderItemByOrderItemId(@Param("orderItemId") String orderItemId);

    MallOrderItemPOJO selectMallOrderItemByGoodsId(@Param("goodsId") String goodsId);
}
