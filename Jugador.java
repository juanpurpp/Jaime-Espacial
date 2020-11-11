package Juego;
import java.lang.Math;
import java.util.Scanner;
import java.util.Random;
public class Jugador{
    public String nombre;
    public int vida;
    public int ataques;
    public int poderes;
    public int fase;
    public int pos;
    public boolean salida;
    public Jugador(String nombre, int vida, int ataques, int poderes, int fase, int pos, boolean salida){
        this.nombre = nombre;
        this.vida = vida;
        this.ataques = ataques;
        this.poderes = poderes;
        this.fase = fase;
        this.pos = pos;
        this.salida = salida;
    }

    public int atacar(Enemigo enem){
        int dano = ((int)(Math.random()*10 + 1))*10;
        enem.vida -=  dano;
        System.out.println("Enemigo "+ enem.id+" recibe putazo bestial de " + this.nombre + " haciendo " +dano + " de daño"); 
        return dano;
    }
}