package com.itnxd.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itnxd.gulimall.product.entity.CategoryEntity;
import com.itnxd.gulimall.product.service.CategoryService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.common.utils.R;



/**
 * 商品三级分类
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 17:38:31
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类及子分类，使用属性结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> list = categoryService.listWithTree();
        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改
     */
    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     *  @RequestBody：post请求才有请求体
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        // 1. 检查当前删除的菜单，是否被他人引用
        categoryService.removeMenusByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
