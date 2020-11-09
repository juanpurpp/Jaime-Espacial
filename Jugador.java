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

    public Jugador(String nombre, int vida, int ataques, int poderes, int fase){
        this.nombre = nombre;
        this.vida = vida;
        this.ataques = ataques;
        this.poderes = poderes;
        this.fase = fase;
    }

    public int atacar(){
        int dano =  (int)(Math.random()*10);
        System.out.println("Enemigo recibe putazo bestial de " + this.nombre + " haciendo " + dano + " de daño"); 
        return dano;
    }
}