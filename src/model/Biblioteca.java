/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author marco
 */
public class Biblioteca {
    private String nombre;
    private GestorBiblioteca gestor;

    public Biblioteca(String nombre, GestorBiblioteca gestor) {
        this.setNombre(nombre);
        this.gestor = gestor;
    }

    public void setNombre(String nombre) {
        if(nombre.length() > 2)
        {
            this.nombre = nombre;
        }
        else
        {
            throw new IllegalArgumentException("El nombre debe tener mas de 3 caracteres");
        }
    }

    public GestorBiblioteca getGestor() {
        return this.gestor;
    }
}
