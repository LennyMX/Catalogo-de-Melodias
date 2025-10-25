package org.CatalogodeMelodia;

public class Melodia {
    private String nombre;
    private String compositor;
    private String cantante;
    private String añoDeGrabacion;
    private float precio;
    private String formato;
    private String genero;

    public Melodia(){
        this.nombre = "";
        this.compositor = "";
        this.cantante = "";
        this.añoDeGrabacion = "";
        this.precio = 0;
    }

    public Melodia(String nombre, String compositor, String genero, String cantante, String añoDeGrabacion, float precio, String formato) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.cantante = cantante;
        this.añoDeGrabacion=añoDeGrabacion;
        this.precio = precio;
        this.formato = formato;
        this.genero=genero;
    }

    public double getPrecio() {
        return precio;
    }

    public String getAñoDeGrabacion(){
        return añoDeGrabacion;
    }
    public void setAñoDeGrabacion(String añoDeGrabacion){
        this.añoDeGrabacion=añoDeGrabacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    public String getCantante() {
        return cantante;
    }
    public void setCantante(String cantante) {
        this.cantante = cantante;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return "Melodia{" +
                "nombre='" + nombre + '\'' +
                ", compositor='" + compositor + '\'' +
                ", genero='" + genero + '\'' +
                ", cantante='" + cantante + '\'' +
                ", añoDeGrabacion='" + añoDeGrabacion + '\'' +
                ", precio=" + precio +
                ", formato='" + formato + '\'' +
                '}';
    }
}
