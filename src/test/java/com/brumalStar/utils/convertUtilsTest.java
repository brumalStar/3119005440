package com.brumalStar.utils;

import org.junit.Test;

public class convertUtilsTest {

    @Test
    public void fileRead() {
        /*
         * 简单测试：
         * 1.路径正确的前提下，正常读取文件
         * 2.通过使用正则表达式的去掉标点符号并打印最后输出
         * 的操作检测是否正常转变为了字符串
         * */
        String str = convertUtils.convertTxt2String("G:\\testText\\orig.txt");
        String replace_str = str.replaceAll("\\pP|\\pS", "");
        String[] strings = replace_str.split(" ");
        for (String item : strings) {
            System.out.println(item);
        }
    }

    @Test
    public void wrongFileRead() {
        //路径错误的情况
        String str = convertUtils.convertTxt2String("G:\\orig.txt");
        System.out.println(str);
    }


    @Test
    public void fileWrite() {
        // 成功将结果写入了指定目录下的指定文件
        double[] result = {0.67, 0.86, 0.91, 0.79, 0.69};
        for (double v : result) {
            convertUtils.convertResult2Txt(v, "G:\\testResult.txt");
        }
    }

    @Test
    public void wrongFileWrite(){
        // 路径错误，写入失败
        double[] result = {0.67, 0.86, 0.91, 0.79, 0.69};
        for (double v : result) {
            convertUtils.convertResult2Txt(v, "G:\\result\\testResult.txt");
        }
    }



}
