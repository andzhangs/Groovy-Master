package java2groovy.inter

class Foo implements IFoo {

    @Override
    int run(int foo) {
        def result=foo * 100
        println("输出结果：$result")
        return result
    }
}
