package first.groovy.dataconstructutures

/**
 *      数据结构
 *  1、映射
 *      key：定义为不可变字符串 单引号 ''
 */


def map = ['key1': "android",
           'key2': "IOS",
           'key3': 'JAVA',
           key4  : "web"]

println map.get("key1") + "\t" + map["key2"] + "\t" + map.key4   //根据索引查找元素

map.put("value", 10010)
map.key4 = "WebSocket"   //1、若map中找到对应的key，则会替换对应的值;
map.key5 = "Server"      //2、若map中没找到对应的key，则会新增一个元素
map.key6 = [a: 1, b: 2]  //二阶map

println map.toMapString()

println map.key6.a

map.remove("key4")

println map.toMapString()

println map.getClass()


def data = [
        1: [id: 400, name: "Tom"],
        2: [id: 401, name: "David"],
        3: [id: 402, name: "Dean"],
        4: [id: 403, name: "Maker"],
        5: [id: 404, name: "Louis"]
]
//遍历
data.each {
    stu -> println "key：${stu.key} value：${stu.value}"
}

//带索引的遍历key-value
data.eachWithIndex { def students, int index -> println "索引：${index}, key：${students.key}, value：${students.value}" }

//Map 查找
println data.find { def stu -> return stu.value.id > 400 }

println data.findAll { def stu -> return stu.value.id > 403 }

println data.count { def stu -> return stu.value.id > 403 && stu.key > 3 }

println data.findAll { def stu -> return stu.value.id > 402 }.collect { return it.value.name }

//分组
println data.groupBy { def stu -> stu.value.id > 402 ? 'Good' : 'Bad' }

//排序
println data.sort { def stu1, def stu2 ->
    Number id1 = stu1.key
    Number id2 = stu2.key
    return id1 == id2 ? 0 : (id1 < id2 ? 1 : -1)
}

