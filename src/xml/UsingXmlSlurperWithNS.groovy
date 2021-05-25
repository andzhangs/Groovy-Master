package xml

import groovy.xml.XmlSlurper

/**
 * declareNamespace()
 *  以前缀为键，命名空间为值
 */
def languages=new XmlSlurper().parse('ComputerAndNaturalLanguages.xml').declareNamespace(human:'Natural')
println(languages.language.collect{it.@name}.join(', '))

println()
println("Natural Language:")
println(languages.'human:language'.collect{it.@name}.join(', '))

println()
def languages2=new XmlSlurper().parse('ComputerAndNaturalLanguages.xml').declareNamespace(human:'Computer')
println()
println("Computer Language:")
println(languages2.'human:language'.collect{it.@name}.join(', '))

