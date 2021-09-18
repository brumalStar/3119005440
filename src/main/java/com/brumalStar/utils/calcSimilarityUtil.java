package com.brumalStar.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class calcSimilarityUtil {

    // 调用MD5算法来计算hash值
    public static String calcHashByMd5(String str) {
        try {
            // 调用java自带的数据加密类，并指定其为MD5算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 考虑到是中文文本，将字符编码设置为utf—8防止乱码
            md.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            BigInteger bi = new BigInteger(1, digest);
            StringBuilder hash = new StringBuilder(bi.toString(2));
            // 保证生成的是一个128位散列值
            while (hash.length() < 128) {
                hash.append("0");
            }
            return hash.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }


    public static String calcSimHash(String str) {
        int[] storeHash = new int[128];
        // 分词
        List<String> keywordList = cuttingWordsUtil.cuttingWords(str);
        // 遍历分词得到的关键词组
        for (String item : keywordList) {
            // 调用上面计算hash的方法
            String hash = calcHashByMd5(item);
            // 将 hash值转化为数组，方便后续比较以及加权
            char[] char_hash = hash.toCharArray();
            for (int i = 0; i < storeHash.length; i++) {
                if (char_hash[i] == '1') {
                    storeHash[i]++;
                } else {
                    storeHash[i]--;
                }
            }
        }
        // 降维 方便后面计算hanmming distance
        StringBuilder SimHash = new StringBuilder();
        for (int hash : storeHash) {
            if (hash <= 0)
                SimHash.append("0");
            else
                SimHash.append("1");
        }
        return SimHash.toString();
    }

    public static int calcHammingDistance(String simHash1, String simHash2) {
        int hammingDistance = 0;
        // 计算汉明距离的前提是保证两个字符串等长，因此应该先进行判断
        if (simHash1.length() != simHash2.length()) {
            hammingDistance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public static double calcSimilarity(String simHash1, String simHash2) {
        //调用
        int hammingDistance = calcHammingDistance(simHash1, simHash2);

        double similarity = 0.01 * (100 - hammingDistance * 100 / 128);

        return similarity;
    }

}
