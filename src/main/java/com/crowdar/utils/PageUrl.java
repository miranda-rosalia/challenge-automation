package com.crowdar.utils;

import java.lang.annotation.Retention;
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface PageUrl {
    String url();

    boolean ssl() default false;
}
