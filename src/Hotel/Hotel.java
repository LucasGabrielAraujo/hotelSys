package Hotel;

public class Hotel {
    private int id;
    private int calificacion;
	private int habitacionesDisponibles;
	private double precio;
	private String nombreHotel;
	private String pais;
	private String productos;
	private String servicios;
	private int capacidad; 
	
	public Hotel(String nombre, int habitacionesDisponibles, int calificacion, double precio,
                  String pais, String productos, String servicios, int capacidad) {
        this.nombreHotel = nombre;
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.calificacion = calificacion;
        this.precio = precio;
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
            this.habitacionesDisponibles--;
            return true;
        } else {
            return false;
        }
    }
    public void liberarHabitacion(){
        this.habitacionesDisponibles++;
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
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
