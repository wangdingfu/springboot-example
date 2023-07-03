package com.fuge.example.script;

import cn.hutool.json.JSONUtil;
import cn.hutool.script.ScriptUtil;
import com.fuge.example.FuDocContent;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import javax.script.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JavaScriptDemo {
    public static void main(String[] args) throws Exception {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("javascript");
//
        FuDocContext fuDocContext = buildContext();
//        // 绑定Java对象
//        engine.put("fudoc", fuDocContext);
//        ScriptEngine jsEngine = ScriptUtil.createScript("javascript");

//        engine.eval(new FileReader("D:\\test.js"));
        // 执行JavaScript代码
//        engine.eval("var token = '241342'");
//        String script = "const x = 10; console.log(x);";
//        jsEngine.eval(script);

        Context cx = Context.enter();

        try {
            // 将Java对象绑定到Rhino执行上下文中
            ScriptableObject scriptableObject = cx.initStandardObjects();
            ScriptableObject.putProperty(scriptableObject, "fudoc", fuDocContext);
            cx.evaluateReader(scriptableObject, new FileReader("D:\\test.js"), "<cmd>", 1, null);
        } finally {
            Context.exit();
        }

        System.out.println(JSONUtil.toJsonPrettyStr(fuDocContext));
    }

    private static final String json = "{\n" +
            "    \"code\": 0,\n" +
            "    \"message\": \"请求成功\",\n" +
            "    \"data\":\n" +
            "    {\n" +
            "        \"token\": \"uiorqwuriewo840912843\",\n" +
            "        \"expireTime\": 60\n" +
            "    }\n" +
            "}";

    private static FuDocContext buildContext() {
        FuDocContext context = new FuDocContext();
        context.setResult(JSONUtil.parse(json));
        return context;
    }

}
