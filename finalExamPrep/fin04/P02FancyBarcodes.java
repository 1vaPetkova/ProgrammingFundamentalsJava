package finalExamPrep.fin04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int barcodes = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("^(@[#]+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+$");
        for (int i = 0; i < barcodes; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder group = new StringBuilder();
                String barcode = matcher.group("barcode");
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        group.append(barcode.charAt(j));
                    }
                }
                if (group.toString().isEmpty()) {
                    group.append("00");
                }
                System.out.println("Product group: " + group);

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
