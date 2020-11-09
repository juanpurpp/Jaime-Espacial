package Juego;
public class Enemigo {
    public int id;
    public int vida;
    public int ataque;
    public int pos;
    public Enemigo(int id, int vida, int ataque, int pos){
        this.id = id;
        this.vida = vida;
        this.ataque = ataque;
        this.pos = pos;
    }
    public int atacar(Jugador player){
        if(this.vida <= 0){
            System.out.println("Bot n° "+this.id+" ha intentado atacar pero no tiene fuerzas");
            return 0;
        }
        else{
            player.vida -= this.ataque*10;
            System.out.println("Robot n°" + this.id + " le ha quitado" + this.ataque*10 + " de vida a jugador " + player.nombre);
            return (this.ataque * 10);
        }
    }
}
