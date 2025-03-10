package tamagochi;

public class Tamagochi {
    private String name;
    private int energy;
    private int life;
    private boolean necesitaLimpieza;

    // Constructor
    public Tamagochi(String name) {
        this.name = name;
        this.energy = 10;
        this.life = 5;
        this.necesitaLimpieza = false;
    }

    // Métodos get y set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getLife() {
        return life;
    }

    public boolean isNecesitaLimpieza() {
        return necesitaLimpieza;
    }

    // Métodos de acción
    public void jugar() {
        if (energy > 0) {
            energy -= 2;
            necesitaLimpieza = true; // Jugar ensucia a la mascota
            System.out.println(name + " está jugando. Energía restante: " + energy);
        } else {
            System.out.println(name + " está demasiado cansado para jugar. Necesita dormir o comer.");
        }
    }

    public void golpear() {
        if (life > 1) {
            life--;
            System.out.println(name + " ha sido golpeado. Vida restante: " + life);
        } else {
            life = 0;
            System.out.println(name + " ha perdido toda su vida... GAME OVER");
        }
    }

    public void alimentar() {
        if (energy < 10) {
            energy += 3;
            if(energy > 10){
                energy = 10;
            }
            System.out.println(name + " ha comido y recuperó energía. Energía actual: " + energy);
        } else {
            System.out.println(name + " ya está lleno y no quiere comer más.");
        }
    }

    public void dormir() {
        energy = 10;
        System.out.println(name + " ha dormido y recuperó toda su energía.");
    }

    public void limpiar() {
        if (necesitaLimpieza) {
            necesitaLimpieza = false;
            System.out.println(name + " ha sido limpiado y ahora está feliz.");
        } else {
            System.out.println(name + " ya está limpio.");
        }
    }
}
