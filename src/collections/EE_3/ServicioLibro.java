/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EE_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author javie
 */
public class ServicioLibro {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    Set<Libro> libros = new TreeSet<>(Arrays.asList(
            new Libro("Cien Años de Soledad", "Gabriel García Márquez", 3, 1),
            new Libro("Orgullo y prejuicio", "Jane Austen", 3, 1),
            new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 3, 1),
            new Libro("El extranjero", "Albert Camus", 0, 1),
            new Libro("Moby-Dick", "Herman Melville", 3, 0)
    ));
    
    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
    
    private Libro crearLibro() {
        Libro libro = new Libro();
        
        System.out.println("Ingresa el Título del Libro");
        do {
            libro.setTitulo(scan.nextLine());
            
            if (libro.getTitulo().equals("")) {
                System.out.println("No se ingresó un título válido, vuelve a intentarlo");
            }
        } while (libro.getTitulo().equals(""));
        
        System.out.println("Ingresa el Autor del Libro");
        do {
            libro.setAutor(scan.nextLine());
            
            if (libro.getAutor().equals("")) {
                System.out.println("No se ingresó un Autor válido, vuelve a intentarlo");
            }
        } while (libro.getAutor().equals(""));
        
        
        System.out.println("Ingresa La cantidad de ejemplares");
        boolean cantidadValida;
        
        do {
            if (scan.hasNextInt()) {
                libro.setNumeroEjemplares(scan.nextInt());
                cantidadValida = true;
            } else {
                System.out.println("No se ingresó una cantidad de ejemplares válida, vuelve a intentarlo");
                cantidadValida = false;
                scan.next();
            }
            
        } while (!cantidadValida);
        
        libro.setNumeroEjemplaresPrestados(0);
        
        return libro;
    }
    
    public void crearLibros() {
        String guardarOtroLibro = "";
        boolean ingresarOtroLibro = false;

        do {
            libros.add(crearLibro());

            scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro Libro? (si / no)");
                guardarOtroLibro = scan.nextLine();

                switch (guardarOtroLibro.toLowerCase()) {
                    case "si":
                        ingresarOtroLibro = true;
                        break;
                    case "no":
                        ingresarOtroLibro = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtroLibro.equals("si")
                    && !guardarOtroLibro.equals("no"));

        } while (ingresarOtroLibro);
        
        mostrarLibros();
    }
    
    public boolean prestamo() {
        System.out.println("Ingresa el título del libro que quieres pedir prestado");
        String libroPrestar = scan.nextLine();
        boolean existeLibro = false;
        boolean sePuedePrestar = false;
        
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(libroPrestar)) {
                existeLibro = true;
                
                if (libro.getNumeroEjemplares() > 0) {
                    sePuedePrestar = true;
                    libro.setNumeroEjemplares(libro.getNumeroEjemplares() - 1);
                    libro.setNumeroEjemplaresPrestados(libro.getNumeroEjemplaresPrestados() + 1);
                } else {
                    sePuedePrestar = false;
                    System.out.println("");
                    System.out.println("El libro " + libro.getTitulo() + " no tiene ejemplares disponibles para prestar");
                    System.out.println("");
                }
                
                break;
            }   
        }
        
        if (!existeLibro) {
            System.out.println("No se encontró el Libro: " + libroPrestar);  
        } 

        mostrarLibros();
        
        return sePuedePrestar;
    }
    
    public boolean devolucion() {
        System.out.println("Ingresa el título del libro que quieres devolver");
        String libroDevolver = scan.nextLine();
        boolean existeLibro = false;
        boolean sePuedeDevolver = false;
        
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(libroDevolver)) {
                existeLibro = true;
                
                if (libro.getNumeroEjemplaresPrestados() > 0) {
                    sePuedeDevolver = true;
                    libro.setNumeroEjemplaresPrestados(libro.getNumeroEjemplaresPrestados()- 1);
                    libro.setNumeroEjemplares(libro.getNumeroEjemplares() + 1);
                } else {
                    sePuedeDevolver = false;
                    System.out.println("");
                    System.out.println("El libro " + libro.getTitulo() + " no tiene prestamos pendientes de devolver");
                    System.out.println("");
                }
                
                break;
            }   
        }
        
        if (!existeLibro) {
            System.out.println("No se encontró el Libro: " + libroDevolver);  
        } 

        mostrarLibros();
        
        return sePuedeDevolver;
    }
    
}
