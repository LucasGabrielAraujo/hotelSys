package Hotel;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Ejemplo", 10, 4, 100, "Ejemplo Hotel", "País Ejemplo",
                "Productos Ejemplo", "Servicios Ejemplo", 50);
        Cliente cliente = new Cliente("John", "Doe", "123456789", "Calle Ejemplo",
                "Tarjeta Ejemplo", "john.doe@example.com", "contraseña123", 987654321,
                "johndoe", "Mercado Pago");
        Date fechaInicio = new Date();
        Date fechaFin = new Date(fechaInicio.getTime() + 86400000);
        ReservarHotel reserva = new ReservarHotel(cliente, hotel, fechaInicio, fechaFin);
        Pago pago = new Pago(reserva, 100.0, "Tarjeta de Crédito");
        
        if (reserva.hacerReserva()) {
            System.out.println("Reserva realizada con éxito.");
            if (pago.realizarPago()) {
                System.out.println("Pago realizado con éxito.");
            } else {
                System.out.println("Error en el pago.");
            }
        } else {
            System.out.println("No hay habitaciones disponibles para reservar.");
        }
    }
}
