package com.example.flori.swim;

/**
 * Created by flori on 06.02.18.
 */

public class player {
    String name;
    int life;


    public void setplayerName(int i){
        name = "Player_" + i ;

    }
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

    public int decLife(){
        if(life == -1){
            return life;

        }else{
            life -= 1;
            return life;

        }


    }




}
