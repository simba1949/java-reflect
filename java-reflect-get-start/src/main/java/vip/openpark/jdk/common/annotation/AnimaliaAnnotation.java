package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 动物注解
 * {@link AnimaliaAnnotation} ——> {@link BiologyAnnotation}
 *
 * @author anthony
 * @version 2024/1/17 15:25
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnimaliaAnnotation {
}
