/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import collections.EP_4.ServicioPelicula;


/**
 *
 * @author javie
 */
public class main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioPelicula sp = new ServicioPelicula();
        
        sp.crearPeliculas();
        
        sp.mostrarMayorAUnaHora();
        
        sp.ordenarMayorAMenorDuracion();
        
        sp.ordenarMenorAMayorDuracion();
        
        sp.ordenarPorTitulo();
        
        sp.ordenarPorDirector();
        
    }
}
