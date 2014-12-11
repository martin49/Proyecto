/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author arturo
 */
public class EjemploCUP {

    public final static int GENERAR = 1;
    public final static int EJECUTAR = 2;
    public final static int TABLAD = 3;
    public final static int TABLAF = 4;
    public final static int TABLAFD = 5;
    public final static int CODIGO = 7;
    public final static int CUADRO = 6;
    public final static int SALIR = 8;

    /**
     * Es un menu para elegir entre generar el analizador lexico y sintactico, o
     * ejecutarlos sobre un archivo de pruebas.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner in = new Scanner(System.in);
        int valor = 0;
        do {
            System.out.println("Elija una opcion: ");
            System.out.println("1) Generar");
            System.out.println("2) Ejecutar");
            System.out.println("3) Tabla Simbolos");
            System.out.println("4) Tabla Simbolos Funsiones");
            System.out.println("5) Tabla Simbolos Funsiones Variables");
            System.out.println("6) Codigo Intermedio");
            System.out.println("7) Codigo Final");
            System.out.println("8) Salir");
            System.out.print("Opcion: ");
            valor = in.nextInt();
            switch (valor) {
                /*  Generamos el analizador lexico y sintactico.
                 lcalc.flex contiene la definicion del analizador lexico
                 ycalc.cup contiene la definicion del analizador sintactico
                 */
                case GENERAR: {
                    System.out.println("\n*** Generando ***\n");
                    String archLexico = "";
                    String archSintactico = "";
                    if (args.length > 0) {
                        System.out.println("\n*** Procesando archivos custom ***\n");
                        archLexico = args[0];
                        archSintactico = args[1];
                    } else {
                        System.out.println("\n*** Procesando archivo default ***\n");
                        archLexico = "Proyecto.flex";
                        archSintactico = "proyecto.cup";
                    }
                    String[] alexico = {archLexico};
                    String[] asintactico = {"-parser", "parser", archSintactico};
                    jflex.Main.main(alexico);
                    try {
                        java_cup.Main.main(asintactico);
                    } catch (Exception ex) {
                        Logger.getLogger(EjemploCUP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //movemos los archivos generados
                    boolean mvAL = moverArch("Proyecto.java");
                    boolean mvAS = moverArch("parser.java");
                    boolean mvSym= moverArch("sym.java");
                    if(mvAL && mvAS && mvSym){
                        System.exit(0);
                    }
                    System.out.println("Generado!");
                    break;
                }
                case EJECUTAR: {
                    /*  Ejecutamos el analizador lexico y sintactico
                     sobre un archivo de pruebas. 
                     */
                    String nombre = "";
                    Scanner s = new Scanner(System.in);
                    System.out.println("Ingrese el nombre del ejemplo");
                    nombre = in.next();
                    String[] archivoPrueba = {nombre+".pas"};
                    parser.main(archivoPrueba);
                    System.out.println("Ejecutado!");
                    break;
                }case TABLAD:{
                    TablaSimbolos.imprimir();
                    break;
                }
                case TABLAF:{
                    TablaFunsiones.imprimir();
                    break;
                }
                case TABLAFD:{
                    
                    TablaSimbolosFunciones.imprimir();
                    break;
                }
                case CUADRO:{
                    TablaIntermedio.PrintTabla();
                    break;
                }    
                case CODIGO:{
                    CodigoFinal.escribir();
                    break;
                }    
                case SALIR: {
                    System.out.println("Adios!");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida!");
                    break;
                }
            }
        } while (valor != 8);

    }

    public static boolean moverArch(String archNombre) {
        boolean efectuado = false;
        File arch = new File(archNombre);
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "proyectonetbeans" + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + archNombre + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + archNombre + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo no existente ***\n");
        }
        return efectuado;
    }
}