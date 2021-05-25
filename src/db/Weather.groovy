package db

import groovy.sql.Sql
import groovy.xml.MarkupBuilder


def db_url = 'jdbc:mysql://localhost:3306/weatherinfo?characterEncoding=utf8&useSSL=false'
def username = 'root'
def password = 'admin2020'
def driverClass = 'com.mysql.jdbc.Driver'
def sql = Sql.newInstance(db_url, username, password, driverClass)
println('当前数据库：' + sql.connection.catalog)

//println("City             Temperature")
//方式一 输出的头部为硬编码
sql.eachRow('select * from weather') {
    printf("%-20s%s\n", it[1], it[2])
//  System.out.println(it.city+", "+it.temperature)
}

//返回一个结果数据ArrayList
def rows = sql.rows('select * from weather')
println("Weather info available for ${rows.size()} cities")

def bldr = new MarkupBuilder()
bldr.weather {
    sql.eachRow('select * from weather') {
        city(name: it.city, temperature: it.temperature)
    }
}
println()

//DataSet过滤数据
def dataSet = sql.dataSet('weather')
println('Cities below freezing:')
// 过滤方式一
dataSet.each { if (it.temperature < 32) {
    print('\t' + it.city)
} }
// 过滤方式二
println('Cities below freezing:')
//def citiesBelowFreezing = dataSet.findAll { it.temperature < 32 }
//citiesBelowFreezing.each {println(it.city)}

//方式二
//def processMeta = { metaData ->
//    metaData.columnCount.times { i ->
//        printf("%-20s", metaData.getColumnLabel(i+1))
//    }
//    println()
//}
//sql.eachRow('select * from weather',processMeta){
//    printf("%-20s%s\n", it[0],it.city,it[2])
//}

println()

//插入、更新
println("Weather info available for ${sql.rows('select * from weather').size()} cities")
// 插入方式一
//dataSet.add(city:'ChangSha',temperature: 20)
// 插入方式二
//def customTemp=22
//dataSet.executeInsert("""
//   insert into weather (city,temperature)
//   values ('TaiWan',$customTemp)
//""")
println("Weather info available for ${sql.rows('select * from weather').size()} cities")

println(sql.firstRow("select temperature from weather where city='HongKong'"))

println()
//访问Microsoft Excel
//def sqlExcel = Sql.newInstance("""jdbc:odbc:Driver=
//    {Microsoft Excel Driver (*.xls,*.xlsx,*.xlsm,*.xlsb)};
//    DBQ=/Users/zhangshuai/Idea_Project/Groovy-Master/weather.xlsx;READONLY=false""",
//        '',
//        '')
//println('打印Excel 文件内容：')
//sqlExcel.eachRow('select * from [age$]'){
//    println("${it.name}\t\t${it.age}")
//}

