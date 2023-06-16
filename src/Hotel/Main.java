package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int reservasId = 1;
        int hotelId = 1;
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<ReservarHotel> listaReservas = new ArrayList<>();
        List<Hotel> listaHoteles = new ArrayList<>();
        List<String> listaServicios = new ArrayList<>();
        Hotel hotelSeleccionado = null;
        ReservarHotel reserva = null;
        Habitacion habitacionSeleccionada = null;
        Pago pago = null;

        Habitacion sencilla = new Habitacion(20, "Sencilla");
        Habitacion doble = new Habitacion(10, "Doble");
        Habitacion suite = new Habitacion(5, "Suite");
        Hotel hotel = new Hotel("Hotel Azul", 10, 100, "Peru",
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

        Usuario cliente = new Usuario("", "", "", "", "", "", false);
        listaHoteles.add(hotel);
        listaHoteles.add(hotel1);
        listaHoteles.add(hotel2);
        hotel.addServicios("Cena");
        hotel.addServicios("Desayuno");
        hotel1.addServicios("Auto");
        hotel2.addServicios("Desayuno");
        hotel2.addServicios("Cena");
        cuenta(listaUsuarios, cliente);
        int opcion;
        System.out.println(cliente.getAdmistrador());
        if (cliente.getAdmistrador()) {
            Scanner scanner = new Scanner(System.in);
            menuAdmin();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:

                    break;

                default:
                    break;
            }
        } else if(!cliente.getAdmistrador()){
            do {
                Scanner scanner = new Scanner(System.in);
                menuHoteles();
                opcion = scanner.nextInt();
                scanner.nextLine();
                System.out.println("---------------------------------------");
                switch (opcion) {
                    case 1:
                        for (Hotel hotelPos : listaHoteles) {
                            mostraHotel(hotelPos);
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
                                            mostraHotel(hotelN);
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
                                            mostraHotel(hotelN);
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
                                    System.out.print("Ingrese precio: ");
                                    int hotelPrecio = scanner.nextInt();
                                    encontrado = false;
                                    for (Hotel hotelN : listaHoteles) {
                                        if (hotelN.getPrecio() <= hotelPrecio) {
                                            mostraHotel(hotelN);
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
                                            mostraHotel(hotelN);
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
                                            /*
                                             * for (Habitacion habitacion : hotelSeleccionado.getTiposHabitacion()) {
                                             * if (habitacion.getTipoHabitacion().equalsIgnoreCase(tipoHabitacion)) {
                                             * habitacionSeleccionada = habitacion;
                                             * habitacion.setHabitacionesDisponibles(
                                             * habitacion.getHabitacionesDisponibles() - 1);
                                             * break;
                                             * }
                                             * }
                                             */
                                            break;
                                        }
                                    }
                                    System.out.print("Ingrese el tipo de habitacion deseado: ");
                                    String tipoHabitacion = scanner.nextLine();
                                    scanner.nextLine();

                                    // Verificar si se encontró el hotel
                                    if (hotelSeleccionado != null) {
                                        System.out.println("Hotel seleccionado: ID " + hotelSeleccionado.getId()
                                                + "\nNombre: " + hotelSeleccionado.getNombre());
                                    } else {
                                        System.out.println(
                                                "El hotel ingresado no está disponible. Por favor, seleccione otro hotel.");
                                        System.out.println("---------------------------------------");
                                    }
                                    // verificar si se encontro habitacion
                                    for (Habitacion habitacion : hotelSeleccionado.getTiposHabitacion()) {
                                        if (habitacion.getTipoHabitacion().equalsIgnoreCase(tipoHabitacion)
                                                && habitacion.getHabitacionesDisponibles() > 0) {
                                            habitacion.setHabitacionesDisponibles(
                                                    habitacion.getHabitacionesDisponibles() - 1);
                                            System.out.println("Habitación seleccionada: "
                                                    + tipoHabitacion);
                                            System.out.println("---------------------------------------");
                                            habitacionSeleccionada = new Habitacion(
                                                    habitacion.getHabitacionesDisponibles(),
                                                    tipoHabitacion);
                                            break;
                                        }
                                    }
                                    if (habitacionSeleccionada == null) {
                                        System.out.println(
                                                "La habitacion ingresada no está disponible. Por favor, seleccione otra.");
                                        System.out.println("---------------------------------------");
                                    }
                                    break;
                                case 2:
                                    if (hotelSeleccionado == null || habitacionSeleccionada == null) {
                                        System.out.println("Primero seleccione hotel y habitacion");
                                        System.out.println("---------------------------------------");
                                    }
                                    Boolean agregado = false;
                                    System.out.print("Ingrese el servicio deseado: ");
                                    String servicio = scanner.nextLine();
                                    scanner.nextLine();
                                    if (servicio.isEmpty()) {
                                        System.out.println("No se han seleccionado servicios");
                                        break;
                                    } else {
                                        for (Hotel hservicio : listaHoteles) {
                                            for (String serv : hservicio.getServicios()) {
                                                if (agregado) {
                                                    break;
                                                }
                                                if (serv.equalsIgnoreCase(servicio)) {
                                                    agregado = true;
                                                    listaServicios.add(servicio);
                                                    break;
                                                }
                                            }
                                        }
                                        if (listaServicios.isEmpty()) {
                                            System.out.println("Servicios no encontrados");
                                        } else {
                                            System.out.println("Servicios seleccionados: " + listaServicios);
                                        }
                                    }
                                    break;
                                case 3:
                                    // Verificar si se ha seleccionado un hotel
                                    if (hotelSeleccionado == null || habitacionSeleccionada == null) {
                                        System.out.println("Primero debe seleccionar un hotel y habitacion.");
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
                                    Boolean reservaExitosa = true;
                                    try {
                                        fechaInicio = dateFormat.parse(fechaInicioStr);
                                        fechaFin = dateFormat.parse(fechaFinStr);
                                    } catch (ParseException e) {
                                        System.out.println(
                                                "Formato de fecha inválido. Por favor, ingrese las fechas en el formato correcto.");
                                        System.out.println("---------------------------------------");
                                        reservaExitosa = false;
                                        break;
                                    }
                                    // Realizar la reserva
                                    if (reservaExitosa) {
                                        reserva = new ReservarHotel(cliente, hotelSeleccionado, fechaInicio, fechaFin,
                                                habitacionSeleccionada.getTipoHabitacion());
                                        System.out.println("Reserva realizada exitosamente.");
                                        System.out.println("---------------------------------------");
                                        reserva.setId(reservasId++);
                                        listaReservas.add(reserva);
                                    } else {
                                        System.out.println(
                                                "No se pudo realizar la reserva");
                                        System.out.println("---------------------------------------");
                                    }
                                    break;
                                case 4:
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
                                                + (hotelSeleccionado.getPrecio()
                                                        - (hotelSeleccionado.getPrecio() * 0.3)));
                                    } else {
                                        System.out.println("Precio: $" + hotelSeleccionado.getPrecio());
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
                                        habitacionSeleccionada = null;
                                    } else {
                                        System.out.println(
                                                "No se pudo realizar el pago. El monto ingresado es insuficiente.");
                                        System.out.println("---------------------------------------");
                                    }
                                    break;
                                case 5:
                                    // Verificar si se ha realizado una reserva
                                    if (listaReservas.isEmpty()) {
                                        System.out.println("No se ha realizado ninguna reserva.");
                                        System.out.println("---------------------------------------");
                                        break;
                                    }
                                    // Confirmar la cancelación de la reserva
                                    Boolean encontrado = false;
                                    String nHotel = "";
                                    System.out.println("Seleccione el ID de la reserva: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    for (ReservarHotel reservaux : listaReservas) {
                                        if (!(reservaux.getId() == id)) {
                                            encontrado = false;
                                        } else {
                                            encontrado = true;
                                            nHotel = reservaux.getHotel().getNombre();
                                            break;
                                        }
                                    }
                                    if (!encontrado) {
                                        System.out.println("Reserva no encontrada");
                                        break;
                                    }
                                    System.out.println("¿Está seguro que desea cancelar la reserva? (S/N)");
                                    System.out.println("Hotel: " + nHotel);
                                    String aux = scanner.nextLine();

                                    if (aux.equalsIgnoreCase("S")) {
                                        // Liberar la habitación en el hotel
                                        for (ReservarHotel raux : listaReservas) {
                                            if (raux.getId() == id) {
                                                reserva = raux;
                                            }

                                        }
                                        listaReservas.remove(reserva);
                                        hotel.liberarHabitacion();

                                        // Mostrar mensaje de cancelación exitosa
                                        System.out.println("La reserva ha sido cancelada exitosamente.");
                                        System.out.println("---------------------------------------");
                                        // borrar la reserva de la lista
                                        reserva = null; // Limpiar la reserva actual
                                    } else {
                                        System.out.println("La reserva no ha sido cancelada.");
                                        System.out.println("---------------------------------------");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (opcion != 6);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                        break;
                }
                System.out.println();
            } while (opcion != 4);
        }

    }

    public static void generarTicket(ReservarHotel reserva, Pago pago, Hotel hotel) {
        System.out.println("---------- Ticket de Reserva ----------");
        System.out.println("ID de reserva: " + reserva.getId());
        System.out.println("Cliente: " + reserva.getUsuario().getNombre() + " " + reserva.getUsuario().getApellido());
        System.out.println("Hotel: " + reserva.getHotel().getNombre());
        System.out.println("Habitacion: " + reserva.getTipoHabitacion());
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
        System.out.println("2. Agregar servicio/s");
        System.out.println("3. Realizar reserva");
        System.out.println("4. Realizar pago");
        System.out.println("5. Cancelar reserva");
        System.out.println("6. Salir");
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

    /*
     * public void seleccionarTipoHabitacion(ReservarHotel reserva) {
     * System.out.println("Tipos de habitación disponibles:");
     * for (Habitacion habitacion : reserva.getHotel().getTiposHabitacion()) {
     * System.out.println("- " + habitacion.getTipoHabitacion() + " (Disponibles: "
     * + habitacion.getHabitacionesDisponibles() + ")");
     * }
     * System.out.print("Ingrese el tipo de habitación deseado: ");
     * String tipoSeleccionado = scanner.nextLine();
     * 
     * // Verificar si el tipo de habitación seleccionado está disponible
     * for (Habitacion habitacion : reserva.getHotel().getTiposHabitacion()) {
     * if (habitacion.getTipoHabitacion().equals(tipoSeleccionado)
     * && habitacion.getHabitacionesDisponibles() > 0) {
     * reserva.setTipoHabitacion(tipoSeleccionado);
     * habitacion.setHabitacionesDisponibles(habitacion.getHabitacionesDisponibles()
     * - 1);
     * System.out.println("Habitación seleccionada: " + tipoSeleccionado);
     * return;
     * }
     * }
     * 
     * System.out.
     * println("El tipo de habitación seleccionado no está disponible. Por favor, elija otro tipo."
     * );
     * }
     */

    public static void mostraHotel(Hotel hotelN) {
        System.out.println("---------------------------------------");
        System.out.println("ID: " + hotelN.getId());
        System.out.println("Nombre: " + hotelN.getNombre());
        System.out.println("Pais: " + hotelN.getPais());
        System.out.println("Capacidad: " + hotelN.getCapacidad());
        System.out.print("Tipos de habitacion:");
        for (Habitacion habitacion : hotelN.getTiposHabitacion()) {
            System.out.print(" " + habitacion.getTipoHabitacion());
        }
        System.out.println("\nServicios: " + hotelN.getServicios());
        System.out.println("Calificacion: " + hotelN.getCalificacion() + "/5");
        System.out.println("Disponibilidad: "
                + (hotelN.verificarDisponibilidad() ? "Sí" : "No"));
        System.out.println("Precio: " + hotelN.getPrecio());
        System.out.println("---------------------------------------");
    }

    public static void cuenta(List<Usuario> listaUsuarios, Usuario expUsuario) {
        Scanner scanner = new Scanner(System.in);
        Boolean salir = false;

        do {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.print("Seleccionar opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("1. Cliente");
                    System.out.println("2. Administrador");
                    System.out.println("3. Atras");
                    System.out.print("Seleccionar opcion: ");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoUsuario == 1) {
                        System.out.println("Registro de usuario");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("DNI: ");
                        String dni = scanner.nextLine();
                        System.out.print("Domicilio: ");
                        String domicilio = scanner.nextLine();

                        int cuentaBancaria = 0;
                        String mercadoPago = "";
                        String nombreDeTarjeta = "";

                        // Comprobación de cuenta bancaria o MercadoPago/Tarjeta de Crédito
                        System.out.println("¿Tiene tarjeta de crédito? (s/n)");
                        String tieneTarjeta = scanner.nextLine();
                        if (tieneTarjeta.equalsIgnoreCase("s")) {
                            System.out.print("Número de Tarjeta de Crédito: ");
                            String numeroTarjeta = scanner.nextLine();
                            // Comprobación de que el número de tarjeta tenga entre 12 y 16 dígitos
                            if (numeroTarjeta.length() < 12 || numeroTarjeta.length() > 16) {
                                System.out.println("El número de tarjeta de crédito debe tener entre 12 y 16 dígitos");
                                // scanner.close();
                                break;
                            }
                            System.out.print("Nombre de Tarjeta de Crédito: ");
                            nombreDeTarjeta = scanner.nextLine();
                            // Comprobación de que la tarjeta esté al mismo nombre que el cliente
                            if (!nombreDeTarjeta.equalsIgnoreCase(nombre + " " + apellido)) {
                                System.out.println("La tarjeta de crédito no está a nombre del cliente");
                                // scanner.close();
                                break;
                            }
                        } else if (tieneTarjeta.equalsIgnoreCase("n")) {
                            System.out.println("¿Desea ingresar MercadoPago o cuenta bancaria? (m/c)");
                            String opcionPago = scanner.nextLine();
                            if (opcionPago.equalsIgnoreCase("m")) {
                                System.out.print("MercadoPago: ");
                                mercadoPago = scanner.nextLine();
                            } else if (opcionPago.equalsIgnoreCase("c")) {
                                System.out.print("Cuenta Bancaria: ");
                                cuentaBancaria = scanner.nextInt();
                                scanner.nextLine(); // Consumir el salto de línea pendiente
                            } else {
                                System.out.println("Opción inválida");
                                // scanner.close();
                                break;
                            }
                        } else {
                            System.out.println("Opción inválida");
                            // scanner.close();
                            break;
                        }

                        System.out.print("Premium (true/false): ");
                        boolean premium = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir el salto de línea pendiente
                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        // Comprobación de email válido
                        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                            System.out.println("Email inválido");
                            // scanner.close();
                            break;
                        }
                        boolean emailExistente = listaUsuarios.stream()
                                .anyMatch(usuario -> usuario.getEmail().equals(email));

                        if (emailExistente) {
                            System.out.println(
                                    "El correo electrónico ya está registrado. Por favor, ingrese un correo diferente.");
                            break; // O realiza otra acción adecuada, como mostrar un mensaje de error y solicitar
                                   // nuevamente el correo
                        }

                        // Comprobación de contraseña con al menos 8 caracteres
                        System.out.print("Contraseña: ");
                        String contraseña = scanner.nextLine();
                        if (contraseña.length() < 8) {
                            System.out.println("La contraseña debe tener al menos 8 caracteres");
                            // scanner.close();
                            break;
                        }

                        System.out.print("Usuario: ");
                        String usuario = scanner.nextLine();

                        // Crear nuevo usuario con los datos ingresados
                        Usuario nuevoUsuario = new Usuario(nombre, apellido, dni, domicilio,
                                nombreDeTarjeta, email, contraseña, cuentaBancaria,
                                usuario, mercadoPago, premium, false);

                        // Agregar nuevo usuario a la lista de usuarios
                        listaUsuarios.add(nuevoUsuario);

                        System.out.println("Registro exitoso");
                    } else if (tipoUsuario == 2) {
                        System.out.println("Registro de administrador");
                        System.out.print("Nombre: ");
                        String nombreAdmin = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoAdmin = scanner.nextLine();
                        System.out.print("DNI: ");
                        String dniAdmin = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailAdmin = scanner.nextLine();

                        // Comprobación de email válido
                        if (!emailAdmin.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                            System.out.println("Email inválido");
                            // scanner.close();
                            break;
                        }
                        boolean emailExistente = listaUsuarios.stream()
                                .anyMatch(usuario -> usuario.getEmail().equals(emailAdmin));

                        if (emailExistente) {
                            System.out.println(
                                    "El correo electrónico ya está registrado. Por favor, ingrese un correo diferente.");
                            break; // O realiza otra acción adecuada, como mostrar un mensaje de error y solicitar
                                   // nuevamente el correo
                        }
                        System.out.print("Usuario: ");
                        String usuarioAdmin = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        String contraseñaAdmin = scanner.nextLine();
                        if (contraseñaAdmin.length() < 8) {
                            System.out.println("La contraseña debe tener al menos 8 caracteres");
                            // scanner.close();
                            break;
                        }

                        // Crear objeto de administrador
                        Usuario administrador = new Usuario(nombreAdmin, apellidoAdmin, dniAdmin,
                                emailAdmin, usuarioAdmin, contraseñaAdmin,
                                true);
                        listaUsuarios.add(administrador);
                        expUsuario=administrador;
                        break;
                    } else
                        break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Iniciar sesión");
                    System.out.print("Email: ");
                    String emailInicio = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseñaInicio = scanner.nextLine();

                    // Comprobar si el usuario existe
                    Usuario usuarioIniciado = null;
                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getEmail().equals(emailInicio)) {
                            usuarioIniciado = usuario;
                            break;
                        }
                    }

                    if (usuarioIniciado != null) {
                        // Comprobar contraseña
                        if (usuarioIniciado.getContraseña().equals(contraseñaInicio)) {
                            // Inicio de sesión exitoso
                            System.out.println(
                                    "Inicio de sesión exitoso. ¡Bienvenido/a, " + usuarioIniciado.getNombre() + "!");

                            // Comprobar si el usuario está bloqueado
                            if (usuarioIniciado.isBloqueado()) {
                                System.out.println(
                                        "Tu cuenta está bloqueada. Ingresa el código enviado a tu email para desbloquearla.");

                                // Generar y enviar código por email
                                String codigoDesbloqueo = generarCodigoDesbloqueo();
                                System.out.println("Se ha enviado el codigo por email (" + codigoDesbloqueo + ")");

                                // Solicitar ingreso de código de desbloqueo
                                System.out.print("Ingresa el código de desbloqueo: ");
                                String codigoIngresado = scanner.nextLine();

                                // Comprobar código de desbloqueo
                                if (codigoIngresado.equals(codigoDesbloqueo)) {
                                    // Desbloquear cuenta
                                    usuarioIniciado.setBloqueado(false);
                                    System.out.println("¡Tu cuenta ha sido desbloqueada exitosamente!");
                                } else {
                                    // Código incorrecto, bloquear cuenta
                                    usuarioIniciado.setBloqueado(true);
                                    System.out.println(
                                            "Código incorrecto. Tu cuenta ha sido bloqueada por motivos de seguridad, se ha enviado la contraseña a la direccion mail registrada.");
                                }
                            } else {
                                expUsuario = usuarioIniciado;
                                salir = true;
                            }
                        } else {
                            // Contraseña incorrecta, bloquear email
                            usuarioIniciado.setBloqueado(true);
                            System.out
                                    .println(
                                            "Contraseña incorrecta. Tu email ha sido bloqueado por motivos de seguridad, se ha enviado la contrase\u00F1a a la direccion mail registrada.");
                        }
                    } else {
                        // Usuario no encontrado
                        System.out.println("No se encontró ningún usuario con el email ingresado.");
                    }
                    break;
                default:
                    break;
            }
        } while (!salir);
    }

    public static String generarCodigoDesbloqueo() {
        Random random = new Random();
        int codigo = random.nextInt(900000) + 100000; // Genera un número aleatorio de 100000 a 999999
        return String.valueOf(codigo);
    }

    public static void menuAdmin() {
        System.out.println("1. Agregar Hotel");
        System.out.println("2. Agregar habitacion");
        System.out.println("3. Eliminar Hotel");
        System.out.println("4. Eliminar habitacion");
        System.out.print("Seleccione una opcion: ");
    }
}
