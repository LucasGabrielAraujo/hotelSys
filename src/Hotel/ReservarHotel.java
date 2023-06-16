package Hotel;

import java.util.Date;
import java.util.List;

public class ReservarHotel {
    private int id;
    private Usuario usuario;
    private Hotel hotel;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoHabitacion;

    public ReservarHotel(Usuario usuario, Hotel hotel, Date fechaInicio, Date fechaFin, String tipoHabitacion) {
        this.usuario = usuario;
        this.hotel = hotel;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoHabitacion=tipoHabitacion;
    }

    public boolean hacerReserva() {
        if (hotel.reservarHabitacion()) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setTipoHabitacion(String tipoHabitacion){
        this.tipoHabitacion=tipoHabitacion;
    }

}
