

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
            bw.append("main:\n");
            bw.append("move $fp,$sp\n");
            
             for (int i = 0; i < TablaIntermedio.tabla.size(); i++) {
                 switch(TablaIntermedio.tabla.get(i).operador){
                     case ":=":{
                         try{
                            if(TablaIntermedio.tabla.get(i).arg2.equals("1")){
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1))
                                bw.append("li $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                bw.append("move $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i).arg1+"\n");
                         }
                         }catch (Exception e) {
                             int a=0;
                             bw.append("move $a"+a+", $"+TablaIntermedio.tabla.get(i).arg1+"\n");
                             bw.append("la $a"+a+", _"+TablaIntermedio.tabla.get(i).resultado+"\n");
                             a++;
                         }  
                         
                         
                         break;
                     }
                     case "+":{
                         if(i==0)
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1)){
                                bw.append("li $a0,"+TablaIntermedio.tabla.get(i).arg1+"\n");
                            bw.append("add $"+TablaIntermedio.tabla.get(i).resultado+", $a0, "+TablaIntermedio.tabla.get(i).arg2+"\n");
                            }else
                            bw.append("add $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+", "+TablaIntermedio.tabla.get(i).arg2+"\n");
                         else
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i-1).arg1))
                                bw.append("add $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                 
                                bw.append("add $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }
                     case "-":{
                         if(i==0)
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1)){
                                bw.append("li $a0,"+TablaIntermedio.tabla.get(i).arg1+"\n");
                            bw.append("sub $"+TablaIntermedio.tabla.get(i).resultado+", $a0, "+TablaIntermedio.tabla.get(i).arg2+"\n");
                            }else
                            bw.append("sub $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+", "+TablaIntermedio.tabla.get(i).arg2+"\n");
                         else
                         if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i-1).arg1))
                                bw.append("sub $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                 
                                bw.append("sub $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }
                     case "*":{
                         if(i==0){
                            if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1)){
                                bw.append("li $a0,"+TablaIntermedio.tabla.get(i).arg1+"\n");
                            bw.append("mul $"+TablaIntermedio.tabla.get(i).resultado+", $a0, "+TablaIntermedio.tabla.get(i).arg2+"\n");
                            }else{
                                bw.append("mul $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+", "+TablaIntermedio.tabla.get(i).arg2+"\n");
                            }
                                
                                 
                         }
                            
                         else
                         if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i-1).arg1))
                                bw.append("mul $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                 
                                bw.append("mul $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }case "/":{
                         if(i==0)
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1)){
                                bw.append("li $a0,"+TablaIntermedio.tabla.get(i).arg1+"\n");
                            bw.append("div $"+TablaIntermedio.tabla.get(i).resultado+", $a0, "+TablaIntermedio.tabla.get(i).arg2+"\n");
                            }else
                            bw.append("div $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+", "+TablaIntermedio.tabla.get(i).arg2+"\n");
                         else
                         if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i-1).arg1))
                                bw.append("div $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                 
                                bw.append("div $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }
                 }
             }
             
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
            bw.append("main:\n");
            bw.append("move $fp,$sp\n");
            
             for (int i = 0; i < TablaIntermedio.tabla.size(); i++) {
                 switch(TablaIntermedio.tabla.get(i).operador){
                     case ":=":{
                         if(TablaIntermedio.tabla.get(i).arg2.equals("1")){
                             if(TablaSimbolos.isinteger(TablaIntermedio.tabla.get(i).arg1))
                                bw.append("li $"+TablaIntermedio.tabla.get(i).resultado+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                             else
                                bw.append("move $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i).arg1+"\n");
                         }else{
                             int a=0;
                             bw.append("move $a"+a+", $"+TablaIntermedio.tabla.get(i).arg1+"\n");
                             bw.append("la $a"+a+", _"+TablaIntermedio.tabla.get(i).resultado+"\n");
                             a++;
                         }  
                         
                         
                         break;
                     }
                     case "+":{
                         bw.append("add $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }
                         case "*":{
                         bw.append("mul $"+TablaIntermedio.tabla.get(i).resultado+", $"+TablaIntermedio.tabla.get(i-1).arg1+", "+TablaIntermedio.tabla.get(i).arg1+"\n");
                         break;
                     }
                 }
             }
        }
          bw.close();      
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
        
        
    }
    
}
