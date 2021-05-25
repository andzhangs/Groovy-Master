package first.groovy

/**
 * 闭包的委托策略
 */
class Student {
    String name
    def pretty = { "I am ${name} is a student." }

    String toString() {
        pretty.call()
    }

}

class Teacher {
    String name
}

def stu = new Student(name: 'Tom')
def tea = new Teacher(name: 'Android')
//println(stu.toString())
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()
