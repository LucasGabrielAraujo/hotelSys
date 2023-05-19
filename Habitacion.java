package com.mycompany.tphotel;

public class Habitacion {
    private boolean disponible = true;
    private int[] habitacionesDisponibles;
    private String tipoHabitacion;

    public Habitacion(int[] habitacionesDisponibles, String tipoHabitacion) {
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int[] getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(int[] habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "disponible=" + disponible + ", habitacionesDisponibles=" + habitacionesDisponibles + ", tipoHabitacion=" + tipoHabitacion + '}';
    }
    
    public void obtenerHabitacionesDisponibles(){
        
    }
    

}