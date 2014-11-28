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
public class tablaFunciones {
    String nombre;
    String tipo;
    String ambito;
    
    public tablaFunciones(String nombre, String tipo, String ambito) 
    {
        this.nombre = nombre;       
        this.tipo = tipo;
        this.ambito = ambito;
    }
    
}

    
<<<<<<< HEAD

=======
    public TablaSimbolosFunciones()
    {        
        tablaSimbolos = new HashMap<String, tablaFunciones>();  
        sim = new ArrayList<String>();
        idMetodo = new ArrayList<String>();
    }
    
            
    public tablaFunciones crear(String nombre, String tipo, String ambito)
    {        
        tablaFunciones simbolo = buscar(nombre);                            
        if(simbolo == null) // La variable no existe
        {
            simbolo = new tablaFunciones(nombre, tipo, ambito);
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
   
    public void crearid(String id){
        idMetodo.add(id);
    }
    
    public String getId(){
        int size = idMetodo.size()-1;
        return idMetodo.get(size);
    }
    
    public String quitarAmbito(String ambito, String id){
        int size = idMetodo.size()-1;
        idMetodo.remove(size);
        String tmp = ambito.replace(id,"");
        return tmp.substring(0,tmp.length()-1);
    } 
    
    public tablaFunciones buscar(String nombre)
    {
        return (tablaFunciones)tablaSimbolos.get(nombre);
    }
    
    public String buscarTipo(String nombre)
    {
        return tablaSimbolos.get(nombre).tipo;
    }
    
    public void imprimir()
    {
        System.out.println("\nIngresando a imprimir de TablaSimbolos");
        System.out.println("    Valores de la tabla de simbolos:");
        for (tablaFunciones s : tablaSimbolos.values())
            System.out.println(String.format("      "
                    + "Nombre: %s, tipo: %s, ambito: %s",s.nombre, s.tipo, s.ambito));        
        System.out.println("Saliendo de imprimir en TablaSimbolos\n ");
    }
}
>>>>>>> FETCH_HEAD
