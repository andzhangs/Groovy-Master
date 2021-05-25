package script.g2g


//全局binding
println("I am from Script2Params.groovy")
def name="哈哈哈"
binding.setProperty('name',name)
def groovyShell=new GroovyShell(binding)
def result=groovyShell.evaluate(new File('Script1Params.groovy'))
println("Script1Params returned: $result")
println("Hello ${name}")

println()
//新建binding 1
def binding1=new Binding()
binding1.setProperty('name',"你大爷的-binding1")
def groovyShell1=new GroovyShell(binding1)
def result1=groovyShell1.evaluate(new File('Script1Params.groovy'))
println("Script1Params returned: $result1")

