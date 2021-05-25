package module

class PriceExtension {
    public static double getPrice(String self){
        def utl="http://ichart.finance.yahoo.com/table.csv?s=$self".toURL()
        def data=utl.readLines()[1].split(',')
        Double.parseDouble(data[-1])
    }
}
