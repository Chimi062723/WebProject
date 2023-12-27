package com.example.webproject.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Arrays;
import java.util.List;

public class MyRequest extends HttpServletRequestWrapper {
    private final List<String> sensitiveParams = Arrays.asList("title", "content", "username", "comment","commentContent","review");

    public MyRequest(HttpServletRequest request) {
        super(request);
    }

@Override
public String getParameter(String name) {
    String value = super.getParameter(name);
    if (value != null && sensitiveParams.contains(name)) {
        return filterInput(value);
    }
    return value;
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
