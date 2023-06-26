package Generics;

interface Player{}
record BaseBallPlayer(String name, String position) implements  Player{};
record FootBallPlayer(String name, String position) implements  Player{};


public class Main {
    public static void main(String[] args) {

var philly=new Affiliation("Philidalphia","Sjorpa","IS");
        Team<BaseBallPlayer,Affiliation> banglore = new Team<>("Banglore",philly);

//        Team<BaseBallPlayer,Affiliation> kolkata = new Team<>("Kolkata");
//        scoreResult(banglore,1,kolkata,2);
        var jadega= new BaseBallPlayer("Jadega","Left-Arm spinner");
        var russel= new BaseBallPlayer("Russel","Right-Arm Faster");
        banglore.addTeamMember(jadega);
        banglore.addTeamMember(russel);
        banglore.listTeamMembers();

        Team<FootBallPlayer,Affiliation> fcGoa = new Team<>("FC GOA");
        var sunil=new FootBallPlayer("Sunil","Attacker");
        fcGoa.addTeamMember(sunil);
        fcGoa.listTeamMembers();

    }

    public  static  void  scoreResult(BaseballTeam team1 , int team1Score,BaseballTeam team2 , int team2Score){
        String message = team1.setScore(team1Score,team2Score);
        team2.setScore(team2Score,team1Score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
}
