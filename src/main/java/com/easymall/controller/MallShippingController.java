package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.MallShippingPOJO;
import com.easymall.pojo.ShipIds;
import com.easymall.service.MallShippingService;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@RestController
@RequestMapping("/Ship")
@Slf4j
@Api(value = "收货地址接口",tags = "收货地址接口")
public class MallShippingController extends BaseController {

    @Autowired
    MallShippingService mallShippingService;

    @GetMapping("/selectMallShippingByUserId")
    @ApiOperation(value="通过用户ID查询收货地址", notes="通过用户ID查询收货地址")
    public TableDataInfo selectMallShippingByUserId(Integer pageNum, Integer pageSize, String userId){
        startPage();
        List<MallShippingPOJO> MallShippingList=mallShippingService.selectMallShippingByUserId(userId);
        return getDataTable(MallShippingList);
    }

    @GetMapping("/selectMallShippingByShipId")
    @ApiOperation(value="通过收货ID查询收货地址", notes="通过收货ID查询收货地址")
    public ResultUtil selectMallShippingByShipId(String shipId){

        MallShippingPOJO mallShipping=mallShippingService.selectMallShippingByShipId(shipId);
        return ResultUtil.success(mallShipping);
    }


    @PostMapping(value = "deleteMallShippingByShipId",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过shipId删除收货地址", notes="通过shipId删除收货地址")
    public ResultUtil deleteMallShippingByShipIds(@RequestBody ShipIds shipIds){
        String[] split = shipIds.getShipIds().split(",");
        int i=mallShippingService.deleteMallShippingByShipIds(split);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }


    @PostMapping(value = "updateMallShippingByShipId",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过shipId修改收货地址", notes="通过shipId修改收货地址")
    public ResultUtil updateMallShippingByShipId(@RequestBody MallShippingPOJO mallShipping){

        int i=mallShippingService.updateMallShippingByShipId(mallShipping);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }


    @PostMapping(value = "insertMallShipping",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="添加收货地址", notes="添加收货地址")
    public ResultUtil insertMallShipping(@RequestBody MallShippingPOJO mallShipping){

        int i=mallShippingService.insertMallShipping(mallShipping);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }

}
