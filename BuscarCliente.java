package programaDeCobro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class BuscarCliente {
	
	private static Scanner entrada;

	public static void buscarCliente() {
		entrada = new Scanner(System.in);
        System.out.print("Ingrese el número de NIT: ");
        String numeroNIT = entrada.nextLine();

        boolean encontrado = buscarEnArchivo(numeroNIT);

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static boolean buscarEnArchivo(String numeroNIT) {
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("registro_parqueo.txt"))) {
            String linea;
            StringBuilder clienteInfo = new StringBuilder();
            boolean clienteEncontrado = false;

            while ((linea = br.readLine()) != null) {
                if (linea.contains("NIT: " + numeroNIT)) {
                    clienteEncontrado = true;
                }
                if (clienteEncontrado) {
                    clienteInfo.append(linea).append("\n");
                    if (linea.trim().isEmpty()) {
                        break;
                    }
                }
            }

            if (clienteEncontrado) {
                System.out.println("Cliente encontrado:\n" + clienteInfo.toString());
                encontrado = true;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return encontrado;
    }
}
