package com.healthtrack;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void actualizarPeso(double nuevoPeso) {
    if (nuevoPeso <= 0) {
        throw new IllegalArgumentException("El peso debe ser mayor que cero.");
    }    
    this.peso = nuevoPeso;
    // Error corregido: antes restaba -1kg al nuevo peso
    }

    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }
}