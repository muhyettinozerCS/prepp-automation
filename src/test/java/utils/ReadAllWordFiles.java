package utils;

import java.io.File;
import java.io.FilenameFilter;

public class ReadAllWordFiles {
    public static void main(String[] args) {
        String folderPath = "src/resources/";
        File folder = new File(folderPath);
        File[] wordFiles = folder.listFiles(new WordFileFilter());

        for (File file : wordFiles) {
            String fileName = removeExtension(file.getName());
            System.out.println("Word dosyası: " + fileName);
        }
    }

    private static String removeExtension(String filename) {
        int lastIndexOfDot = filename.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return filename;
        }
        return filename.substring(0, lastIndexOfDot);
    }
    public static String removeExtensionDot(String filename) {
        int lastIndexOfDot = filename.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return ""; // Dosya adında nokta karakteri yok, uzantı da yok
        }
        return filename.substring(lastIndexOfDot + 1);
    }
    public static String removeExtensionBrackets(String filename) {
        int lastIndexOfBrackets = filename.lastIndexOf(')');
        if (lastIndexOfBrackets == -1) {
            return ""; // Dosya adında nokta karakteri yok, uzantı da yok
        }
        return filename.substring(lastIndexOfBrackets + 1);
    }


    private static class WordFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".docx");
        }
    }
}