package com.easymall.mapper;

import com.easymall.pojo.MallCartPOJO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
public interface MallCartMapper {

    List<MallCartPOJO> selectMallCartByUserId(@Param("userId") String userId);

    int insertMallCart(List<MallCartPOJO> mallCartList);

    int deleteMallCartByCartIds(String[] cartIds);

    int updateMallCartByCartId(@Param("cartId") String cartId ,@Param("checked") String checked);

}
