package com.example.datastructure.sparsearray.filereview;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名：FileReview
 * 作 者：Miles zhu
 * 时 间：2019/12/12 23:43
 * -------------------------
 * 功能和描述：
 **/
public class FileReview {
    public static void main(String[] args) {
        File file = new File("F:\\桌面文件\\zyz");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".avi");
            }
        });


        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
