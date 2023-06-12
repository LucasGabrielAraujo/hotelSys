package Hotel;

import java.util.Date;

public class ReservarHotel {
    private Cliente cliente;
    private Hotel hotel;
    private Date fechaInicio;
    private Date fechaFin;

    public ReservarHotel(Cliente cliente, Hotel hotel, Date fechaInicio, Date fechaFin) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean hacerReserva() {
        if (hotel.reservarHabitacion()) {
            return true;
        } else {
            return false;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
