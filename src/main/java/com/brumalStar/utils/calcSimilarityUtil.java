package com.brumalStar.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class calcSimilarityUtil {

    public static String calcHashByMd5(String str) {
        try {
            // 调用java自带的数据加密类，并指定其为MD5算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 考虑到是中文文本，将字符编码设置为utf—8防止乱码
            md.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            BigInteger bi = new BigInteger(1, digest);
            String hash = bi.toString(16);
            while (hash.length() < 128) {
                hash += "0";
            }
            return hash;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }


    public static String calcSimHash(String str) {
        int[] storeHash = new int[128];
        List<String> keywordList = cuttingWordsUtil.cuttingWords(str);
        int size = keywordList.size();
        for (String item : keywordList) {
            String hash = calcHashByMd5(item);
            // 将 hash值转化为数组，方便后续比较以及加权
            char char_hash[] = hash.toCharArray();
            for (int i = 0; i < storeHash.length; i++) {
                if (char_hash[i] == '1') {
                    storeHash[i]++;
                } else {
                    storeHash[i]--;
                }
            }
        }
        String SimHash = "";
        for (int i = 0; i < storeHash.length; i++) {
            if (storeHash[i] <= 0)
                SimHash += "0";
            else
                SimHash += "1";
        }
        return SimHash;
    }

    public static int calcHammingDistance(String simHash1, String simHash2) {
        int hammingDistance = 0;
        // 计算汉明距离的前提是保证两个字符串等长，因此应该先进行判断
        if(simHash1.length() != simHash2.length()){
            hammingDistance = -1;
        } else{
            for(int i = 0; i < simHash1.length(); i++) {
                if(simHash1.charAt(i) != simHash2.charAt(i)){
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public static double calcSimilarity(String simHash1, String simHash2) {
        int hammingDistance = calcHammingDistance(simHash1, simHash2);

        double similarity = 0.01 * (100 - hammingDistance * 100 / 128);

        return similarity;
    }

}
