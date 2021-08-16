package finalExamPrep.archive.RetakeExam10Jan2019PartII;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        List<String> list = new ArrayList<>();
          String input = "";
            while (!(input = scan.nextLine()).equals("end")) {
                StringBuilder sb = new StringBuilder();
                for (char c : input.toCharArray()) {
                    sb.append((char)(c-key));
                }
                list.add(sb.toString());
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]+!(?<behaviour>[GN])!");
        List<String> goodBehavedChildren = new ArrayList<>();
            for (String c : list) {
            Matcher matcher = pattern.matcher(c);
            if(matcher.find()){
                if(matcher.group("behaviour").equals("G")){
                goodBehavedChildren.add(matcher.group("name"));
                }
            }
        }
        System.out.println(String.join(System.lineSeparator(),goodBehavedChildren));
    }
}
