package com.easymall.service;

import com.easymall.mapper.MallCartMapper;
import com.easymall.pojo.MallCartPOJO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@Service
public class MallCartService {

    @Resource
    MallCartMapper mallCartMapper;

    public List<MallCartPOJO> selectMallCartByUserId(String userId) {

        return mallCartMapper.selectMallCartByUserId(userId);
    }

    public int insertMallCart(List<MallCartPOJO> mallCartList) {


        return mallCartMapper.insertMallCart(mallCartList);
    }

    public int deleteMallCartByCartIds(String[] cartIds) {

        return mallCartMapper.deleteMallCartByCartIds(cartIds);
    }

    public int updateMallCartByCartId(String cartId,String checked) {

        return mallCartMapper.updateMallCartByCartId(cartId,checked);
    }
}
