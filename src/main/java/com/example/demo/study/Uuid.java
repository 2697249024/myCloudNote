package com.example.demo.study;
import java.util.UUID;
import java.util.function.Predicate;  

public class Uuid {  
    public static void main(String[] args) {  
        for (int i = 0; i < 5; i++) {  
            //注意replaceAll前面的是正则表达式  
            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
            System.out.println(uuid);  
//            System.out.println(uuid.length());  
            
            
        }  
    }  
}  