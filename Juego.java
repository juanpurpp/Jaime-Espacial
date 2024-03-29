package Juego;

import java.util.Scanner;

public class Juego{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido nuevo jugador, ingrese su nombre a continuación:");
        Jugador player = new Jugador(input.nextLine(), 100, 0, false,0, false);
        System.out.println("Se ha registrado como "+ player.nombre + ", bienvenido " + player.nombre);

        System.out.println("Etapa 1... Etapa 1... Etapa 1... ");
        for(int i = 0; i<15; i++) System.out.println(" ");
        Escena escena1 = new Escena(player, 1,false);
        do{
            escena1.dialogo();
            player.vida = 100;
            player.puntos = 0;
            escena1 = new Escena(player, 1,false);
            do{ escena1.render();
            }while(!escena1.terminada);
            escena1 = null;
            if(player.salida == true) return;
            if(player.vida<=0) System.out.println("Reiniciando etapa... Reiniciando etapa... Reiniciando etapa...");
        }while(player.vida<=0);
        
        //etapa 2
        for(int i = 0; i<15; i++) System.out.println(" ");
        System.out.println("Etapa 2...Etapa2 .... Etapa 2...");
        Escena escena2 = new Escena(player, 2,false);
        escena2.dialogo();
        do{
            player.vida = 100;
            escena2 = new Escena(player, 2,false);
            do{ escena2.render();
            }while(!escena2.terminada);
            escena2 = null;
            if(player.salida == true) return;
            if(player.vida<=0) System.out.println("Reiniciando etapa... Reiniciando etapa... Reiniciando etapa...");
            
        }while(player.vida<=0);
        for(int i = 0; i<15; i++) System.out.println(" ");

        EscenaFinal escenaf = new EscenaFinal(player ,1,false);
        //final
        System.out.println("Etapa FINAL...Etapa FINAL .... Etapa FINAL...");
        escenaf.dialogo();
        do{
            player.vida = 200;
            player.pos = 2;
            escenaf = new EscenaFinal(player ,1,false);
            do{ escenaf.render();
            }while(!escenaf.terminada);
            if(player.salida == true) return;
            if(player.vida<=0) System.out.println("Reiniciando etapa... Reiniciando etapa... Reiniciando etapa...");
            
        }while(player.vida<=0);
        for(int i = 0; i<15; i++) System.out.println(" ");
        escenaf.dialogoFinal();

    }
}
