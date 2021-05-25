package first.groovy.dataconstructutures

def range = 0..10
println range[0]
println range.contains(9)  //是否包含
println range.from //起始值
println range.to   //结束之

//遍历
range.each { print it + '\t' }
println()

static def get(Number number) {
    def result
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