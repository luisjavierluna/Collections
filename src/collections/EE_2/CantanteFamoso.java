/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EE_2;

/**
 *
 * @author javie
 */
public class CantanteFamoso {
    private String nombre;
    private String discoConMasVentas;

    public CantanteFamoso() {
    }

    public CantanteFamoso(String nombre, String discoConMasVentas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDiscoConMasVentas() {
        return discoConMasVentas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDiscoConMasVentas(String discoConMasVentas) {
        this.discoConMasVentas = discoConMasVentas;
    }

    @Override
    public String toString() {
        return "Cantante: " + nombre + "\n" +
               "Disco más Vendido: " + discoConMasVentas + "\n";
    }
    
    
}
