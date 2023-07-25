/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EP_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author javie
 */
public class ServicioPais {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    Iterator<Pais> it;

    // Set<Pais> paises = new HashSet<Pais>();
     Set<Pais> paises = new TreeSet<>(Arrays.asList(
        new Pais("Uruguay"),
        new Pais("Argentina"),
        new Pais("Venezuela"),
        new Pais("Paraguay"),
        new Pais("Chile"),
        new Pais("Perú")
     ));
     
    private void mostrarPais(Pais pais) {
        System.out.println("País: " + pais.getNombre());
    }
    
    public void mostrarPaises() {
        System.out.println("");
        for (Pais pais : paises) {
            mostrarPais(pais);
        }
    }
    
    private Pais crearPais() {
        Pais pais = new Pais();
        
        System.out.println("Ingresa el nombre del país");
        do {
            pais.setNombre(scan.nextLine());
            
            if (pais.getNombre().equals("")) {
                System.out.println("No se ingresó un nombre válido, vuelve a intentarlo");
            }
        } while (pais.getNombre().equals(""));
        
        return pais;
    }
    
    public void crearPaises() {
        String guardarOtroPais = "";
        boolean ingresarOtroPais = false;

        do {
            paises.add(crearPais());

            // scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro país? (si / no)");
                guardarOtroPais = scan.nextLine();

                switch (guardarOtroPais.toLowerCase()) {
                    case "si":
                        ingresarOtroPais = true;
                        break;
                    case "no":
                        ingresarOtroPais = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtroPais.equals("si")
                    && !guardarOtroPais.equals("no"));

        } while (ingresarOtroPais);
        
        mostrarPaises();
    }
    
    public void removerPais() {
        System.out.println("Ingresa el nombre del país que quieres remover");
        String paisRemover = scan.nextLine();
        
        it = paises.iterator();
        
        Pais aux;
        boolean encontrado = false;
        while(it.hasNext()) {
            aux = it.next();

            if (aux.getNombre().equals(paisRemover)) {
                System.out.println("Se removió el país" + aux);
                it.remove();
                encontrado = true;
            } 
        }

        if (!encontrado) {
            System.out.println("No se encontró el país: " + paisRemover);
        }
        
        mostrarPaises();
    }
    
     
}
