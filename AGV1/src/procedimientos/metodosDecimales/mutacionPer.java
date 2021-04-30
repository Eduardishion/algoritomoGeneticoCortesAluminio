/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos.metodosDecimales;

import classesIndividuos.individuoPer;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DeveloperEdu
 */
public class mutacionPer {
   
   //Metodo de muctacion de individuos para obtener una muctacion con una 
   //probabilidad de 1 entre 1000
    public ArrayList<individuoPer> mutacionPorIntercambio(ArrayList<individuoPer> poblacionCruzada,double porcentaje,int numeroDeGenes) {
        
        ArrayList<individuoPer> poblacionTMPmutada = new ArrayList<individuoPer>();
        individuoPer individuoTmp = null; 
        
        for (int i = 0; i < poblacionCruzada.size(); i++) {
            individuoTmp = new individuoPer();
            
            //se obtiene el cromosoma de cada individuo
            int cromosomaTmp[] = poblacionCruzada.get(i).getCromosoma();
            
            //se recorre de gen a gen y si la probabildad es 1 ese gen se muta
            for (int j = 0; j < cromosomaTmp.length; j++) {
                //se obtiene la probabilidad
                int probalidaDeMutacion=obtenerProvabilidadDeMutacion(porcentaje);//el valor de entrada se obtiene de la interfaz
                
                //int probalidaDeMutacion = (int) (Math.random() * total);
                Random aleatorio1 = new Random();
                int numeroAleatorio = (int) (aleatorio1.nextDouble() * (1000) +1);
                
                if (numeroAleatorio < probalidaDeMutacion) {
                    //se identifica la posicion del gen que se va a mutar 
                    //System.out.println("gen a mutar esta esta en la posicion:"+i);
                    //se genera una po
                    Random aleatorio = new Random();
                    int posicionDeGenAintercambiar = 0;
                    //se busca una posicion diferente si es que es igual a i que es la posicion selecta
                    do{
                        //se genera un aleatoria de rango de  1 al numero maximo de genes
                        
                        posicionDeGenAintercambiar=(int) (aleatorio.nextDouble() * (numeroDeGenes-1) +1);
                        //System.out.println("posicionDeGenAintercambiar>>>>>"+posicionDeGenAintercambiar);
                    }while(posicionDeGenAintercambiar == i);
                    
                    //System.out.println("posicion a cambiar:"+posicionDeGenAintercambiar);
                    
                    //int aux = cromosomaTmp[posicionDeGenAintercambiar];
                    //int aux2 = cromosomaTmp[j];
                    //cromosomaTmp[j] = aux;
                    //cromosomaTmp[posicionDeGenAintercambiar] = aux2;
                    
                    int temp = cromosomaTmp[j];
                    cromosomaTmp[j]=cromosomaTmp[posicionDeGenAintercambiar];
                    cromosomaTmp[posicionDeGenAintercambiar]=temp;  
                }
                aleatorio1 = null;
            }
            individuoTmp.setCromosoma(cromosomaTmp);
            poblacionTMPmutada.add(individuoTmp);
       
        }
        
        return poblacionTMPmutada;
    }
    
    /*Metodo para probabilidad de mutacion a qui se con solo mover el 1000 depeniendo si se quiere elevar
    el procentaje de probabilidad de mutacion por ejemplo a 100,1000,10000*/
    
    public int obtenerProvabilidadDeMutacion(double porcentaje){
        int probabilidad = 0;
            probabilidad=(int)( 1000 * porcentaje ) ;  
            //System.out.println("La probabilidad es de :"+probabilidad);
        return probabilidad;
    }
    
    public ArrayList<individuoPer> mutacionPorInsercion(ArrayList<individuoPer> poblacionCruzada,double porcentaje,int numeroDeGenes) {
        ArrayList<individuoPer> poblacionTMPmutada = new ArrayList<individuoPer>();
        individuoPer individuoTmp = null; 
        
        for (int i = 0; i < poblacionCruzada.size(); i++) {
             individuoTmp = new individuoPer();
             
             //se obtiene el cromosoma de cada individuo
            int cromosomaTmp[] = poblacionCruzada.get(i).getCromosoma();
            
            //se recorre de gen a gen y si la probabildad es 1 ese gen se muta
            for (int j = 0; j < cromosomaTmp.length; j++) {
                //se obtiene la probabilidad
                int total=obtenerProvabilidadDeMutacion(porcentaje);//el valor de entrada se obtiene de la interfaz
                int probalidaDeMutacion = (int) (Math.random() * total);
                //se verifica si la provabilidad es 1 
                if (probalidaDeMutacion == 1) {
                    
                    
                    //se identifica la posicion del gen que se va a mutar 
                    System.out.println("gen a mutar esta esta en la posicion:"+i);
                    //se genera una po
                    Random aleatorio = new Random();
                    int posicionDeGenAintercambiar = 0;
                    //se busca una posicion diferente si es que es igual a i que es la posicion selecta
                    do{
                        //se genera un aleatoria de rango de  1 al numero maximo de genes
                        
                        posicionDeGenAintercambiar=(int) (aleatorio.nextDouble() * (numeroDeGenes-1) +1);
                        System.out.println("posicionDeGenAintercambiar>>>>>"+posicionDeGenAintercambiar);
                    }while(posicionDeGenAintercambiar == i);
                    
                    
                      
                }
            }

            individuoTmp.setCromosoma(cromosomaTmp);
            poblacionTMPmutada.add(individuoTmp);
       
            
        }
        
        
        return poblacionTMPmutada;
    }

