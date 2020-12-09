package com.github.Dnkiss.Homework_1;

import java.util.Arrays;
import java.util.List;

public class PinyinComparator {
    public static void main(String[]args){
        String[] arr = { "阿巴", "万普初", "邹志伟", "广洺祺", "JAVA", "123", "$%$#", "哈哈A",
                "可惜", "！@#", "1笨蛋！a", "嗷嗷", "我就一拳头过去", "真就那个肉蛋葱鸡" };
        List<String> list = Arrays.asList(arr);
        Arrays.sort(arr, new PinyinConverter());
        System.out.println(list);
    }
}
