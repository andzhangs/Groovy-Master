使用模块定制方法：对现有的类添加扩展方法<br/>
1、声明信息：<br/>
2、命令编译：<br/>
groovyc -d classes mmodule/*.groovy <br/>
jar priceExtensions.jar -C classes com -C manifaet 
    
3、新建一个groovy文件：<br/>

def ticker='ORCL' <br/>
println "Price for $ticker using instance method is ${String.getPrice(ticker)}" <br/>
println "Price for $ticker using instance method is ${ticker.getPrice()}" <br/>
