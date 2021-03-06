import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

 class Simbolo
{  
    String nombre;
    String tipo;
    String ambito;
    
    public Simbolo(String nombre, String tipo, String ambito) 
    {
        this.nombre = nombre;       
        this.tipo = tipo;
        this.ambito = ambito;
    }
    
}

class TablaSimbolos {
    static Map<String, Simbolo> tablaSimbolos;
    static ArrayList<String> sim;
    public static Logger log = Logger.getLogger(TablaSimbolos.class.getName());            
    
    public TablaSimbolos()
    {        
        tablaSimbolos = new HashMap<String, Simbolo>();  
        sim = new ArrayList<String>();
    }
    
            
    public Simbolo crear(String nombre, String tipo, String ambito)
    {        
        Simbolo simbolo = buscar(nombre);                            
        if(simbolo == null) // La variable no existe
        {
            simbolo = new Simbolo(nombre, tipo, ambito);
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
   
        
    
    public Simbolo buscar(String nombre)
    {
        return (Simbolo)tablaSimbolos.get(nombre);
    }
    
    public String buscarTipo(String nombre)
    {
        return tablaSimbolos.get(nombre).tipo;
    }
    
    public String buscarAmbito(String nombre)
    {
        return tablaSimbolos.get(nombre).ambito;
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
        for (Simbolo s : tablaSimbolos.values())
            System.out.println(String.format("      "
                    + "Nombre: %s, tipo: %s, ambito: %s",s.nombre, s.tipo, s.ambito));        
        System.out.println("Saliendo de imprimir en TablaSimbolos\n ");
    }
    
    public static boolean isinteger(String n){
        try{
            Integer.parseInt(n);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
}
