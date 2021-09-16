package com.brumalStar.utils;

import java.io.*;

public class convertUtils {


    public static String convertTxt2String(String filePath){
        String str = "";
        String str1;
        // 创建一个File对象用于读取需要进行查重的文本
        File file = new File(filePath);
        // 使用文件输入流来从文件读取文本
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            // 将字节流转换为字符流，便于对字符进行分割
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 将用BufferedReader读取道德字符流逐行读取 拼接到 str 上，最后返回整个转化为字符串的文本
            while ((str1 = bufferedReader.readLine()) != null){
                str += str1;
            }
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

   public static void convertResult2Txt(double txt,String txtPath){
       String str = Double.toString(txt);
       File file = new File(txtPath);
       FileWriter fileWriter = null;
       try{
           // 按字符向流中 写入接收到的输出数据 ，此处append参数的属性为true，表明将字节写入文件末尾
           fileWriter = new FileWriter(file, true);
           // 对需要的结果输出部分进行截取
           fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
           fileWriter.write("\r\n");
           fileWriter.close();
       } catch (IOException e){
           e.printStackTrace();
       }
   }


}
