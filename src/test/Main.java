package test;
import model.Biblioteca;
import model.GestorBiblioteca;
import model.Libro;
import model.LibroRepository;

public class Main {

    public static void main(String[] args) {
        
        LibroRepository libroRepos = new LibroRepository("archivos.dat");
        GestorBiblioteca gestorBiblioteca = new GestorBiblioteca(libroRepos);
        Biblioteca biblioteca = new Biblioteca("Biblioteca", gestorBiblioteca);
        
        biblioteca.getGestor().agregarLibro("Accion", "Marcos");
        biblioteca.getGestor().agregarLibro("Aventura", "Leonel");
        biblioteca.getGestor().agregarLibro("Comedia", "Pucci");
        biblioteca.getGestor().agregarLibro("Romantico", "Maximum");
        biblioteca.getGestor().agregarLibro("Ex", "Marcos");
        
        System.out.println(biblioteca.getGestor().buscarLibroPorId(1));
        
        System.out.println(biblioteca.getGestor().buscarLibrosPorAutor("Marcos"));
        
        System.out.println(biblioteca.getGestor().listarLibros());
        
        //libroRepos.saveAll();
        //System.out.println(libroRepos.loadAll());
        //biblioteca.getGestor().getLibroRepository().saveAll();
        GestorBiblioteca ges = biblioteca.getGestor();
        LibroRepository librosrepo = (LibroRepository) ges.getLibroRepository();
        librosrepo.saveAll();
        System.out.println(librosrepo.loadAll());
    }
    
}
