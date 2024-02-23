package vip.openpark.jdk.common.annotation;

import java.lang.annotation.*;

/**
 * 呼吸注解
 *
 * @author anthony
 * @version 2024/1/18 14:53
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BreatheAnnotation {
}