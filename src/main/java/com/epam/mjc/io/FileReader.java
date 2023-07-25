package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public static Profile getDataFromFile(File file) throws IOException {
        String content;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file.getPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            fileInputStream = new FileInputStream(file.getPath());
        } catch (FileNotFoundException e) {
            fileInputStream.close();
            throw new RuntimeException(e);

        }

        byte[] bytes = new byte[1024];
        int bts;
        String[] res = new String[0];
        while (true) {
            try {
                if ((bts = fileInputStream.read(bytes)) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileInputStream.close();
            content = new String(bytes, 0, bts);
            res = finalContent(content);


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


