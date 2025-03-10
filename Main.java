package tamagochi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del Tamagochi
        System.out.print("Ingresa el nombre de tu mascota: ");
        String nombreTamagochi = scanner.nextLine();

        // Crear el Tamagochi con el nombre ingresado
        Tamagochi miTamagochi = new Tamagochi(nombreTamagochi);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE MASCOTA ---");
            System.out.println("1. Jugar con " + miTamagochi.getName());
            System.out.println("2. Alimentar a " + miTamagochi.getName());
            System.out.println("3. Golpear a " + miTamagochi.getName());
            System.out.println("4. Dormir a " + miTamagochi.getName());
            System.out.println("5. Limpiar a " + miTamagochi.getName());
            System.out.println("6. Ver estado de " + miTamagochi.getName());
            System.out.println("0. Salir del juego");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    miTamagochi.jugar();
                    break;
                case 2:
                    miTamagochi.alimentar();
                    break;
                case 3:
                    miTamagochi.golpear();
                    break;
                case 4:
                    miTamagochi.dormir();
                    break;
                case 5:
                    miTamagochi.limpiar();
                    break;
                case 6:
                    System.out.println("\n--- ESTADO DE " + miTamagochi.getName() + " ---");
                    System.out.println("Energía: " + miTamagochi.getEnergy());
                    System.out.println("Vida: " + miTamagochi.getLife());
                    System.out.println("¿Necesita limpieza? " + (miTamagochi.isNecesitaLimpieza() ? "Sí" : "No"));
                    break;
                case 0:
                    System.out.println("¡Gracias por jugar con " + miTamagochi.getName() + "! Nos vemos pronto.");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

}
