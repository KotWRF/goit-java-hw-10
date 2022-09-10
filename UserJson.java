import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UserJson {
    public static void ReadWrite() throws IOException {
        FileReader fr = new FileReader("./src/file.txt");
        Scanner scan = new Scanner(fr);

        File file = new File("user.json");

        try (FileWriter writer = new FileWriter(file)) {
            String result = "[\n    ";
            String temp = "{\n        ";

            String fLine = scan.nextLine();
            String[] fArr = fLine.split(" ");


            while (scan.hasNextLine()) {
                int o = 0;
                String str = scan.nextLine();
                String[] arr = str.split(" ");

                for (int i = 0; i < fArr.length; i++) {
                    if (o < fArr.length - 1) {
                        temp += "\"" + fArr[i] + "\"" + ": \"" + arr[i] + "\",\n        ";
                        o++;
                    } else {
                        temp += "\"" + fArr[i] + "\":" + arr[i] + "\n    },\n    {\n        ";
                        o = 0;
                    }
                }
            }

            temp = temp.substring(0, temp.length() - 16);
            result += temp + "\n]";

            writer.write(result);
            writer.flush();
        }

        //System.out.println(result);
    }

}


class UserJsonTest {
    public static void main (String[] args) throws IOException {
        UserJson.ReadWrite();
    }
}