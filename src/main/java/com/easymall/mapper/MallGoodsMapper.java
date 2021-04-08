package com.easymall.mapper;

import com.easymall.pojo.MallGoodsPOJO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/8
 * @description：
 **/
public interface MallGoodsMapper {

    void insertGoods(MallGoodsPOJO goodsPOJO);

    List<MallGoodsPOJO> selectGoods(@Param("status") String status);

    List<MallGoodsPOJO> selectGoodsByUserId(@Param("userId") String userId,@Param("status") String status);

    void updateGoods(MallGoodsPOJO goodsPOJO);

    MallGoodsPOJO selectGoodsByGoodsId(@Param("goodsId") String goodsId);

    int deleteGoodsByGoodsId(String[] goodsIds);

    void updateGoodsStatus(@Param("goodsId") String goodsId,@Param("status") String status);

    List<MallGoodsPOJO> selectGoodsByGoodsName(@Param("goodsName") String goodsName);
}
