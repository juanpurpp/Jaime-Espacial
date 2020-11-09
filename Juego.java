package Juego;

import java.util.Scanner;

public class Juego{
    public static int contEnemigos(Enemigo bot[]){
        for(int i = 0; i <= bot.length; i++){
            if(bot[i].id == -1){
                return i;
            }
        }
        return -1;
    }
    public static void escena(Jugador player, Enemigo bot[]){
        for(int i = contEnemigos(bot); i < 3; i++){
            bot[i] = new Enemigo(i, 10, (int)(Math.random() * 5));
        }
        while(player.fase >= 0 && player.fase < 3){
            //System.out.println("kepasa");
            /*
            for(int i = 0; i<3; i++){
                for(int i = 0; i<4; i++){

                }
            }
            */
            player.atacar();
            player.fase++;
        }
    }
    public static void main(String[] args){
        Enemigo bot[] = new Enemigo[10];
        int x;
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido nuevo jugador, ingrese su nombre a continuación:");
        Jugador player = new Jugador(input.nextLine(), 100, 3, 3, 0);
        System.out.println("Se ha registrado como "+ player.nombre + ", bienvenido " + player.nombre);
        escena(player, bot);
    }

}