    public ArrayList<individuoPer> mutacionPorInsercion2(ArrayList<individuoPer> poblacionCruzada,double porcentaje,int numeroDeGenes) {
        System.out.println("mutacion por insercion");
        ArrayList<individuoPer> poblacionTMPmutada = new ArrayList<individuoPer>();
        individuoPer individuoTmp = null;
        
        for (int i = 0; i < poblacionCruzada.size(); i++) {
             individuoTmp = new individuoPer();
             
             int cromodomaHijo  [] = poblacionCruzada.get(i).getCromosoma(); 
             int cromosomaPadre [] = poblacionCruzada.get(i).getCromosoma();
             int cromosomaTmp [] = poblacionCruzada.get(i).getCromosoma();
             
             for (int j = 0; j < cromosomaTmp.length; j++) {
                int total=obtenerProvabilidadDeMutacion(porcentaje);//el valor de entrada se obtiene de la interfaz
                int probalidaDeMutacion = (int) (Math.random() * total);
                int numero = 0;
                if (probalidaDeMutacion == 1) {
                        System.out.println("gen a mutar"+j);
                        numero = j;
                        //numero signifaca la posicion del gen a mutar
                        //debemos obtener el otro gen con cual se intercambiara
                        Random aleatorio = new Random();
                        int posicion=(int) (aleatorio.nextDouble() * (numeroDeGenes-1) +1);
                        System.out.println("gen a cual cambiara"+posicion);
                        if(posicion > numero){
                            System.out.println("caso 1");
                            for (int k = 0; k < numero; k++) {
                                cromodomaHijo[k] = cromosomaPadre[k]; 
                            }
                            for (int k = numero; k < posicion; k++) {
                                cromodomaHijo[k] = cromosomaPadre[k+1]; 
                            }
                            for (int k = posicion+1; k < cromodomaHijo.length; k++) {
                                cromodomaHijo[k] = cromosomaPadre[k]; 
                            }
                            cromodomaHijo[posicion]=cromosomaPadre[numero];
                        }  
                        
                        if(numero > posicion){
                            System.out.println("caso 2");
                            for (int k = 0; k < posicion; k++) {
                                cromodomaHijo[k]=cromosomaPadre[k];
                            }
                            for (int k = posicion+1; k < numero+1; k++) {
                                cromodomaHijo[k]=cromosomaPadre[k-1];
                            }
                            for (int k = numero+1; k < cromodomaHijo.length; k++) {
                                cromodomaHijo[posicion]=cromosomaPadre[numero];
                            }
                        }
                        if(numero == posicion){
                            System.out.println("caso3");
                            cromodomaHijo=cromosomaPadre;
                        }
                }
             }
            individuoTmp.setCromosoma(cromodomaHijo);
            poblacionTMPmutada.add(individuoTmp);
        }
        return poblacionTMPmutada;
    }
    
    
    public ArrayList<individuoPer> mutacionPorInsercion3(ArrayList<individuoPer> poblacionCruzada,double porcentaje,int numeroDeGenes) {
        //System.out.println("mutacion por insercion");
        ArrayList<individuoPer> poblacionTMPmutada = new ArrayList<individuoPer>();
        individuoPer individuoTmp = null;
        
        for (int i = 0; i < poblacionCruzada.size(); i++) {
            individuoTmp = new individuoPer();
            int cromodomaHijo[]= poblacionCruzada.get(i).getCromosoma();
            
            Random aleatorio1 = new Random();
            Random aleatorio2 = new Random();
                
            int pos1 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
            int pos2= (int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);
            
            while(pos1 >= pos2) {
                    pos1 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                    pos2= (int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);
            }
                
            //System.out.println("r1: "+pos1);
            //System.out.println("r2: "+pos2);
            
            for(int j = pos2-1; j > pos1 ; j--){       
		int temp2 = cromodomaHijo[j+1];
		cromodomaHijo[j+1] = cromodomaHijo[j];
		cromodomaHijo[j] = temp2; 
            }
             
            individuoTmp.setCromosoma(cromodomaHijo);
            poblacionTMPmutada.add(individuoTmp);
        }
        return poblacionTMPmutada;
    }
    
    
    
    //ejemplo de de mutacion por intercambio
    public int[] mutacionPorIntercabioPruevas(int cromosomaPadre[]){
        int cromosomaPadreTmp[]=cromosomaPadre.clone();
        int numeroDeGenes=cromosomaPadreTmp.length;
        
        Random aleatorio1 = new Random();
        int pos1 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
        Random aleatorio2 = new Random();
        int pos2 =0; 
        do{
          pos2=(int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);
        } while(pos2==pos1);
                
        int temp = cromosomaPadreTmp[pos1];
        cromosomaPadreTmp[pos1]=cromosomaPadreTmp[pos2];
        cromosomaPadreTmp[pos2]=temp;       
        
        return cromosomaPadreTmp;
    }
    
    public int[] mutacionPorInsercionPruevas(int cromosomaPadre[]){
        int cromosomaPadreTmp[]=cromosomaPadre.clone();
        int numeroDeGenes=cromosomaPadreTmp.length;
        
        Random aleatorio1 = new Random();
        int pos1 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
        Random aleatorio2 = new Random();
        int pos2 =0; 
        do{
          pos2=(int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);
        } while(pos2>=pos1);
                
        for (int i = pos2-1; i < pos1; i--) {
            int temp = cromosomaPadreTmp[i+1];
            cromosomaPadreTmp[i+1]=cromosomaPadreTmp[i];
            cromosomaPadreTmp[i]=temp; 
        }

        return cromosomaPadreTmp;
    }
}