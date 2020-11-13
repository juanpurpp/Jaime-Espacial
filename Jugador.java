package Juego;
import java.lang.Math;
import java.util.Scanner;
import java.util.Random;
public class Jugador{
    public String nombre;
    public int vida;
    public int poderes;
    public int pos;
    public boolean salida;
    public int puntos;
    public boolean ultimode;
    public Jugador(String nombre, int vida, int pos, boolean salida, int puntos, boolean ultimode){
        this.nombre = nombre;
        this.vida = vida;
        this.pos = pos;
        this.salida = salida;
        this.puntos = puntos;
        this.ultimode = ultimode;
    }

    public int atacar(Enemigo enem){
        int dano;
        if(this.ultimode){
            dano = ((int)(Math.random()*150-50+ 1)+50);
            this.ultimode = false;
            System.out.println(this.nombre + " ha completado su forma Jaime completa y se prepara para dar el wate galactico");
        }
        else dano = ((int)(Math.random()*90-10+ 1)+10);
        enem.vida -=  dano;
        System.out.println("Enemigo "+ enem.id+" recibe ataque de " + this.nombre + " haciendo " +dano + " de daño"); 
        return dano;
    }
    public void ulti(){

        this.puntos-=500;
        this.ultimode = true;
        this.vida += 100;
        System.out.println(this.nombre + " ha usado su modo ultimate...");
    }
}