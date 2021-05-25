package org;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

/**
 * Java调用Groovy
 */
public class Java2Groovy {

    public static void main(String[] args) throws IOException {
        try {
            String result= (String) GroovyCommonUtil.invokeMethod("Java2GroovyUtil.groovy","withoutParam");
            System.out.println("无参函数："+result);

            BaseBean bean=new BaseBean(200,"success","name=Tom");
            String result1= (String) GroovyCommonUtil.invokeMethod("Java2GroovyUtil.groovy","withParam",bean,10086);
            System.out.println("有参函数："+result1);

        }catch (SecurityException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
