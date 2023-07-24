/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EP_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class ServicioPelicula {
    // ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    List<Pelicula> peliculas = Arrays.asList(
            new Pelicula("Pinocho", "Guillermo del Toro", 3),
            new Pelicula("Titanic", "James Cameron", 2),
            new Pelicula("Batman Begins", "Nolan", 4),
            new Pelicula("Jurassic Park", "Spielberg", 5),
            new Pelicula("Barbie", "Greta", 1)
    );
    
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    private Pelicula crearPelicula() {
        Pelicula pelicula = new Pelicula();
        
        System.out.println("Ingresa el titulo de la pélicula");
        do {
            pelicula.setTitulo(scan.nextLine());
            
            if (pelicula.getTitulo().equals("")) {
                System.out.println("No se ingresó un título, vuelve a intentarlo");
            }
        } while (pelicula.getTitulo().equals(""));
        
        System.out.println("Ingresa el director de " + pelicula.getTitulo());
        do {
            pelicula.setDirector(scan.nextLine());
            
            if (pelicula.getDirector().equals("")) {
                System.out.println("No se ingresó un director, vuelve a intentarlo");
            }
        } while (pelicula.getDirector().equals(""));
        
        System.out.println("Ingresa la duración en horas de la pélicula");
        boolean duracionValida;
        
        do {
            if (scan.hasNextInt()) {
                pelicula.setDuracion(scan.nextInt());
                duracionValida = true;
            } else {
                System.out.println("No se ingresó una duración valida en horas, vuelve a intentarlo");
                duracionValida = false;
                scan.next();
            }
            
        } while (!duracionValida);
        
        return pelicula;
    }
    
    public void crearPeliculas() {
        String guardarOtraPelicula = "";
        boolean ingresarOtraPelicula = false;

        do {
            peliculas.add(crearPelicula());

            scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otra pélicula? (si / no)");
                guardarOtraPelicula = scan.nextLine();

                switch (guardarOtraPelicula.toLowerCase()) {
                    case "si":
                        ingresarOtraPelicula = true;
                        break;
                    case "no":
                        ingresarOtraPelicula = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtraPelicula.equals("si")
                    && !guardarOtraPelicula.equals("no"));

        } while (ingresarOtraPelicula);
    }
    
    private void mostrarPelicula(Pelicula pelicula) {
        System.out.println("");
        System.out.println("Título: " +  pelicula.getTitulo());
        System.out.println("Director: " +  pelicula.getDirector());
        System.out.println("Duración: " +  pelicula.getDuracion() + " horas");
    }
    
    public void mostrarPeliculas() {
        for (Pelicula pelicula : peliculas) {
            mostrarPelicula(pelicula);
        }
    }
    
    public void mostrarMayorAUnaHora() {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion() > 1) {
                mostrarPelicula(pelicula);
            }
        }
    }
    
    public void ordenarMayorAMenorDuracion() {
        peliculas.sort(Comparator.comparing(Pelicula::getDuracion));
        
        mostrarPeliculas();
    }
    
    public void ordenarMenorAMayorDuracion() {
        peliculas.sort(Comparator.comparing(Pelicula::getDuracion).reversed());
        
        mostrarPeliculas();
    }
    
    public void ordenarPorTitulo() {
        peliculas.sort(Comparator.comparing(Pelicula::getTitulo));
        
        mostrarPeliculas();
    }
    
    public void ordenarPorDirector() {
        peliculas.sort(Comparator.comparing(Pelicula::getDirector));
        
        mostrarPeliculas();
    }
    
    
    
}
