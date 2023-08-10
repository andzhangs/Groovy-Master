package main.files

def path = '/Users/zhangshuai/IdeaProjects/FirstScript-Groovy/FirstScript-Groovy.iml'
def file = new File(path)
file.eachLine {
    line -> println(line)
}

println file.getText()

println file.readLines()

//println file.withReader { reader ->
//    char[] buffer = new char[100]
//    reader.read(buffer)
//    return buffer
//}
//
////拷贝
//def copy(String sourcePath, String newFilePath) {
//    try {
//        //首相创建目标文件
//        def desFile = new File(newFilePath)
//        if (!desFile.exists()) {
//            desFile.createNewFile()
//        }
//        //开始创建
//        new File(sourcePath).withReader { reader ->
//            def lines = reader.readLines()
//            desFile.withWriter { writer ->
//                lines.each { line ->
//                    writer.append(line + "\r\n")
//                }
//            }
//        }
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//}
//
//def path2 = '/Users/zhangshuai/IdeaProjects/FirstScript-Groovy/FirstScript-Groovy2.iml'
//def result = copy(path, path2)
//println(result)


/**
 * 对象的读写
 */

////对象的写 注：一定要序列化对象,否则报 java.io.NotSerializableException:异常
//def saveObject(Object object, String path) {
//    try {
//        //首相创建目标文件
//        def desFile = new File(path)
//        if (!desFile.exists()) {
//            desFile.createNewFile()
//        }
//
//        desFile.withObjectOutputStream { out ->
//            out.writeObject(object)
//        }
//        return true
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//    return false
//}
//
////对象的读
//def readObject(String path) {
//    def obj = null
//    try {
//        def file = new File(path)
//        if (file == null || !file.exists()) {
//            return null
//        }
//
//        //从文件中读取对象
//        file.withObjectInputStream { input ->
//            obj = input.readObject()
//        }
//        return obj
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//    return null
//}
//
//def objectPath = 'Person.bin'
//def person = new Persons(name: 'Android', age: 18)
//println saveObject(person, objectPath)
//def result = (Persons) readObject(objectPath)
//println result.name + '\t' + result.age