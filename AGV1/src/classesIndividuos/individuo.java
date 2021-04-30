/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesIndividuos;

/**
 *
 * @author DeveloperEdu
 */
public class individuo {
    
    private int cromosoma[];
    private int cromosomaAsociativo[];
    private double valorDecimal;
    private double valorAptitud; //valor de fitnness
    
    public individuo(){
        
    }

    public individuo(int[] cromosoma, int[] cromosomaAsociativo, double valorDecimal, double valorAptitud) {
        this.cromosoma = cromosoma;
        this.cromosomaAsociativo = cromosomaAsociativo;
        this.valorDecimal = valorDecimal;
        this.valorAptitud = valorAptitud;
    }

    
    public int[] getCromosomaAsociativo() {
        return cromosomaAsociativo;
    }

    public void setCromosomaAsociativo(int[] cromosomaAsociativo) {
        this.cromosomaAsociativo = cromosomaAsociativo;
    }

   
    public int[] getCromosoma() {
        return cromosoma;
    }

    public void setCromosoma(int[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    public double getValorDecimal() {
        return valorDecimal;
    }

    public void setValorDecimal(double valorDecimal) {
        this.valorDecimal = valorDecimal;
    }

    public double getValorAptitud() {
        return valorAptitud;
    }

    public void setValorAptitud(double valorAptitud) {
        this.valorAptitud = valorAptitud;
    }

       
    
}
