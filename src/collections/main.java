/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author javie
 */
public class main {
    static List<Integer> valores = new ArrayList<Integer>();
    // static List<Integer> valores = new ArrayList<Integer>(Arrays.asList( 1, 2, 3, 4, 5));
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        leerValores();
        
    }
    
    public static void leerValores() {
        int valor;
        
        do {
            System.out.println("Ingresa el "  + (valores.size() + 1) + "° valor");
            valor = scan.nextInt();
            
            if (valor != -99) {
                valores.add(valor);
            } else {
                System.out.println("Se ingreso el valor -99");
            }
            
        } while (valor != -99);
        
        valoresLeidos();
        
        sumaValores();
        
        mediaValores();
    }
    
    public static void valoresLeidos() {
        System.out.println("");
        System.out.println("La cantidad de valores leidos fue de " + valores.size());
        System.out.println(valores.toString());
    }
    
    public static void sumaValores() {
        System.out.println("");
        System.out.println("La suma de los valores es: ");
        System.out.println(valores.stream().reduce(0, Integer::sum));   
    }
    
    public static void mediaValores() {
        System.out.println("");
        System.out.println("La media de los valores es: ");
        System.out.println(valores.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        
    }
}
