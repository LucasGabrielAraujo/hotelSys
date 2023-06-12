package Hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date inicio;
        Date fin;
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel Ejemplo", 10, 4, 100, "Ejemplo Hotel", "País Ejemplo",
                "Productos Ejemplo", "Servicios Ejemplo", 50);
        Cliente cliente = new Cliente("Lucas","Araujo","42830058","Casual 123", "Lucas Araujo", "lucas@mail.com", "123", 532512, "Lucas123", "caca.mp");

        int opcion;
        do {
            System.out.println("Bienvenido al sistema de gestión de reservas de hoteles");
            System.out.println("1. Verificar disponibilidad");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Realizar pago");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    boolean disponibilidad = hotel.verificarDisponibilidad();
                    System.out.println("Disponibilidad: " + (disponibilidad ? "Sí" : "No"));
                    break;
                case 2:
                    if (hotel.verificarDisponibilidad()) {
                        ReservarHotel reserva = new ReservarHotel(cliente, hotel,null, null);
                        ingresarFechasReserva(reserva);
                        if (reserva.hacerReserva()) {
                            System.out.println("Reserva realizada con éxito.");
                        } else {
                            System.out.println("No hay habitaciones disponibles para reservar.");
                        }
                    } else {
                        System.out.println("No hay habitaciones disponibles para reservar.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el monto del pago: ");
                    double montoPago = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.print("Ingrese el método de pago: ");
                    String metodoPago = scanner.nextLine();

                    ReservarHotel reserva = new ReservarHotel(cliente, hotel, null, null);
                    Pago pago = new Pago(reserva, montoPago, metodoPago);
                    if (pago.realizarPago(hotel)) {
                        System.out.println("Pago realizado con éxito.");
                        imprimirTicket(reserva, pago, hotel);
                    } else {
                        System.out.println("Error en el pago.");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el sistema de gestión de reservas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }

            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    public static void imprimirTicket(ReservarHotel reserva, Pago pago, Hotel hotel) {
        System.out.println("---------- Ticket de Reserva ----------");
        System.out.println("Hotel: " + reserva.getHotel().getNombre());
        System.out.println("Cliente: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
        System.out.println("Fecha de inicio: " + reserva.getFechaInicio());
        System.out.println("Fecha de fin: " + reserva.getFechaFin());
        System.out.println("Monto pagado: " + pago.getMonto());
        System.out.println("Vuelto: " + (pago.getMonto() - hotel.getPrecio()));
        System.out.println("Método de pago: " + pago.getMetodoPago());
        System.out.println("---------------------------------------");
    }

    public static void ingresarFechasReserva(ReservarHotel reserva) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Ingrese la fecha de inicio de la reserva (dd/MM/yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        try {
            reserva.setFechaInicio(dateFormat.parse(fechaInicioStr));
        } catch (Exception e) {
            System.out.println("Error al ingresar la fecha de inicio.");
            return;
        }

        System.out.print("Ingrese la fecha de fin de la reserva (dd/MM/yyyy): ");
        String fechaFinStr = scanner.nextLine();
        try {
            reserva.setFechaFin(dateFormat.parse(fechaFinStr));
        } catch (Exception e) {
            System.out.println("Error al ingresar la fecha de fin.");
            return;
        }

        System.out.println("Fechas de reserva:");
        System.out.println("Fecha de inicio: " + dateFormat.format(reserva.getFechaInicio()));
        System.out.println("Fecha de fin: " + dateFormat.format(reserva.getFechaFin()));
    }
}
