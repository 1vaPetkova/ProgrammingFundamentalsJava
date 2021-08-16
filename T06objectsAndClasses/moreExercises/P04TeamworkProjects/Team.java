package T06objectsAndClasses.moreExercises.P04TeamworkProjects;

import java.util.ArrayList;
import java.util.List;


public class Team {
    private String teamName;
    private String creator;
    private List<String> members;


    public Team(String teamName, String creator) {
        this.teamName = teamName;
        this.creator = creator;
        this.members = new ArrayList<>();

    }

    public String getTeamName() {
        return teamName;
    }

    public String getCreator() {
        return creator;
    }

    public List<String> getMembers() {
        return members;
    }

    public int getNumberOfMembers() {
        return members.size();
    }

  public boolean doesUserExist(String user) {
       return this.creator.equals(user)|| this.members.contains(user);
    }
}


