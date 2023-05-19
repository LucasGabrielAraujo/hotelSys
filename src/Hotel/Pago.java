package Hotel;

public class Pago {
	int numeroDeTarjeta;
	int tipoPago;
	
	public Pago(int numeroDeTarjeta, int tipoPago){
		this.numeroDeTarjeta=numeroDeTarjeta;
		this.tipoPago=tipoPago;
	}
	public int obtenerNumero(){
		return this.numeroDeTarjeta;
	}
	public int obtenerTipoPago(){
		return this.tipoPago;
	}
}
