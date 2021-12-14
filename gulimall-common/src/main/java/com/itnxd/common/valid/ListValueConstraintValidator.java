package com.itnxd.common.valid;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义注解ListValue的校验器
 * @author ITNXD
 * @create 2021-12-13 21:18
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    // 初始化方法
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val : vals) {
            set.add(val);
        }
    }

    /**
     * 校验判断逻辑
     *
     * @param integer 添加校验注解的字段的值
     * @param context 注解的信息，上下文信息
     * @return
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        return set.contains(integer);
    }
}
