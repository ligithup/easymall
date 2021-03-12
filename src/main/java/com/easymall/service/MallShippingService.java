package com.easymall.service;

import com.easymall.mapper.MallShippingMapper;
import com.easymall.pojo.MallShippingPOJO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@Service
public class MallShippingService {

    @Resource
    MallShippingMapper mallShippingMapper;

    public List<MallShippingPOJO> selectMallShippingByUserId(String userId) {

        return mallShippingMapper.selectMallShippingByUserId(userId);
    }

    public int deleteMallShippingByShipIds(String[] shipIds) {

        return mallShippingMapper.deleteMallShippingByShipIds(shipIds);
    }

    public int updateMallShippingByShipId(MallShippingPOJO mallShipping) {

        return mallShippingMapper.updateMallShippingByShipId(mallShipping);
    }

    public int insertMallShipping(MallShippingPOJO mallShipping) {
        return mallShippingMapper.insertMallShipping(mallShipping);
    }

    public MallShippingPOJO selectMallShippingByShipId(String shipId) {
        return mallShippingMapper.selectMallShippingByShipId(shipId);
    }
}
