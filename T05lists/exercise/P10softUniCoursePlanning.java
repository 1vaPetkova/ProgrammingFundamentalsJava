package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10softUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("course start")) {
            List<String> command = Arrays.stream(input.split(":"))
                    .collect(Collectors.toList());
            String title = command.get(1);
            switch (command.get(0)) {
                case "Add":
                    addLesson(schedule, title);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command.get(2));
                    insertLessonAtIndex(schedule, title, index);
                    break;
                case "Remove":
                    removeLesson(schedule, title);
                    break;
                case "Swap":
                    String secondTitle = command.get(2);
                    swapLessons(schedule, title, secondTitle);
                    break;
                case "Exercise":
                    addExerciseToTheLesson(schedule, title);
                    break;
            }
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, schedule.get(i));
        }
    }

    private static void addExerciseToTheLesson(List<String> schedule, String title) {
        String exerciseFormat = String.format("%s-Exercise", title);
        if (schedule.contains(title)) {
            int titleIndex = schedule.indexOf(title);
            if (titleIndex == schedule.size() - 1) {
                schedule.add(exerciseFormat);
            } else if (!schedule.get(titleIndex + 1).equals(exerciseFormat)) {
                schedule.add(titleIndex + 1, exerciseFormat);
            }
        } else {
            schedule.add(title);
            schedule.add(exerciseFormat);
        }
    }

    private static void swapLessons(List<String> schedule, String title, String secondTitle) {
        String exerciseFormatFirst = String.format("%s-Exercise", title);
        String exerciseFormatSecond = String.format("%s-Exercise", secondTitle);
        int firstIndex = schedule.indexOf(title);
        int secondIndex = schedule.indexOf(secondTitle);
        if (schedule.contains(title) && schedule.contains(secondTitle)) {
            schedule.set(firstIndex, secondTitle);
            schedule.set(secondIndex, title);
        }
        //it is considered that first index is always bigger!!
        //check if title has exercise
        if (firstIndex != schedule.size()-1 && schedule.get(firstIndex + 1).equals(exerciseFormatFirst)) {
            schedule.add(secondIndex + 1, exerciseFormatFirst);
            schedule.remove(firstIndex + 1);
            secondIndex -= 1;
        }
        //check if secondTitle has exercise
        if (secondIndex != schedule.size() - 1 && schedule.get(secondIndex + 1).equals(exerciseFormatSecond)) {
            schedule.add(firstIndex + 1, exerciseFormatSecond);
            secondIndex += 1;
            schedule.remove(secondIndex + 1);
        }
    }

    private static void removeLesson(List<String> schedule, String title) {
        String exerciseFormat = String.format("%s-Exercise", title);
        int index = schedule.indexOf(title);
        if (index != schedule.size() - 1) {
            schedule.remove(title);
            if (schedule.get(index).contains(exerciseFormat)) {
                schedule.remove(exerciseFormat);
            }
        } else {
            schedule.remove(title);
        }
    }

    private static void insertLessonAtIndex(List<String> schedule, String title, int index) {
        if (!schedule.contains(title)) {
            schedule.add(index, title);
        }
    }

    private static void addLesson(List<String> schedule, String title) {
        if (!schedule.contains(title)) {
            schedule.add(title);
        }
    }
}

