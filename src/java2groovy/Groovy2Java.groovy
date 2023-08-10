package java2groovy

/**
 * Groovy调用Java直接引用就行了
 *
 */
class Groovy2Java {
    public static void main(String[] args) {
        BaseBean baseBean=new BaseBean(10086,'Hello','World')
        String msg=baseBean.toString()
        println("打印："+msg)
    }
}
