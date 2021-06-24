package T06objectsAndClasses.lab.P04Songsv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scan.nextLine());
        List<P04Song> songsList = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scan.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];

            P04Song song = new P04Song(typeList, name, time);
            songsList.add(song);

        }
        String filterCommand = scan.nextLine();

        if (filterCommand.equals("all")) {
            for (P04Song song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            List<P04Song> filteredList = songsList.stream().filter(e -> e.getTypeList().equals(filterCommand))
                    .collect(Collectors.toList());
            for (P04Song song : filteredList) {
                    System.out.println(song.getName());
            }
        }
    }
}
