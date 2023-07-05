package Generics;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name ,String type,String countryCode){
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
public class Team<T extends Player,S> {

    private String teamName;
    private List<T> teamMembers= new ArrayList<>();
    private  int totalWins =0;
    private  int totalLoss= 0;

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    private S affiliation;
    private  int totalTies = 0;

    public Team(String teamName) {
        this.teamName = teamName;
    }
    public  void  addTeamMember(T t){
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);

        }

    }
    public  void listTeamMembers(){
        System.out.print(teamName+" Roaster : ");
        System.out.println(affiliation==null?"":"Affiliation "+affiliation);
        System.out.println(teamMembers);
    }

     public int ranking(){
        return (totalLoss *2) + totalTies +1;
    }


    @Override
    public String toString() {
        return teamName+" ( Ranked " + ranking() + ")";
    }
    public  String setScore(int ourScore , int theirScore) {
        String message = "Loss to ";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat ";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied ";
        } else {
            totalLoss++;
        }
        return message;
    }
}
