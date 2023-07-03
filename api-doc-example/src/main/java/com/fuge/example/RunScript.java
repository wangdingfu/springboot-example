package com.fuge.example;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 运行脚本
 * @author Ruby
 *
 */
public class RunScript {

    private ScriptEngineManager manager = new ScriptEngineManager();
    @Getter
    private ScriptEngine engine;
    private String fileName;
    
    public RunScript(String fileName){
        engine = manager.getEngineByName("JavaScript");
        this.fileName = fileName;
    }
    
    /**
     * 设置变量
     * @param varName
     * @param obj
     */
    public void setVar(String varName, Object obj){
        engine.put(varName, obj);
    }
    
    /**
     * 启动脚本
     * @throws FileNotFoundException
     * @throws ScriptException
     */
    public void start(Bindings bindings) throws FileNotFoundException, ScriptException{
        engine.eval(new FileReader(fileName),bindings);
    }
}