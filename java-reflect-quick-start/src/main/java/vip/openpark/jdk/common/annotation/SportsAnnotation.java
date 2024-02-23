package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 运动注解
 *
 * @author anthony
 * @version 2024/1/17 17:38
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SportsAnnotation {
}