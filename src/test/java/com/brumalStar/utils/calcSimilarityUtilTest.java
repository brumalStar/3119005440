package com.brumalStar.utils;
import org.junit.Test;

public class calcSimilarityUtilTest {

    @Test
    public void calcHashTest(){
        // 测试用MD5获取128位的hash值
        String[] strings = {"程序员", "是", "从事","程序", "开发", "维护","专业","人员"};
        for(String item : strings){
            String testHash = calcSimilarityUtil.calcHashByMd5(item);
            System.out.println(testHash.length());
            System.out.println(testHash);
        }
    }

    @Test
    public void calcSimHashTest(){
        // 测试经过加权降维得到的SimHash
        String str1 = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        String str2 = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_add.txt");
        System.out.println(calcSimilarityUtil.calcSimHash(str1));
        System.out.println(calcSimilarityUtil.calcSimHash(str2));

    }

    @Test
    public void calcHammingDistanceTest(){
        String str1 = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        String str2 = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_add.txt");
        int hammingDistance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str1),
                calcSimilarityUtil.calcSimHash(str2));
        System.out.println("海明距离为：" + hammingDistance);
        System.out.println("文本相似度为：" + 0.01 * (100 - hammingDistance * 100 / 128));

    }

    @Test
    public void calcSimilarityTest(){
        String str1 = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        String str2 = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_add.txt");
        int hammingDistance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str1),
                calcSimilarityUtil.calcSimHash(str2));
        double similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str1),
                calcSimilarityUtil.calcSimHash(str2));

        System.out.println("原文本和抄袭文本的海明距离为：" + hammingDistance);
        System.out.println("原文本和抄袭文本的文本相似度为：" + similarity );
    }
}
