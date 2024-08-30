package programaDeCobro;

class Calculo {
	
	public static double calcularCosto(long minutos) {
        if (minutos <= 30) {
            return 7.00;
        } else if (minutos <= 60) {
            return 13.00;
        } else {
            long horasCompletas = (minutos - 60) / 60;
            long minutosRestantes = (minutos - 60) % 60;
            double costoAdicional = horasCompletas * 13.00;
            
            if (minutosRestantes > 0 && minutosRestantes <= 30) {
                costoAdicional += 7.00; // Costo de media hora
            } else if (minutosRestantes > 30) {
                costoAdicional += 13.00; // Costo de una hora completa
            }
            
            return 13.00 + costoAdicional;
        }
    }
}


