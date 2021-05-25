package script.j2gscript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CallScript {
    public static void main(String[] args) {
        ScriptEngineManager manager=new ScriptEngineManager();
        ScriptEngine engine=manager.getEngineByExtension("groovy");
        System.out.println("Call script from java");
        try{
            engine.eval("println 'Hello from Groovy'");
            System.out.println();


            engine.put("name","达拉咯");
            engine.eval("println \"Hello ${name} from groovy \";name+='!'");
            String name= (String) engine.get("name");
            System.out.println("打印："+name);
        }catch (ScriptException e){
            System.out.println(e.toString());
        }
    }
}
