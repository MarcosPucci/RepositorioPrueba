/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Libro implements Serializable{
    protected int id;
    protected static int contadorDeInstancias = 0;
    protected String titulo;
    protected String autor;

    public Libro(String titulo, String autor) {
        this.setAutor(autor);
        this.setTitulo(titulo);
        Libro.contadorDeInstancias += 1;
        this.id = Libro.contadorDeInstancias;
    }

    public void setTitulo(String titulo) {
        if(titulo.length() > 2)
        {
            this.titulo = titulo;
        }
        else
        {
            throw new IllegalArgumentException("El titulo debe ser mayor a 3 caracteres");
        }
    }

    public void setAutor(String autor) {
        if(autor.length() > 2)
        {
            this.autor = autor;
        }
        else
        {
            throw new IllegalArgumentException("El autor debe tener mas de 3 caracteres");
        }
    }
    
    public int getId() {
        return this.id;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + '}';
    }
}
