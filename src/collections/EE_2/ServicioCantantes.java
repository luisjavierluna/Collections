/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EE_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class ServicioCantantes {
    List<CantanteFamoso> cantantes = new ArrayList<CantanteFamoso>(Arrays.asList(
            new CantanteFamoso("Luis Miguel", "México"),
            new CantanteFamoso("Mon Laferte", "Chile"),
            new CantanteFamoso("Bizarrap", "Argentina"),
            new CantanteFamoso("Maluma", "Colombia"),
            new CantanteFamoso("Daddy Yankee", "Puerto Rico")
    ));
    
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    public void mostrarCantantes() {
        for (CantanteFamoso cantante : cantantes) {
            System.out.println(cantante.toString());
        }
    }
    
    private CantanteFamoso agregarCantante() {
        CantanteFamoso cantante = new CantanteFamoso();
        
        System.out.println("Ingresa el nombre del cantante");
        do {
            cantante.setNombre(scan.nextLine());
            
            if (cantante.getNombre().equals("")) {
                System.out.println("No se ingresó un nombre, vuelve a intentarlo");
            }
        } while (cantante.getNombre().equals(""));
        
        System.out.println("Ingresa el disco más vendido de " + cantante.getNombre());
        do {
            cantante.setDiscoConMasVentas(scan.nextLine());
            
            if (cantante.getDiscoConMasVentas().equals("")) {
                System.out.println("No se ingresó un disco, vuelve a intentarlo");
            }
        } while (cantante.getDiscoConMasVentas().equals(""));
        
        return cantante;
    }
    
    public void agregarCantantes() {
        String guardarOtroCantante = "";
        boolean ingresarOtroCantante = false;

        do {
            cantantes.add(agregarCantante());

            // scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro cantante? (si / no)");
                guardarOtroCantante = scan.nextLine();

                switch (guardarOtroCantante.toLowerCase()) {
                    case "si":
                        ingresarOtroCantante = true;
                        break;
                    case "no":
                        ingresarOtroCantante = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtroCantante.equals("si")
                    && !guardarOtroCantante.equals("no"));

        } while (ingresarOtroCantante);
    }
    
    public void removerCantante() {
        System.out.println("Ingresa el nombre del cantante que quieres remover");
        String cantanteRemover = scan.nextLine();
        boolean existeCantante = false;
        
        for (CantanteFamoso cantante : cantantes) {
            if (cantante.getNombre().equals(cantanteRemover)) {
                existeCantante = true;
                cantantes.remove(cantante);
                break;
            }   
        }
        
        if (!existeCantante) {
            System.out.println("No se encontró el producto: " + cantanteRemover);  
        } 

        mostrarCantantes();
    }
    
    public void menu() {
        String eleccion;
        
        do {
            System.out.println(
                    "¿Qué acción deseas realizar? (Elige una opción entre A y D)" + "\n"
                    + "A. Agregar un cantante más" + "\n"
                    + "B. Mostrar todos los cantantes" + "\n"
                    + "C. Eliminar un cantante" + "\n"
                    + "D. Salir del programa" + "\n");

            eleccion = scan.nextLine();
            eleccion = eleccion.toUpperCase();

            switch (eleccion) {
                case "A":
                    agregarCantantes();
                    break;
                case "B":
                    mostrarCantantes();
                    break;
                case "C":
                    removerCantante();
                    break;
                case "D":
                    System.out.println("Elegiste salir del programa");
                    System.out.println("");
                    break;
                default:
                    System.out.println("No se ingreso una letra entre A y D, vuelve a intentarlo");
                    System.out.println("");
            }
        } while (!eleccion.equals("D"));

        mostrarCantantes();
    }
}
