package dsl

/**
 * 合并脚本
 */
def dslDef=new File('GroovyOrderPizza.groovy').text
def dsl =new File('orderPizza.gdsl').text

def script="""
${dslDef}
acceptOrder{
    ${dsl}
}
"""

new GroovyShell().evaluate(script)