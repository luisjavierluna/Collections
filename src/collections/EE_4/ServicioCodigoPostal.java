/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EE_4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author javie
 */
public class ServicioCodigoPostal {
    Map<Integer, String> codigos = new TreeMap() {{
        put(3008, "Belsh");
        put(3009, "Bradashesh");
        put(3011, "Bujqes");
        put(3012, "Bodin");
        put(3013, "Branesh");
        put(3015, "Burrishtë");
        put(3016, "Broshke");
        put(3020, "Banje");
        put(3024, "Bene");
        put(3026, "Blerimas");
    }};
    
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    private void mostrarCodigo(Integer codigo, String ciudad) {
        System.out.println(codigo + ": " + ciudad);
    }
    
    public void mostrarCodigos() {
        System.out.println("");
        
        for (Map.Entry<Integer, String> aux : codigos.entrySet()) {
            Integer codigo = aux.getKey();
            String ciudad = aux.getValue();
         
            mostrarCodigo(codigo, ciudad);
        }
    }
    
    private CodigoPostal introducirCodigo() {
        CodigoPostal producto = new CodigoPostal();
        
        System.out.println("Ingresa el código postal");
        boolean esValido;
        
        do {
            if (scan.hasNextInt()) {
                producto.setCodigo(scan.nextInt());
                esValido = true;
            } else {
                System.out.println("No se ingresó un código válido, vuelve a intentarlo");
                esValido = false;
                scan.next();
            }            
        } while (!esValido);
        
        scan.nextLine();
        System.out.println("Ingresa el nombre de la ciudad");
        do {
            producto.setCiudad(scan.nextLine());
            
            if (producto.getCiudad().equals("")) {
                System.out.println("No se ingresó un nombre válido, vuelve a intentarlo");
            }
        } while (producto.getCiudad().equals(""));
        
        return producto;
    }
    
    public void introducirCodigos() {
        String codigoGuardar = "";
        boolean ingresarOtroCodigo = false;
        CodigoPostal codigo;

        do {
            codigo = introducirCodigo();
            
            codigos.put(codigo.getCodigo(), codigo.getCiudad());

            // scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro? (si / no)");
                codigoGuardar = scan.nextLine();

                switch (codigoGuardar.toLowerCase()) {
                    case "si":
                        ingresarOtroCodigo = true;
                        break;
                    case "no":
                        ingresarOtroCodigo = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!codigoGuardar.equals("si")
                    && !codigoGuardar.equals("no"));

        } while (ingresarOtroCodigo);
        
        mostrarCodigos();
    }
    
    public void buscarCodigo() {
        System.out.println("Ingresa el codigo postal de la ciudad a buscar");
        int codigoBuscar = scan.nextInt();
        boolean existeCodigo = false;

        for (Map.Entry<Integer, String> entry : codigos.entrySet()) {
            Integer codigo = entry.getKey();
            String ciudad = entry.getValue();

            if (codigo == codigoBuscar) {
                existeCodigo = true;
                break;
            }
        }
        
        if (existeCodigo) {
            System.out.println("El código " + codigoBuscar + " corresponde a la siguiente ciudad");
            mostrarCodigo(codigoBuscar, codigos.get(codigoBuscar));
        } else {
            System.out.println("No se encontró ciudad con código postal " + codigoBuscar);
        }
    }
    
    public void removerCodigos() {
        System.out.println("Ingresa el nombre del código que quieres remover");
        int codigoRemover = scan.nextInt();
        boolean existeCodigo = false;

        for (Map.Entry<Integer, String> entry : codigos.entrySet()) {
            Integer codigo = entry.getKey();
            String ciudad = entry.getValue();

            if (codigo == codigoRemover) {
                existeCodigo = true;   
                break;
            }
        }
        
        if (existeCodigo) {
            codigos.remove(codigoRemover);
        } else {
            System.out.println("No se encontró el codigo: " + codigoRemover);
        }

        mostrarCodigos();
    }
    
}
