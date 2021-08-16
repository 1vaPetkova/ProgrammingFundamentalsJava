package finalExamPrep.fin04v2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(@[#]+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@[#]+)$");
        int lines = Integer.parseInt(scan.nextLine());
        while (lines-- > 0) {
            String txt = scan.nextLine();
            Matcher matcher = pattern.matcher(txt);
            if (matcher.find()) {
                String barcode = matcher.group(2);
                StringBuilder sb = new StringBuilder();
                for (char ch : barcode.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    }
                }
                if (sb.toString().isEmpty()) {
                    sb.append("00");
                }
                System.out.println("Product group: " + sb);

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
