package com.mycompany.tphotel;

import java.util.Scanner;

public class Paquete {
    private String nombrePaquete;
    private double precio;

    public Paquete(String nombrePaquete, double precio) {
        this.nombrePaquete = nombrePaquete;
        this.precio = precio;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Paquete{" + "nombrePaquete=" + nombrePaquete + ", precio=" + precio + '}';
    }
    
    public void obtenerPaquete(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese el Paquete elegido: ");
        nombrePaquete = entrada.nextLine();
    }
    
    public void obtenerPrecio(){
        
    }
}
