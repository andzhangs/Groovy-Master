package groovy

def map = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']
//each会把一个MapEntr实例发送给参数 it
map.each {
    println("${it.key} : ${it.value}")
}
println()
map.each { key, value -> println("$key : $value") }

//collect
println(map.collect { key, value ->
    key.replaceAll("[+]", "p")
})
println()

//any 确认是否在语言的名字上含着非字母的字符
//查找至少满足一个给定条件
println map.any { key, value -> key =~ '[^A_Za_z]' }
println()
//
println map.every { key, value -> key =~ '[^A_Za_z]' }