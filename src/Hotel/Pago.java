package Hotel;

public class Pago {
    private ReservarHotel reserva;
    private double monto;
    private String metodoPago;

    public Pago(ReservarHotel reserva, double monto, String metodoPago) {
        this.reserva = reserva;
        this.monto = monto;
        if (metodoPago.equalsIgnoreCase("mercado pago")) {
            this.metodoPago = "Mercado Pago";
        } else {
            this.metodoPago = "Transferencia Bancaria";
        }
    }

    public boolean realizarPago(Hotel hotel) {
        if (monto >= hotel.getPrecio()) {
            return true;
        } else {
            return false;
        }
    }

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
        if (metodoPago.equalsIgnoreCase("m")) {
            this.metodoPago = "Mercado Pago";
        } else {
            this.metodoPago = "Transferencia Bancaria";
        }
    }
}
