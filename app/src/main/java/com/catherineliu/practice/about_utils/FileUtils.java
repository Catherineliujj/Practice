package com.catherineliu.practice.about_utils;

import java.io.File;

/**
 * 项目：Practice
 * 文件描述：文件相关工具类
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public class FileUtils {

    public static File getTempFile(String url, String filePath) {
        File parentFile = new File(filePath).getParentFile();
        String md5 = bytes2HexString(url.getBytes());
        return new File(parentFile.getAbsolutePath(), md5 + ".temp");
    }

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String bytes2HexString(final byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        int len = bytes.length;
        if (len <= 0) {
            return "";
        }
        char[] ret = new char[len << 1];
        for (int i = 0, j = 0; i < len; i++) {
            ret[j++] = HEX_DIGITS[bytes[i] >> 4 & 0x0f];
            ret[j++] = HEX_DIGITS[bytes[i] & 0x0f];
        }
        return new String(ret);
    }
}