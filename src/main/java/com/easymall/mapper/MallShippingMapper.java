package com.easymall.mapper;

import com.easymall.pojo.MallShippingPOJO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
public interface MallShippingMapper {

    List<MallShippingPOJO> selectMallShippingByUserId(@Param("userId") String userId);

    int deleteMallShippingByShipIds(String[] shipIds);

    int updateMallShippingByShipId(MallShippingPOJO mallShipping);

    int insertMallShipping(MallShippingPOJO mallShipping);

    MallShippingPOJO selectMallShippingByShipId(@Param("shipId") String shipId);
}
