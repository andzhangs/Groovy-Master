package groovy

/**
 * 正则表达式 RegEx
 */
def pattern = "(G|g)roovy"
def text = 'Groovy is help'
def match_text='groovy'

//部分匹配 =~
if (text =~ pattern) {
    println('match')
} else {
    println('no match')
}

//精确匹配 ==~
if (match_text ==~ pattern) {
    println('match')
} else {
    println('no match')
}
println()

//定义一个RegEx，使用正斜杠
def matcher='Groovy is groovy' =~ /(G|g)roovy/
println("Size of matcher is ${matcher.size()}")
matcher[0].each {
    println "print: $it"
}
println("with elements ${matcher[0]} and ${matcher[1]}")



