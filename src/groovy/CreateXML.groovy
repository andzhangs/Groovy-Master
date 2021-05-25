package groovy

import groovy.xml.StreamingMarkupBuilder

/**
 * 字符串
 */


/**
 * 1、多行字符串
 */
def langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']
def content = ''

langs.each { language, author ->
    fragment =
            """
    <language name="$language">
        <author>$author</author>
    </language>
    """

    content += fragment
}

def xml = "<languages>$content</languages>"
println(xml)
println()


/**
 * <?xml version='1.0'?>
 * <languages xmlns:computer='Computer'>
 *     <!--Created using StreamingMarkupBuilder-->
 *         <computer:language name='C++'>
 *             <author>Stroustrup</author>
 *         </computer:language>
 *
 *         <computer:language name='Java'>
 *             <author>Gosling</author>
 *         </computer:language>
 *
 *         <computer:language name='Lisp'>
 *             <author>McCarthy</author>
 *         </computer:language>
 *
 *  </languages>
 */
def xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(computer: 'Computer')
    languages {
        comment << "Created using StreamingMarkupBuilder"
        langs.each { key, value ->
            computer.language(name:key){
                author(value)
            }
        }
    }
}
println(xmlDocument)







/**
 * 字符串边界方法
 */
def str = "It's a rainy day in seattle"
println(str)

str -= 'rainy'
println(str)
println()

for (s in 'held'..'helj') {
    print("\t $s")
}





