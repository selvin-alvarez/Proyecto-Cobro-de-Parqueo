package programaDeCobro;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salida = false;

        while (!salida) {
            System.out.println("\tMENÚ DE OPCIONES:");
            System.out.println();
            System.out.println("1. Cobrar Parqueo");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Ver Información");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción (1-4): ");
            
            // Verificar que la entrada sea un número
            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                entrada.next(); // Descartar la entrada no válida
                System.out.print("Seleccione una opción (1-4): ");
            }

            int opcion = entrada.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------");

            switch (opcion) {
                case 1:
                    CobrarParqueo.cobrarParqueo();
                    break;
                case 2:
                    BuscarCliente.buscarCliente();
                    break;
                case 3:
                    BaseDatos.mostrarDatos();
                    break;
                case 4:
                    salida = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        entrada.close();
    }
}