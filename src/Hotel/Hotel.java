package Hotel;

public class Hotel {
    int calificacion;
	int habitacionesDisponibles;
	int precio;
	String nombreHotel;
	String pais;
	String productos;
	String servicios;
	int capacidad; 
	
	public Hotel(String nombre, int habitacionesDisponibles, int calificacion, int precio,
                 String nombreHotel, String pais, String productos, String servicios, int capacidad) {
        this.nombreHotel = nombre;
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.calificacion = calificacion;
        this.precio = precio;
        this.nombreHotel = nombreHotel;
        this.pais = pais;
        this.productos = productos;
        this.servicios = servicios;
        this.capacidad = capacidad;
	}

	public boolean verificarDisponibilidad() {
        return habitacionesDisponibles > 0;
    }

    public boolean reservarHabitacion() {
        if (verificarDisponibilidad()) {
            habitacionesDisponibles--;
            return true;
        } else {
            return false;
        }
    }
	public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
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

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
