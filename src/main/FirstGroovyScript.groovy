package main

def z = 3.1
println("z:" + z.class)

def z1 = "23"
println("z1:" + z1.class)

def z2 = 1
println("z2:" + z2.class)

def z3 = { 1; 5; 4 }
println("z3:" + z3.class)

def z4 = [1, 2, 3, 4]
println("z4:" + z4.class)


def str="groovy";
def str1=str.center(8,'a')
println "总共8个字符长度，左右各加一个 填充："+str1

def str2=str.padLeft(8,'a')
println "总共8个字符长度，只填充左边："+str2
println "字符串取值："+str[0]
println "字符串范围取值："+str[0..4]

def str3=str[0].concat(str2)
println ("拼接字符串："+str3)
println("倒序："+str.reverse())
println "首字母大写："+str.capitalize()

println "去除交集："+str1.minus(str[2]+str[3])


def msg = 3
switch (msg.class) {
    case String:
        println("找到了：String")
        break
    case Double:
        println("找到了：Double")
        break
    case Float:
        println("找到了：Float")
        break
    case String:
        println("找到了：String")
        break
    case Integer:
        println("找到了：Integer")
        break
    case BigDecimal:
        println("找到了：BigDecimal")
        break
}

def sum = 0;
for (i in 0..9) {
    sum += i
}
println("和：" + sum)



