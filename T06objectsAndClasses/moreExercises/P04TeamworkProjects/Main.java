package T06objectsAndClasses.moreExercises.P04TeamworkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Team> teams = new ArrayList<>();
        while (lines-- > 0) {
            String txt = scan.nextLine();
            String creator = txt.split("-")[0].trim();
            String teamName = txt.split("-")[1].trim();
            if (teams.stream().anyMatch(e -> e.getTeamName().equals(teamName))) {
                System.out.printf("Team %s was already created!\n", teamName);
            } else if (teams.stream().anyMatch(e -> e.getCreator().equals(creator))) {
                System.out.println(creator + " cannot create another team!");
            } else {
                Team team = new Team(teamName, creator);
                teams.add(team);
                System.out.printf("Team %s has been created by %s!\n", teamName, creator);
            }
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("end of assignment")) {
            String userToJoin = input.split("->")[0].trim();
            String teamToJoin = input.split("->")[1].trim();

            if (teams.stream().noneMatch(t -> t.getTeamName().equals(teamToJoin))) {
                System.out.printf("Team %s does not exist!\n", teamToJoin);
            } else if (isUserInTeams(teams, userToJoin)) {
                System.out.printf("Member %s cannot join team %s!\n", userToJoin, teamToJoin);
            } else {
                teams.stream().filter(t -> t.getTeamName().equals(teamToJoin))
                        .forEach(m -> m.getMembers().add(userToJoin));
            }
        }

        teams.stream()
                .sorted(Comparator.comparing(Team::getNumberOfMembers).reversed().thenComparing(Team::getTeamName))
                .filter(m -> !m.getMembers().isEmpty())
                .forEach(e -> {
                    System.out.println(e.getTeamName());
                    System.out.printf("- %s\n", e.getCreator());
                    e.getMembers().sort(String::compareTo);
                    e.getMembers().forEach(m -> System.out.printf("-- %s\n", m));
                });
        System.out.println("Teams to disband:");
        teams.stream().sorted(Comparator.comparing(Team::getTeamName)).filter(t -> t.getMembers().isEmpty())
                .forEach(t -> System.out.println(t.getTeamName()));

    }

    public static boolean isUserInTeams(List<Team> teams, String userToJoin) {
        return teams.stream().anyMatch(a -> a.doesUserExist(userToJoin));
    }
}
