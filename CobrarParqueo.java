package programaDeCobro;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;


class CobrarParqueo {
	
	private static int numeroTicket = 1;

    public static void cobrarParqueo() {
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String ticket = String.format("%04d", numeroTicket++);
        System.out.println("Número de ticket: " + ticket);
        
        
        String nombreCobrador = obtenerEntradaTexto(entrada, "Nombre de la persona que está cobrando: ").toUpperCase();
        String nit = obtenerEntradaNumerica(entrada, "NIT: ");
        String nombreCliente = obtenerEntradaTexto(entrada, "Nombre del cliente: ").toUpperCase();
        String telefono = obtenerEntradaNumerica(entrada, "Número telefónico: ");
        String placa = obtenerEntradaPlaca(entrada, "Número de placa del vehículo: ").toUpperCase();
        String fecha = obtenerEntradaFecha(entrada, "Fecha (dd-MM-yyyy): ", fechaFormato);
        LocalDateTime horarioIngreso = obtenerEntradaHora(entrada, "Horario de ingreso del cliente (HH:mm): ", horaFormato);
        LocalDateTime horarioSalida = obtenerEntradaHora(entrada, "Horario de salida del cliente (HH:mm): ", horaFormato);

        Duration duracion = Duration.between(horarioIngreso, horarioSalida);
        long minutos = duracion.toMinutes();
        double totalCobrar = Calculo.calcularCosto(minutos);

        

        Registro.guardarDatos(ticket, nombreCobrador, horarioIngreso, horarioSalida, minutos, totalCobrar, fecha, nombreCliente, nit, telefono, placa);

        System.out.println("Total a cobrar: Q" + totalCobrar);
    }

    private static String obtenerEntradaTexto(Scanner entrada, String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = entrada.nextLine();
            if (Pattern.matches("[a-zA-Z\\s]+", texto)) {
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese solo texto.");
            }
        }
        return texto;
    }

    private static LocalDateTime obtenerEntradaHora(Scanner entrada, String mensaje, DateTimeFormatter formatter) {
        LocalDateTime hora;
        while (true) {
            System.out.print(mensaje);
            try {
                hora = LocalDateTime.parse(LocalDateTime.now().toLocalDate() + "T" + entrada.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora no válido. Por favor, use el formato HH:mm.");
            }
        }
        return hora;
    }

    private static String obtenerEntradaFecha(Scanner entrada, String mensaje, DateTimeFormatter formato) {
        String fecha;
        while (true) {
            System.out.print(mensaje);
            try {
                fecha = entrada.nextLine();
                formato.parse(fecha);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha no válido. Por favor, use el formato dd-MM-yyyy.");
            }
        }
        return fecha;
    }

    private static String obtenerEntradaNumerica(Scanner entrada, String mensaje) {
        String numero;
        while (true) {
            System.out.print(mensaje);
            numero = entrada.nextLine();
            if (Pattern.matches("\\d+", numero)) {
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese solo números.");
            }
        }
        return numero;
    }

    private static String obtenerEntradaPlaca(Scanner entrada, String mensaje) {
        String placa;
        while (true) {
            System.out.print(mensaje);
            placa = entrada.nextLine();
            if (Pattern.matches("[a-zA-Z0-9\\s]+", placa)) {
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese una placa válida.");
            }
        }
        return placa;
    }
}