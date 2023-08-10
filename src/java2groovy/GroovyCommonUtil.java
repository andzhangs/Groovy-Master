package java2groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java2groovy.inter.IFoo;
import org.junit.platform.commons.logging.LoggerFactory;

import org.junit.platform.commons.logging.Logger;

import java.io.File;
import java.io.IOException;

public class GroovyCommonUtil {
    public static final Logger log = LoggerFactory.getLogger(GroovyCommonUtil.class);
    private static String PATH_GROOVY_FILE = "src/java2groovy/";
    //该变量用于指明groovy脚本所在的父目录
    private static final String[] root = new String[]{PATH_GROOVY_FILE};
    private static GroovyScriptEngine engine;
    private static GroovyClassLoader groovyCLoader = null;

    static {
        try {
            engine = new GroovyScriptEngine(root);
            ClassLoader classLoader = GroovyCommonUtil.class.getClassLoader();
            groovyCLoader = new GroovyClassLoader((classLoader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于调用指定groovy脚本中的指定方法
     */
    public static Object invokeMethod(String scriptName, String methodName, Object... params) throws Exception {
        Object obj = null;
        GroovyObject scriptInstance = null;

        try {
            Class scriptClass = engine.loadScriptByName(scriptName);
            scriptInstance = (GroovyObject) scriptClass.getDeclaredConstructor().newInstance();
        } catch (ResourceException | ScriptException | InstantiationException | IllegalArgumentException e) {
            System.out.println("加载脚本{" + scriptName + "}出现异常，" + e.toString());
            throw new Exception("加载脚本{" + scriptName + "}失败");
        }

        try {
            obj = scriptInstance.invokeMethod(methodName, params);
        } catch (IllegalArgumentException e) {
            System.out.println("执行方法" + methodName + "参数出现异常, 参数为" + params + ", " + e.toString());
            throw new Exception("调用方法[" + methodName + "]失败，因参数不合法");
        }
        return obj;
    }

    /**
     * 接口调用
     * groovy全名，包括后缀，例如下:
     * HelloWorld.groovy
     */
    public static IFoo invokeMethod(String fileName) {
        try {
            String path = PATH_GROOVY_FILE + "inter/" + fileName;
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("文件不存在：" + path);
                return null;
            }
            Class clz = groovyCLoader.parseClass(file);
            IFoo ifoo = (IFoo) clz.getDeclaredConstructor().newInstance();
            return ifoo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
