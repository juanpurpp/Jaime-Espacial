package Juego;
public class Escena{

    Jugador player;
    Enemigo bot[] = new Enemigo[5];
    int nivel;
    public Escena(Jugador player, int nivel){
        this.player = player;
        int pos[] = new int[3];
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
            this.bot[i] = new Enemigo(i, 100, (int)(Math.random()*6), pos[i]);
        }
        this.nivel = nivel; //por ahora no lo usamos ya que solo vamos a crear 1 nivel
    }
    public void render(){
        char[] cuadro = new char[5];
        //System.out.println("posicion bot 2 "+ bot[2].pos);
        for(int i = 0; i < cuadro.length; i++){
            cuadro[i] = ' ';
        }
        for(int i = 0; i <= 2; i++){
            System.out.println("guerdando en " + this.bot[i].pos );
            cuadro[this.bot[i].pos] = 'H';
        }
        String escenario = "";
        for(int i = 0;i<cuadro.length; i++) escenario = (escenario + "| " + cuadro[i] + " |");
        System.out.println("Escena de batalla:                                      ");
        System.out.println("                           "+escenario+"                ");
        System.out.println("o                                                       ");
    }
}