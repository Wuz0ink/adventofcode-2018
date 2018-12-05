package tools;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    public String readFile(String fileName) throws Exception{
        File file = new File("resources/" + fileName);

        Scanner sc = new Scanner(file);

        String sr = "";

        while (sc.hasNextLine()){
            sr = sr + sc.nextLine();
        }

        return sr;
    }
}
