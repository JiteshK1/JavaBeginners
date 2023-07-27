package com.jitesh.generics;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam implements Player {
    private String teamName;
    private List<Player> teamMembers= new ArrayList<>();
    private  int totalWins =0;
    private  int totalLoss= 0;

    private  int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }
    public  void  addTeamMember(Player player){
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);

        }

    }
    public  void listTeamMembers(){
        System.out.println(teamName+" Roaster");
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
