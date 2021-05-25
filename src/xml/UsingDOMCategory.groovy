package xml

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def document = DOMBuilder.parse(new FileReader('languages.xml'))
def rootElement = document.documentElement
//DOMCategory必须把代码放在use()块内
use(DOMCategory) {
    println("Languages and Authors")
    def languages = rootElement.language
    languages.each { language ->
        println("${language.'@name'} author by ${language.author[0].text()}")
    }
    def languagesByAuthor = { authorName ->
        languages.findAll {
            it.author[0].text()==authorName
        }.collect {
            it.'@name'
        }.join(', ')
    }
    println("Languages by wirth: "+languagesByAuthor('Wirth'))
}