
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MartinPastora
 */
public class Funsiones {
    String nombre;
    String tipo;
    String ambito;
    String dominio;
    String rango;
    
    public Funsiones(String nombre, String tipo, String ambito, String dominio, String rango) 
    {
        this.nombre = nombre;       
        this.tipo = tipo;
        this.ambito = ambito;
        this.dominio = dominio;
        this.rango = rango;
    }
    
}

class TablaFunsiones {
    static Map<String, Funsiones> tablaSimbolos;
    static ArrayList<String> sim;
    public static Logger log = Logger.getLogger(TablaSimbolos.class.getName());            
    
    public TablaFunsiones()
    {        
        tablaSimbolos = new HashMap<String, Funsiones>();  
        sim = new ArrayList<String>();
    }
    
            
    public Funsiones crear(String nombre, String tipo, String ambito, String dominio, String rango)
    {        
        Funsiones simbolo = buscar(nombre);                            
        if(simbolo == null) // La variable no existe
        {
            simbolo = new Funsiones(nombre, tipo, ambito, dominio, rango);
            //System.out.println("Agregando a tabla de simbolos con nombre: " + nombre);
            tablaSimbolos.put(nombre, simbolo);            
            //System.out.println("Variable creada exitosamente!!!");
              
            //imprimir();                
            System.out.println(" ");
            return simbolo;
        }
        else
        {
            log.log(Level.SEVERE, "Redefinición de la variable: " + nombre);
            return null; // La variable ya existía                
        }
    }
    
    public void creartipo(String tipo)
    {        
      if(sim.isEmpty()){
         sim.add(tipo);
      }else{
          sim.remove(0);
          sim.add(tipo);
      }  
        
    }
    
    public String getTipo(){
        return sim.get(0);
    }
   
        
    
    public Funsiones buscar(String nombre)
    {
        return (Funsiones)tablaSimbolos.get(nombre);
    }
    
    public String buscarTipo(String nombre)
    {
        return tablaSimbolos.get(nombre).tipo;
    }
    
    public String buscarAmbito(String nombre)
    {
        return tablaSimbolos.get(nombre).ambito;
    }
    
    public String buscarDominio(String nombre)
    {
        return tablaSimbolos.get(nombre).dominio;
    }
    
    public String buscarRango(String nombre)
    {
        return tablaSimbolos.get(nombre).rango;
    }
    
    public boolean prefijo(String nombre, String ambito){
        String ambitop = tablaSimbolos.get(nombre).ambito;
        if(ambito.startsWith(ambitop)==true)
            return true;
        else
            return false;
    }
    
    public static void imprimir()
    {
        System.out.println("\nIngresando a imprimir de TablaSimbolos");
        System.out.println("    Valores de la tabla de simbolos:");
        for (Funsiones s : tablaSimbolos.values())
            System.out.println(String.format("      "
                    + "Nombre: %s, tipo: %s, ambito: %s",s.nombre, s.tipo, s.ambito));        
        System.out.println("Saliendo de imprimir en TablaSimbolos\n ");        
    }
    
    public boolean isinteger(String n){
        try{
            Integer.parseInt(n);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
