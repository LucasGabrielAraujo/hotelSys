package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int reservasId = 1;
        int hotelId = 1;
        List<ReservarHotel> listaReservas = new ArrayList<>();
        // Variables para almacenar la selección del usuario
        List<Hotel> listaHoteles = new ArrayList<>();
        Hotel hotelSeleccionado = null;
        ReservarHotel reserva = null;
        Habitacion habitacionSeleccionada = null;
        Pago pago = null;
        Scanner scanner = new Scanner(System.in);

        Habitacion sencilla = new Habitacion(20, "Sencilla");
        Habitacion doble = new Habitacion(10, "Doble");
        Habitacion suite = new Habitacion(5, "Suite");
        Hotel hotel = new Hotel("Hotel Azul", 10, 4.0, "Peru",
                "Productos Ejemplo");
        hotel.setTiposHabitacion(sencilla);
        hotel.setTiposHabitacion(doble);
        hotel.setTiposHabitacion(suite);
        hotel.setId(hotelId++);
        Hotel hotel1 = new Hotel("Hotel Verde", 2, 50.0, "Argentina", "cosas");
        hotel1.setTiposHabitacion(sencilla);
        hotel1.setTiposHabitacion(doble);
        hotel1.setTiposHabitacion(suite);
        hotel1.setId(hotelId++);
        Hotel hotel2 = new Hotel("Hotel Blanco", 4, 522, "Brasil",
                "Productos Ejemplo");
        hotel2.setId(hotelId++);
        hotel2.setTiposHabitacion(sencilla);

        Usuario cliente = new Usuario("Lucas", "Araujo", "42830058", "Casual 123", "Lucas Araujo", "lucas@mail.com",
                "123", 532512, "Lucas123", "caca.mp", true);
        listaHoteles.add(hotel);
        listaHoteles.add(hotel1);
        listaHoteles.add(hotel2);
        int opcion;
        do {
            menuHoteles();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------------------");
            switch (opcion) {
                case 1:
                    for (Hotel hotelPos : listaHoteles) {
                        System.out.println("ID: " + hotelPos.getId());
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
                                for (Hotel hotelN : listaHoteles) {
                                    if (hotelN.getNombre().equals(hotelAux)) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("ID: " + hotelN.getId());
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
                            case 2:
                                System.out.print("Ingrese precio: ");
                                hotelAux = scanner.nextLine();
                                encontrado = false;
                                for (Hotel hotelN : listaHoteles) {
                                    if (hotelN.getPais().equals(hotelAux)) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("ID: " + hotelN.getId());
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
                                for (Hotel hotelN : listaHoteles) {
                                    if (hotelN.getPrecio() <= hotelPrecio) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("ID: " + hotelN.getId());
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
                                for (Hotel hotelN : listaHoteles) {
                                    if (hotelN.verificarDisponibilidad()) {
                                        System.out.println("---------------------------------------");
                                        System.out.println("ID: " + hotelN.getId());
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
                    do {
                        menuReserva();
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("---------------------------------------");
                        switch (opcion) {
                            case 1:
                                // Solicitar al usuario que ingrese el nombre del hotel deseado
                                System.out.print("Ingrese el nombre del hotel deseado: ");
                                String nombreHotel = scanner.nextLine();
                                scanner.nextLine();
                                // Buscar el hotel en la lista de hoteles disponibles
                                for (Hotel hoteln : listaHoteles) {
                                    if (hoteln.getNombre().equalsIgnoreCase(nombreHotel)) {
                                        hotelSeleccionado = hoteln;
                                        System.out.print("Ingrese el tipo de habitacion deseado: ");
                                        String tipoHabitacion = scanner.nextLine();
                                        scanner.nextLine();
                                        for (Habitacion habitacion : hotelSeleccionado.getTiposHabitacion()) {
                                            if (habitacion.getTipoHabitacion().equalsIgnoreCase(tipoHabitacion)) {
                                                habitacionSeleccionada = habitacion;
                                                hoteln.setCalificacion(hoteln.getCalificacion()-1);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }

                                // Verificar si se encontró el hotel
                                if (hotelSeleccionado != null) {
                                    System.out.println("Hotel seleccionado: ID " + hotelSeleccionado.getId()
                                            + "\nNombre: " + hotelSeleccionado.getNombre());
                                    System.out.println("---------------------------------------");
                                } else {
                                    System.out.println(
                                            "El hotel ingresado no está disponible. Por favor, seleccione otro hotel.");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 2:
                                // Verificar si se ha seleccionado un hotel
                                if (hotelSeleccionado == null) {
                                    System.out.println("Primero debe seleccionar un hotel.");
                                    System.out.println("---------------------------------------");
                                    break;
                                }

                                // Solicitar al usuario las fechas de inicio y fin de la reserva
                                System.out.print("Ingrese la fecha de inicio de la reserva (dd/MM/yyyy): ");
                                String fechaInicioStr = scanner.nextLine();
                                System.out.print("Ingrese la fecha de fin de la reserva (dd/MM/yyyy): ");
                                String fechaFinStr = scanner.nextLine();

                                // Convertir las cadenas de fecha a objetos Date
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date fechaInicio;
                                Date fechaFin;
                                try {
                                    fechaInicio = dateFormat.parse(fechaInicioStr);
                                    fechaFin = dateFormat.parse(fechaFinStr);
                                } catch (ParseException e) {
                                    System.out.println(
                                            "Formato de fecha inválido. Por favor, ingrese las fechas en el formato correcto.");
                                    System.out.println("---------------------------------------");
                                    break;
                                }

                                // Crear una instancia de ReservarHotel
                                reserva = new ReservarHotel(cliente, hotelSeleccionado, fechaInicio,
                                        fechaFin, habitacionSeleccionada);

                                // Realizar la reserva
                                boolean reservaExitosa = reserva.hacerReserva();

                                if (reservaExitosa) {
                                    System.out.println("Reserva realizada exitosamente.");
                                    System.out.println("---------------------------------------");
                                    reserva.setId(reservasId++);
                                    listaReservas.add(reserva);
                                } else {
                                    System.out.println(
                                            "No se pudo realizar la reserva. El hotel no tiene habitaciones disponibles.");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 3:
                                // Verificar si se ha realizado una reserva
                                if (reserva == null) {
                                    System.out.println("Primero debe realizar una reserva.");
                                    System.out.println("---------------------------------------");
                                    break;
                                }

                                // Solicitar al usuario el monto y método de pago
                                if (cliente.isPremium()) {
                                    System.out.println("Precio: $" + hotelSeleccionado.getPrecio());
                                    System.out.println("Descuento por usuario premium(30%): $"
                                            + (hotelSeleccionado.getPrecio() * 0.3));
                                    System.out.println("Precio final: $"
                                            + (hotelSeleccionado.getPrecio() - (hotelSeleccionado.getPrecio() * 0.3)));
                                }
                                System.out.print("Ingrese el monto a pagar: ");
                                double monto = scanner.nextDouble();
                                scanner.nextLine(); // Consumir la nueva línea pendiente
                                System.out.print("Ingrese el método de pago: ");
                                String metodoPago = scanner.nextLine();

                                // Crear una instancia de Pago
                                pago = new Pago(reserva, monto, metodoPago);
                                hotelSeleccionado.setPrecio(
                                        hotelSeleccionado.getPrecio() - (hotelSeleccionado.getPrecio() * 0.3));
                                // Realizar el pago
                                boolean pagoExitoso = pago.realizarPago(hotelSeleccionado);

                                if (pagoExitoso) {
                                    System.out.println("Pago realizado exitosamente.");
                                    // Generar el ticket con la reserva, el pago y el hotel
                                    generarTicket(reserva, pago, hotelSeleccionado);
                                    pago = null;
                                    reserva = null;
                                    hotelSeleccionado = null;
                                } else {
                                    System.out.println(
                                            "No se pudo realizar el pago. El monto ingresado es insuficiente.");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            case 4:
                                // Verificar si se ha realizado una reserva
                                if (listaReservas.isEmpty()) {
                                    System.out.println("No se ha realizado ninguna reserva.");
                                    System.out.println("---------------------------------------");
                                    break;
                                }

                                // Confirmar la cancelación de la reserva
                                System.out.println("¿Está seguro que desea cancelar la reserva? (S/N)");
                                String aux = scanner.nextLine();

                                if (aux.equalsIgnoreCase("S")) {
                                    // Liberar la habitación en el hotel
                                    hotel.set;

                                    // Mostrar mensaje de cancelación exitosa
                                    System.out.println("La reserva ha sido cancelada exitosamente.");
                                    System.out.println("---------------------------------------");
                                    // borrar la reserva de la lista
                                    listaReservas.remove(reserva);
                                    reserva = null; // Limpiar la reserva actual
                                } else {
                                    System.out.println("La reserva no ha sido cancelada.");
                                    System.out.println("---------------------------------------");
                                }
                                break;
                            default:
                                break;
                        }
                    } while (opcion != 5);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();

    }

    public static void generarTicket(ReservarHotel reserva, Pago pago, Hotel hotel) {
        System.out.println("---------- Ticket de Reserva ----------");
        System.out.println("Hotel: " + reserva.getHotel().getNombre());
        System.out.println("Cliente: " + reserva.getUsuario().getNombre() + " " + reserva.getCliente().getApellido());
        System.out.println("Fecha de inicio: " + reserva.getFechaInicio());
        System.out.println("Fecha de fin: " + reserva.getFechaFin());
        System.out.println("Pais: " + hotel.getPais());
        System.out.print("Moneda: ");
        if (hotel.getPais().equals("Argentina")) {
            System.out.println("ARS$ (pesos argentinos)");
        } else {
            System.out.println("USD$ (dolar estadounidense)");
        }
        System.out.println("Precio: $" + hotel.getPrecio());
        System.out.println("Monto pagado: $" + pago.getMonto());
        if (pago.getMonto() < hotel.getPrecio()) {
            System.out.println("Vuelto: $0" + " (Debe: " + (-1 * (hotel.getPrecio() - pago.getMonto())) + ")");
        } else {
            System.out.println("Vuelto: $" + (pago.getMonto() - hotel.getPrecio()));
        }
        System.out.println("Método de pago: " + pago.getMetodoPago());
        System.out.println("---------------------------------------");
    }

    public static void menuReserva() {
        System.out.println("1. Seleccionar hotel");
        System.out.println("2. Realizar reserva");
        System.out.println("3. Realizar pago");
        System.out.println("4. Cancelar reserva");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void menuHoteles() {
        System.out.println("---------------------------------------");
        System.out.println("Bienvenido al sistema de gestión de reservas de hoteles");
        System.out.println("---------------------------------------");
        System.out.println("1. Ver hoteles");
        System.out.println("2. Filtrar hoteles");
        System.out.println("3. Reservar hotel");
        System.out.println("4. Salir");
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

    public void seleccionarTipoHabitacion(ReservarHotel reserva) {
        System.out.println("Tipos de habitación disponibles:");
        for (Habitacion habitacion : reserva.getHotel().getTiposHabitacion()) {
            System.out.println("- " + habitacion.getTipoHabitacion() + " (Disponibles: "
                    + habitacion.getHabitacionesDisponibles() + ")");
        }
        System.out.print("Ingrese el tipo de habitación deseado: ");
        String tipoSeleccionado = scanner.nextLine();

        // Verificar si el tipo de habitación seleccionado está disponible
        for (Habitacion habitacion : reserva.getHotel().getTiposHabitacion()) {
            if (habitacion.getTipoHabitacion().equals(tipoSeleccionado)
                    && habitacion.getHabitacionesDisponibles() > 0) {
                reserva.setTipoHabitacion(tipoSeleccionado);
                habitacion.setHabitacionesDisponibles(habitacion.getHabitacionesDisponibles() - 1);
                System.out.println("Habitación seleccionada: " + tipoSeleccionado);
                return;
            }
        }

        System.out.println("El tipo de habitación seleccionado no está disponible. Por favor, elija otro tipo.");
    }
}
