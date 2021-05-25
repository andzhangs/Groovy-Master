package mop



def methods(){

    def str="HELLO"
    def methodName='toUpperCase'

    def methodOfInterest=str.metaClass.getMetaMethod(methodName)
    if (methodOfInterest != null){
        println(methodOfInterest.invokeMethod(methodName,null))
    }else{
        println('methodOfInterest is null')
    }
}
methods()