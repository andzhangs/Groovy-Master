package groovy

import javax.xml.xpath.XPath

println('对Java5特性的支持')
println('1、自动装箱(必要时groovy会自动将基本类型视作对象)')
int val = 5
println('\t' + val.getClass().name)



println()
print('2、for-each：')
String[] str = ['one', 'two', 'three']
for (String s : str) {
    print("\t" + s)
}



println()
print('\t2.1、in：')
for (s in str) {
    print("\t" + s)
}
println()
print('\t2.2、each()：')
str.each { print("${it}\t") }



println()
println('3、枚举 enum：')
enum CoffeeSize {
    SHORT, SMALL, MEDIUM, LARGE, MUG
}
def orderCoffee(def size) {
    def msg=null
    switch (size) {
        case [CoffeeSize.SHORT,CoffeeSize.SMALL]: {
            msg="You're health conscious."
            break
        }
        case CoffeeSize.MEDIUM..CoffeeSize.LARGE: {
            msg="You're gotta be a programmer."
            break
        }
        case CoffeeSize.MUG: {
            msg="You should try Caffeine IV."
            break
        }
        default: {
            break
        }
    }
    println("\tCoffee order received for size $size："+msg)
}
orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)
print('\tAvailable sizes are：')
for (s in CoffeeSize.values()){
    print("$s\t")
}



println()
enum Methodolgies{
    Evo(5),
    XP(21),
    Scrium(30);

    final int daysInIteration
    Methodolgies(def days){
        this.daysInIteration=days
    }
    def iterationDetails(){
        println("\t${this} recommends $daysInIteration days for iteration")
    }
}

for (methodolies in Methodolgies.values()){
    methodolies.iterationDetails()
}



println()
println("4、不定长参数")
def receiveVarArgs(int a,int... b){
    println("\treceiveVarArgs : $a , $b")
}
def receiveVarArgs1(int a,int[] b){
    println("\treceiveVarArgs1: $a , $b")
}
receiveVarArgs(1,2,3,4,5)
receiveVarArgs1(5,4,3,2,1)

println()
println("5、注解")



println()
println("6、静态导入")
import static java.lang.Math.random as rand
import groovy.lang.ExpandoMetaClass as EMC
double value=rand()
def metaClass=new EMC(Integer)
assert metaClass.getClass().name=='groovy.lang.ExpandoMetaClass'


println()
println("7、泛型")
import java.util.ArrayList;
def list=ArrayList<Integer>

