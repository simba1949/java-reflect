package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 读书注解
 *
 * @author anthony
 * @version 2024/1/17 17:40
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ReadAnnotation {
}