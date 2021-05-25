package org.inter

class Foo implements IFoo {

    @Override
    int run(int foo) {
        println('Hello World!')
        return foo * 100
    }
}
