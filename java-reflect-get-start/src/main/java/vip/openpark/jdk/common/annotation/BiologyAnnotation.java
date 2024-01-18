package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 生物注解
 *
 * @author anthony
 * @version 2024/1/17 15:25
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BiologyAnnotation {
}