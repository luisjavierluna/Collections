/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EP_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class ServicioAlumno {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    
    public Alumno crearAlumno() {
        Alumno alumno = new Alumno();
        int[] notas = new int[3];
        
        System.out.println("Ingresa el nombre del Alumno");
        alumno.setNombre(scan.nextLine());
        
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Ingresa la " + (i + 1) + "° nota de " + alumno.getNombre());
            notas[i] = scan.nextInt();
        }
        
        alumno.setNotas(notas);
        
        return alumno;
    }
    
    public void crearAlumnos() {
        String guardarOtroAlumno = "";
        boolean ingresarOtroAlumno = false;

        do {
            alumnos.add(crearAlumno());

            scan.nextLine();
            do {
                System.out.println("¿Quieres ingresar otro alumno? (si / no)");
                guardarOtroAlumno = scan.nextLine();

                switch (guardarOtroAlumno.toLowerCase()) {
                    case "si":
                        ingresarOtroAlumno = true;
                        break;
                    case "no":
                        ingresarOtroAlumno = false;
                        break;
                    default:
                        System.out.println("las únicas opciones válidas son si y no, vuelve a intentarlo");
                        break;
                }
            } while (!guardarOtroAlumno.equals("si")
                    && !guardarOtroAlumno.equals("no"));

        } while (ingresarOtroAlumno);
    }
    
    public void notaFinal() {
        
        boolean alumnoEncontrado = false;
        double promedio = 0;
        
        System.out.println("Ingresa el nombre del alumno para mostrar su nota final");
        String alumnoBuscar = scan.nextLine();
        
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(alumnoBuscar)) {
                alumnoEncontrado = true;
                
                promedio = Arrays.stream(alumno.getNotas()).average().getAsDouble();
                
                System.out.println("La nota final del alumno " + alumno.getNombre() + " es " + promedio);
                
            } else {
                alumnoEncontrado = false;
            }
        }
        
        if (!alumnoEncontrado) System.out.println("No se encontró en el listado al alumno " + alumnoBuscar);
    }
}
