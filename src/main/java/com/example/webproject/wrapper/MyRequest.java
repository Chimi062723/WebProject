package com.example.webproject.wrapper;

import com.example.webproject.util.DBhelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Arrays;
import java.util.List;

public class MyRequest extends HttpServletRequestWrapper {
    private final List<String> sensitiveParams = Arrays.asList("title", "content", "username", "comment","commentContent","review");

    public MyRequest(HttpServletRequest request) {
        super(request);
    }
//    public String getParameter(String name) {
//        if ("title".equals(name)) {
//            String value = super.getParameter(name);
//            return filterInput(value);
//        }else if("content".equals(name)){
//            String value = super.getParameter(name);
//            return filterInput(value);
//        }else if("username".equals(name)){
//            String value = super.getParameter(name);
//            return filterInput(value);
//        }else if("comment".equals(name)){
//            String value = super.getParameter(name);
//            return filterInput(value);
//        }else {
//            return super.getParameter(name);
//        }
//
//
//    }
//    public String getParameter(String name) {
//        String value = super.getParameter(name);
//        if (value != null) {
//            return filterInput(value);
//        }
//        return value;

//    }
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
