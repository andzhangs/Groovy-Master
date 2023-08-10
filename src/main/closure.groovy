package main

/**
 *          闭包
 * 闭包与字符串结合使用
 */

def closure = { println("Hello Groovy! ${it}") }  //默认参数
closure.call()
closure()
closure.call("哈哈哈")

def closures = { String name, int age -> println("Hello Groovy! ${name} and ${age} years old") }
closures.call("I am from call", 10010)
closures("I am from myself", 10086)
def name = "Tom"
closures(name, 1008611)

def define = { String param1 -> return "我输入的是：${param1}" }
def result1 = define.call("QWERTYUIOP")
println result1

int x = 5

static int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

def result = fab(x)
println(result)


static int fab2(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result
}

def result2 = fab2(x)
println(result2)


static int tiems(int number) {
    int result = 0
    number.times {
        num -> result += num
    }

    return result
}

def redult3 = tiems(x)
println(redult3)


String str = "H8e3l5lo1"
//each遍历：HH88ee33ll55lloo11H8e3l5lo1
println(str.each { String temp -> print(temp.multiply(2)) })

//find 查找符合条件的第一个：8
println(str.find { String s -> s.isNumber() })

//查询数字，然后放入集合中：[8, 3, 5, 1]
println(str.findAll { String s -> s.isNumber() }.toListString())

//存在一项满足：true
println(str.any { String s -> s.isNumber() })

//每项都要满足：false
println(str.every { String s -> s.isNumber() })

//小写字母都转换成大写字母：[H, 8, E, 3, L, 5, L, O, 1]
println(str.collect { it.toUpperCase() })


