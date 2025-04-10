package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cofradia")
public class cofradia {

    private String nombre;
    private int numeroHermanos;
    private int fundacion;
    private String ciudad;

    // Constructor vacío obligatorio para JAXB
    public cofradia() {}

    public cofradia(String nombre, int numeroHermanos, int fundacion, String ciudad) {
        this.nombre = nombre;
        this.numeroHermanos = numeroHermanos;
        this.fundacion = fundacion;
        this.ciudad = ciudad;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public int getNumeroHermanos() {
        return numeroHermanos;
    }

    @XmlElement
    public int getFundacion() {
        return fundacion;
    }

    @XmlElement
    public String getCiudad() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHermanos(int numeroHermanos) {
        this.numeroHermanos = numeroHermanos;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Cofradia{" +
                "nombre='" + nombre + '\'' +
                ", numeroHermanos=" + numeroHermanos +
                ", fundacion=" + fundacion +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
