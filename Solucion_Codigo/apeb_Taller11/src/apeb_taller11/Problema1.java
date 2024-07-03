package apeb_taller11;

public class Problema1 {

    public static void main(String[] args) {
        TiposPersonaje guerrero = new Guerrero(20,5,1,100,0);
        TiposPersonaje mago = new Mago(15,2,1,100,0);
        TiposPersonaje arquero = new Arquero(15,5,1,100,0);
        System.out.println(guerrero.combate(mago));
    }

}

abstract class TiposPersonaje {

    public int nievlPesonaje;
    public int puntosVida;
    public int nivelExperiencia;

    public TiposPersonaje(int nievlPesonaje, int puntosVida, int nivelExperiencia) {
        this.nievlPesonaje = nievlPesonaje;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
    }
    
    public abstract int ataque();

    public abstract int defensa();

    public abstract String combate(TiposPersonaje enemigos);

}

class Guerrero extends TiposPersonaje {

    public int nivelFuerza;     //20
    public int nivelHabilCuerpo;    //5

    public Guerrero(int nivelFuerza, int nivelHabilCuerpo, int nievlPesonaje, int puntosVida, int nivelExperiencia) {
        super(nievlPesonaje, puntosVida, nivelExperiencia);
        this.nivelFuerza = nivelFuerza;
        this.nivelHabilCuerpo = nivelHabilCuerpo;
    }
    
    @Override
    public int ataque() {
        int puntosDano = nivelFuerza * nievlPesonaje;
        return puntosDano;
    }

    @Override
    public int defensa() {
        int puntosDefensa = nivelHabilCuerpo * nievlPesonaje;
        return puntosDefensa;
    }

    @Override
    public String combate(TiposPersonaje enemigos) {
        while (this.puntosVida > 0 && enemigos.puntosVida > 0) {
            System.out.println("Vida guerr = "+this.puntosVida);
            System.out.println("Vida enem = "+enemigos.puntosVida);
            
            enemigos.puntosVida -= (ataque()-enemigos.defensa());
            System.out.println("Ataca guerr ");
            System.out.println("Vida guerr = "+this.puntosVida);
            System.out.println("Vida enem = "+enemigos.puntosVida);
            
            this.puntosVida -= (enemigos.ataque() - defensa());
            System.out.println("ataca enem ");
            System.out.println("Vida guerr = "+this.puntosVida);
            System.out.println("Vida enem = "+enemigos.puntosVida);
        }
        if(this.puntosVida<=0){
            return "El guerrero murio";
        }
        if(enemigos.puntosVida<=0){
            nivelExperiencia+= 10;
            return "El Enemigo murio";
        }
        return"";
    }
}

class Mago extends TiposPersonaje {
    
    public int nivelHechizo;        //15
    public int nivelPoderesMagicos;     //5

    public Mago(int nivelHechizo, int nivelPoderesMagicos, int nievlPesonaje, int puntosVida, int nivelExperiencia) {
        super(nievlPesonaje, puntosVida, nivelExperiencia);
        this.nivelHechizo = nivelHechizo;
        this.nivelPoderesMagicos = nivelPoderesMagicos;
    }
    
    @Override
    public int ataque() {
        int puntosDano = nivelHechizo * nievlPesonaje;
        return puntosDano;
    }

    @Override
    public int defensa() {
        int puntosDefensa = nivelPoderesMagicos * nievlPesonaje;
        return puntosDefensa;
    }

    @Override
     public String combate(TiposPersonaje enemigos) {
        while (this.puntosVida > 0 && enemigos.puntosVida > 0) {
            enemigos.puntosVida = ataque();
            this.puntosVida -= (enemigos.ataque() - defensa());
        }
        if(this.puntosVida<0){
            return "El Mago murio";
        }
        if(enemigos.puntosVida<0){
            nivelExperiencia+= 10;
            return "El Enemigo murio";
        }
        return"";
    }
}


class Arquero extends TiposPersonaje {

    public int nivelPrecicion;
    public int nivelHabilDistancia;

    public Arquero(int nivelPrecicion, int nivelHabilDistancia, int nievlPesonaje, int puntosVida, int nivelExperiencia) {
        super(nievlPesonaje, puntosVida, nivelExperiencia);
        this.nivelPrecicion = nivelPrecicion;
        this.nivelHabilDistancia = nivelHabilDistancia;
    }
    
    @Override
    public int ataque() {
        int puntosDano = nivelPrecicion * nievlPesonaje;
        return puntosDano;
    }

    @Override
    public int defensa() {
        int puntosDefensa = nivelHabilDistancia * nievlPesonaje;
        return puntosDefensa;
    }

    @Override
     public String combate(TiposPersonaje enemigos) {
        while (this.puntosVida > 0 && enemigos.puntosVida > 0) {
            enemigos.puntosVida = ataque();
            this.puntosVida -= enemigos.ataque() - defensa();
        }
        if(this.puntosVida<0){
            return "El Arquero murio";
        }
        if(enemigos.puntosVida<0){
            nivelExperiencia+= 10;
            return "El Enemigo murio";
        }
        return"";
    }
}
