public class PilaLIFO {

    static class Nodo {
        String accion;
        Nodo siguiente;

        public Nodo(String accion) {
            this.accion = accion;
            this.siguiente = null;
        }
    }

    static class Pila {
        Nodo tope;

        public Pila() {
            this.tope = null;
        }

        // (Push)
        public void apilar(String accion) {
            Nodo nuevoNodo = new Nodo(accion);
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
            System.out.println("Acción registrada: " + accion);
        }

        // (Pop)
        public String desapilar() {
            if (estaVacia()) {
                System.out.println("Error: No hay acciones para deshacer (Pila vacía).");
                return null;
            }
            String accionRevertida = tope.accion;
            tope = tope.siguiente;
            System.out.println("Acción revertida (desapilada): " + accionRevertida);
            return accionRevertida;
        }

        // Visualizar el tope (Peek)
        public void verTope() {
            if (estaVacia()) {
                System.out.println("La pila está vacía. No hay tope.");
            } else {
                System.out.println("Última acción en el tope: " + tope.accion);
            }
        }

        // Verificar si está vacía
        public boolean estaVacia() {
            return tope == null;
        }

        // Metodo para mostrar la pila
        public void mostrarPila() {
            if (estaVacia()) {
                System.out.println("Pila vacía.");
                return;
            }
            Nodo actual = tope;
            System.out.print("Pila actual (Tope -> Base): ");
            while (actual != null) {
                System.out.print("[" + actual.accion + "] -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    // Metodo Main para probar el caso
    public static void main(String[] args) {
        Pila historialAcciones = new Pila();

        System.out.println("--- SIMULACIÓN: SISTEMA DE MATRÍCULA ---");

        // El estudiante realiza acciones
        historialAcciones.apilar("Agregar curso de Java");
        historialAcciones.apilar("Cambiar sección a Mañana");
        historialAcciones.apilar("Eliminar curso de Base de Datos");

        System.out.println("\n--- ESTADO ACTUAL ---");
        historialAcciones.mostrarPila();

        // Verificamos el tope
        System.out.println("\n--- VERIFICANDO TOPE ---");
        historialAcciones.verTope();

        // El estudiante se equivoca y presiona "Deshacer" (Revertir)
        System.out.println("\n--- PRESIONANDO 'DESHACER' ---");
        historialAcciones.desapilar(); // Debería revertir "Eliminar curso..."

        System.out.println("\n--- ESTADO DESPUÉS DE DESHACER ---");
        historialAcciones.mostrarPila();

        // Deshacemos otra acción
        System.out.println("\n--- PRESIONANDO 'DESHACER' OTRA VEZ ---");
        historialAcciones.desapilar(); // Debería revertir "Cambiar sección..."

        System.out.println("\n--- ESTADO FINAL ---");
        historialAcciones.mostrarPila();
    }
}
