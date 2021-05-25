package first.groovy


def str='Hello Groovy!' //size=13
//println str.center(16,"+")
println str.padLeft(16,'+')
println str.padRight(16,'+')
def str2='哈哈哈哈哈哈哈哈'
println str > str2
println str.getAt(0) +'\t'+ str[1] +'\t'+ str2[0..5]
def str3='哈哈哈哈哈哈哈哈'
println str.minus(str2)
println(str.reverse())
for (int i = 0; i < 10; i++) {
    print i +"\t"
}
println()
def sum=0
for (i in 1..100){
    sum+=i
}
println("范围打印："+sum)
sum=0
for (i in [1,2,3,4,5,6,7,8,9,10]){
    sum+=i
}
println("集合打印："+sum)
sum=0
for (i in ['key1':1,'key2':2,'key3':3,'key4':4]){
    sum+=i.value
}
println("Map打印："+sum)