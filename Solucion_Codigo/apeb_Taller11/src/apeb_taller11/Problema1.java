package apeb_taller11;

import java.util.Scanner;

public class Problema1 {

    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        boolean jugar = true;
        int tipoPartida;
        System.out.println("*********INICIA EL JUEGO**********");
        int nivelAtaque;
        int nivelDefenza;
        int puntosVida;
        int personaje;
        int nivelPersonaje;
        TiposPersonaje jugador = null;
        while (true) {
            System.out.println("""
                               ELIGE TU PERSONAJE:
                               [1] Guerrero
                               [2] Mago
                               [3] Arquero
                               """);
            personaje = put.nextInt();
            if (personaje >= 1 && personaje <= 3) {
                break;
            } else {
                System.out.println("NO EXISTE ESA OPCION");
            }

        }
        switch (personaje) {
            case 1:
                nivelAtaque = (int) (Math.random() * (20 - 7 + 1)) + 7;
                nivelDefenza = (int) (Math.random() * (8 - 3 + 1)) + 3;
                puntosVida = (int) (Math.random() * (250 - 100 + 1)) + 100;
                jugador = new Guerrero(nivelAtaque, nivelDefenza, 1, puntosVida);
                System.out.println("==TU GUERRERO==");
                System.out.println("Nivel de Personaje: " + 1);
                System.out.println("Nivel de Fuerza: " + nivelAtaque);
                System.out.println("Nivel de Habilidades Cuerpo a Cuerpo: " + nivelDefenza);
                System.out.println("Puntos de vida: " + puntosVida);
                break;

            case 2:
                nivelAtaque = (int) (Math.random() * (30 - 10 + 1)) + 10;
                nivelDefenza = (int) (Math.random() * (5 - 2 + 1)) + 2;
                puntosVida = (int) (Math.random() * (200 - 85 + 1)) + 85;
                jugador = new Mago(nivelAtaque, nivelDefenza, 1, puntosVida);
                System.out.println("==TU MAGO==");
                System.out.println("Nivel de Personaje: " + 1);
                System.out.println("Nivel de Hechizo: " + nivelAtaque);
                System.out.println("Nivel de Poderes Magicos: " + nivelDefenza);
                System.out.println("Puntos de vida: " + puntosVida);
                break;

            case 3:
                nivelAtaque = (int) (Math.random() * (20 - 7 + 1)) + 7;
                nivelDefenza = (int) (Math.random() * (15 - 5 + 1)) + 5;
                puntosVida = (int) (Math.random() * (140 - 70 + 1)) + 70;
                jugador = new Arquero(nivelAtaque, nivelDefenza, 1, puntosVida);
                System.out.println("==TU ARQUERO==");
                System.out.println("Nivel de Personaje: " + 1);
                System.out.println("Nivel de Precision: " + nivelAtaque);
                System.out.println("Nivel de Habilidades a Distancia: " + nivelDefenza);
                System.out.println("Puntos de vida: " + puntosVida);
                break;

        }

