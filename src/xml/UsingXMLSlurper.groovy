package xml

import groovy.xml.XmlSlurper

def languages = new XmlSlurper().parse('languages.xml')
println('Languages and Authors')
languages.language.each {
    println("${it.'@name'} author by ${it.author[0].text()}")
}
def languagesByAuthor = { authorName ->
    languages.language.findAll{
        it.author[0].text()==authorName
    }.collect{
        it.'@name'
    }.join(', ')
}
println("Languages by wirth: "+languagesByAuthor('Wirth'))
