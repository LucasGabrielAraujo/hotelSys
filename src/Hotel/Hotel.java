package Hotel;

import java.util.List;

public class Hotel {
    private int id;
    private int calificacion;
    private List<Habitacion> tiposHabitacion;
    private double precio;
    private String nombreHotel;
    private String pais;
    private String productos;
    private int capacidad;
    private List<String> servicios;

    public Hotel(String nombre, int calificacion, double precio,
            String pais, String productos) {
        this.nombreHotel = nombre;
        this.calificacion = calificacion;
        this.precio = precio;
        this.pais = pais;
        this.productos = productos;
    }

    public void addServicios(String servicio) {
        this.servicios.add(servicio);
    }

    public void removeServicios(String servicio) {
        servicios.remove(servicio);
    }

    public boolean verificarDisponibilidad() {
        return capacidad > 0;
    }

    public List<Habitacion> getTiposHabitacion() {
        return tiposHabitacion;
    }

    public void setTiposHabitacion(Habitacion habitacion) {
        this.tiposHabitacion.add(habitacion);
    }

    public void definirCantHabitacion() {
        capacidad = 0;
        for (Habitacion habita : tiposHabitacion) {
            capacidad += habita.getHabitacionesDisponibles();
        }
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombreHotel;
    }

    public void setNombre(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
