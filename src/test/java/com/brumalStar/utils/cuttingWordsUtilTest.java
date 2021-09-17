package com.brumalStar.utils;

import com.hankcs.hanlp.HanLP;
import org.junit.Test;

import java.util.List;

public class cuttingWordsUtilTest {

    @Test
    public void cutWordsUtilTest(){
        // 原工具类直接调用了 HanLp分词的 关键词提取方法 因此这里直接引用官方文档的例子
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(content, content.length());
        System.out.println(keywordList);
    }
}
