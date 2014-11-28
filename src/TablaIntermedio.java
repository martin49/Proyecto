/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nacedo
 */


import java.util.ArrayList;

public class TablaIntermedio {
    public ArrayList<Cuadrupla> tabla;
    
    public TablaIntermedio(){

        this.tabla= new ArrayList<Cuadrupla>();
    }
    public void Ingresar(String operador,String arg1,String arg2,String resultado){
        tabla.add(new Cuadrupla(operador,arg1,arg2,resultado));
    }
    public void Ingresar(String op,String arg1,String arg2){

        tabla.add(new Cuadrupla(op,arg1,arg2));
    }            
    public void AgregarCuad(Cuadrupla cuadru){

        tabla.add(cuadru);
    }
    public ArrayList<Cuadrupla> getTabla(){

        return this.tabla;
    }
    public void resltado(int i,String etiqueta){

        this.tabla.get(i).resultado =etiqueta;
    }
    public void PrintTabla(){
        for(Cuadrupla i: tabla){
            System.out.print(i.operador+" |");
            if(i.arg1 != null)
                System.out.print(i.arg1 + " |");
            if(i.arg2 != null)
                System.out.print(i.arg2+" |");
            System.out.print(i.resultado+" |");
            System.out.println("\n");
        }
    }
}