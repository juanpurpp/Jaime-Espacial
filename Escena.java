package Juego;

import java.lang.*; 
import java.util.Scanner;
public class Escena{

    public Jugador player;
    public Enemigo bot[] = new Enemigo[5];
    public int nivel;
    public boolean terminada;
    public int enemCant;
    public Escena(Jugador player, int nivel, boolean terminada){
        this.player = player;
        this.nivel = nivel; //por ahora no lo usamos ya que solo vamos a crear 1 nivel
        this.terminada = terminada;
        if(this.nivel == 1) enemCant = 3;
        else if(this.nivel == 2) enemCant = 5;
        int pos[] = new int[enemCant];
        for(int i = 0; i < enemCant; i++){
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
                case 3:
                    do{ pos[i] = (int)((Math.random()*5));
                    }while(pos[i-1] == pos[i] || pos[i-2] == pos[i] || pos[i-3] == pos[i]);
                break;
                case 4:
                    do{ pos[i] = (int)((Math.random()*5));
                    }while(pos[i-1] == pos[i] || pos[i-2] == pos[i] || pos[i-3] == pos[i] || pos[i-4] == pos[i]);
                break;
            }
            this.bot[i] = new Robot(i, 100, (int)(Math.random()*(this.nivel*4)+1), pos[i]);
        }
    }
    public void render(){
        int cuadCant = 0;
        if(this.nivel == 1) cuadCant=5;
        if(this.nivel == 2) cuadCant=7;
        char[] cuadro = new char[cuadCant];
        //escenario 1
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        for(int i = 0; i < enemCant; i++) cuadro[this.bot[i].pos] = 'H';
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
        for(int i = 0;i<enemCant;i++) cuadro[this.bot[i].pos] = Character.forDigit(this.bot[i].ataque, 10);
        for(int i = 0;i<cuadro.length; i++) ataques = (ataques + "  " + cuadro[i] + "  ");
        
        //vidas
        String vidas = "";
        String espacio[] = new String[6];
        for(int i = 0; i < espacio.length; i++) espacio[i] = "     ";
        for(int i = 0;i<enemCant;i++){
            if(this.bot[i].vida >= 100) espacio[this.bot[i].pos] =          " " + Integer.toString(this.bot[i].vida) + " ";
            else if(this.bot[i].vida >= 10) espacio[this.bot[i].pos] =      " " + Integer.toString(this.bot[i].vida) + "   ";
            else if(this.bot[i].vida >= 0) espacio[this.bot[i].pos] =       "  " + Integer.toString(this.bot[i].vida) + "  ";
        }
        for(int i = 0;i<espacio.length; i++) vidas = (vidas + espacio[i] );
        //linea numeros
        String nums = "";
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        for(int i = 0;i<enemCant;i++) cuadro[this.bot[i].pos] = Character.forDigit(this.bot[i].id, 10);
        for(int i = 0;i<cuadro.length; i++) nums = ( nums+ "  " + cuadro[i] + "  ");
        
        System.out.println("Escena de batalla:                                           ");
        System.out.println("N° de robot                     "+nums+"                     ");
        System.out.println("Vidas                           "+vidas+"                    ");
        System.out.println("Daño de ataque                  "+ataques+"                  ");
        System.out.println("                                "+escenario+"                ");
        System.out.println("                                "+escenario2+"               ");
        System.out.println("                                                             ");
        System.out.println("Vida: "+this.player.vida+"                                   ");
        //Ver si murió
        if(player.vida <= 0 ){
            System.out.println("Has muerto :(");
            this.terminada = true;
            return;
        }
        //Ver si ganó
        for(int i = enemCant - 1; i >= 0 && bot[i].vida <= 0; i--){
            if(i == 0){
                System.out.println("Has eliminado a todos los enemigos de esta fase");
                this.terminada = true;
                return;
            }
        }
        System.out.println("COMANDOS: X-atacar("+player.ataques+") C-invisible("+player.poderes+")     A  D  MOVERSE      M-salir");
        inputTecla(cuadro.length,true);
        if((int)(Math.random()*3) == 1) this.bot[(int)(Math.random()*enemCant)].atacar(player);
    }
    public void inputTecla(int casillas, boolean cls){
        String command;
        Scanner input = new Scanner(System.in);
        command = input.next();
        if(cls) for(int i = 0; i<15; i++) System.out.println(" ");
        if(command.equals("a") && player.pos>0) player.pos--;
        if(command.equals("d") && player.pos<casillas-1) player.pos++;
        if(command.equals("x")){
            boolean pos_correct = false;
            for(int i=0; i<enemCant; i++){
                if(this.player.pos == this.bot[i].pos){
                    pos_correct = true;
                    player.atacar(bot[i]);
                }
            }
            if(!pos_correct) System.out.println("Debes estar enfrente de un enemigo");
        }
        if(command.equals("m")){
            this.terminada = true;
            player.salida = true;        }
    }
}