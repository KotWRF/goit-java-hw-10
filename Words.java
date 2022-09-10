
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Words {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader("./src/words.txt");
        Scanner scan = new Scanner(fr);

        String all = "";
        while (scan.hasNext()) {
            all += scan.nextLine() + " ";
        }

        String[] arr = all.split(" ");

        HashSet<String> uniqe = new HashSet<>();
        for (String word: arr) {
            if (!uniqe.contains(word)) {
                uniqe.add(word);
            }
        }

        //System.out.println(uniqe.size());

        ArrayList<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (String words : list) {
            if (map.containsKey(words)) {
                map.put(words, map.get(words) + 1);
                continue;
            }
            map.put(words, 1);
        }

        map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(s ->
                System.out.println(s.getKey() + " " + s.getValue()));


    }

}