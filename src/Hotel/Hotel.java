package Hotel;

public class Hotel {
    	int calificacion;
	String categoria;
	int empleadoComercial;
	String nombreHotel;
	String pais;
	String productos;
	String servicios;
	String verCapacidad; //Capacidad, creo que deberia ser un valor entero, por el hecho de que si alguien
						 //reserva una habitacion, esta baje su capacidad. Tambien ponerle solamente "capacidad"
	
	public Hotel(int cal, String cat, int empC, String nomH, String pais, String prod, String serv, String capacidad) {
		this.calificacion=cal;
		this.categoria=cat;
		this.empleadoComercial=empC;
		this.nombreHotel=nomH;
		this.pais=pais;
		this.productos=prod;
		this.servicios=serv;
		this.verCapacidad=capacidad;
	}
	public int obtenerCalificacion() {
		return this.calificacion;
	}
	public String obtenerCapacidad() {
		return this.verCapacidad;
	}
	public String obtenerCategoria() {
		return this.categoria;
	}
	public int obtenerEmpleadoComercial() {
		return this.empleadoComercial;
	}
	public String obtenerNombre() {
		return this.nombreHotel;
	}
	public String obtenerServicios() {
		return this.servicios;
	}
	public String obtenerProductos() {
		return this.productos;
	}
}
