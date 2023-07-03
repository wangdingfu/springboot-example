package com.fuge.example;

import cn.hutool.json.JSONUtil;
import cn.hutool.script.ScriptUtil;
import org.slf4j.LoggerFactory;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author wangdingfu
 * @date 2023-05-30 11:58:25
 */
public class ScriptTest {

    String js = "fudoc.environment.set(\"ACCESS_TOKEN\", jsonData.token_type + ' ' + jsonData.access_token);\n" +
            "fudoc.environment.set(\"ACCESS_TOKEN_EXPIRES\", new Date().getTime()+(jsonData.expires_in)*1000);";
    //创建容器对象
    private ScirptContainer scirptContainer = new ScirptContainer();

//    public static void main(String[] args) {
//        ScriptEngine jsEngine = ScriptUtil.createJsEngine();
//        Bindings bindings = jsEngine.createBindings();
//
//        jsEngine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
//
//
//    }


    public static void main(String[] args) throws Exception {
//        RunScript rs = new RunScript("D:\\test.js");
//        Bindings bindings = rs.getEngine().createBindings();
//        FuDocContent fuDocContent = new FuDocContent();
//        Map<String,Object> env = new HashMap<>();
//        Map<String,Object> result = new HashMap<>();
//        Map<String,Object> jsonData = new HashMap<>();
//        jsonData.put("access_token","21313213123");
//        jsonData.put("expire_time",60);
//        result.put("data",jsonData);
//        fuDocContent.setEnv(env);
//        fuDocContent.setResult(result);
//        bindings.put("fudoc",fuDocContent);
//        rs.start(bindings);
//        System.out.println(JSONUtil.toJsonPrettyStr(fuDocContent));
    }
}

