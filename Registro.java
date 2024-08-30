package programaDeCobro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Registro {
	
	public static void guardarDatos(String ticket, String nombreCobrador, LocalDateTime horarioIngreso, LocalDateTime horarioSalida, long minutos, double totalCobrar, String fecha, String nombreCliente, String nit, String telefono, String placa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registro_parqueo.txt", true))) {
            writer.write("Ticket: " + ticket);
            writer.newLine();
            writer.write("Nombre del cobrador: " + nombreCobrador);
            writer.newLine();
            writer.write("NIT: " + nit);
            writer.newLine();
            writer.write("Nombre del cliente: " + nombreCliente);
            writer.newLine();
            writer.write("Teléfono: " + telefono);
            writer.newLine();
            writer.write("Placa: " + placa);
            writer.newLine();
            writer.write("Fecha: " + fecha);
            writer.newLine();
            writer.write("Horario de ingreso: " + horarioIngreso.format(DateTimeFormatter.ofPattern("HH:mm")));
            writer.newLine();
            writer.write("Horario de salida: " + horarioSalida.format(DateTimeFormatter.ofPattern("HH:mm")));
            writer.newLine();
            writer.write("Duración: " + minutos + " minutos");
            writer.newLine();
            writer.write("Total a cobrar: Q" + totalCobrar);
            writer.newLine();
            writer.write("------------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}


