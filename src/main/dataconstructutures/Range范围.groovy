package main.dataconstructutures

def range = 0..10
println '第一个值：' + range[0]
println '是否包含第10个值：' + range.contains(9)  //是否包含
println '起始值：' + range.from //起始值
println '结束值：' + range.to   //结束值

//遍历
print '输出：'
range.each { print it + '\t' }
println()

static def get(Number number) {
    def result = null
    switch (number) {
        case 0..<60: result = '学渣'
            break
        case 60..<80: result = '混子'
            break
        case 80..<95: result = '优秀'
            break
        case 95..100: result = '学霸'
            break
    }
    return result
}

println get(95)