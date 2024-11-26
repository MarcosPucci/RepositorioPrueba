/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author marco
 */
public interface Repository<T> {
    
    public void add(T entity);
    
    public Optional<T> findById(int id);
    
    public List<T> findAll();
    
    public List<T> findByAuthor(String autor);
}
