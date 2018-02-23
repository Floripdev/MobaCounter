package com.example.flori.swim;

/**
 * Created by flori on 06.02.18.
 */

public class player {
    private String name;
    private int life;


    //Standard Name vergeben
    public void setplayerName(int i){
        name = "Spieler_" + i ;

    }
    //Name vergeben
    public void setPlayerName(String n){
        name = n;

    }

    public String getPlayerName(){
        return name;

    }

    public void initLife(int i){
        life = i;

    }

    public int getLife(){
        return life;

    }

    //Leben um 1 verringern. Wenn das Leben schon -1 ist wird das Leben nicht mehr runter gezählt
    public int decLife(){
        if(life == -1){
            return life;

        }else{
            life -= 1;
            return life;

        }


    }




}
