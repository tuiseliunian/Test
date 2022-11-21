package com.zj.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class TestResource {
    private static final String RESOURCE_FILE = "test/test.txt";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        getJarFilePath();
    }

    private static void getJarFilePath() {
        ProtectionDomain pd = TestResource.class.getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        System.out.println(cs.getLocation());
    }

    private static void test4() {
        try {
            // 可以正常获取
            InputStream inputStream = TestResource.class.getClassLoader().getResourceAsStream(RESOURCE_FILE);
            String content = IoUtil.read(inputStream, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test4----------------------------end");
    }

    private static void test3() {
        try {
            URL resource = ResourceUtil.getResource(RESOURCE_FILE, TestResource.class);
            System.out.println(resource);
            String content = FileUtil.readString(resource, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test3---------------------------end");
    }

    private static void test2() {
        try {
            // 可以正常获取
            URL resource = ResourceUtil.getResource(RESOURCE_FILE);
            System.out.println(resource);
            String content = FileUtil.readString(resource, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test2----------------------------end");
    }

    private static void test1() {
        try {
            // 可以正常获取
            Resource resourceObj = ResourceUtil.getResourceObj(RESOURCE_FILE);
            System.out.println(resourceObj.getUrl());
            try (InputStream stream = resourceObj.getStream()) {
                String content = IoUtil.read(stream, StandardCharsets.UTF_8);
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test1----------------------------end");
    }
}
