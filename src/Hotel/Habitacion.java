package Hotel;

public class Habitacion {
    private String tipoHabitacion;
    private int habitacionesDisponibles;

    public Habitacion(int habitacionesDisponibles, String tipoHabitacion) {
        this.habitacionesDisponibles = habitacionesDisponibles;
        if (tipoHabitacion.equalsIgnoreCase("sencilla")) {
            this.tipoHabitacion = "Sencilla";
        }else if (tipoHabitacion.equalsIgnoreCase("suite")){
            this.tipoHabitacion="Suite";
        }else if (tipoHabitacion.equalsIgnoreCase("doble")){
            this.tipoHabitacion="Doble";
        }
    }
    public int getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(int habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
}