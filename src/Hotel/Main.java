package Hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date inicio;
        Date fin;
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel Azul", 10, 4, 100, "Peru",
                "Productos Ejemplo", "Servicios Ejemplo", 50);
        Hotel hotel1 = new Hotel("Hotel Verde", 0, 5, 300, "Argentina",
                "Productos Ejemplo", "Servicios Ejemplo", 50);
        Hotel hotel2 = new Hotel("Hotel Blanco", 10, 4, 522, "Brasil",
                "Productos Ejemplo", "Servicios Ejemplo", 50);
        Hotel[] hoteles = new Hotel[] { hotel1, hotel2, hotel };
        Cliente cliente = new Cliente("Lucas", "Araujo", "42830058", "Casual 123", "Lucas Araujo", "lucas@mail.com",
                "123", 532512, "Lucas123", "caca.mp");

        int opcion;
        do {
            menuHoteles();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------------------");
            switch (opcion) {
                case 1:
                    for (Hotel hotelPos : hoteles) {
                        System.out.println("Nombre: " + hotelPos.getNombre());
                        System.out.println("Pais: " + hotelPos.getPais());
                        System.out.println("Capacidad: " + hotelPos.getCapacidad());
                        System.out.println("Calificacion: " + hotelPos.getCalificacion());
                        System.out.println("Disponibilidad: " + (hotelPos.verificarDisponibilidad() ? "Sí" : "No"));
                        System.out.println("Precio: " + hotelPos.getPrecio());
                        System.out.println("---------------------------------------");
                    }
                    break;
                case 2:
                    do {
                        Boolean encontrado;
                        String hotelAux;
                        menuFiltrarHoteles();
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("---------------------------------------");
                        switch (opcion) {
                            case 1:
                                System.out.print("Ingrese nombre: ");
                                hotelAux = scanner.nextLine();
                                encontrado = false;
                                for (Hotel hotelN : hoteles) {
                                    if (hotelN.getNombre().equals(hotelAux)) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("Nombre: " + hotelN.getNombre());
                                        System.out.println("Pais: " + hotelN.getPais());
                                        System.out.println("Capacidad: " + hotelN.getCapacidad());
                                        System.out.println("Calificacion: " + hotelN.getCalificacion() + "/5");
                                        System.out.println("Disponibilidad: "
                                                + (hotelN.verificarDisponibilidad() ? "Sí" : "No"));
                                        System.out.println("Precio: " + hotelN.getPrecio());
                                        System.out.println("---------------------------------------");
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("---------------------------------------");
                                    System.out.println("¡Hoteles no encontrados!");
                                    System.out.println("---------------------------------------");
                                } else {
                                    menuVerHoteles();
                                    opcion = scanner.nextInt();
                                    int auxNum = 0;
                                    encontrado = false;
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Ingrese el nombre del Hotel: ");
                                            hotelAux = scanner.nextLine();
                                            for (int i = 0; i < hoteles.length; i++) {
                                                if (hoteles[i].getNombre().equals(hotelAux)) {
                                                    auxNum = i;
                                                    encontrado = true;
                                                    break;
                                                }
                                            }
                                            if (!encontrado) {
                                                System.out.println("---------------------------------------");
                                                System.out.println("¡Hoteles no encontrados!");
                                                System.out.println("---------------------------------------");
                                            } else {
                                                menuReserva();
                                                opcion = scanner.nextInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (hoteles[auxNum].verificarDisponibilidad()) {
                                                            ReservarHotel reserva = new ReservarHotel(cliente, hotel,
                                                                    null,
                                                                    null);
                                                            if (reserva.hacerReserva()) {
                                                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                                System.out.print(
                                                                        "Ingrese la fecha de inicio de la reserva(dd/MM/yyyy): ");
                                                                String fechaInicioStr = scanner.nextLine();
                                                                inicio=null;
                                                                System.out.print(
                                                                        "Ingrese la fecha de fin de la reserva(dd/MM/yyyy): ");
                                                                String fechaFinStr = scanner.nextLine();
                                                                fin=null;
                                                                try{
                                                                    inicio = dateFormat.parse(fechaInicioStr);
                                                                }catch(Exception e){
                                                                    System.out.println("Error al ingresar la fecha de inicio.");
                                                                    break;
                                                                }
                                                                try{
                                                                    fin = dateFormat.parse(fechaFinStr);
                                                                }catch(Exception e){
                                                                    System.out.println("Error al ingresar la fecha de fin.");
                                                                    break;
                                                                }
                                                                reserva.setFechaInicio(inicio);
                                                                reserva.setFechaFin(fin);
                                                                System.out.println("Reserva realizada con éxito.");
                                                            } else {
                                                                System.out.println(
                                                                        "No hay habitaciones disponibles para reservar.");
                                                            }
                                                        } else {
                                                            System.out.println(
                                                                    "No hay habitaciones disponibles para reservar.");
                                                        }

                                                        break;

                                                    default:
                                                        break;
                                                }
                                            }
                                            break;
                                        case 2:
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Ingrese precio: ");
                                hotelAux = scanner.nextLine();
                                encontrado = false;
                                for (Hotel hotelN : hoteles) {
                                    if (hotelN.getPais().equals(hotelAux)) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("Nombre: " + hotelN.getNombre());
                                        System.out.println("Pais: " + hotelN.getPais());
                                        System.out.println("Capacidad: " + hotelN.getCapacidad());
                                        System.out.println("Calificacion: " + hotelN.getCalificacion() + "/5");
                                        System.out.println("Disponibilidad: "
                                                + (hotelN.verificarDisponibilidad() ? "Sí" : "No"));
                                        System.out.println("Precio: " + hotelN.getPrecio());
                                        System.out.println("---------------------------------------");
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("---------------------------------------");
                                    System.out.println("¡Hoteles no encontrados!");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 3:
                                System.out.print("Ingrese pais: ");
                                int hotelPrecio = scanner.nextInt();
                                encontrado = false;
                                for (Hotel hotelN : hoteles) {
                                    if (hotelN.getPrecio() <= hotelPrecio) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("Nombre: " + hotelN.getNombre());
                                        System.out.println("Pais: " + hotelN.getPais());
                                        System.out.println("Capacidad: " + hotelN.getCapacidad());
                                        System.out.println("Calificacion: " + hotelN.getCalificacion() + "/5");
                                        System.out.println("Disponibilidad: "
                                                + (hotelN.verificarDisponibilidad() ? "Sí" : "No"));
                                        System.out.println("Precio: " + hotelN.getPrecio());
                                        System.out.println("---------------------------------------");
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("---------------------------------------");
                                    System.out.println("¡No hay hoteles a el precio dado!");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 4:
                                encontrado = false;
                                for (Hotel hotelN : hoteles) {
                                    if (hotelN.verificarDisponibilidad()) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("Nombre: " + hotelN.getNombre());
                                        System.out.println("Pais: " + hotelN.getPais());
                                        System.out.println("Capacidad: " + hotelN.getCapacidad());
                                        System.out.println("Calificacion: " + hotelN.getCalificacion() + "/5");
                                        System.out.println("Disponibilidad: "
                                                + (hotelN.verificarDisponibilidad() ? "Sí" : "No"));
                                        System.out.println("Precio: " + hotelN.getPrecio());
                                        System.out.println("---------------------------------------");
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("---------------------------------------");
                                    System.out.println("¡No hay hoteles disponibles!");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    } while (opcion != 5);

                    break;
                case 3:
                    /*
                     * System.out.print("Ingrese el monto del pago: ");
                     * double montoPago = scanner.nextDouble();
                     * 
                     * scanner.nextLine();
                     * System.out.print("Ingrese el método de pago: ");
                     * String metodoPago = scanner.nextLine();
                     * 
                     * ReservarHotel reserva = new ReservarHotel(cliente, hotel, null, null);
                     * Pago pago = new Pago(reserva, montoPago, metodoPago);
                     * if (pago.realizarPago(hotel)) {
                     * System.out.println("Pago realizado con éxito.");
                     * imprimirTicket(reserva, pago, hotel);
                     * } else {
                     * System.out.println("Error en el pago.");
                     * }
                     */
                    break;
                case 4:
                    /*
                     * System.out.
                     * println("Gracias por utilizar el sistema de gestión de reservas. ¡Hasta luego!"
                     * );
                     */
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }

            System.out.println();
        } while (opcion != 3);

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

    public static void menuReserva() {
        System.out.println("1. Verificar disponibilidad");
        System.out.println("2. Realizar reserva");
        System.out.println("3. Realizar pago");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void menuHoteles() {
        System.out.println("---------------------------------------");
        System.out.println("Bienvenido al sistema de gestión de reservas de hoteles");
        System.out.println("---------------------------------------");
        System.out.println("1. Ver hoteles");
        System.out.println("2. Filtrar hoteles");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void menuVerHoteles() {
        System.out.println("---------------------------------------");
        System.out.println("1. Seleccionar hotel");
        System.out.println("2. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void menuFiltrarHoteles() {
        System.out.println("1. Filtrar por nombre");
        System.out.println("2. Filtrar por pais");
        System.out.println("3. Filtrar por precio");
        System.out.println("4. Filtrar por disponibilidad");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opcion: ");
    }
}
