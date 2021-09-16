package com.brumalStar.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.List;

public class cuttingWordsUtil {
    public static List<String> cuttingWords(String str) {
        // 为了方便计算simHash值，这里调用了hanlp分词中的关键字提取方法 参数（提取目标，提取范围）
        List<String> keywordList = HanLP.extractKeyword(str,str.length());
        return keywordList;
    }
    public static void main(String[] args){
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(content, content.length());
        System.out.println(keywordList);
    }
}
