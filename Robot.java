package Juego;

public class Robot extends Enemigo{
    public Robot(int id, int vida, int ataque, int pos){
        super(id, vida, ataque, pos);
    }
    @Override
    public int atacar(Jugador player){
        if(this.vida <= 0){
            System.out.println("Bot n° "+this.id+" ha intentado atacar pero no tiene fuerzas");
            return 0;
        }
        else{
            int dano = (int)(Math.random()*((this.ataque*10)-10+1)) + 10;
            player.vida -= dano;
            System.out.println("Robot n°" + this.id + " le ha quitado" + dano + " de vida a jugador " + player.nombre);
            return (dano);
        }
    }
}