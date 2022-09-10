import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;


public class PhoneReader {
    public static void readFile() throws IOException {
        FileReader fr = new FileReader("./src/file.txt");
        Scanner scan = new Scanner(fr);

        while (scan.hasNext()) {
            char[] temp = scan.nextLine().toCharArray();
            StringBuilder str = new StringBuilder();
            int a = 0;

            if (temp.length == 12) {
                for (int i = 0; i < temp.length; i++) {
                    if (i != 3 && i != 7 ) {
                        if (DigitCheck.isDigit(temp[i])) {
                            a++;
                        } else {
                            a -= 1000;
                        }
                    } else  {
                        if (temp[i] == '-'){
                            a++;
                        } else {
                            a -= 1000;
                        }
                    }
                }
            } else if (temp.length == 14) {
                for (int i = 0; i < temp.length; i++) {
                    if (i != 0 && i != 4 && i != 5 && i != 9 ) {
                        if (DigitCheck.isDigit(temp[i])) {
                            a++;
                        } else {
                            a -= 1000;
                        }
                    } else  {
                        if (temp[i] == '-' || temp[i] == '(' || temp[i] == ')' || temp[i] == ' '){
                            a++;
                        }
                    }
                }
            }

            if (a > 0) {
                for (char c : temp) {
                    str.append(c);
                }
                System.out.println(str);
            }

        }
        fr.close();
    }
}
class DigitCheck {
    public static boolean isDigit(char c) {
        return switch (c) {
            case ('1'), ('2'), ('3'), ('4'), ('5'), ('6'), ('7'), ('8'), ('9'), ('0') -> true;
            default -> false;
        };
    }
}


class PhoneReaderTest {
    public static void main (String[] args) throws IOException {
        PhoneReader.readFile();
    }
}