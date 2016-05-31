package com.ffcs.crmd.cas.base;

import java.util.Random;

public class RandomHan { 

    private Random ran = new Random(); 

    private final static int delta = 0x9fa5 - 0x4e00 + 1; 

    public static void main(String[] args) {
        RandomHan han = new RandomHan();
        System.out.println(han.getRandomHan(3));
    }
       

    public String getRandomHan(int num) { 
        if(num <=0){
            num = 1;
        }
        StringBuffer hanzi = new StringBuffer();
        for (int i = 0; i < num; i++) {
            
            hanzi.append(new StringBuffer().append((char)(0x4e00 + ran.nextInt(delta))));
        }
        return hanzi.toString();  

    } 

}