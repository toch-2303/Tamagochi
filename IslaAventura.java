package tamagochi;


import java.util.Random;

public class IslaAventura {
    protected char[][] mapa = new char[10][10];
    protected int jugadorX, jugadorY;
    protected int barcoX, barcoY;
    protected boolean tieneLlave = false;
    protected boolean misionCompletada = false;
    protected boolean misionActiva = false;
    protected int objetoX, objetoY; // Ubicación del objeto de la misión
    protected int npcX, npcY; // Coordenadas del NPC con la misión

    public IslaAventura() {
        inicializarMapa();
    }

    public void inicializarMapa() {
        Random random = new Random();
        
        // Llenar el mapa de puntos
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapa[i][j] = '.';
            }
        }
        
        // Ubicar al jugador en una posición aleatoria
        jugadorX = (random.nextInt(11));
        jugadorY = (random.nextInt(11));
        System.out.println(jugadorX);
        System.out.println(jugadorY);
        
        // Ubicar el barco
        barcoX = random.nextInt(10);
        do {
            barcoY = random.nextInt(10);
		} while (barcoY != 0 && barcoY != 10);
        mapa[barcoX][barcoY] = 'B';

        // Ubicar un NPC en una posición aleatoria
        do {
            npcX = random.nextInt(10);
            npcY = random.nextInt(10);
        } while (mapa[npcX][npcY] != '.');
        mapa[npcX][npcY] = 'N';

        // Ubicar el objeto de la misión en una posición aleatoria
        do {
            objetoX = random.nextInt(10);
            objetoY = random.nextInt(10);
        } while (mapa[objetoX][objetoY] != '.' || (objetoX == npcX && objetoY == npcY));
        mapa[objetoX][objetoY] = 'O';
    }

    public void mostrarMapa() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == jugadorX && j == jugadorY) {
                    System.out.print("X "); // Posición del jugador
                } else {
                    System.out.print(mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void moverJugador(String direccion) {
        int nuevaX = jugadorX, nuevaY = jugadorY;
        switch (direccion.toUpperCase()) {
            case "N": nuevaX--; break;
            case "S": nuevaX++; break;
            case "E": nuevaY++; break;
            case "O": nuevaY--; break;
            default: 
                System.out.println("Movimiento no válido."); 
                return;
        }

        if (nuevaX >= 0 && nuevaX < 10 && nuevaY >= 0 && nuevaY < 10) {
            jugadorX = nuevaX;
            jugadorY = nuevaY;

            // Comprobar si encuentra el objeto de la misión
            comprobarMision();
        } else {
            System.out.println("No puedes moverte en esa dirección.");
        }
    }

    public boolean puedeHablar() {
        return jugadorX == npcX && jugadorY == npcY;
    }

    public void hablarConPersonajes() {
        if (puedeHablar()) {
            if (!misionActiva && !misionCompletada) {
                System.out.println("NPC: ¡Hola, forastero! Tengo una misión para ti.");
                System.out.println("Misión: Encuentra el objeto sagrado en el bosque (en otra ubicación de la isla).");
                misionActiva = true;
            } else if (misionActiva && !misionCompletada) {
                System.out.println("NPC: ¡Aún no has encontrado el objeto sagrado!");
            } else if (misionCompletada && !tieneLlave) {
                System.out.println("NPC: ¡Bien hecho! La llave está en la cueva al norte.");
                tieneLlave = true;
            } else {
                System.out.println("NPC: ¡Buena suerte en tu aventura!");
            }
        } else {
            System.out.println("No hay nadie aquí para hablar.");
        }
    }

    public void comprobarMision() {
        if (misionActiva && jugadorX == objetoX && jugadorY == objetoY) {
            System.out.println("¡Has encontrado el objeto sagrado!");
            misionCompletada = true;
            misionActiva = false;
        }
    }

    public boolean jugadorEnBarco() {
        return jugadorX == barcoX && jugadorY == barcoY && tieneLlave;
    }
}
