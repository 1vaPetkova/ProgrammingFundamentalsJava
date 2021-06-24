package T07associativeArrays.exercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, List<String>> data = new TreeMap<>();
        while (!(input = scan.nextLine()).equals("End")) {
            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];
            data.putIfAbsent(companyName, new ArrayList<>());
            if (!data.get(companyName).contains(employeeID)) {
                data.get(companyName).add(employeeID);
            }
        }
        data.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().stream()
                            .forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
