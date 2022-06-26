package Task1;

import java.io.*;
import java.util.regex.Pattern;

public class TelephoneNumberValidate {
    private String filePath;


    public void readFile() {
        filePath = "src/main/resources/file.txt";
        validator(filePath);
    }

    public void readFile(String filePath) {
        validator(filePath);
    }

    private void validator(String filePath) {
        File file = new File(filePath);
        String numberFormat =
                "^[(0-9]{1}[0-9]{2}[-0-9]{1}[)0-9]{1}([0-9]{0,2})?([-]{0,1})?([0-9]{0,4})?( [0-9]{3})?([-]{1})?([0-9]{4})?$";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (true) {
                String s = reader.readLine();
                if (s != null) {
                    if (s.matches(numberFormat)) {
                        System.out.println(s);
                    }
                } else {
                    break;
                }
            }

        } catch (IOException ex) {
            ex.getMessage();
        }
    }


}
