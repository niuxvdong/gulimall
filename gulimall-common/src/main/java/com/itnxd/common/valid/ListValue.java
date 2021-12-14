package com.itnxd.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *  自定义校验注解！
 *  根据给定的values数组进行校验！
 *
 *  JSR303校验规范规定必须要有三个属性
 *
 * @author ITNXD
 * @create 2021-12-13 20:57
 */
@Documented
@Constraint(validatedBy = { ListValueConstraintValidator.class })  // 关联自定义指定校验器
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ListValue {

    // 默认找的文件名：ValidationMessages.properties
    String message() default "{com.itnxd.common.valid.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 需要校验的int数组
    int[] vals() default { };
}
