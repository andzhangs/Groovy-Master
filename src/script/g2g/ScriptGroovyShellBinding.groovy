package script.g2g

/**
 * 设置 binding.setProperty Script1Params.groovy 中的name字段
 */

//全局binding
def name = "哈哈哈"
binding.setProperty('name', name)
def groovyShell = new GroovyShell(binding)
def result = groovyShell.evaluate(new File('Script1Params.groovy'))
println("Script1Params returned: $result")
println("Hello ${name}")
//
println('//----------------------------------------------------------------------------------------------')
//新建binding 1
def binding1 = new Binding()
binding1.setProperty('name', "你大爷的-binding1")
binding1.setVariable('name',"哈哈哈---")
def groovyShell1 = new GroovyShell(binding1)
def result1 = groovyShell1.evaluate(new File('Script1Params.groovy'))
println("Script1Params returned: $result1")
//
//
////----------------------------------------------------------------------------------------------
//def groovy_Shell = new GroovyShell()
//groovy_Shell.evaluate(new File('Script1.groovy'))
////简写版本
//println('简写版：')
//evaluate(new File('Script1.groovy'))

//----------------------------------------------------------------------------------------------
//def gCLoader = new GroovyClassLoader();
//Class gClass = gCLoader.parseClass(new File('Script1.groovy'))
//def gObj = (GroovyObject) gClass.getDeclaredConstructor().newInstance()
//gObj.invokeMethod('test', 200)




