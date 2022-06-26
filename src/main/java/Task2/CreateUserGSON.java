package Task2;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class CreateUserGSON {
    ArrayList<User> users = new ArrayList<>();
    String fileGsonPath = "src/main/resources/user.json";
    File fileGson;
    File file;


    public void run() {
        file = new File("src/main/resources/file.txt");
        createGson(file);
    }

    public void run(String filePath) {
        file = new File(filePath);
        createGson(file);
    }

    private void createGson(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s = reader.readLine();
            if (s.startsWith("name")) {
                s = reader.readLine();
            }
            while (s != null) {
                String[] userItem = new String[2];
                userItem = s.split(" ");
                User user = new User(userItem[0], userItem[1]);
                users.add(user);
                s = reader.readLine();
            }
            Gson gson = new Gson();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileGsonCheck()))) {
                writer.write(gson.toJson(users));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private File fileGsonCheck() {
        fileGson = new File(fileGsonPath);
        if (!fileGson.exists()) {
            fileGson.getParentFile().mkdirs();
            try {
                fileGson.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return fileGson;
    }

}
