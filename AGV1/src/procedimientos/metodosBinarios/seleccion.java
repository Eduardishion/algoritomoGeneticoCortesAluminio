/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos.metodosBinarios;
import classesIndividuos.individuo;
import java.util.ArrayList;
/**
 *
 * @author DeveloperEdu
 */
public class seleccion {
    
    /*Metodo de seleccion aleatoria que permite seleccionar individuos
    padre de forma aleatoria*/
    public ArrayList<individuo> seleccionAleatoria(ArrayList<individuo> poblacion,int numeroDeIndividuos) {
        
        ArrayList<individuo> poblacionTMPselecta = new ArrayList<individuo>();
        individuo individuo=null;
        /*
         *se re corre la generacion inicial la cual es el doble de numeroDeIndividuos
         *si la poblacion fue 10 el doble de la pobalcion es 20
         *si la poblacion fue 15 el doble de la poblacion es 30 asi sucesivamente
         */
        for (int i = 0; i < poblacion.size(); i++) {
            /*
             *por que se se van ontener dos individuos el padre uno y padre dos
             *hacemejando que solo seleccionaran dos individuos dependiendo 
             *del numero aleatorio generado 
             */
                 /*
                  *numero aleatorio generado para ontener que individuo sera elegido 
                  *el numero aleatorio esta regido por cuantos individuos se desean generar
                  *por ejemplo si se de sean generar 10 individuos se tendra un rango de 
                  *seleccion aleatoria dentro de 1 a 10, otro ejemplo si se quieren elegir 
                  *20 individuos se tieen un rango de seleccion de 1 a 20 posibilidades
                  */
                  int individuoAleayotio = (int) (Math.random() * numeroDeIndividuos);
                  //System.out.print(individuoAleayotio+",");//para mostrar los selectos 
                  //individuo = new individuo();
                  individuo = poblacion.get(individuoAleayotio);
                  poblacionTMPselecta.add(individuo);
             
        }
        System.out.println("\n");
        generadorDePoblacion muestra= new generadorDePoblacion();
        //muestra.mostrarPoblacion(poblacionTMPselecta);
        
        return poblacionTMPselecta;
    }
    
    /*
     *seleccion por ruleta 
     */
    public ArrayList<individuo> seleleccionPorRuleta(ArrayList<individuo> poblacion,int numeroDeIndividuos) {
        
        ArrayList<individuo> poblacionTMPselecta = new ArrayList<individuo>();
        individuo individuo=null;
        double sumatoria = 0;
        int selecto = 0;
        // guarda los rangos de las aptitudes para despues saber cual elegir como individuo
        double[] FxActitud = new double[numeroDeIndividuos]; 
                
        for (int i = 0; i < poblacion.size(); i++) {
            sumatoria += poblacion.get(i).getValorAptitud();
            FxActitud[i] = sumatoria;
        }
        //System.out.println("sumatoria es de :" + sumatoria); //PARA MOSTRAR LA SUMATORIA
        /*n son las veses que re repetira el proceso */
        for (int n = 0; n < poblacion.size(); n++) {
            ////////////////////////////////////////////////////////////////////
            System.out.println("\n");
            int numAleatorio = (int) (Math.random() * sumatoria);
            for (int j = 0; j < FxActitud.length; j++) {
                if (FxActitud[j] <= numAleatorio) {
                    System.out.println(FxActitud[j] + "\t\t\t > \t" + numAleatorio + ":mayor");
                    selecto = j;
                    break;
                } else {
                    System.out.println(FxActitud[j] + "\t\t\t < \t" + numAleatorio + ":menor");
                }
            }
            ////////////////////////////////////////////////////////////////////
            System.out.println("selecto es:" + selecto);//pendiente camBIAR EL 1 SOLO PARA VERIFICAR SI DEBE O ASI 
            individuo = poblacion.get(selecto);         //
            poblacionTMPselecta.add(individuo);
        }
        System.out.println("\n");
        generadorDePoblacion muestra= new generadorDePoblacion();
        //muestra.mostrarPoblacion(poblacionTMPselecta);
        
        return poblacionTMPselecta;
    }
 
