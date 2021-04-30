/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos.metodosBinarios;

import classesIndividuos.individuo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * 
 *
 * @author DeveloperEdu
 */
public class generadorDePoblacion{
    
    /*
     *ArrayList solo para capturar todos los individuos mejores de las generaciones
     *este es el arryList que se utiliza para hacer la grafica    
     */
    ArrayList<individuo> mejoresIndividosDeGeneraciones = new ArrayList<individuo>();
    individuo mejorIndivioGA=null;
    
    public void generarPoblacion(){
        /* variables para poblacion     
        * numero de generaciones que indica el numero de generaciones a generar
        * Arraylist para contener la poblaciones tanto la inicial, la selecta y la cruzada
        */
       int numeroGeneraciones=1;
       ArrayList<individuo> poblacion = new ArrayList<individuo>();
       ArrayList<individuo> poblacionSelecta = new ArrayList<individuo>();
       ArrayList<individuo> poblacionCruzada = new ArrayList<individuo>();
       
       
       /*
        *variables de la cantidad de individuos tanto su numero de genes que contiene
        */
       int numeroDeIndividuos=10;
       int numeroDeGenes=8;
       int numeroCortes=2;
       //objetos para invocar a los metodos genticos
       seleccion seleccion= new seleccion(); 
       cruza cruza = new cruza(); 
       
       for (int i = 0; i < numeroGeneraciones; i++) {
            System.out.println("\nGeneracion: "+ (i+1));
            /*
             *si i es == 0 significa que es la generacion uno 
             *lo cual la primera generacion se debe generar aleatoriamente  
             */
            if(i == 0){ 
                poblacion=generadorDeIndividuosPrimeraGeneracion(poblacion,numeroDeIndividuos,numeroDeGenes);
                mostrarPoblacion(poblacion,numeroDeGenes);
            }else{
                /*
                 *si la iteracion deja de ser cero las proximas generaciones 
                 *siguen el algoritmo del algoritmo genetico
                 *seleccion 
                 *cruza
                 *mutacion 
                 */
                //seleecion
                //poblacionSelecta=seleccion.seleccionAleatoria(poblacion,numeroDeIndividuos);
                //poblacionSelecta=seleccion.seleleccionPorRuleta(poblacion,numeroDeIndividuos);
                //poblacionSelecta=seleccion.seleleccionPorMuestreoEstocasticoUniversal(poblacion,numeroDeIndividuos);
                poblacionSelecta=seleccion.seleccionPorTorneo(poblacion,numeroDeIndividuos,3);
                //cruza
                //poblacionCruzada=cruza.cruzaUnPunto(poblacionSelecta,numeroDeGenes);
                //poblacionCruzada=cruza.cruzaDedosPuntos(poblacionSelecta,numeroDeGenes);
                //poblacionCruzada=cruza.cruzedeUnPuntoUniforme(poblacionSelecta,numeroDeGenes);
                //poblacionCruzada=cruza.cruzedeUnpuntoManeraApaptativa(poblacionSelecta,i,numeroDeGenes);
                poblacionCruzada=cruza.cruzeMultipuntoAleatorio(poblacionSelecta,numeroDeGenes,numeroCortes);
                //poblacionCruzada=cruza.cruzaMultipuntoUniforme(poblacionSelecta,numeroDeGenes,numeroCortes);
                //poblacionCruzada=cruza.cruzaMultipuntoAdaptativa(poblacionSelecta,i,numeroDeGenes,numeroCortes);
                //mutacion
                poblacion=generadorDeIndividuosNuevos(poblacionCruzada);
                //seleccion
                //cruza
                //mutacion
                
            }
        }
    }
    
    /*
     *@param metodo para generar individuos se pasa como parametro un 
     *arrayList donde se guardara la poblacion 
     */
    public ArrayList<individuo> generadorDeIndividuosPrimeraGeneracion(ArrayList<individuo> poblacion, int numeroDeIndividuos,int numeroDeGenes){
        
        individuo individuoTMP = null; //individuo temporal qeu guarda los valores del individuo
       
        for (int i = 0; i < numeroDeIndividuos; i++) { //dependiendo del numero de individuos sera el tamaño del arrarlist de poblacion
            individuoTMP = new individuo();
            //metodo para las dps tipos de genraciones tanto decimal como binaria
            individuoTMP = generadorDeGenesBinarios(individuoTMP,numeroDeGenes);
            poblacion.add(individuoTMP);
            
        }
        poblacion=evaluarPoblacion(poblacion,numeroDeGenes);
        
        return poblacion;
    }
    
    
    public ArrayList<individuo> generadorDeIndividuosNuevos(ArrayList<individuo> poblacionCruzada){
       
        double valorDecimal=0; 
        double valorAptitud=0; 
        for (int i = 0; i < poblacionCruzada.size(); i++) {
             valorDecimal=generaValorDecimal(poblacionCruzada.get(i).getCromosoma());
             valorAptitud=generaValorAptitud(valorDecimal);
             poblacionCruzada.get(i).setValorDecimal(valorDecimal);
             poblacionCruzada.get(i).setValorAptitud(valorAptitud);
        }
        
        //mostrarPoblacion(poblacionCruzada);
        //mejorIndivioGA=buscarMejorIndividuo(poblacionCruzada);
        
        return poblacionCruzada;
    }
    
    /*
     *metodo que se encarga de generar genes de tipo binario
     *como paramentro se pasa un individuo el cual llena llena los atributos 
     *del individuo y de inmediato obtiene tanto el valor de aptitud
     *y el valor en decimal    
     */
    public individuo generadorDeGenesBinarios(individuo individuoTMP,int numeroDeGenes){
        
        int cromosoma []=new int[numeroDeGenes];
        //double valorDecimal=0; 
        //double valorAptitud=0; 
        
        cromosoma=generaBinarios(cromosoma);
        individuoTMP.setCromosoma(cromosoma);
        
        return individuoTMP;
    }
    
