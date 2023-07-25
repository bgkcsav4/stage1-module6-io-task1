package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public static Profile getDataFromFile(File file) {
        String content;
        String[] res = new String[0];

        try (FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            byte[] bytes = new byte[1024];
            int bts;
            while ((bts = fileInputStream.read(bytes)) != -1) {
                content = new String(bytes, 0, bts);
                res = finalContent(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Profile(res[0], Integer.parseInt(res[1]), res[2], Long.parseLong(res[3]));
    }

    public static String[] finalContent(String content) {
        String[] finalContent = new String[4];
        String[] lines = content.split("\\r?\\n");
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(":");
            if (parts.length == 2) {
                finalContent[i] = parts[1].trim();
            }
        }
        return finalContent;
    }

}
