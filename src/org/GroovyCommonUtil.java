package org;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.junit.platform.commons.logging.LoggerFactory;

import org.junit.platform.commons.logging.Logger;

import java.io.IOException;

public class GroovyCommonUtil {
    public static final Logger log = LoggerFactory.getLogger(GroovyCommonUtil.class);
    //该变量用于指明groovy脚本所在的父目录
    static String root[] = new String[]{"src/org/"};
    static GroovyScriptEngine engine;

    static {
        try {
            engine = new GroovyScriptEngine(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于调用指定groovy脚本中的指定方法
     */
    public static Object invokeMethod(String scriptName, String methodName, Object... params) throws Exception {
        Object obj = null;
        Class scriptClass = null;
        GroovyObject scriptInstance = null;

        try {
            scriptClass = engine.loadScriptByName(scriptName);
            scriptInstance = (GroovyObject) scriptClass.newInstance();
        } catch (ResourceException | ScriptException | InstantiationException | IllegalArgumentException e) {
            System.out.println("加载脚本{" + scriptName + "}出现异常，"+e.toString());
            throw new Exception("加载脚本{" + scriptName + "}失败");
        }

        try {
            obj=scriptInstance.invokeMethod(methodName,params);
        }catch (IllegalArgumentException e){
            System.out.println("执行方法" + methodName + "参数出现异常, 参数为" + params+", "+e.toString());
            throw new Exception("调用方法[" + methodName + "]失败，因参数不合法");
        }
        return obj;
    }





}