        while (jugar) {
            System.out.println("""
                               QUE DESEAS HACER
                               [1] Buscar Combate
                               [2] Salir 
                               """);
            int accion = put.nextInt();
            if (accion == 2) {
                jugar = false;
            } else {
                int enemigoAleat = (int) (Math.random() * (3 - 1 + 1)) + 1;
                TiposPersonaje guerreroCPU = null;
                TiposPersonaje magoCPU = null;
                TiposPersonaje arqueroCPU = null;
                TiposPersonaje enemigo = null;
                switch (enemigoAleat) {
                    case 1:
                        nivelAtaque = (int) (Math.random() * (20 - 7 + 1)) + 7;
                        nivelDefenza = (int) (Math.random() * (8 - 3 + 1)) + 3;
                        puntosVida = (int) (Math.random() * (250 - 100 + 1)) + 100;
                        nivelPersonaje = (int) (Math.random() * (2 - 1 + 1)) + 1;
                        enemigo = new Guerrero(nivelAtaque, nivelDefenza, nivelPersonaje, puntosVida);
                        System.out.println("==GUERRERO ENEMIGO==");
                        System.out.println("Nivel de Personaje: " + nivelPersonaje);
                        System.out.println("Nivel de Fuerza: " + nivelAtaque);
                        System.out.println("Nivel de Habilidades Cuerpo a Cuerpo: " + nivelDefenza);
                        System.out.println("Puntos de vida: " + puntosVida);
                        break;

                    case 2:
                        nivelAtaque = (int) (Math.random() * (30 - 10 + 1)) + 10;
                        nivelDefenza = (int) (Math.random() * (5 - 2 + 1)) + 2;
                        puntosVida = (int) (Math.random() * (200 - 85 + 1)) + 85;
                        nivelPersonaje = (int) (Math.random() * (2 - 1 + 1)) + 1;
                        enemigo = new Mago(nivelAtaque, nivelDefenza, nivelPersonaje, puntosVida);
                        System.out.println("==MAGO ENEMIGO==");
                        System.out.println("Nivel de Personaje: " + nivelPersonaje);
                        System.out.println("Nivel de Hechizo: " + nivelAtaque);
                        System.out.println("Nivel de Poderes Magicos: " + nivelDefenza);
                        System.out.println("Puntos de vida: " + puntosVida);
                        break;

                    case 3:
                        nivelAtaque = (int) (Math.random() * (20 - 7 + 1)) + 7;
                        nivelDefenza = (int) (Math.random() * (15 - 5 + 1)) + 5;
                        puntosVida = (int) (Math.random() * (140 - 70 + 1)) + 70;
                        nivelPersonaje = (int) (Math.random() * (2 - 1 + 1)) + 1;
                        enemigo = new Arquero(nivelAtaque, nivelDefenza, nivelPersonaje, puntosVida);
                        System.out.println("==ARQUERO ENEMIGO==");
                        System.out.println("Nivel de Personaje: " + nivelPersonaje);
                        System.out.println("Nivel de Precision: " + nivelAtaque);
                        System.out.println("Nivel de Habilidades a Distancia: " + nivelDefenza);
                        System.out.println("Puntos de vida: " + puntosVida);
                        break;

                }
                System.out.println(jugador.combate(enemigo));
                

                
                if(jugador.puntosVida<=0){
                    System.out.println("*********GAME OVER*********");
                    jugar=false;
                }
                else{
                    System.out.println("\n==BIEN HECHO==");
                    System.out.println("SUBES DE NIVEL!!!");
                    System.out.println("Nivel de Personaje: "+jugador.nievlPesonaje);
                    System.out.println("==HAS DESCANZADO Y RECUPERASTE 100 PUNTOS DE VIDA==\n");
                    jugador.puntosVida+=100;
                    if(jugador.nievlPesonaje==5){
                        System.out.println("HAS LLEGADO AL NIVEL MAXIMO");
                        System.out.println("AHORA ERES EL SER MAS PODEROSO");
                        System.out.println("*********GAME OVER*********");
                        jugar=false;
                    }
                }
                 
            }
        }

    }
   
}

abstract class TiposPersonaje {

    public int nievlPesonaje;
    public int puntosVida;


    public TiposPersonaje(int nievlPesonaje, int puntosVida) {
        this.nievlPesonaje = nievlPesonaje;
        this.puntosVida = puntosVida;

    }

    public abstract int ataque();

    public abstract int defensa();

    //public abstract String combate(TiposPersonaje enemigos);
    public String combate(TiposPersonaje enemigos) {
        String textoCombate = "=====INICIA LA PELEA===== \n" + "TU VIDA = " + this.puntosVida + "\n"
                + "VIDA ENEMIGO = " + enemigos.puntosVida;
        int ataqueValido;
        while (this.puntosVida > 0 && enemigos.puntosVida > 0) {
            ataqueValido = (ataque() - enemigos.defensa());
            if (ataqueValido < 0) {
                ataqueValido = 0;
            }
            enemigos.puntosVida -= ataqueValido;
            textoCombate += "\n--TU ATACAS--\n" + "tu vida = " + this.puntosVida + "\n"
                    + "vida enem = " + enemigos.puntosVida;

            if (enemigos.puntosVida <= 0) {
                nievlPesonaje+=1;
                textoCombate += "\n MURIO TU ENEMIGO - GANASTE :)";
                return textoCombate;
            }
            ataqueValido = (enemigos.ataque() - defensa());
            if (ataqueValido < 0) {
                ataqueValido = 0;
            }
            this.puntosVida -= ataqueValido;
            textoCombate += "\n--TU ENEMIGO ATACA--\n" + "tu vida = " + this.puntosVida + "\n"
                    + "vida enem = " + enemigos.puntosVida;

            if (this.puntosVida <= 0) {
                textoCombate += "\n MORISTE - PERDISTE :(";
                return textoCombate;
            }

        }
        return "";
    }
}

class Guerrero extends TiposPersonaje {

    public int nivelFuerza;
    public int nivelHabilCuerpo;

    public Guerrero(int nivelFuerza, int nivelHabilCuerpo, int nievlPesonaje, int puntosVida) {
        super(nievlPesonaje, puntosVida);
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
}

class Mago extends TiposPersonaje {

    public int nivelHechizo;
    public int nivelPoderesMagicos;

    public Mago(int nivelHechizo, int nivelPoderesMagicos, int nievlPesonaje, int puntosVida) {
        super(nievlPesonaje, puntosVida);
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

}

class Arquero extends TiposPersonaje {

    public int nivelPrecicion;
    public int nivelHabilDistancia;

    public Arquero(int nivelPrecicion, int nivelHabilDistancia, int nievlPesonaje, int puntosVida) {
        super(nievlPesonaje, puntosVida);
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

}
