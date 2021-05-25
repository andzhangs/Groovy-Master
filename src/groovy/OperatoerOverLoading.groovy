package groovy

/**
 * 直接运行当前文件
 */
println("操作符重载：")

println("1、'in' 操作符：")
for (def i in 'a'..'c') {
    print('\t' + i)
}

println()
println("2、'<<' 向集合中添加元素：")
def list = ["hello"]
list << 'groovy!!'
print('\t' + list)

println()
println("3、为一个类添加重载操作符 '+'-> 'plus()' ")

class ComplexNumber {
    def real, imaginary;

    def plus(other) {
        new ComplexNumber(real: real + other.real, imaginary: imaginary + other.imaginary)
    }

    String toString() { "$real ${imaginary > 0 ? '+' : ''} ${imaginary}" }
}

def c1 = new ComplexNumber(real: 1, imaginary: 2)
def c2 = new ComplexNumber(real: 3, imaginary: 4)
print('\t')
println( c1 + c2)

