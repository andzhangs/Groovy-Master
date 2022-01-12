package groovy

class ExecuteProcess {
    /**
     * 版本控制系统维护
     * @param args
     */
    public static void main(String[] args) {
        //方式一
        try {
            Process process=Runtime.getRuntime().exec("groovy -v")
            BufferedReader result=new BufferedReader(new InputStreamReader(process.getInputStream()))
            String line
            while ((line =result.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace()
        }

        //方式二
//        println "Github Help".execute().text  //打开GitHubDesktop app
//        println "groovy -v".execute().text
//        println "brew list".execute().text
    }
}
