package com.zj.rename;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReFilename {
    /*
     * 通过递归得到某一路径下所有的目录及其文件
     */
    static void changeNames(String filePath, String decode, String encode) throws UnsupportedEncodingException {
        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                changeNames(file.getAbsolutePath(), decode, encode);
                System.out.println(changeName(file.getAbsolutePath(), decode, encode) + ":" + file.getAbsolutePath());
            } else {
                System.out.println(changeName(file.getAbsolutePath(), decode, encode) + ":" + file.getAbsolutePath());
            }
        }
    }

    /*
     * 修改文件名，成功返回true
     */
    public static boolean changeName(String path, String decode, String encode) throws UnsupportedEncodingException {
        File oldfile = new File(path);
        // 获取当前文件名，转换编码得到新的文件名
        String newName = new String(oldfile.getName().getBytes(decode), encode);
        System.out.println(newName);
        File newfile = new File(oldfile.getParent() + File.separator + newName);
        // 重命名
        return oldfile.renameTo(newfile);

    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        testCoding();
        //更改文件的路径
        String decode = "ISO-8859-1";
        String encode = "gbk";
        changeNames("\\\\192.168.1.119\\media\\books\\小书屋", decode, encode);
    }

    private static void testCoding() throws UnsupportedEncodingException {
        String oldName = "(µÂ)ÌÀÄ·.°ÂÍÐÊÖ»æ²ÊÉ«Ö²ÎïÍ¼Æ×.epub";
        // 获取当前文件名，转换编码得到新的文件名
        List<String> codingList = new ArrayList<>();

        codingList.add(StandardCharsets.US_ASCII.toString());
        codingList.add(StandardCharsets.UTF_8.toString());
        codingList.add("gbk");
        codingList.add("Windows-31J");
        codingList.add(StandardCharsets.ISO_8859_1.toString());
        for (String decode : codingList) {
            for (String encode : codingList) {
                String newName = new String(oldName.getBytes(decode), encode);
                System.out.println(decode + " " + encode + ":" + newName);
            }
        }
    }
}