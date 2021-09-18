package com.brumalStar.main;


import com.brumalStar.utils.calcSimilarityUtil;
import com.brumalStar.utils.convertUtils;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void origAndOthersTest1() {
        // 测试文本1
        String[] str = new String[6];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_add.txt");
        str[2] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_del.txt");
        str[3] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_1.txt");
        str[4] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_10.txt");
        str[5] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_15.txt");
        String resultTxt = "G:\\resultTxt\\resultAll.txt";
        for (int i = 1; i < str.length; i++) {
            String result = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]), calcSimilarityUtil.calcSimHash(str[i]));
            System.out.println(result);
            convertUtils.convertResult2Txt(result, resultTxt);
        }
    }

    @Test
    public void origAndAddTest(){
        String[] str = new String[2];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_add.txt");
        int distance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        String similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        System.out.println("海明距离：" + distance);
        System.out.println("原文本和抄袭文本的相似度：" + similarity);
    }

    @Test
    public void origAndDelTest(){
        String[] str = new String[2];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_del.txt");
        int distance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        String similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        System.out.println("海明距离：" + distance);
        System.out.println("原文本和抄袭文本的相似度：" + similarity);
    }

    @Test
    public void origAndDis_1Test(){
        String[] str = new String[2];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_1.txt");
        int distance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        String similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        System.out.println("海明距离：" + distance);
        System.out.println("原文本和抄袭文本的相似度：" + similarity);
    }

    @Test
    public void origAndDis_10Test(){
        String[] str = new String[2];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_10.txt");
        int distance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        String similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        System.out.println("海明距离：" + distance);
        System.out.println("原文本和抄袭文本的相似度：" + similarity);
    }

    @Test
    public void origAndDis_15Test(){
        String[] str = new String[2];
        str[0] = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        str[1] = convertUtils.convertTxt2String("G:\\testText\\orig_0.8_dis_15.txt");
        int distance = calcSimilarityUtil.calcHammingDistance(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        String similarity = calcSimilarityUtil.calcSimilarity(calcSimilarityUtil.calcSimHash(str[0]),calcSimilarityUtil.calcSimHash(str[1]));
        System.out.println("海明距离：" + distance);
        System.out.println("原文本和抄袭文本的相似度：" + similarity);
    }


}
