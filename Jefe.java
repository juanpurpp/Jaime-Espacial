package Juego;
import java.lang.Math;
public class Jefe extends Enemigo{
    String nombre;
    public Jefe(String nombre, int id, int vida, int ataque, int pos){
        super(id, vida, ataque,pos);
        this.nombre = nombre;
        
    }
    @Override
    public int atacar(Jugador player){
        if(this.vida <= 0){
            System.out.println("Jefe "+this.nombre+" ha intentado atacar pero no tiene fuerzas");
            return 0;
        }
        else if(player.ultimode == true){
            System.out.println("Jefe "+this.nombre+" ha intentado atacar, pero no puede ver a " + player.nombre + " en su estado ulti");
            return 0;
        }
        else{
            int dano = (int)(Math.random()*((this.ataque*80)-50+1)) + 50;
            player.vida -= dano;
            System.out.println("Jefe "+ this.nombre + " atacó y quitó "+ dano + " de vida a jugador " + player.nombre);
            if((int)(Math.random()*5) <= 2){
                player.vida -= dano/5;
                System.out.println("Jefe "+ this.nombre + " hizo segundo ataque quitando " + dano/5+ " de vida a jugador " + player.nombre);
            }
                return dano + dano/5 ;
        }
    }
    public void mover(int casillas){
        int mov=(int)(Math.random() * 3) - 1;
        if(this.pos + mov >= 0 && this.pos + mov<casillas ) this.pos += mov;
    }
}