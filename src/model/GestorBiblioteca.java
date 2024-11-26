/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marco
 */
public class GestorBiblioteca {
    private final Repository<Libro> libroRepository;

    public GestorBiblioteca(Repository<Libro> libroRepository) {
        this.libroRepository = libroRepository;
    }
    
    public void agregarLibro(String titulo, String autor)
    {
        try
        {
            Libro libro = new Libro(titulo, autor);
            this.libroRepository.add(libro);
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el libro: " + e.getMessage());
        }
    }
    
    public Optional<Libro> buscarLibroPorId(int id)
    {
        return this.libroRepository.findById(id);
    }
    
    public List<Libro> buscarLibrosPorAutor(String autor)
    {
        return this.libroRepository.findByAuthor(autor);
    }
    
    public List<Libro> listarLibros()
    {
        return this.libroRepository.findAll();
    }

    public Repository<Libro> getLibroRepository() {
        return this.libroRepository;
    }
}
