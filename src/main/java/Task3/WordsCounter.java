package Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsCounter {
    private String filePath;

    public void run() {
        filePath = "src/main/resources/words.txt";
        counter(filePath);
    }

    public void run(String filePath) {
        counter(filePath);
    }

    private void counter(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String str = reader.readLine();
            while (str != null) {
                sb.append(str);
                sb.append(" ");
                str = reader.readLine();
            }
            str = sb.toString();
            String[] text = str.split(" ");
            Set<String> hashSet = new HashSet<String>();
            hashSet.addAll(List.of(text));

            String[] words = hashSet.toArray(new String[hashSet.size()]);
            int[] wordsCount = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (String textItem : text) {
                    if (textItem.equals(words[i])) {
                        wordsCount[i]++;
                    }
                }
            }

            Boolean permutation = true;
            while (permutation) {
                permutation = false;
                int decVariable;
                String strVariable;
                for (int i = 0; i < wordsCount.length - 1; i++) {
                    if (wordsCount[i] < wordsCount[i + 1]) {
                        decVariable = wordsCount[i];
                        wordsCount[i] = wordsCount[i + 1];
                        wordsCount[i + 1] = decVariable;

                        strVariable = words[i];
                        words[i] = words[i + 1];
                        words[i + 1] = strVariable;

                        permutation = true;
                    }
                }
            }

            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i] + " " + wordsCount[i]);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
