package script.j2g;

import script.j2g.AGroovyClass;

/**
 * 在java中创建和传递Groovy闭包
 */
public class UseAGroovyClass {
    public static void main(String[] args) {
        AGroovyClass aGroovyClass=new AGroovyClass();
        Object result=aGroovyClass.useClosure(new Object(){
            public String call(){
                return "I am from UseAGroovyClass";
            }
        });
        System.out.println("打印："+result+"\n");


        Object result1=aGroovyClass.passToClosure(100,new Object(){
           public String call(int value){
               return "I am from UseAGroovyClass, values is "+value;
           }
        });
        System.out.println("打印："+result1);
    }
}
