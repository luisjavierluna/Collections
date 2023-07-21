/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EP_3;

/**
 *
 * @author javie
 */
public class Alumno {
    public String nombre;
    public int[] notas;

    public Alumno() {
    }

    public Alumno(String nombre, int[] notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

}
