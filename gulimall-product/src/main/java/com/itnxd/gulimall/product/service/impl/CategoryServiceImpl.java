package com.itnxd.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.common.utils.Query;

import com.itnxd.gulimall.product.dao.CategoryDao;
import com.itnxd.gulimall.product.entity.CategoryEntity;
import com.itnxd.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1. 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 2. 组装成父子结构

        // 2.1 获取以及分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map(menu -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        // TODO 1. 检查当前删除的菜单，是否被他人引用
        baseMapper.deleteBatchIds(asList);
    }

    // 递归获取当前菜单的子菜单（filter元素为0时，自动返回空结束递归）
    public List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all){

        return all.stream().filter(categoryEntity ->
                categoryEntity.getParentCid().equals(root.getCatId())
        ).map(menu -> {
            menu.setChildren(getChildrens(menu, all));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
    }

}