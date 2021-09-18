package com.brumalStar.utils;

import com.hankcs.hanlp.HanLP;
import java.util.List;

public class cuttingWordsUtil {
    public static List<String> cuttingWords(String str) {
        // 为了方便计算simHash值，这里调用了HanLp分词中的关键字提取方法 参数（提取目标，提取范围）
        return HanLP.extractKeyword(str, str.length());
    }
}
