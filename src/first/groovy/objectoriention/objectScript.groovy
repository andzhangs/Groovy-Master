package first.groovy.objectoriention

class Persons implements Serializable{

    String name
    Integer age

    def inCreateAge(Integer age) {
        this.name += age
    }

    /**
     * 重写 invokeMethod
     * @param name 被调用的方法名
     * @param args 被调用的方法的参数
     * @return
     */
    def invokeMethod(String name, Object args) {
        return "the method name is ${name}, and the params is ${args}"
    }

    //重写 methodMissing ，优先级比invokeMethod高
    def methodMissing(String name, Object args) {

        return "the method ${name} is messing"
    }
}

def person = new Persons(name: 'Tom', age: 18)
println person.name + '\t' + person.age
println person.invokeMethod('David', '你妹啊')
println person.cry()

//为类动态的添加一个属性
Persons.metaClass.sex = 'male'  //注入新的属性
def person2 = new Persons(name: 'Tom', age: 18)
println person2.sex
person2.sex = 'female'
println person2.sex

//为类动态添加方法
Persons.metaClass.setNameTag = { -> name + '-Tag' }
def person3 = new Persons(name: 'Tom', age: 18)
println person3.setNameTag()


//为类动态添加静态方法
Persons.metaClass.static.addPerson = {
    String name, Integer age -> new Persons(name: name, age: age)
}
def result = Persons.addPerson('David', 33)
println result.name + "\t" + result.age