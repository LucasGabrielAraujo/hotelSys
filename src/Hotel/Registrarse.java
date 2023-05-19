package Hotel;

public class Registrarse {
	String nombre;
	String apellido;
	String dni;
	String domicilio;
	String nombreDeTarjetaDeCredito;
	String email;
	String contraseña;
	int cuentaBancaria;
	String usuario;
	String mercadoPago;
	
	//Constructor
	public Registrarse(String nombre, String apellido, String dni, String domicilio, String nombreDeTarjetaDeCredito,
			String email, String contraseña, int cuentaBancaria, String usuario, String mercadoPago) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombreDeTarjetaDeCredito = nombreDeTarjetaDeCredito;
		this.email = email;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.usuario = usuario;
		this.mercadoPago = mercadoPago;
	}
      //Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombreDeTarjetaDeCredito() {
		return nombreDeTarjetaDeCredito;
	}

	public void setNombreDeTarjetaDeCredito(String nombreDeTarjetaDeCredito) {
		this.nombreDeTarjetaDeCredito = nombreDeTarjetaDeCredito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(int cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public String getUsusario() {
		return usuario;
	}

	public void setUsusario(String ususario) {
		this.usuario = ususario;
	}

	public String getMercadoPago() {
		return mercadoPago;
	}

	public void setMercadoPago(String mercadoPago) {
		this.mercadoPago = mercadoPago;
	}
		
	
	
	
	

}