    public ArrayList<individuo> seleleccionPorMuestreoEstocasticoUniversal(ArrayList<individuo> poblacion,int numeroDeIndividuos){
        
        ArrayList<individuo> poblacionTMPselecta = new ArrayList<individuo>();
        individuo individuo=null;
        double sumatoria = 0;
        int posicion = 0;
        double elegido=0;
        double[] elegidos = new double[numeroDeIndividuos];
        double[] FxActitud = new double[numeroDeIndividuos];
        
        //System.out.println("\nselectos");
        for (int i = 0; i < poblacion.size(); i++) {
            sumatoria += poblacion.get(i).getValorAptitud();
            FxActitud[i] = sumatoria;
        }
        int numAleatorio = (int) (Math.random() * sumatoria);
        
        for (int n = 0; n < poblacion.size(); n++) {
            ////////////////////////////////////////////////////////////////////
            elegido=(numAleatorio+(n*sumatoria)-sumatoria)/numeroDeIndividuos;
            
            for (int j = 0; j < FxActitud.length; j++) {
                if (FxActitud[j] <= elegido) {
                    System.out.println(FxActitud[j] + "\t\t\t > \t" + numAleatorio + ":mayor");
                    posicion = j;
                    break;
                } else {
                    System.out.println(FxActitud[j] + "\t\t\t < \t" + numAleatorio + ":menor");
                }
            }
            ////////////////////////////////////////////////////////////////////
            System.out.println("la posicion"+posicion);
            System.out.println("selecto es:" + elegido);
            individuo = poblacion.get(posicion);         //
            poblacionTMPselecta.add(individuo);
            System.out.println("\n");
        }
        //System.out.println("\n");
        generadorDePoblacion muestra= new generadorDePoblacion();
        //muestra.mostrarPoblacion(poblacionTMPselecta);
        
        return poblacionTMPselecta;
    }
        
    public ArrayList<individuo> seleccionPorTorneo(ArrayList<individuo> poblacion,int numeroDeIndividuos,int muestra){
        
        ArrayList<individuo> poblacionTMPselecta = new ArrayList<individuo>();
        individuo individuo=null;
        //valordelaFuncionActitud
        int kmuestra = muestra;/*muestra indica cuantos deseamos seleccionar*/
        int selecto = 0;/*individuo del torneo*/
        //double[] individuosDeTorneo = new double[kmuestra];
        //double[] aleatoriosGenerados = new double[kmuestra];
        
        ArrayList<individuo> individuosDeTorneos = new ArrayList<individuo>(); 
        ArrayList<Integer> aleatoriosGeneradoss = new ArrayList<Integer>();
        
        for (int n = 0; n < numeroDeIndividuos ; n++) {
            ////////////////////////////////////////////////////////////////////
            for (int k = 0; k < kmuestra; k++) {
                int numAleatorio = (int) (Math.random() * (poblacion.size()));
                System.out.println("aleatorio:"+numAleatorio);
                //individuosDeTorneo[k]=valordelaFuncionAptitud[numAleatorio];
                individuosDeTorneos.add(poblacion.get(numAleatorio));
                aleatoriosGeneradoss.add(numAleatorio);
                //aleatoriosGenerados[k]=numAleatorio;
            }
            //double mayor = Double.MIN_VALUE;
            double mayor = -1000000000;
            int posicion=0;
            for (int i = 0; i < individuosDeTorneos.size(); i++) {
                System.out.println("individuo "+i+":"+individuosDeTorneos.get(i).getValorAptitud());
                if(individuosDeTorneos.get(i).getValorAptitud() > mayor){
                    mayor=individuosDeTorneos.get(i).getValorAptitud();
                    posicion=i;
                }
            }
            //System.out.println("el aleatiro ganador es:"+aleatoriosGeneradoss.get(posicion));
            System.out.println("mayor es:"+mayor+"posicion es:"+posicion);
            ////////////////////////////////////////////////////////////////////
            int numIndividuo=(int) aleatoriosGeneradoss.get(posicion);
            
            individuo = poblacion.get(numIndividuo);         //
            poblacionTMPselecta.add(individuo);
            System.out.println("\n");
            
            individuosDeTorneos.clear();
            
        }
            
        generadorDePoblacion muestras= new generadorDePoblacion();
        //muestras.mostrarPoblacion(poblacionTMPselecta);
        
        return poblacionTMPselecta;
    }
    
}
