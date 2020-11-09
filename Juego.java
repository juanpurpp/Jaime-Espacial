package Juego;

import java.util.Scanner;

public class Juego{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido nuevo jugador, ingrese su nombre a continuación:");
        Jugador player = new Jugador(input.nextLine(), 100, 3, 3, 0, 0);
        System.out.println("Se ha registrado como "+ player.nombre + ", bienvenido " + player.nombre);

        System.out.println("Escena 1: ");
        Escena escena1 = new Escena(player, 1,false);
        do{
            escena1.render();

        }while(!escena1.terminada);

    }
}