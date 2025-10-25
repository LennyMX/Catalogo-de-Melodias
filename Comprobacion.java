package org.CatalogodeMelodia;


import java.util.List;
import java.util.Scanner;

public class Comprobacion {
    public static String[] generos = {"romantica", "infantil", "Ranchera", "disco",
            "regional", "clasica",
            "rock", "POP", "cumbia", "Metal", "Reggeton", "Rap", "electronica",};
    Scanner leerCadena = new Scanner(System.in);
    Scanner leerNumeros = new Scanner(System.in);
    Catalogo catalogo = new Catalogo();


    public void capturarMelodia() {
        Melodia melodia;
        System.out.println("Ingrese el nombre que quiere capturar:");
        String nombre = leerCadena.nextLine();
        System.out.println("Ingrese el compositor");
        String compositor = leerCadena.nextLine();
        System.out.println("Seleccione el genero:");
        for (int i = 0; i < Comprobacion.generos.length; i++) {
            System.out.println(". " + generos[i]);
        }
        int indice = leerNumeros.nextInt();
        leerNumeros.nextLine();
        System.out.println("Ingrese el cantante");
        String cantante = leerCadena.nextLine();
        System.out.println("Ingrese el año de grabacion");
        String añoDeGrabacion = leerCadena.nextLine();
        System.out.println("Ingrese el precio");
        float precio = leerNumeros.nextFloat();
        System.out.println("Ingrese el formato: mp3, cop, wav");
        String formato = leerCadena.nextLine();

        catalogo.agregarMelodia(new Melodia(nombre, compositor, Comprobacion.generos[--indice], cantante,
                añoDeGrabacion, precio, formato));


    }

    public void mostrarMelodias() {
        System.out.println("Todo el catalogo de melodias");
        System.out.println(catalogo.getListaMelodias());
    }

    public void mostrarPrecioMelodias() {
        System.out.println("Este es el precio total de las melodias:");
        System.out.println(catalogo.getPrecioMelodia());
    }

    public void mostrarCantantes() {
        System.out.println("Cantantes en la colección:");
        catalogo.obtenerCantantes().forEach(System.out::println);
        System.out.println("Total: " + catalogo.obtenerCantantes().size());
    }

    public void mostrarGeneros() {
        System.out.println("Géneros en la coleccion:");
        catalogo.obtenerGeneros().forEach(System.out::println);
    }

    public void mostrarMelodiasPorGenero() {
        System.out.print("Ingrese el género a consultar: ");
        String genero = leerCadena.nextLine();

        List<Melodia> lista = catalogo.obtenerPorGenero(genero);
        if (lista.isEmpty()) {
            System.out.println("No hay melodías de ese género.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public void eliminarMelodia() {
        System.out.print("Ingrese el nombre de la melodía que quiera eliminar: ");
        String nombre = leerCadena.nextLine();

        if (catalogo.eliminarMelodia(nombre)) {
            System.out.println("Melodía eliminada.");
        } else {
            System.out.println("No se encontró la melodía.");
        }
    }

    public void corregirMelodia() {
        System.out.print("Ingrese el nombre de la melodía que quiera corregir: ");
        String nombre = leerCadena.nextLine();

        Melodia actual = catalogo.buscarMelodia(nombre);
        if (actual == null) {
            System.out.println("No se encontró la melodía.");
            return;
        }

        System.out.println("Ingrese los nuevos datos (dejar en blanco para no modificar):");

        System.out.print("Compositor [" + actual.getCompositor() + "]: ");
        String compositor = leerCadena.nextLine();
        if (compositor.isEmpty()) {
            compositor = actual.getCompositor();
        }

        System.out.print("Género [" + actual.getGenero() + "]: ");
        String genero = leerCadena.nextLine();
        if (genero.isEmpty()) {
            genero = actual.getGenero();
        }

        System.out.print("Cantante [" + actual.getCantante() + "]: ");
        String cantante = leerCadena.nextLine();
        if (cantante.isEmpty()) {
            cantante = actual.getCantante();
        }

        System.out.print("Año de grabación [" + actual.getAñoDeGrabacion() + "]: ");
        String año = leerCadena.nextLine();
        if (año.isEmpty()) {
            año = actual.getAñoDeGrabacion();
        }

        System.out.print("Precio [" + actual.getPrecio() + "]: ");
        String precioInput = leerNumeros.nextLine();
        float precio;
        if (precioInput.isEmpty()) {
            precio = (float) actual.getPrecio();
        } else {
            try {
                precio = Float.parseFloat(precioInput);
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido, se mantiene el anterior.");
                precio = (float) actual.getPrecio();
            }
        }

        System.out.print("Formato [" + actual.getFormato() + "]: ");
        String formato = leerCadena.nextLine();
        if (formato.isEmpty()) {
            formato = actual.getFormato();
        }

        Melodia nueva = new Melodia(nombre, compositor, genero, cantante, año, precio, formato);

        if (catalogo.corregirMelodia(nombre, nueva)) {
            System.out.println("Melodía actualizada.");
        } else {
            System.out.println("Error no se pudo actualizar.");
        }
    }
}
