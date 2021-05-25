package groovy

import groovy.transform.*

/**
 * 代码生成转换
 * -------------------------------------------------------------------
 */
println('代码生成转换')


/**
 *  toString()方法   @Canonical
 * 示例结果： groovy.Person@20f12539
 *   @ 后面的字符串是不确定的，这个实际上调用的是java.lang.Object对象的toString方法，这个方法是这么实现的：
 *   public String toString() { return getClass().getName() + "@" + Integer.toHexString(hashCode());}*   @ 后面的数字实际上对应了Object里面native实现的hashCode方法，实际上对应的是对象的内存地址
 *   给Person加上@ToString注解，查看ToString注解源码
 */
println("1、使用 @Canonical：")

@Canonical
//方式一
//@ToString(includeNames=true,excludes=['lastName','age'])  //方式二
class Person {
    String firstName
    String lastName
    int age
}

def sara = new Person("firstName": "Hello", "lastName": "World", "age": 2002)
println("\t$sara")


/**
 * 委托 @Delegate
 * Expert类有一个与Worker类的名字和签名都相同的方法
 */
println()
println("2、使用 @Delegate：")

class Worker {
    def work() { println('\tget work done') }

    def analyze() { println('\tWorker analyze...') }

    def writeReport() { println('\tget report written...') }
}

class Expert {
    def analyze() { println('\tExpert  analyze...') }
}

class Manager {
    @Delegate
    Expert expert = new Expert()
    @Delegate
    Worker worker = new Worker()
}

def bernie = new Manager()
bernie.analyze()
bernie.work()
bernie.writeReport()


/**
 * 创建不可变对象  @Immutable
 * @Immutable标注一个类 ,Groovy会将其字段标记为final的，并且额外创建一些简洁方法
 * 不可变对象是线程安全的，可作为消息传递的理想实例
 */
println()
println("3、使用 @Immutable：")

@Immutable
class CreditCard {
    String cardNumber
    int creditLimit
}

println '\t' + new CreditCard('10086-11', 1000)


/**
 * 延迟加载  @Lazy
 * 示例：延迟创建Heavy实例，在真正需要它的时候，
 *  1、在声明的地方直接初始化实例
 *  2、将创建逻辑包在一个闭包中
 * 不仅推迟创建，还将字段标记为volatile，并确保创建期间是线程安全的
 * @Lazy 提供了一种轻松实现线程安全的虚拟代理模式的方式*
 */
println()
println("4、使用 @Lazy：")

class Heavy {
    def size = 10

    Heavy() { println("\tCreate new Heavy with $size") }
}

class AsNeeded {
    def value
    @Lazy
    Heavy heavy1 = new Heavy()
    @Lazy
    Heavy heavy2 = { new Heavy(size: value) }()

    AsNeeded() { println('\tCreate AsNeeded') }
}

def asNeeded = new AsNeeded(value: 1000)
println("\t ${asNeeded.heavy1.size}")
println("\t ${asNeeded.heavy1.size}")
println("\t ${asNeeded.heavy2.size}")


/**
 * 创建实例  @Newify
 * 示例：延迟创建Heavy实例，在真正需要它的时候，
 *  1、在声明的地方直接初始化实例
 *  2、将创建逻辑包在一个闭包中
 * 不仅推迟创建，还将字段标记为volatile，并确保创建期间是线程安全的
 * @Lazy 提供了一种轻松实现线程安全的虚拟代理模式的方式* 若创建ruby风格构造器 auto=false
 */
println()
println("5、使用 @Newify：")

@Newify(value = [Person, CreditCard])
def fluentCreate() {
    println("\t ${Person.new('Tom', 'Cat', 20)}")
    println("\t ${Person('Cat', 'Tom', 200)}")
    println("\t ${CreditCard('Tom', 20)}")
}

fluentCreate()


/**
 * 单例模式 @Singleton
 * 确保线程安全、决定是否要惰性创建
 */
println()
println("5、使用 @Singleton：")

@Singleton(lazy = true, strict = false)
class TheUnique {
    private TheUnique() { println('\tTheUnique created') }

    def hello() { println('\tHello TheUnique object') }
}
println('\tAccess TheUnique')
TheUnique.instance.hello()
TheUnique.instance.hello()


/**
 *
 * helper 没有指定类型，默认类型为object
 * helper在它上面调用了helpMoveThings函数，这就是能力式设计
 */
println()
println('\t使用动态类型')
def takeHelp(helper){
    helper.helpMoveThings()
}


/**
 * @TypeChecked
 * 在目标代码执行严格检查
 *
 * @TypeChecked(TypeCheckingMode.SKI)
 * 不对方法进行静态检测
 */
@TypeChecked
def shout(String str){
    println('printing in uppercase')
    str.toUpperCase()
    println('printing again in uppercase')

//    str.toUppercase()
}
try {
    shout("hello")
}catch(ex){
    println(ex.toString())
    ex.printStackTrace()
}