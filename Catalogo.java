package org.CatalogodeMelodia;

import java.util.*;
import java.util.stream.Collectors;

public class Catalogo {
    private ArrayList<Melodia> misMelodias;

    public Catalogo() {
        misMelodias = new ArrayList<>();

    }

    public String getListaMelodias() {
        String melodias = "";
        for (Melodia melodia : misMelodias) {
            melodias += melodia + "\n";
        }
        return melodias.toString();
    }


    public void agregarMelodia(Melodia melodia) {
        boolean existe = misMelodias.stream()
                .anyMatch(m -> m.getNombre().equalsIgnoreCase(melodia.getNombre())
                        && m.getCantante().equalsIgnoreCase(melodia.getCantante()));
        if (!existe) {
            misMelodias.add(melodia);
            System.out.println("agreada");
        } else {
            System.out.println("ya existe");
        }
    }



    public double getPrecioMelodia() {
        double precio = 0;
        for (Melodia melodia : misMelodias) {
            precio += melodia.getPrecio();
        }
        return precio;
    }

    public boolean eliminarMelodia(String nombre) {
        return misMelodias.removeIf(m -> m.getNombre().equalsIgnoreCase(nombre));
    }

    public Set<String> obtenerCantantes() {
        return misMelodias.stream()
                .map(Melodia::getCantante)
                .collect(Collectors.toSet());
    }

    public Set<String> obtenerGeneros() {
        return misMelodias.stream()
                .map(Melodia::getGenero)
                .collect(Collectors.toSet());
    }
    public List<Melodia> obtenerPorGenero(String genero) {
        return misMelodias.stream()
                .filter(m -> m.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }
    public Melodia buscarMelodia(String nombre) {
        return misMelodias.stream()
                .filter(m -> m.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean corregirMelodia(String nombre, Melodia nuevosDatos) {
        for (int i = 0; i < misMelodias.size(); i++) {
            Melodia m = misMelodias.get(i);
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                m.setCompositor(nuevosDatos.getCompositor());
                m.setGenero(nuevosDatos.getGenero());
                m.setCantante(nuevosDatos.getCantante());
                m.setAñoDeGrabacion(nuevosDatos.getAñoDeGrabacion());
                m.setPrecio((float) nuevosDatos.getPrecio());
                m.setFormato(nuevosDatos.getFormato());
                return true; 
            }
        }
        return false; 
    }
    
}
