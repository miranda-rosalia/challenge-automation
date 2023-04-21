package com.crowdar.utils;

import com.crowdar.pages.common.Page;
import com.google.common.collect.ImmutableMap;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Map;
public class ThymeleafPageUrlBuilder {
    public static String urlFor(Class<? extends Page> pageClass, Map pageContextMap) {
        try {
            PageUrl pageUrl = pageClass.getAnnotation(PageUrl.class);
            String urlTemplate = pageUrl.url();
            String hostTemplate = urlTemplate.split("/")[0];
            String endPointSolvedUrl = urlTemplate.replace(hostTemplate,""); //environment.getProperty(hostTemplate)
            TemplateEngine templateEngine = new TemplateEngine();
            Context context = new Context(null, ImmutableMap.of("pc", pageContextMap));
            return templateEngine.process(endPointSolvedUrl,context);
        } catch (Exception e) {
            throw new IllegalStateException("Fallo en URL de PageObject");
        }
    }
}
