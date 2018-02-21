package com.example.flori.swim;

/**
 * Created by flori on 05.02.18.
 */

public class game {
   static int playerCnt;
   static int playerTmp = 0;
   static int flashes = 0;
   static int rounds = 0;
   boolean status = true;

    player players[] = new player[10];

    public void setPlayerCnt(int count){
        playerCnt = count;

    }
    public int getPlayerCnt(){




        return playerCnt;

    }

    public void createPlayers(){
        for(int i = 0; i < playerCnt; i++) {
            players[i] = new player();

        }

    }

    public void incTmp(){
        playerTmp++;

    }
    public int getPlayerTmp(){
        return playerTmp;

    }
    public void initLifes(int lifes){
        for(int i = 0; i < playerCnt; i++){
            players[i].initLife(lifes);

        }

    }

    public void countRoundsUp(){
        rounds++;

    }

    public void countFlashUp(){
        flashes++;

    }
    public void flash(int player){
        for(int i = 0; i < playerCnt; i++){
            if(i != player){
                players[i].decLife();

            }

        }

    }

    public void setZero(){
        flashes = 0;
        rounds = 0;

    }
    public boolean getStatus(){
        return status;

    }

    public void setStatus(boolean b){
        status = b;

    }

}
