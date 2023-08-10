package java2groovy;

import java2groovy.inter.IFoo;

import java.io.IOException;

/**
 * Java调用Groovy
 */
public class Java2Groovy {

    public static void main(String[] args) throws IOException {
        try {
            String result = (String) GroovyCommonUtil.invokeMethod("Java2GroovyUtil.groovy", "withoutParam");
            System.out.println("无参函数：" + result);

            BaseBean bean = new BaseBean(200, "success", "name=Tom");
            String result1 = (String) GroovyCommonUtil.invokeMethod("Java2GroovyUtil.groovy", "withParam", bean, 10086);
            System.out.println("有参函数：" + result1);

            IFoo foo=  GroovyCommonUtil.invokeMethod("Foo.groovy");
            assert foo != null;
            foo.run(99);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
