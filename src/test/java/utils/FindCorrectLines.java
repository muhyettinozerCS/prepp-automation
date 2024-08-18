package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindCorrectLines {

    public static void main(String[] args) {
        String textFilePath = "Continuous1MultipleChoices.txt"; // Path to the text file
        int questionNumber = 5; // Example: Input the desired question number here

        int lineNumber = findCorrectLine(textFilePath, questionNumber);

        if (lineNumber != -1) {
            System.out.println("Line number with correct answer for question " + questionNumber + ": " + lineNumber);
            System.out.println("Answer for line " + lineNumber + ": " + getAnswerFromLineNumber(lineNumber));
        } else {
            System.out.println("Correct answer not found for question " + questionNumber);
        }
    }
    public static List<String> getSpecificLines(String textFilePath, int startLine, int endLine) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(textFilePath)))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine >= startLine && currentLine <= endLine) {
                    lines.add(line);
                }
                if (currentLine > endLine) {
                    break;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static int findCorrectLine(String textFilePath, int questionNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(textFilePath)))) {
            String expectedCorrect = questionNumber + "correct";
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.startsWith(expectedCorrect)) {
                    return lineNumber;
                }
                if (line.startsWith("correct")) {
                    return -1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      return -1;
    }
    public static int countLines(String textFilePath) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(textFilePath)))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineCount;
    }
    public static List<String> getWordsListFromLine(String textFilePath, int lineNumber) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(textFilePath)))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    String[] parts = line.split("/"); // Satırı slash'lere göre böler
                    for (String part : parts) {
                        words.add(part.trim()); // Listeye ekler, trim ile gereksiz boşluklar temizlenir
                    }
                    break;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    // Belirli bir satırdaki slashler arasındaki kelime sayısını döndürür
    public static int countSlashesInLine(String textFilePath, int lineNumber) {
        int slashCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(textFilePath)))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    slashCount = line.length() - line.replace("/", "").length(); // Slash sayısını hesaplıyoruz
                    break;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return slashCount+1;
    }


    public static String getAnswerFromLineNumber(int lineNumber) {
        return switch (((lineNumber - 2) % 6) - 2) { // Assuming answers A, B, C, D repeat every 4 lines
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            default -> null;
        };
    }
    public static void addBlockNumbersToText(String textFilePath, int blockNumbers) {
        File originalFile = new File(textFilePath);
        File tempFile = new File("temp_" + originalFile.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            int lineNumber = 0;
            int blockNumber = 0;
            lineNumber += blockNumbers;

            while ((line = reader.readLine()) != null) {
//                 Her 6 satırı bir blok numarasıyla işaretle
                if (lineNumber % 6 == 1) {
                    writer.write( line);
                    writer.newLine();
                }else {
                    writer.write(blockNumber + line);
                    writer.newLine();
                }

                if ((lineNumber) % 6 == 0) {
                    blockNumber++; // Her 6 satırda bir blok numarasını artır
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Geçici dosyayı orijinal dosyanın yerine koy
        if (!originalFile.delete()) {
            System.out.println("Orijinal dosya silinemedi.");
        }
        if (!tempFile.renameTo(originalFile)) {
            System.out.println("Geçici dosya orijinal dosyaya taşınamadı.");
        }
    }
}