    /*
     *metodo para generar numeros aleatorios binarios para el cromosoma
     */
    public int[] generaBinarios(int []cromosoma){
        double auxAleatorio;
        Random aleatorio = new Random();
        for (int i = 0; i < cromosoma.length; i++) {
                auxAleatorio = aleatorio.nextDouble() * 1 + 0;
                if (auxAleatorio < 0.5) {
                    cromosoma[i] = 0;
                } else {
                    cromosoma[i] = 1;
                }
        }
        return cromosoma;
    }
    
    public ArrayList<individuo> evaluarPoblacion(ArrayList<individuo> poblacion,int numeroDeGenes){
        
        ArrayList<individuo> poblacionTmp = new ArrayList<individuo>();
        individuo individuoTmp = null;
        double valorDecimal=0; 
        double valorAptitud=0;
        //=new int[numeroDeGenes];
        
            for (int i = 0; i < poblacion.size(); i++) {
                individuoTmp =new individuo();
                int cromosoma [] = poblacion.get(i).getCromosoma();
                valorDecimal=generaValorDecimal(cromosoma);
                valorAptitud=generaValorAptitud(valorDecimal);
                individuoTmp.setValorDecimal(valorDecimal);
                individuoTmp.setValorAptitud(valorAptitud);
                poblacionTmp.add(individuoTmp);
            }
        //metodo para mostrar la poblacion
        //mostrarPoblacion(poblacionTmp,numeroDeGenes);
        //mejorIndivioGA=buscarMejorIndividuo(poblacion)
        //poblacion = generadorDeGenesDecimales(poblacion);
        return poblacionTmp;
    }
    
    
    /*
     *Se obtiene el valor decimal dependiendo del cromooma que su valor 
     *se obtiene a cuando es equivalente al numero en binario
     *se usa el metodo convertirBinarioaEntero para obtener su su simil en decimal
     *como parametro se usa el cromoma del individuo
     */
    public double generaValorDecimal(int []cromosoma){
        double valorDecimal=0;
            valorDecimal=convertirBinarioaEntero(cromosoma);
        return valorDecimal;
    }
    
    /*
     *metodo para convertir el numero equivalente en binario en decimal se usa
     *como parametro el cromosoma del individuo
     */
    public int convertirBinarioaEntero(int[] cromosoma) {
        int valorDecimalTMP = 0;
        int longitud = cromosoma.length - 1;
        for (int i = 0; i < cromosoma.length; i++) {
            if (cromosoma[i] == 1) {
                valorDecimalTMP += Math.pow(2, longitud - i);
            }
        }
        return valorDecimalTMP;
    }
    /*
     *metodo que obtiene el valor de la aptitud como parametro se usa
     *el valor decimal equivalente del comosoma en binario
     */
    public double generaValorAptitud(double valorDecimal){    
        double ValorAptitud=0;
            ValorAptitud=funciondeActitud(valorDecimal);
        return ValorAptitud;
    } 
    
    /*
     *metodo que contiene la funcion de aptitud a evaluar aqui es donde se 
     *cambia la funcion de aptitud
     */
    public double funciondeActitud(double x) {
        /*solo se cambia el tipo de funcion al que quiera evaluar*/
        double valorAptitud = 0;
        valorAptitud = -2 * Math.pow(x, 2) + (11 * x) / 3;
        //valorAptitud =Math.abs((x-5)/(2+Math.sin(x)));
        return valorAptitud;
    }
    
    public void mostrarPoblacion(ArrayList<individuo> poblacion,int numeroDeGenes){
        System.out.println("Individuo\t\tValor decimal\t\tValor Aptitud\t\t");
        
       
        /*
        for (int i = 0; i < poblacion.size(); i++) {
                //try {
                    //int []cromosomaTmp = new int[numeroDeGenes];
                    //cromosomaTmp  =  poblacion.get(i).getCromosoma();
                    System.out.println(Arrays.toString(poblacion.get(i).getCromosoma()));
                    //System.out.println(cromosoma.length);
                    //int n = cromosoma.length;
                    
                    for (int j = 0; j < cromosomaTmp.length; j++) {
                        System.out.print(cromosomaTmp[j]);
                    }
                    
                    System.out.println("\t\t"+poblacion.get(i).getValorDecimal()+"\t\t\t"+poblacion.get(i).getValorAptitud());

                //} catch (Exception e) {
                //    System.out.println("no hay cromosoma que mostrar");
                //}
                
        }
        
        */
        
    }
    
   
            
    public individuo buscarMejorIndividuo(ArrayList<individuo> poblacion){
        individuo individuoTmp=new individuo();
        int []cromosomaTmp=null;
        int []cromosoma=null;
        //double mayor = Double.MIN_VALUE;
        double mayor = -1000000000;
        //double mayor = Double.MIN_VALUE;
        int posicion=0;
        for (int i = 0; i < poblacion.size(); i++) {
                if(poblacion.get(i).getValorAptitud() >=  mayor){
                     mayor = poblacion.get(i).getValorAptitud();
                     posicion = i;
                     individuoTmp.setCromosoma(poblacion.get(posicion).getCromosoma());
                     individuoTmp.setValorDecimal(poblacion.get(posicion).getValorDecimal());
                     individuoTmp.setValorAptitud(poblacion.get(posicion).getValorAptitud());
                }
        }

        
        System.out.println("");
        mejoresIndividosDeGeneraciones.add(individuoTmp);
        System.out.println("El mejor de la generacion fue :"+mayor);
        return individuoTmp;//pendiente ver por que lo retorno 
        
    }
    
   
}
