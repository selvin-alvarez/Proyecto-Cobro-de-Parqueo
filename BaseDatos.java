package programaDeCobro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BaseDatos {
	
	public static void mostrarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader("registro_parqueo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarDatos();
    }
}


