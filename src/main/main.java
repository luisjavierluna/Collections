/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class main {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");
    static ArrayList<String> razas = new ArrayList<String>();
    static Iterator<String> it;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        guardarRaza();
        
        mostrarPerros();
 
        removerPerro();
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
        Collections.sort(razas);
        System.out.println("");
        System.out.println("Listado de Perros");
        for(String raza : razas) {
            System.out.println(raza);
        }
    }
    
    public static void removerPerro() {
        System.out.println("");
        String perroBuscar = "";
        do {
            System.out.println("Ingresa la raza de perro a borrar");
            perroBuscar = scan.nextLine();
        } while (perroBuscar.equals(""));
        
        it = razas.iterator();
        
        String aux = "";
        boolean encontrado = false;
        while(it.hasNext()) {
            aux = it.next();
            
            if (aux.equals(perroBuscar)) {
                System.out.println("Se removió la raza " + aux);
                it.remove();
                encontrado = true;
            } 
        }
        
        if (!encontrado) {
            System.out.println("No se encontró la raza: " + perroBuscar);
        }
        
        mostrarPerros();
    }
    
}
