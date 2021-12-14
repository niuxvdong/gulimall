package com.itnxd.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.itnxd.common.valid.AddGroup;
import com.itnxd.common.valid.UpdateGroup;
import com.itnxd.common.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itnxd.gulimall.product.entity.BrandEntity;
import com.itnxd.gulimall.product.service.BrandService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 17:38:31
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     * @Valid: 开启JSR303校验
     * BindingResult: 紧跟要校验数据返回校验结果信息
     *      若不写则异常会向上抛出
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand /*, BindingResult result*/){
        /*if(result.hasErrors()){
            Map<String, String> map = new HashMap<>();
            result.getFieldErrors().forEach((item)->{
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put(field, message);
            });
            return R.error(400, "提交的数据不合法！").put("data", map);
        }*/
		brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    @RequestMapping("/update/status")
    public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand){
        brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
