package java2groovy

String withoutParam() {
    println('start to call withoutParam')
    return 'success, withoutParam'
}


String withParam(BaseBean persion, int id) {
    println('start to call withoutParam, param：' + persion + ', id：' + id + '}')
    return 'success, withParam'
}


/**
 * 尾递归闭包
 * 方法中最后的表达式或者是结束递归，或者是调用自身
 * @param factorialFor
 * @return
 */
def factorial(int factorialFor) {
    def tailFactorial
    tailFactorial = { int number, Integer theFactorial = 1 ->
        number == 1 ? theFactorial : tailFactorial.trampoline(number - 1, number * theFactorial)
    }.trampoline()
    tailFactorial(factorialFor)
}

println("factorial of 5 is ${factorial(5)}")