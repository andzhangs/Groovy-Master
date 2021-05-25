package script.g2g


println("I am from Script2.groovy")
def groovyShell=new GroovyShell()
groovyShell.evaluate(new File('Script1.groovy'))

//简写版本
println('简写版：')
evaluate(new File('Script1.groovy'))