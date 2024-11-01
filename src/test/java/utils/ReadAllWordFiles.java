package utils;

import java.io.File;
import java.io.FilenameFilter;

public class ReadAllWordFiles {
    public static void main(String[] args) {
        String wordFolderPath = "src/resources";
        String textFolderPath = "src/resources/resourcesText";

        File wordFolder = new File(wordFolderPath);
        File[] wordFiles = wordFolder.listFiles(new WordFileFilter());



        for (File wordFile : wordFiles) {
            String wordFileName = removeExtension(wordFile.getName());
            System.out.println("Word dosyası: " + wordFileName);
        }

        File textFolder = new File(textFolderPath);
        File[] textFiles = textFolder.listFiles(new TextFileFilter());

        for (File textFile : textFiles) {
            String textFileName = removeExtension(textFile.getName());
            System.out.println("Text dosyası: " + textFileName);
        }
    }

    private static void wordFileName(File file) {

    }
    private static void textFileName(File file) {

    }


    private static String removeExtension(String filename) {
        int lastIndexOfDot = filename.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return filename;
        }
        return filename.substring(0, lastIndexOfDot);
    }
//    public static String removeExtensionDot(String filename) {
//        int lastIndexOfDot = filename.lastIndexOf('.');
//        if (lastIndexOfDot == -1) {
//            return ""; // Dosya adında nokta karakteri yok, uzantı da yok
//        }
//        return filename.substring(lastIndexOfDot + 1);
//    }
//    public static String removeExtensionBrackets(String filename) {
//        int lastIndexOfBrackets = filename.lastIndexOf(')');
//        if (lastIndexOfBrackets == -1) {
//            return ""; // Dosya adında nokta karakteri yok, uzantı da yok
//        }
//        return filename.substring(lastIndexOfBrackets + 1);
//    }


    private static class WordFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".docx");
        }
    }
    private static class TextFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".txt");
        }
    }
}