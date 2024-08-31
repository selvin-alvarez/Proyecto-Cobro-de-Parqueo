package programaDeCobro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class VerInformacion {
	
	public static void verInformacion() {
        try (BufferedReader br = new BufferedReader(new FileReader("ClientesParqueo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}

