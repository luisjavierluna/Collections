/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.EE_4;

import java.util.Objects;

/**
 *
 * @author javie
 */
public class CodigoPostal {
    private int codigo;
    private String ciudad;

    public CodigoPostal() {
    }

    public CodigoPostal(int codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.ciudad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CodigoPostal other = (CodigoPostal) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        return true;
    }
    
    
}
