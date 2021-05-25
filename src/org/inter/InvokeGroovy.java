package org.inter;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;

/**
 * 通过接口实现Java调用Groovy
 */
public class InvokeGroovy {
    public static void main(String[] args) {
        ClassLoader cl= InvokeGroovy.class.getClassLoader();
        GroovyClassLoader gcl=new GroovyClassLoader(cl);
        try {
            Class gClass=gcl.parseClass(new File("src/org/inter/Foo.groovy"));
            IFoo iFoo= (IFoo) gClass.newInstance();
            System.out.println(iFoo.run(250));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
