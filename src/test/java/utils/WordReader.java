package utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordReader {

    public static void main(String[] args) {
        String filePath = "src/resources/5. Narrative Tenses.docx";
        List<String> keywords = Arrays.asList(
                "Vocabulary-Reading-1", "Vocabulary-MultipleChoices-1", "Vocabulary-ClozeTest-1",
                "Grammar-MultipleChoices-1", "Grammar-MultipleChoices-2", "Grammar-ClozeTest-1",
                "OrdertheSentence"
        );

        // Process Word document
        processWordDocument(filePath, keywords);

        // Add block numbers to text file
//        String textFilePath = "Continuous1Reading.txt";
//        FindCorrectLines.addBlockNumbersToText(textFilePath,4);
    }

    public static void processWordDocument(String filePath, List<String> keywords) {
        Set<String> redText = new HashSet<>();  // Kırmızı renge sahip metinleri toplamak için

        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            FileWriter writer = null;
            String currentKeyword = null;

            // Paragrafları tek tek okuyoruz
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                StringBuilder paragraphText = new StringBuilder();
                boolean hasRedText = false;

                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null) {
                        // Eğer metin kırmızı renkte ise, başına "correct" ekleriz
                        if ("FF0000".equals(run.getColor())) {  // Kırmızı renk kodu
                            redText.add("correct ");  // HashSet kullanarak tekrarı önleriz
                            hasRedText = true;
                        }
                        // Metni toplarız
                        paragraphText.append(text);
                    }
                }

                // Boş satırları yok etmek için temizleyelim
                String text = paragraphText.toString().replaceAll("\\s+", " ").trim();
                if (text.isEmpty()) {
                    continue;
                }

                // Eğer yeni bir kelime bulunursa, önceki dosyayı kapatıp yeni bir dosya açarız
                for (String keyword : keywords) {
                    if (text.contains(keyword)) {
                        if (writer != null) {
                            writer.close();  // Önceki dosyayı kapatıyoruz
                        }
                        currentKeyword = keyword;
                        writer = new FileWriter(currentKeyword + ".txt");
                        writer.write(text + System.lineSeparator());
                        break;
                    }
                }

                // Eğer bir kelime bulunduysa, metni ilgili dosyaya yazdırmaya devam ediyoruz
                if (currentKeyword != null && writer != null && !text.contains(currentKeyword)) {
                    writer.write(text + System.lineSeparator());
                }

                // Kırmızı renkteki metinleri dosyaya ekliyoruz
                if (hasRedText) {
                    // Tekrar etmeyen kırmızı metinleri ekleriz
                    FileWriter finalWriter = writer;
                    redText.forEach(red -> {
                        try {
                            finalWriter.write(red + System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    redText.clear(); // Bir sonraki paragraf için seti temizleriz
                }
            }

            // Son dosyayı kapatıyoruz
            if (writer != null) {
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}