package org.CatalogodeMelodia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op = 0;
        Comprobacion comp = new Comprobacion();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Capturar melodia:");
            System.out.println("2. Mostrar todas las melodias");
            System.out.println("3. Mostrar precio de las melodias");
            System.out.println("4. Mostrar Cantantes");
            System.out.println("5. Mostrar géneros musicales");
            System.out.println("6. Mostrar melodías por género");
            System.out.println("7. Eliminar melodia");
            System.out.println("8. Corregir melodia");
            System.out.println("9. Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    comp.capturarMelodia();
                    break;
                case 2:
                    comp.mostrarMelodias();
                    break;
                    case 3:comp.mostrarPrecioMelodias();
                    break;
                case 4: comp.mostrarCantantes();
                break;
                case 5: comp.mostrarGeneros();
                break;
                case 6: comp.mostrarMelodiasPorGenero();
                    break;
                case 7: comp.eliminarMelodia();
                break;
                case 8: comp.corregirMelodia();
                break;
                case 9: System.out.println("Saliendo del programa");
                    break;
                default: System.out.println("Opción no válida.");
            }
        } while (op!=9);
        for(int i=1;i<=5;i++){

    }
}
}
