/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marco
 */
public class LibroRepository implements Repository<Libro>{
    private List<Libro> libros = new ArrayList<>();
    private String filePath;

    public LibroRepository(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void add(Libro entity)
    {
        if(entity == null)
        {
            throw new IllegalArgumentException("Se pasó un libro vacio");
        }
        else
        {
            this.libros.add(entity);
            System.out.println("Se agrego el libro id: " + entity.getId());
        }
    }
    
    @Override
    public Optional<Libro> findById(int id)
    {
        return this.libros.stream().filter(libro -> libro.getId() == id).findFirst();
    }
    
    @Override
    public List<Libro> findByAuthor(String autor)
    {
        List<Libro> librosDelAutor = new ArrayList<>();
        
        for(Libro libro : this.libros)
        {
            if(libro.getAutor().equals(autor))
            {
                librosDelAutor.add(libro);
            }
        }
        return librosDelAutor;
    }
    
    @Override
    public List<Libro> findAll()
    {
        return this.libros;
    }
    
    public void saveAll()
    {
        try(ObjectOutputStream cos = new ObjectOutputStream(new FileOutputStream(this.filePath)))
        {
            cos.writeObject(this.libros);
            System.out.println("Datos serializados en el archivo: " + this.filePath);
        }
        catch(IOException e)
        {
            System.err.println("Error en la serializacion: " + e.getMessage());
        }
    }
    
    public List<Libro> loadAll()
    {
        List<Libro> librosGuardados = null;
        
        try (ObjectInputStream cis = new ObjectInputStream(new FileInputStream(this.filePath))) 
        {
            librosGuardados = (List<Libro>) cis.readObject();
            System.out.println("Datos cargados desde el archivo: " + this.filePath);
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
        
        return librosGuardados;
    }
}
