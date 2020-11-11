package Juego;

import java.util.Scanner;

public class Juego{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido nuevo jugador, ingrese su nombre a continuación:");
        Jugador player = new Jugador(input.nextLine(), 100, 3, 3, 0, 0, false);
        System.out.println("Se ha registrado como "+ player.nombre + ", bienvenido " + player.nombre);

        System.out.println("Etapa 1... Etapa 1... Estapa 2... ");
        for(int i = 0; i<15; i++) System.out.println(" ");
        do{
            player.vida = 100;
            Escena escena1 = new Escena(player, 1,false);
            do{ escena1.render();
            }while(!escena1.terminada);
            escena1 = null;
            if(player.salida == true) return;
            for(int i = 0; i<15; i++) System.out.println(" ");
            if(player.vida<=0) System.out.println("Reiniciando etapa... Reiniciando etapa... Reiniciando etapa...");
        }while(player.vida<=0);
        
        //etapa 2
        for(int i = 0; i<5; i++) System.out.println(" ");
        System.out.println("Etapa 2...Etapa2 .... Etapa 2...");
        do{
            player.vida = 100;
            Escena escena2 = new Escena(player, 2,false);
            do{ escena2.render();
            }while(!escena2.terminada);
            escena2 = null;
            if(player.salida == true) return;
            for(int i = 0; i<15; i++) System.out.println(" ");
            if(player.vida<=0) System.out.println("Reiniciando etapa... Reiniciando etapa... Reiniciando etapa...");
            
        }while(player.vida<=0);

    }
}