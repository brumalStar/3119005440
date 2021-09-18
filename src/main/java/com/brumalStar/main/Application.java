package com.brumalStar.main;

import com.brumalStar.utils.calcSimilarityUtil;
import com.brumalStar.utils.convertUtils;

public class Application {
    public static void main(String[] args){
        // 顺序读取 在命令行键入的文件名
       String str1 = convertUtils.convertTxt2String(args[0]);
       String str2 = convertUtils.convertTxt2String(args[1]);
       String resultOut = args[2];

       //根据 存入的字符串 求出对应的 SimHash值
        String simHash1 = calcSimilarityUtil.calcSimHash(str1);
        String simHash2 = calcSimilarityUtil.calcSimHash(str2);

       // 根据读入的文件求出它们的相似度
        String similarity = calcSimilarityUtil.calcSimilarity(simHash1,simHash2);

        // 将计算结果写入到指定文件
        convertUtils.convertResult2Txt(similarity, resultOut);

    }
}
