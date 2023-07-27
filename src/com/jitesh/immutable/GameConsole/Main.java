package com.jitesh.immutable.GameConsole;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('K');
        System.out.println("weapon = "+ weapon + ", hitPoints=" +
                weapon.getHitPoints() + ", minLevel=" + weapon.getMinLevel());

        List<Weapon> weapons = Weapon.getWeaponsByLevel(0);
        weapons.forEach(System.out::println);

//        System.out.println(PirateGame.getTowns(0));
//        System.out.println("------------------------------");
////        System.out.println(PirateGame.getTowns(1));
//PirateGame.getTowns(0).forEach(t-> System.out.println(t.information()));
//        PirateGame.getTowns(1).forEach(t-> System.out.println(t.information()));

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
//        Town town = new Town("Shiroda","Lukow",0);
//        System.out.println(town.information());



    }
}
