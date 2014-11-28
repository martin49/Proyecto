/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nacedo
 */


public class Cuadrupla {
    public String operador;
    public String arg1;
    public String arg2;
    public String resultado;
    public String ambito = null;
    
    
    public Cuadrupla(String operador,String argumento1, String argumento2, String resultado){
        this.operador = operador;
        this.arg1 = argumento1;
        this.arg2 = argumento2;
        this.resultado = resultado;
    }
    public Cuadrupla(String operador,String argumento1, String argumento2, String resultado,String ambito){
        this.operador = operador;
        this.arg1 = argumento1;
        this.arg2 = argumento2;
        this.resultado = resultado;
        this.ambito = ambito;
    }
    
    public Cuadrupla(String operador,String argumento1,String resultado){
        this.operador = operador;
        this.arg1 = argumento1;
        this.resultado = resultado;
    }
    public Cuadrupla(String operador,String resultado){
        this.operador = operador;
        this.resultado = resultado;
    }
    public String toString(){
        return "operador: "+ operador + " argumento 1: "+ arg1+" argumento 2: "+arg2+ " resultado: "+resultado;
    }

    public String getOperador() {
        return this.operador;
    }

    public String getArg1() {
        return this.arg1;
    }

    public String getArg2() {
        return this.arg2;
    }

    public String getResultado() {
        return this.resultado;
    }

    public void setOperador(String op) {
        this.operador = op;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public void setResultado(String res) {
        this.resultado = res;
    }
    
}
