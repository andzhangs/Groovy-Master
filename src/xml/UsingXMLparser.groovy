package xml

import groovy.xml.XmlParser

def languages = new XmlParser().parse('languages.xml')
println('Languages and Authors')
languages.each {
    println("${it.'@name'} author by ${it.author[0].text()}")
}
def languagesByAuthor = { authorName ->
    languages.findAll {
        it.author[0].text()==authorName
    }.collect {
        it.'@name'
    }.join(', ')
}
println("Languages by wirth: "+languagesByAuthor('Wirth'))
