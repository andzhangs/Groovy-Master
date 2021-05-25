package first.groovy.xml


import groovy.xml.MarkupBuilder

/**
 * 解析xml数据
 */
final String xml = ''' <activity>
            <intent>
                <action name='100'>android:name="android.intent.action.MAIN"</action>
                <category>android:name="android.intent.category.LAUNCHER"</category>
            </intent>
        </activity>'''

def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)
println response.intent.action.text() + '\t' + response.intent.action.@name


/**
 * 生成xml格式的数据
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw) //用来生成xml数据的核心类
//xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
//    //节点
//    language(flavor: 'static', version: '1.0.0', value: 'Java')
//    language(flavor: 'static', version: '1.0.1', value: 'Kotlin')
//    language(flavor: 'static', version: '1.0.2', value: 'JavaScript') {
//        child(age: '10', count: '100', value: 'from Language')
//    }
//}
//println sw
//println()

def lang = new Langs()
xmlBuilder.langs(type: lang.type, count: lang.count, mainstream: lang.mainstream) {
    lang.languages.each { l -> language(flavor: l.flavor, version: l.version, l.value) }
}
println(sw)
println(lang.languages.size())


class Language {
    String flavor
    String version
    String value
}

class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true

    def languages = [new Language(flavor: 'static', version: '1.0.0', value: ' Java'),
                     new Language(flavor: 'static', version: '1.0.1', value: 'Kotlin'),
                     new Language(flavor: 'static', version: '1.0.2', value: 'JavaScript')]
}



//Json数据 转 实体对象  转  xml数据
