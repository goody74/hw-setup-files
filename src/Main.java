import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {
        StringBuilder logMessage = new StringBuilder();
        List<String> dirList = Arrays.asList(
                "D://MyGames"
                ,"D://MyGames/temp"
                ,"D://MyGames/savegames"
                ,"D://MyGames/src"
                ,"D://MyGames/src/main"
                ,"D://MyGames/src/test"
                ,"D://MyGames/res"
                ,"D://MyGames/res/drawables"
                ,"D://MyGames/res/vectors"
                ,"D://MyGames/res/icons");
        List<String> fileList = Arrays.asList(
                "D://MyGames/src/main/Main.java"
                ,"D://MyGames/src/main/Utils.java"
                ,"D://MyGames/temp/temp.txt");

        createDirs(dirList,logMessage);
        createFiles(fileList,logMessage);

        try {

            FileWriter writer = new FileWriter("D://MyGames/temp/temp.txt", true);
            writer.write(logMessage.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }

    }

    public static void createDirs(List<String> dirList, StringBuilder logMessage) {
        for (String dir :dirList){
            if (new File(dir).mkdir()) {
                logMessage.append("Directory ").
                        append(dir)
                        .append(" created!\n");

            } else {
                logMessage.append("Error creating directory ")
                        .append(dir)
                        .append("\n");
                System.out.println(logMessage);
                exit(1);
            }
        }
    }

    public static void createFiles(List<String> fileList, StringBuilder logMessage) {
        for (String file:fileList) {

            try {
                if (new File(file).createNewFile()) {
                    logMessage.append("File ").
                            append(file)
                            .append(" created!\n");
                }

            } catch (IOException ex) {
                logMessage.append("Error creating file ")
                        .append(ex.getMessage());
                System.out.println(logMessage);
                exit(1);
            }
        }
    }
}