package Juego;

import Juego.Jefe;

public class EscenaFinal extends Escena{
    
    Jefe arredondopus = new Jefe("Arredondopus", 1, 500, 10, 2);
    public EscenaFinal(Jugador player, int nivel, boolean terminada){
        super(player, nivel, terminada);

    }



    @Override
    public void render(){
        if(player.puntos>=500) player.puntos = 500;
        char[] cuadro = new char[5];
        if( (int)(Math.random()*3) <2) arredondopus.mover(cuadro.length);
        //escenario 1
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        cuadro[arredondopus.pos] = 'A';
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
        cuadro[arredondopus.pos] = Character.forDigit(arredondopus.ataque, 10);
        for(int i = 0;i<cuadro.length; i++) ataques = (ataques + "  " + cuadro[i] + "  ");
        
        //vidas
        String vidas = "";
        String espacio[] = new String[5];
        for(int i = 0; i < espacio.length; i++) espacio[i] = "     ";
        if(arredondopus.vida <= 0) espacio[arredondopus.pos] =  "  X  ";
        else if(arredondopus.vida >= 100) espacio[arredondopus.pos] =     " " + Integer.toString(arredondopus.vida) + " ";
        else if(arredondopus.vida >= 10) espacio[arredondopus.pos] =      "  " + Integer.toString(arredondopus.vida) + " ";
        else if(arredondopus.vida >= 0) espacio[arredondopus.pos] =       "  " + Integer.toString(arredondopus.vida) + "  ";
        for(int i = 0;i<espacio.length; i++) vidas = (vidas + espacio[i] );
        //linea numeros
        String nums = "";
        for(int i = 0; i < cuadro.length; i++) cuadro[i] = ' ';
        cuadro[arredondopus.pos] = Character.forDigit(1, 10);
        for(int i = 0;i<cuadro.length; i++) nums = ( nums+ "  " + cuadro[i] + "  ");

        System.out.println("Escena de batalla:  JEFE FINAL --- JEFE FINAL --- JEFE FINAL ");
        System.out.println("N° de robot                     "+nums+"                     ");
        System.out.println("Vida                            "+vidas+"                    ");
        System.out.println("Daño de ataque                  "+ataques+"                  ");
        System.out.println("                                "+escenario+"                ");
        System.out.println("                                "+escenario2+"               ");
        System.out.println("                                                             ");
        System.out.println("Vida: "+this.player.vida+"                                   ");

        if(player.vida <= 0 ){
            System.out.println("Has muerto :(");
            this.terminada = true;
            return;
        }
        //Ver si ganó
        if(arredondopus.vida <= 0){ 
            this.terminada=true;
            System.out.println("Has vencido a doctor arredondopus");
            return;
        }
        System.out.print(  "COMANDOS: X-atacar     A  D  MOVERSE      M-salir      ");
        System.out.println("          C-Ulti( |%"+ (int) (((float)(player.puntos) )/500*100) +"|)      pts: "+player.puntos+"/500");
        if(player.ultimode) {
            System.out.println("ULTI MODE ON  --- ULTI MODE ON --- ULTI MODE ON --- ULTI MODE ON --- ULTI MODE ON");
            System.out.println("Curación +    |     Invisibilidad (Enemigos no te ven)    |   WATE GALACTICO(daño)");

        }
        inputTecla(cuadro.length,true);
        if((int)(Math.random()*3) == 1) player.puntos-= arredondopus.atacar(player)/ 10 ;
    }
    public void ataque(Jugador player, Robot bot[]){       
        if(this.player.pos == arredondopus.pos){
            player.puntos += player.atacar(arredondopus);
        }
        else System.out.println("Debes estar enfrente de arredondopus");       
    }
    //aqui también puedes usar pausa();
    public void dialogo(){
        System.out.println("TEXTO DE PRUEBA");
        pausa();
        //aqui pones los dialogos de introduccion al fina
    }
    public void dialogoFinal(){
        System.out.println("TEXTO DE PRUEBA");
        pausa();
        //aqui pones los dialogos finales despues de matar al jefe

    }
}
