

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MartinPastora
 */
public class CodigoFinal {
    
    public static void escribir(){
        File archivo = new File("Codigo.asm");
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            //Abro stream, crea el fichero si no existe
            
            //Escribimos en el fichero un String y un caracter 97 (a)
            
            //Cierro el stream

         if(archivo.exists()) {
             bw.write(".data\n");
             for (Simbolo s : TablaSimbolos.tablaSimbolos.values()) {
            
            if(s.tipo.equals("Integer")){
                bw.append("_"+s.nombre+": "+ ".word "+0+"\n");
            }else if(s.tipo.equals("char")){
                bw.append("_"+s.nombre+": "+ ".asciiz "+'"'+'"'+"\n");
            }
                
            }
            bw.append(".text\n"); 
            bw.append(".globl main\n"); 
             
        } else {
            
            bw.write(".data\n");
             for (Simbolo s : TablaSimbolos.tablaSimbolos.values()) {
            
            if(s.tipo.equals("Integer")){
                bw.append("_"+s.nombre+": "+ ".word "+0+"\n");
            }else if(s.tipo.equals("char")){
                bw.append("_"+s.nombre+": "+ ".asciiz "+'"'+'"'+"\n");
            }
                
            }
             bw.append(".text\n"); 
             bw.append(".globl main\n"); 
        }
          bw.close();      
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
        
        
    }
    
    public static void codigo(){
        
            
    }
}
