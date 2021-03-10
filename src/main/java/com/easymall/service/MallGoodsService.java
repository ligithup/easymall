package com.easymall.service;

import com.easymall.mapper.MallGoodsMapper;
import com.easymall.pojo.MallGoodsPOJO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/8
 * @description：
 **/
@Service
public class MallGoodsService {

    @Resource
    MallGoodsMapper goodsMapper;

    public void insertGoods(MallGoodsPOJO goodsPOJO) {
        goodsMapper.insertGoods(goodsPOJO);
    }

    public List<MallGoodsPOJO> selectGoods() {
        return  goodsMapper.selectGoods();
    }

    public List<MallGoodsPOJO> selectGoodsByUserId(String userId) {


        return  goodsMapper.selectGoodsByUserId(userId);
    }

    public void updateGoods(MallGoodsPOJO goodsPOJO) {

        goodsMapper.updateGoods(goodsPOJO);
    }

    public MallGoodsPOJO selectGoodsByGoodsId(String goodsId) {

        return goodsMapper.selectGoodsByGoodsId(goodsId);
    }

    public int deleteGoodsByGoodsId(String[] goodsIds) {

        return goodsMapper.deleteGoodsByGoodsId(goodsIds);
    }

    public void updateGoodsStatus(String goodsId,String status) {

        goodsMapper.updateGoodsStatus(goodsId,status);
    }

    public List<MallGoodsPOJO> selectGoodsByGoodsName(String goodsName) {

        return goodsMapper.selectGoodsByGoodsName(goodsName);
    }
}
