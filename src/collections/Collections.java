/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Collections {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");
    static ArrayList<String> razas = new ArrayList<String>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        guardarRaza();
        
        mostrarPerros();
    
    }
    
    public static void guardarRaza() {
        boolean esValido = true;
        String raza = "";
        String guardarOtro = "";
        
        
        do {
            System.out.println("Ingresa una raza de perro");
            raza = scan.nextLine();
            
            if (!raza.equals("")) {
                razas.add(raza);
                
                do {
                    System.out.println("¿Quieres guardar otro perro? (si / no)");
                    guardarOtro = scan.nextLine();
                    
                    switch (guardarOtro.toLowerCase()) {
                        case "si":
                            esValido = false;
                            break;
                        case "no":
                            esValido = true;
                            break;
                        default:
                            System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                            break;
                    }
                } while (!guardarOtro.equals("si") &&
                         !guardarOtro.equals("no"));
            } else {
                System.out.println("No se ingresó ninguna raza, vuelve a intentarlo");
                esValido = false;
            }
                        
        } while (!esValido);
    }
    
    public static void mostrarPerros() {
        System.out.println("");
        System.out.println("Listado de Perros");
        for(String raza : Collections.razas) {
            System.out.println(raza);
        }
    }
    
}
