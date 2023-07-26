/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EP_6;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author javie
 */
public class ServicioProducto {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    // Map<String, Double> paises = new TreeMap();
    Map<String, Double> productos = new TreeMap() {{
        put("Agua", 50.5);
        put("Cloro", 20.0);
        put("Fideos", 5.5);
        put("Jabon", 15.5);
        put("Paleta", 2.5);
    }};
    
    private void mostrarProducto(String key, double value) {
        System.out.println(key + ": $" + value);
    }
    
    public void mostrarProductos() {
        System.out.println("");
        
        for (Map.Entry<String, Double> aux : productos.entrySet()) {
            String key = aux.getKey();
            Double value = aux.getValue();
         
            mostrarProducto(key, value);
        }
    }
    
    private Producto introducirProducto() {
        Producto producto = new Producto();
        
        System.out.println("Ingresa el nombre del producto");
        do {
            producto.setNombre(scan.nextLine());
            
            if (producto.getNombre().equals("")) {
                System.out.println("No se ingresó un nombre válido, vuelve a intentarlo");
            }
        } while (producto.getNombre().equals(""));
     
        // Falta Validación
        System.out.println("Ingresa el precio de " + producto.getNombre());
        producto.setPrecio(scan.nextDouble());
        
        return producto;
    }
    
    public void introducirProductos() {
        String guardarOtroProducto = "";
        boolean ingresarOtroProducto = false;
        Producto producto;

        do {
            producto = introducirProducto();
            
            productos.put(producto.getNombre(), producto.getPrecio());

            scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro producto? (si / no)");
                guardarOtroProducto = scan.nextLine();

                switch (guardarOtroProducto.toLowerCase()) {
                    case "si":
                        ingresarOtroProducto = true;
                        break;
                    case "no":
                        ingresarOtroProducto = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtroProducto.equals("si")
                    && !guardarOtroProducto.equals("no"));

        } while (ingresarOtroProducto);
        
        mostrarProductos();
    }
    
    public void modificarPrecioProducto() {
        System.out.println("Ingresa el nombre del producto al que se le modificará su precio");
        String productoModificar = scan.nextLine();
        boolean existeProducto = false;

        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            if (key.equals(productoModificar)) {
                existeProducto = true;
            }

        }
        
        if (existeProducto) {
            System.out.println("Ingresa el nuevo precio de " + productoModificar);
            double precioModificado = scan.nextDouble();
            productos.put(productoModificar, precioModificado);
        } else {
            System.out.println("No se encontró el producto: " + productoModificar);
        }

        mostrarProductos();
    }
    
    
    public void removerProducto() {
        System.out.println("Ingresa el nombre del producto que quieres remover");
        String productoRemover = scan.nextLine();
        boolean existeProducto = false;

        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            if (key.equals(productoRemover)) {
                existeProducto = true;
            }

        }
        
        if (existeProducto) {
            productos.remove(productoRemover);
        } else {
            System.out.println("No se encontró el producto: " + productoRemover);
        }

        mostrarProductos();
    }
    
}