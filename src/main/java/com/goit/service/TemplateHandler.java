package com.goit.service;

import java.io.*;
import java.util.Map;
import java.util.regex.*;
import org.apache.logging.log4j.*;

public class TemplateHandler {

    private static final Logger LOGGER = LogManager.getLogger(TemplateHandler.class);
    private static final Pattern pattern = Pattern.compile("\\{\\{(\\w+)\\}\\}", Pattern.MULTILINE);
    private static TemplateHandler instance;

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private TemplateHandler() {
    }

    public static TemplateHandler getInstance() {
        if (instance == null) {
            instance = new TemplateHandler();
        }
        return instance;
    }

    public String handleTemplate(String templateName, Map<String, String> params) {
        String template = getTemplate(templateName);
        final Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String replacer = params.get(matcher.group(1));
            template = template.replace(matcher.group(0),
                    replacer == null ? "" : replacer );
        }
        return template;
    }

    public String getTemplate(String templateName) {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/templates/" + templateName + ".html");
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            LOGGER.info(e);
        }

        return "";
    }

}
