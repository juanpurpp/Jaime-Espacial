package Juego;

import java.lang.*; 
import java.util.Scanner;
public class Escena{

    public Jugador player;
    public Enemigo bot[] = new Enemigo[5];
    public int nivel;
    public boolean terminada;
    public Escena(Jugador player, int nivel, boolean terminada){
        this.player = player;
        int pos[] = new int[3];
        this.nivel = nivel; //por ahora no lo usamos ya que solo vamos a crear 1 nivel
        this.terminada = terminada;
        for(int i = 0; i < 3; i++){
            switch(i){
                case 0:
                    pos[i] = (int)((Math.random()*5));
                break;
                case 1:
                    do{ pos[i] = (int)((Math.random()*5));
                    }while(pos[i-1] == pos[i]);
                break;
                case 2:
                    do{ pos[i] = (int)((Math.random()*5));
                    }while(pos[i-1] == pos[i] || pos[i-2] == pos[i]);
                break;
            }
            this.bot[i] = new Enemigo(i, 100, (int)(Math.random()*7+1), pos[i]);
        }
    }
    public void render(){
        if((int)(Math.random()*2) == 1) this.bot[(int)(Math.random()*3)].atacar(player);
        char[] cuadro = new char[5];
        //escenario 1
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        for(int i = 0; i <= 2; i++) cuadro[this.bot[i].pos] = 'H';
        String escenario = "";
        for(int i = 0;i<cuadro.length; i++) escenario = (escenario + "| " + cuadro[i] + " |");
        //escenario personaje
        String escenario2 = "";
        for(int i = 0;i<cuadro.length; i++){
            if(this.player.pos == i) escenario2 = escenario2 + "  Y  ";
            else escenario2 = escenario2 + "     ";
        }
        //linea ataques
        String ataques = "";
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        for(int i = 0;i<3;i++) cuadro[this.bot[i].pos] = Character.forDigit(this.bot[i].ataque, 10);
        for(int i = 0;i<cuadro.length; i++) ataques = (ataques + "  " + cuadro[i] + "  ");
        
        //vidas
        String vidas = "";
        String espacio[] = new String[5];
        for(int i = 0; i < espacio.length; i++) espacio[i] = "     ";
        for(int i = 0;i<3;i++){
            if(this.bot[i].vida >= 100) espacio[this.bot[i].pos] =          " " + Integer.toString(this.bot[i].vida) + " ";
            else if(this.bot[i].vida >= 10) espacio[this.bot[i].pos] =      " " + Integer.toString(this.bot[i].vida) + "   ";
            else if(this.bot[i].vida >= 0) espacio[this.bot[i].pos] =       "  " + Integer.toString(this.bot[i].vida) + "  ";
        }
        for(int i = 0;i<espacio.length; i++) vidas = (vidas + espacio[i] );
        //linea numeros
        String nums = "";
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        for(int i = 0;i<3;i++) cuadro[this.bot[i].pos] = Character.forDigit(this.bot[i].id, 10);
        for(int i = 0;i<cuadro.length; i++) nums = ( nums+ "  " + cuadro[i] + "  ");
        

        for(int i = 0; i<10; i++) System.out.println(" ");
        System.out.println("Escena de batalla:                                           ");
        System.out.println("N° de robot                     "+nums+"                     ");
        System.out.println("Vidas                           "+vidas+"                    ");
        System.out.println("Daño de ataque                  "+ataques+"                  ");
        System.out.println("                                "+escenario+"                ");
        System.out.println("                                "+escenario2+"               ");
        System.out.println("                                                             ");
        System.out.println("Vida: "+this.player.vida+"                                   ");
        System.out.println("COMANDOS: X-atacar("+player.ataques+") C-invisible("+player.poderes+")     A  D  MOVERSE      M-salir");
        inputTecla();
        
        //System.out.println(command);
        
    }
    public void inputTecla(){
        String command;
        Scanner input = new Scanner(System.in);
        command = input.next();
        if(command.equals("a") && player.pos>0) player.pos--;
        if(command.equals("d") && player.pos<4) player.pos++;
        if(command.equals("x")){
            boolean pos_correct = false;
            for(int i=0; i<3; i++){
                if(this.player.pos == this.bot[i].pos){
                    pos_correct = true;
                    player.atacar(bot[i]);
                }
            }
            if(!pos_correct) System.out.println("Debes estar enfrente de un enemigo");
        }
        if(command.equals("m")) this.terminada = true;
    }
}