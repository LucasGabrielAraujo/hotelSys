package Hotel;

public class Pago {
	private ReservarHotel reserva;
    private double monto;
    private String metodoPago;

    public Pago(ReservarHotel reserva, double monto, String metodoPago) {
        this.reserva = reserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public boolean realizarPago() {
        if (monto > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Getters y setters para los atributos adicionales

    public ReservarHotel getReserva() {
        return reserva;
    }

    public void setReserva(ReservarHotel reserva) {
        this.reserva = reserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

}
