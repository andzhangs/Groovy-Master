package main

/**
 * this：闭包定义处的类
 * owner：闭包定义处的类或者对象
 * delegate：闭包任意对象，默认值与owner一致
 *
 * 1、闭包中：this 指向最外层类；owner、delegate指向最近的类(对象)
 * 2、修改了delegate的值以后，owner、delegate的值就不同了
 * 3、this、owner不可用修改
 */
class PersonClass {
    def scriptClosure = {
        "this：" + this + "\n" +
                "owner：" + owner + "\n" +
                "delegate：" + delegate + "\n"
    }
    def say(){
        def scriptClosure = {
            "this：" + this + "\n" +
                    "owner：" + owner + "\n" +
                    "delegate：" + delegate + "\n"
        }
        println scriptClosure.call()
    }
}
//闭包、方法加 static关键字
//println PersonClass.scriptClosure.call()
//PersonClass.say()

PersonClass p=new PersonClass()
println p.scriptClosure.call()
p.say()

//闭包内部定义闭包
def nestClosure= {
    def innerClosure = {
        println "this：" + this + "\n" + "owner：" + owner + "\n" + "delegate：" + delegate + "\n"
    }
    innerClosure.delegate=p //修改默认的delegate
    innerClosure.call()
}
nestClosure.call()