package com.example.flori.swim;

/**
 * Created by flori on 05.02.18.
 */

public class game {
   private int playerCnt;
   private int playerTmp = 0;
   private int flashes = 0;
   private int rounds = 0;
   private boolean status = true;
   private player winner;

    player players[] = new player[10]; //Die Spieler gespeichert in einem Array

    //Setter und Getter für playerCnt

    public void setPlayerCnt(int count){
        playerCnt = count;

    }
    public int getPlayerCnt(){
        return playerCnt;

    }

    //Spieler Initalisieren
    public void createPlayers(){
        for(int i = 0; i < playerCnt; i++) {
            players[i] = new player();

        }

    }

    //Tempörären zähler um 1 erhöhen
    public void incTmp(){
        playerTmp++;

    }

    public int getPlayerTmp(){
        return playerTmp;

    }

    //Initalisiert die Leben für jeden Spieler
    public void initLifes(int lifes){
        for(int i = 0; i < playerCnt; i++){
            players[i].initLife(lifes);

        }

    }

    //Getter und Setter für Runden und Blitze
    public void countRoundsUp(){
        rounds++;

    }

    public void countFlashUp(){
        flashes++;

    }

    public int getRoundCount(){
        return rounds;

    }

    public int getFlashesCount(){
        return flashes;

    }

    //Allen Spielern ein Leben abziehen auser dem Spieler der den Blitz hatte
    public void flash(int player){
        for(int i = 0; i < playerCnt; i++){
            if(i != player){
                players[i].decLife();

            }

        }

    }


    //Runden und Blitze auf 0 setzen
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

    //Den Gewinner setzen und holen
    public void setWinner(player w){
        winner = w;

    }

    public player getWinner(){
        return winner;

    }

}
