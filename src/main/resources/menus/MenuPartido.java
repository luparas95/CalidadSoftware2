package main.resources.menus;

import java.util.Scanner;

import main.resources.objects.Partido;

import main.resources.utils.Utils;

public class MenuPartido {
    
    private static final Scanner ENTRADA = new Scanner(System.in);
    
    private static void muestraMenuPrincipal() {
    
        System.out.println("------------------------------");
        System.out.println("1. Ver partidos");
        System.out.println("2. Crear partido");
        System.out.println("3. Volver");
        System.out.print("Introduzca la opción deseada: ");
    
    }

    private static void muestraPartidos(Partido partidos[]) {
    
        System.out.println("------------------------------");
        
        if (partidos.length == 0) {
        
            System.out.println("Aún no hay partidos");
        
        } else {
        
            for (Partido partido:partidos) {

                partido.print();

            }
            
        }
    
    }

    private static Partido[] creaPartido(Partido partidos[]) {
    
        System.out.println("------------------------------");
        System.out.print("Introduzca el nombre del partido: ");
        String nombre = ENTRADA.nextLine();
        
        System.out.print("Introduzca las siglas: ");
        String siglas = ENTRADA.nextLine();
        
        Partido partido = new Partido(nombre, siglas);
        
        return Utils.PartidoArrayPush(partido, partidos);
    
    }

    public static Partido[] muestraMenuPartido(Partido partidos[]) {
    
        Boolean noSalir = true;
        String opcion = "";
        Partido newPartidos[] = partidos;
        
        muestraMenuPrincipal();
        
        while (noSalir) {

            opcion = ENTRADA.nextLine();
            switch (opcion) {
            
                case "1":
                    
                    muestraPartidos(newPartidos);
                    muestraMenuPrincipal();
                    break;
            
                case "2":
                    
                    newPartidos = creaPartido(newPartidos);
                    muestraMenuPrincipal();
                    break;
            
                case "3":
                    
                    noSalir = false;
                    break;
                    
                default:
                    
                    System.out.print("Opción no válida, inténtelo de nuevo: ");
            
            }
            
        }
        
        return newPartidos;
            
    }

}