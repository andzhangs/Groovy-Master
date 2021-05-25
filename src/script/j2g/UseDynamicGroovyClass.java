package script.j2g;

import groovy.lang.GroovyObject;

/**
 * 在Java中调用Groovy动态方法
 */
public class UseDynamicGroovyClass {
    public static void main(String[] args) {
        GroovyObject gObj=new DynamicGroovyClass();
        Object obj=gObj.invokeMethod("squeak", new Object[]{});
        System.out.println("打印："+obj);

        Object obj2=gObj.invokeMethod("squeak", new Object[]{"one","two","three"});
        System.out.println("打印："+obj2);
    }
}
