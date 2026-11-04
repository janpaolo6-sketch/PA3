public class ACTIVIDAD3_PerezScharff {

        // Estructura de nodo
        static class Nodo {
            String dato;
            Nodo siguiente;

            Nodo(String dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        // PILA - LIFO
        static class Pila {
            Nodo tope;

            void apilar(String dato) {
                Nodo nuevo = new Nodo(dato);
                nuevo.siguiente = tope;
                tope = nuevo;
            }

            String desapilar() {
                if (tope == null) {
                    return "Pila vacia";
                }

                String dato = tope.dato;
                tope = tope.siguiente;
                return dato;
            }
        }

        // COLA - FIFO
        static class Cola {
            Nodo frente;
            Nodo fin;

            void encolar(String dato) {
                Nodo nuevo = new Nodo(dato);

                if (fin == null) {
                    frente = nuevo;
                    fin = nuevo;
                    return;
                }

                fin.siguiente = nuevo;
                fin = nuevo;
            }

            String desencolar() {
                if (frente == null) {
                    return "Cola vacia";
                }

                String dato = frente.dato;
                frente = frente.siguiente;

                if (frente == null) {
                    fin = null;
                }

                return dato;
            }
        }

        public static void main(String[] args) {

            // Situacion 1: Revertir cambios
            System.out.println("1. REVERTIR CAMBIOS");
            Pila acciones = new Pila();
            acciones.apilar("Escribir texto");
            acciones.apilar("Cambiar color");
            acciones.apilar("Eliminar imagen");

            System.out.println("Deshacer: "
                    + acciones.desapilar());

            // Situacion 2: Atencion de solicitudes
            System.out.println("\n2. SOLICITUDES");
            Cola solicitudes = new Cola();
            solicitudes.encolar("Solicitud A");
            solicitudes.encolar("Solicitud B");
            solicitudes.encolar("Solicitud C");

            System.out.println("Atender: "
                    + solicitudes.desencolar());

            // Situacion 3: Ultimo ingresado primero
            System.out.println("\n3. PROCESAMIENTO LIFO");
            Pila procesos = new Pila();
            procesos.apilar("Proceso 1");
            procesos.apilar("Proceso 2");
            procesos.apilar("Proceso 3");

            System.out.println("Procesar: "
                    + procesos.desapilar());

            // Situacion 4: Tramites pendientes
            System.out.println("\n4. TRAMITES");
            Cola tramites = new Cola();
            tramites.encolar("Tramite 001");
            tramites.encolar("Tramite 002");
            tramites.encolar("Tramite 003");

            System.out.println("Atender: "
                    + tramites.desencolar());
        }
    }


