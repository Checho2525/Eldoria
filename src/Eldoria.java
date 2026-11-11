import java.util.Scanner;

/*
* Eldoria: Treasures of the Fallen Kingdom
*
* Descripción:
* Videojuego de rol por turnos desarrollado en Java para consola.
* El jugador deberá avanzar por diferentes salas de una mazmorra,
* enfrentándose a enemigos y consiguiendo oro y experiencia.
*
* Durante la aventura podrá atacar, defenderse o huir de los combates.
* Al ganar combates conseguirá recompensas y podrá subir de nivel,
* mejorando sus estadísticas para enfrentarse a enemigos más fuertes.
*
* El objetivo es sobrevivir y avanzar por tantas salas como sea posible.
* 
* Fecha : 28/10/2026
* Autor : Sergio
*/
public class Eldoria {
    public static void main(String[] args) {
        
        //PARTE DECLARATIVA

        //Creamos escaner y las variables para las respuestas de las peticiones que hagamos
        int respuesta;
        int accion;
        Scanner scanner =new Scanner(System.in);

        //Creamos el personaje que tendremos, en este caso las estadisticas iniciales seran vida = 50 daño = 10 oro = 0 
        int[] personaje = {50,10,0};
        //Creamos los enemigos con los que nos enfrentaremos
        int[] slime = {20,7,5};
        int[] goblin = {20,6,6};
        int[] esqueleto = {25,7,7};

        // COLORES ANSI
        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String AMARILLO = "\u001B[33m";
        final String AZUL = "\u001B[34m";
        final String MORADO = "\u001B[35m";
        final String CIAN = "\u001B[36m";

        //Creamos el sistema de niveles y dificultades

        int nivel = 1;
        int experiencia = 0;
        int experienciaNecesaria = 20;
        int vidaMaxima = 50;

        int sala = 1;
        boolean vivo = true;

        final int CURACION_VICTORIA = 10;
        final int EXPERIENCIA_VICTORIA = 10;
        final int MEJORA_DANO_NIVEL = 4;
        final int MEJORA_VIDA_MAXIMA_NIVEL = 10;
        final int AUMENTO_VIDA_ENEMIGO_SALA = 5;
        final int AUMENTO_DAÑO_ENEMIGO_SALA = 2;
        final int AUMENTO_ORO_ENEMIGO_SALA = 2;

        //////////////////////////////////////////////////////////////////////////////////////

        //CUERPO

        respuesta = 1 ;//Inicialización de variables
        accion = 0;

        while (respuesta != 3 && vivo == true) {

            System.out.println(AZUL + "*****************************");
            System.out.println("* QUE OPCIÓN QUIERES ELEGIR *");
            System.out.println("*****************************");
            System.out.println("* 1.Batallar en la mazmorra *");
            System.out.println("*  2.Consultar estadisticas *");
            System.out.println("*          3.Salir          *");
            System.out.println("*****************************" + RESET);
            respuesta = scanner.nextInt();

            if (respuesta == 1) {

                int enemigoAleatorio = (int)(Math.random()*3); // los enemigos seran 0=slime , 1=goblin, 2=esqueleto.

                int vidaEnemigo;
                int dañoEnemigo;
                int oroEnemigo;
                String nombreEnemigo;
                
                if (enemigoAleatorio == 0) {
                    vidaEnemigo = slime[0];
                    dañoEnemigo = slime[1];
                    oroEnemigo   = slime[2];
                    nombreEnemigo = "SLIME";
                } else if (enemigoAleatorio == 1) {
                    vidaEnemigo = goblin[0];
                    dañoEnemigo = goblin[1];
                    oroEnemigo   = goblin[2];
                    nombreEnemigo = "GOBLIN";
                } else {
                    vidaEnemigo = esqueleto[0];
                    dañoEnemigo = esqueleto[1];
                    oroEnemigo   = esqueleto[2];
                    nombreEnemigo = "ESQUELETO";
                
                }
                // Aumentar dificultad según la sala
                vidaEnemigo += (sala - 1) * AUMENTO_VIDA_ENEMIGO_SALA;
                dañoEnemigo += (sala - 1) * AUMENTO_DAÑO_ENEMIGO_SALA;
                oroEnemigo += (sala - 1) * AUMENTO_ORO_ENEMIGO_SALA;
                System.out.println(ROJO + "TE HAS ENCONTRADO A UN " + nombreEnemigo + "!!!" + RESET);

                //Pelea
                while (personaje[0] > 0 && vidaEnemigo > 0) {

                    System.out.println(AMARILLO + "**************************");
                    System.out.println("        COMBATE");
                    System.out.println("**************************");
                    System.out.println("Sala: " + sala);
                    System.out.println("Enemigo: " + nombreEnemigo);
                    System.out.println("Vida enemigo: " + vidaEnemigo);
                    System.out.println("--------------------------");
                    System.out.println("Tu vida: " + personaje[0]);
                    System.out.println("Tu daño: " + personaje[1]);
                    System.out.println("**************************");
                    System.out.println("1. Atacar");
                    System.out.println("2. Defenderse (El daño enemigo se reducira a la mitad)");
                    System.out.println("3. Huir (Volveras al menú principal conservando tus estadisticas y oro actuales)");
                    System.out.print("Elige una opcion: " + RESET);
                    accion = scanner.nextInt();

                    boolean defenderse = false;
                    
                    //Nuestro turno

                    if (accion == 1) {
                        vidaEnemigo = vidaEnemigo - personaje[1];

                        System.out.println(VERDE + "Le has infligido daño!");
                        System.out.println("Daño causado: " + personaje[1] + RESET);
                    }
                    else if (accion == 2) {
                        defenderse = true;
                        System.out.println(VERDE +"Te preparas para recibir el golpe" + RESET);
                    }
                    else if (accion == 3) {
                        System.out.println(CIAN + "Has huido del combate" + RESET);
                        break;
                    }
                    else {
                        System.out.println("Opción incorrecta");
                        continue;
                    }

                    //Turno enemigo
                    if (vidaEnemigo > 0) {

                        int dañoRecibido = dañoEnemigo;

                        if (defenderse == true) {
                            dañoRecibido =  dañoRecibido/2;
                        }

                        personaje[0] = personaje[0] - dañoRecibido;

                        System.out.println(ROJO + "El enemigo esta atacando!");
                        System.out.println("Daño recibido: " + dañoRecibido + RESET);
                    }

                    //Resultado
                    if (vidaEnemigo <= 0) {
                        System.out.println(VERDE + "HAS DERROTADO AL " + nombreEnemigo +"!"+ RESET);

                        //Conseguir oro
                        personaje[2] = personaje[2] + oroEnemigo;
                    
                        System.out.println(AMARILLO +"Has conseguido " + oroEnemigo + " de oro");
                        System.out.println("Oro total: " + personaje [2] + RESET);

                        //Curarse después de la batalla
                        personaje[0] += CURACION_VICTORIA;

                            if (personaje[0] > vidaMaxima) {
                                personaje[0] = vidaMaxima;
                                System.out.println(VERDE + "Alcanzaste los puntos de vida maximos ("+ personaje[0]+")");
                                }
                            else {
                                System.out.println(VERDE + "Has recuperado 10 puntos de vida" + RESET);
                                }

                        //Subida de nivel
                        experiencia = experiencia + EXPERIENCIA_VICTORIA;
                        System.out.println(AMARILLO + "Has conseguido "+ EXPERIENCIA_VICTORIA+" puntos de experiencia");
                        System.out.println("Experiencia: " + experiencia + "/" + experienciaNecesaria + RESET);

                        if (experiencia >= experienciaNecesaria) {
                            nivel++;
                            experiencia = experiencia - experienciaNecesaria;
                            experienciaNecesaria += EXPERIENCIA_VICTORIA;

                            personaje[0] += MEJORA_VIDA_MAXIMA_NIVEL;
                            personaje[1] += MEJORA_DANO_NIVEL;
                            vidaMaxima += MEJORA_VIDA_MAXIMA_NIVEL;
                            System.out.println(VERDE + "¡HAS SUBIDO DE NIVEL!" );
                            System.out.println("Nivel actual: " + nivel);
                            System.out.println("Tu vida máxima ha aumentado en 10");
                            System.out.println("Tu daño ha aumentado en 4" + RESET);
                        }
                        
                        //Incrementarndo el nivel de dificultad
                        sala++;

                        
                    }
                    else if (personaje[0] <= 0) {
                        System.out.println(ROJO + "HAS SIDO DERROTADO" + RESET);
                        System.out.println(AMARILLO + "Has conseguido llegar a la sala " + (sala + 1) + RESET);
                        System.out.println("¡Gracias por jugar a Eldoria! La aventura termina aquí.");
                        vivo = false;
                        break;
                    }
                }
            }
            if (respuesta == 2) {
                System.out.println(MORADO + "*******************************");
                System.out.println("*         ESTADÍSTICAS        *");
                System.out.println("*******************************");
                String[] nombres = {"VIDA", "DAÑO", "ORO"};
                for (int i=0; i < personaje.length; i++){
                    System.out.printf("* %-13s = %-10d *%n", nombres[i], personaje[i]);
                }
                System.out.printf("* NIVEL         = %-10d *%n", nivel);
                System.out.printf("* EXPERIENCIA   = %-10s *%n", experiencia + "/" + experienciaNecesaria);
                System.out.printf("* SALA ACTUAL   = %-10d *%n", sala);
                System.out.println("*******************************" + RESET);
            }
            if (respuesta == 3) {
                System.out.println("Has salido del programa");
            }

            else if (respuesta <1 || respuesta >3){ 

                System.out.println("Elige una de las opciones dentro del menu");
            }
        }
        scanner.close();
    }
}
