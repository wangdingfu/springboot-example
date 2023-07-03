package com.fuge.example;

import cn.hutool.script.ScriptUtil;

import javax.script.*;
import java.util.concurrent.ConcurrentHashMap;

public class ScirptContainer {


    public static ScriptEngine engine;//脚本引擎

    static {
        engine = ScriptUtil.createJsEngine();
        //获取正文并且写入
        engine.getContext().getWriter();
    }

    private ConcurrentHashMap<Integer, CompiledScript> scripts = new ConcurrentHashMap<>();//脚本存储容器


    public CompiledScript getCompiledScript(String script) throws ScriptException {
        //判断脚本是否为空
        if (script == null || "".equals(script)) {
            throw new ScriptException("JavaScript empty");
        }
        //获取脚本Hash
        int hashCode = script.hashCode();
        //从容器中获取脚本
        CompiledScript compiledScript = scripts.get(hashCode);
        if (compiledScript == null) {
            //容器中无脚本创建脚本对象
            Compilable compilable = (Compilable) engine;
            //编译JavaScript脚本
            compiledScript = compilable.compile(script);
            //脚本对象存入容器中
            scripts.put(hashCode, compiledScript);
        }
        return compiledScript;
    }
}