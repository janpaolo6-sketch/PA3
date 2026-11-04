package org.example;

public class Main {
    private int[] datos;
    private int frente;
    private int finalCola;
    private int capacidad;
    private int tamaño;

    // Constructor: Inicializa la cola con un tamaño máximo
    public Main(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamaño = 0;
    }

    // Mtodo para verificar si la cola está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Metodo para verificar si la cola está llena
    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    // Algoritmo Encolar (Enqueue): Inserta un elemento al final
    public void encolar(int idSolicitud) {
        if (estaLlena()) {
            System.out.println("Error: La cola está llena.");
            return;
        }
        finalCola = (finalCola + 1) % capacidad;
        datos[finalCola] = idSolicitud;
        tamaño++;
        System.out.println("Solicitud " + idSolicitud + " encolada.");
    }

    // Algoritmo (Dequeue): Atiende y retira el elemento del frente
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("Error: La cola está vacía.");
            return -1;
        }
        int elementoAtendido = datos[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        System.out.println("Atendiendo solicitud ID: " + elementoAtendido);
        return elementoAtendido;
    }

    // Algoritmo para Visualizar el frente
    public int verFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        System.out.println("Próxima solicitud en el frente: " + datos[frente]);
        return datos[frente];
    }

    // MMeteodo Principal (Main) para ejecutar el programa
    public static void main(String[] args) {
        Main cola = new Main(5);

        System.out.println("--- DEMOSTRACIÓN DE COLA FIFO ---");

        // Probando encolar
        cola.encolar(1001);
        cola.encolar(1002);
        cola.encolar(1003);

        // ver quién está primero
        cola.verFrente();

        // atender
        cola.desencolar();

        // ver el nuevo frente
        cola.verFrente();
    }
}