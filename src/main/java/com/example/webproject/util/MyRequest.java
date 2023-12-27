package com.example.webproject.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.List;

public class MyRequest extends HttpServletRequestWrapper {

    public MyRequest(HttpServletRequest request) {
        super(request);
    }
    public String getParameter(String name) {
        if ("title".equals(name)) {
            String value = super.getParameter(name);
            return filterInput(value);
        }else if("content".equals(name)){
            String value = super.getParameter(name);
            return filterInput(value);
        }else {
            return super.getParameter(name);
        }


    }

    public String filterInput(String str){
        DBhelper db = new DBhelper();
        db.init();
        List<String> wordList = db.getFilterWord(db.dbconn);
        if(wordList.isEmpty()) {
            return str;  // 如果wordList为空，直接返回原始值
        }
        for(String word: wordList){
            if(str.contains(word)){
                str = str.replaceAll(word, "[][文明用语哦~]");
            }
        }
        return str;
    }
}
