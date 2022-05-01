package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Service
public class DictionaryServiceImpl implements IDictionaryService {

    public String translateResult(String name){
        String result = "";
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("name","tên");
        dictionary.put("book","sách");
        dictionary.put("dog","chó");
        dictionary.put("cat","mèo");
        dictionary.put("tree","non");

        for(Map.Entry<String,String> map : dictionary.entrySet()){
            if(map.getKey().equals(name)){
                result = map.getValue();
                break;
            }
        }
        return result;
    }
}
