package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.MallGoodsPOJO;
import com.easymall.service.MallGoodsService;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/8
 * @description：
 **/
@RestController
@RequestMapping("/goods")
@Slf4j
@Api(value = "商品接口",tags = "商品接口")
public class MallGoodsController extends BaseController {

    @Autowired
    MallGoodsService goodsService;

    @PostMapping("/insertGoods")
    @ApiOperation(value="添加商品", notes="添加商品")
    public ResultUtil insertGoods(MallGoodsPOJO goodsPOJO){
        if(ObjectUtils.isEmpty(goodsPOJO)){
            return  ResultUtil.result("不能为空");
        }
        goodsService.insertGoods(goodsPOJO);

        return ResultUtil.success();
    }

    @PostMapping("/updateGoods")
    @ApiOperation(value="修改商品", notes="修改商品")
    public ResultUtil updateGoods(MallGoodsPOJO goodsPOJO){
        if(ObjectUtils.isEmpty(goodsPOJO)){
            return  ResultUtil.result("不能为空");
        }
        goodsService.updateGoods(goodsPOJO);

        return ResultUtil.success();
    }

    @PostMapping("/updateGoodsStatus")
    @ApiOperation(value="修改商品状态", notes="修改商品状态")
    public ResultUtil updateGoodsStatus(String goodsId,String status){

        goodsService.updateGoodsStatus(goodsId,status);

        return ResultUtil.success();
    }

    @PostMapping("/selectGoods")
    @ApiOperation(value="查询全部商品", notes="查询全部商品")
    public TableDataInfo  selectGoods(Integer pageNum, Integer pageSize){
        startPage();
        List<MallGoodsPOJO> goodsList= goodsService.selectGoods();
        return getDataTable(goodsList);
    }

    @PostMapping("/selectGoodsByUserId")
    @ApiOperation(value="通过用户id查询商品", notes="通过用户id查询商品")
    public TableDataInfo  selectGoodsByUserId(Integer pageNum, Integer pageSize,String userId){
        startPage();
        List<MallGoodsPOJO> goodsList= goodsService.selectGoodsByUserId(userId);
        return getDataTable(goodsList);
    }

    @PostMapping("/selectGoodsByGoodsId")
    @ApiOperation(value="通过商品id查询商品", notes="通过商品id查询商品")
    public ResultUtil  selectGoodsByGoodsId(String goodsId){

        MallGoodsPOJO goods= goodsService.selectGoodsByGoodsId(goodsId);

        return ResultUtil.success(goods);
    }

    @PostMapping("/deleteGoodsByGoodsId")
    @ApiOperation(value="通过商品id删除商品", notes="通过商品id删除商品")
    public ResultUtil  deleteGoodsByGoodsId(@RequestBody String[] goodsIds){

        int i=goodsService.deleteGoodsByGoodsId(goodsIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping("/selectGoodsByGoodsName")
    @ApiOperation(value="通过商品名模糊查询商品", notes="通过商品名模糊查询商品")
    public TableDataInfo  selectGoodsByGoodsName(Integer pageNum, Integer pageSize,String goodsName){
        startPage();
        List<MallGoodsPOJO> goodsList= goodsService.selectGoodsByGoodsName(goodsName);
        return getDataTable(goodsList);
    }


}
