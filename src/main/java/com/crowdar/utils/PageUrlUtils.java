package com.crowdar.utils;
import com.crowdar.pages.common.Page;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;
public class PageUrlUtils {
    public static String urlFor(Class<? extends Page> pageClass, Map pageContext) {
        return ThymeleafPageUrlBuilder.urlFor(pageClass, pageContext);
    }

    public static String urlFor(Class<? extends Page> pageClass) {
        return urlFor(pageClass, new HashMap());
    }
}
