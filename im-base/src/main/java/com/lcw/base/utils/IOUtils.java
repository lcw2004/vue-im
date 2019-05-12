package com.lcw.base.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils extends org.apache.tomcat.util.http.fileupload.IOUtils {

    public static byte[] readFully(InputStream is) throws IOException {
        byte[] bytes = new byte[is.available()];
        readFully(is, bytes);
        return bytes;
    }

    public static String readFullyString(InputStream is) throws IOException {
        byte[] bytes = new byte[is.available()];
        readFully(is, bytes);
        return StringUtils.valueOf(bytes);
    }

}
