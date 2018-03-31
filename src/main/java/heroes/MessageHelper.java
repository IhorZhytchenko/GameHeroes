package heroes;

import java.io.FileWriter;
import java.io.IOException;

public class MessageHelper {
    private static StringBuilder log = new StringBuilder();
    private static int movesNumber = 0;


    public static void printMessage(String message){
        movesNumber++;
        System.out.println(movesNumber+" "+message);
        log.append("\n");
        log.append(movesNumber);
        log.append(" ");
        log.append(message);


    }

    public static void saveLog(String path){
        try(FileWriter writer = new FileWriter(path)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
