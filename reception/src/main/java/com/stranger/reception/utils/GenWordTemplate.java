package com.stranger.reception.utils;

import com.stranger.reception.domain.Report;
import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Locale;

public class GenWordTemplate {

    private static final Logger log = LoggerFactory.getLogger(GenWordTemplate.class);

    private static Configuration freemarkerConfig;

    static {
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
        freemarkerConfig.setEncoding(Locale.getDefault(), "UTF-8");
    }

    public static void  genWord(Object obj,String filePath){

        freemarkerConfig.setTemplateLoader(new URLTemplateLoader() {
            @Override
            protected URL getURL(String s) {
                return GenWordTemplate.class.getResource("/templates/test.xml");
            }
        });
        Template template = null;
        File targetFile = new File(filePath);
        Writer out = null;
        try {
            template = freemarkerConfig.getTemplate("test.xml");
        } catch (IOException e) {
            log.info("文件不存在");
        }
        try {
            out = new OutputStreamWriter(new FileOutputStream(targetFile),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("字符编码不正确");
        } catch (FileNotFoundException e) {
            log.info("字符编码时,文件不存在");
        }

        //执行模板替换
        try {
            template.process(obj, out);
            out.flush();
        } catch (TemplateException e) {
            log.info("模板异常");
        } catch (IOException e) {
            log.info("模板文件异常");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
