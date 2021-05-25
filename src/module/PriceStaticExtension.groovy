package module

class PriceStaticExtension {
    public static double getPrice(String self, String ticker) {
        def utl = "http://ichart.finance.yahoo.com/table.csv?s=$ticker".toURL()
        def data = utl.readLines()[1].split(',')
        Double.parseDouble(data[-1])
    }

}
