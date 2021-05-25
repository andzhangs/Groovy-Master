package first.groovy.dataconstructutures

/**
 *      数据结构
 *  1、列表：增、删、改、查
 */

//数组
def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]
println array.class
println array2.class

//集合
def list = [7, 6, 8, 1, 5, 2, 9, 0, 3, 4]
println list.class
//重载函数：自定义排序规则,(按绝对值大小排序)
Comparator comparator = { a, b -> a == b ? 0 : (Math.abs(a) < Math.abs(b) ? -1 : 1) }
// 顺序
Collections.sort(list, comparator)
println list

//闭包形式  倒序
list.sort { a, b -> a == b ? 0 : (Math.abs(a) < Math.abs(b) ? 1 : -1) }
println list

//根据长度排序
def strList = ["android", "JavaScript", "kotlin", "Flutter"]
strList.sort { it -> return it.size() }
println strList


/**
 * 列表查找
 */
def findList = [1, 2, 3, 4, 5, 6, 7, 8, 9]
int resultOne = findList.find { return it % 2 == 0 }  //返回第一个符合条件的
println resultOne

List resultAll = findList.findAll { return it % 2 != 0 }  //返回所有符合条件的
println resultAll.toListString()

println findList.any { return it % 2 != 0 }   //列表元素只要一个满足条件就行

println findList.every { return it % 2 != 0 }   //列表元素都满足条件才行

println "下标：" + findList.findIndexOf { it == 8 }  //根据value找下标

println "最小值 ：" + findList.min { return Math.abs(it) }   //最小值  Math.abs 绝对值

println "最大值：" + findList.max { return Math.abs(it) }   //最大值

println "统计："+findList.count { return it > 5 }  //统计 符合条件的