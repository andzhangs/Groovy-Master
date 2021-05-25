package groovy

public class Greetings {

    //ArrayList的元素个数必须与方法期望的参数个数一致
    static def ls=[1,2,3,4]
    static def worlds(def a,def b,def c,def d){
        print("\t $a $b $c $d")
    }

    public static void main(String[] args) {
        println("1、基本for循环：")
        for (int i = 0; i < 3; i++) {
            println('\tHello!')
        }
        println()

        // reverseEach() 反序
        // eachWithIndex() 计数和索引
        println("2、each：")
        ArrayList list = [1, 2, 3, 4, 5, 6, 7]
        def db = []
        list.each {
            db << it * 2
        }
        println(db)
        //同理
        println(list.collect{it*2})
        //所有子元素长度之和
        println(list.inject(0){carryOver,element->
            println("$carryOver , $element")
            carryOver +element
        })
        //各个元素之间拼接
        println(list.join(' -> '))
        println()


        worlds(*ls)
        println()



        println("3、step：")
        0.step(10, 1) {
            if (it != 8) {
                println("\t$it ->")
            } else {
                println("\t$it")
            }
        }
        println()

        println("4、times：")
        3.times {
            if (it != 8) {
                println("\t$it ++>")
            } else {
                println("\t$it")
            }
        }
        println()

        println("5、upto：")
        0.upto(2) {
            print("\t $it")
        }
        println()
    }


}


