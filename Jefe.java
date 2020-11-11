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
            System.out.println("Bot n° "+this.id+" ha intentado atacar pero no tiene fuerzas");
            return 0;
        }
        else{
            player.vida -= this.ataque*20;
            System.out.println("Jefe"+ this.nombre + "atacó y quitó "+ this.ataque*15 + " de vida a jugador " + player.nombre);
            if((int)(Math.random()*4) <= 2) System.out.println("Jefe"+ this.nombre + "hizo segundo ataque quitando " + this.ataque*3 + " de vida a jugador " + player.nombre);
            return (this.ataque * 10);
        }
    }
}