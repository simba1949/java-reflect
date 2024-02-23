package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 人类注解
 * {@link HumanAnnotation} ——> {@link AnimaliaAnnotation} ——> {@link BiologyAnnotation}
 *
 * @author anthony
 * @version 2024/1/17 14:58
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HumanAnnotation {
}