package script.j2g


class DynamicGroovyClass {
    /**
     * 当某个不存在的方法被调用时，该方法会接入
     * @param methodName 方法明
     * @param args 内容
     * @return
     */
    def methodMissing(String methodName,args){
        println("You called $name with ${args.join(',')}")
        args.size()
    }
}
