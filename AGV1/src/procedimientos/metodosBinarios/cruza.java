/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos.metodosBinarios;

import classesIndividuos.*;
import java.util.Random;
import java.util.*;

/**
 *
 * @author DeveloperEdu
 */
public class cruza {
    
    /*Matodo de para cruzar los individuos padre que se han seleccionado 
    previamente con un punto de corte (Operador de cruze en un punto de manera 
    aleatoria X1PA)*/
    ArrayList usados = new ArrayList();       /*para saber cortes ya generados*/

    public ArrayList<individuo> cruzaUnPunto(ArrayList<individuo> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
             
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                /*rango que incia desde desde 0 a n-1*/
                Random aleatorio = new Random();
                int puntoDecorte = (int) (aleatorio.nextDouble() * (numeroDeGenes-1) + 1);
                //int puntoDecorte = (int) (Math.random() * numeroDeGenes );
                System.out.println("\npc=" + puntoDecorte);
                individuo1 = new individuo();  
                individuo2 = new individuo();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                
                for (int j = 0; j < numeroDeGenes; j++) {
                    System.out.print(cromosomaPadre1tmp[j]);
                }
                System.out.println(""); 
                for (int j = 0; j < numeroDeGenes; j++) {
                    System.out.print(cromosomaPadre2tmp[j]);
                }
                /*para individuo 1*/
                System.out.print("\nNuevo inviduo 1:\t");
               
                for (int j = 0; j < puntoDecorte; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                        cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                        System.out.print(cromosomaHijo1tmp[j]);
                }
                System.out.print("\t");
                for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo1tmp[j]);
                }
                /*para individuo 2*/
                System.out.print("\nNuevo inviduo 2:\t");
                
                for (int j = 0; j < puntoDecorte; j++) {
                        //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                        System.out.print(cromosomaHijo2tmp[j]);
                }
                System.out.print("\t");
                for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                        //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo2tmp[j]);
                }
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacion muestra= new generadorDePoblacion();
        //muestra.mostrarPoblacion(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuo> cruzaDedosPuntos(ArrayList<individuo> poblacionSelecta,int numeroDeGenes) {
         
        
        
        
        
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                //para numeros aleatotitod    
                Random aleatorio1 = new Random();
                int puntoDecorte1 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                Random aleatorio2 = new Random();
                int puntoDecorte2 =0; 
                do{
                    puntoDecorte2=(int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);
                } while(puntoDecorte2==puntoDecorte1);
               
                //System.out.println("\npc1:"+puntoDecorte1);
                //System.out.println("\npc2:"+puntoDecorte2);
                
                if(puntoDecorte2 < puntoDecorte1){
                    int aux,aux2;
                    aux=puntoDecorte2;
                    aux2=puntoDecorte1;
                    puntoDecorte1=aux;
                    puntoDecorte2=aux2;
                }
                System.out.print("\npc1: "+puntoDecorte1);
                System.out.print("\npc2: "+puntoDecorte2);
                System.out.println("");
                individuo1 = new individuo();  
                individuo2 = new individuo();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();

                /*para individuo 1*/
                System.out.print("\nNuevo inviduo 1:\t");
                for (int j = 0; j < puntoDecorte1; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                        cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                        System.out.print(cromosomaHijo1tmp[j]);
                }
                System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo1tmp[j]);
                }
                System.out.print("\t");
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo1tmp[j]);
                }
                System.out.print("\nNuevo inviduo 2:\t");
                for (int j = 0; j < puntoDecorte1; j++) {
                        //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                        System.out.print(cromosomaHijo2tmp[j]);
                }
                
                System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo2tmp[j]);
                }
                
                System.out.print("\t");
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {
                        //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        System.out.print(cromosomaHijo2tmp[j]);
                }
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacion muestra= new generadorDePoblacion();
        //muestra.mostrarPoblacion(individuosCruzadosTmp);
        muestra.mostrarPoblacion(poblacionSelecta, numeroDeGenes);
        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuo> cruzedeUnPuntoUniforme(ArrayList<individuo> poblacionSelecta,int numeroDeGenes){
        
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        if(numeroDeGenes%2==0){ //caso cuando el cromosoma es par
            int puntoDecorte=numeroDeGenes/2;
            for (int x = 0; x < poblacionSelecta.size(); x++) {
                if (x % 2 == 0 || x == 0) {
                    
                    System.out.println("\n\npc=" + puntoDecorte);
                    individuo1 = new individuo();  
                    individuo2 = new individuo();
                    cromosomaHijo1tmp = new int[numeroDeGenes];
                    cromosomaHijo2tmp = new int[numeroDeGenes];
                    cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                    cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();

                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre1tmp[j]);
                    }
                    System.out.println(""); 
                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre2tmp[j]);
                    }
                    /*para individuo 1*/
                    System.out.print("\nNuevo inviduo 1:\t");

                    for (int j = 0; j < puntoDecorte; j++) {
                            cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                            cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                            System.out.print(cromosomaHijo1tmp[j]);
                    }
                    System.out.print("\t");
                    for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                            cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                            cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                            System.out.print(cromosomaHijo1tmp[j]);
                    }
                    /*para individuo 2*/
                    System.out.print("\nNuevo inviduo 2:\t");

                    for (int j = 0; j < puntoDecorte; j++) {
                            //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                            System.out.print(cromosomaHijo2tmp[j]);
                    }
                    System.out.print("\t");
                    for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                            //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                            System.out.print(cromosomaHijo2tmp[j]);
                    }
                    individuo1.setCromosoma(cromosomaHijo1tmp);
                    individuo2.setCromosoma(cromosomaHijo2tmp);
                    individuosCruzadosTmp.add(individuo1);
                    individuosCruzadosTmp.add(individuo2);

                }
            }

        }else{//en caso de el cromosoma es impar
            int puntoDecorte=((numeroDeGenes/2)+1);
            for (int x = 0; x < poblacionSelecta.size(); x++) {
                if (x % 2 == 0 || x == 0) {
                    System.out.println("\n\npc=" + puntoDecorte);
                    individuo1 = new individuo();  
                    individuo2 = new individuo();
                    cromosomaHijo1tmp = new int[numeroDeGenes];
                    cromosomaHijo2tmp = new int[numeroDeGenes];
                    cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                    cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();

                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre1tmp[j]);
                    }
                    System.out.println(""); 
                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre2tmp[j]);
                    }
                    /*para individuo 1*/
                    System.out.print("\nNuevo inviduo 1:\t");

                    for (int j = 0; j < puntoDecorte; j++) {
                            cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                            cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                            System.out.print(cromosomaHijo1tmp[j]);
                    }
                    System.out.print("\t");
                    for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                            cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                            cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                            System.out.print(cromosomaHijo1tmp[j]);
                    }
                    /*para individuo 2*/
                    System.out.print("\nNuevo inviduo 2:\t");

                    for (int j = 0; j < puntoDecorte; j++) {
                            //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                            System.out.print(cromosomaHijo2tmp[j]);
                    }
                    System.out.print("\t");
                    for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                            //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                            System.out.print(cromosomaHijo2tmp[j]);
                    }
                    individuo1.setCromosoma(cromosomaHijo1tmp);
                    individuo2.setCromosoma(cromosomaHijo2tmp);
                    individuosCruzadosTmp.add(individuo1);
                    individuosCruzadosTmp.add(individuo2);
                }
            }
           
        }
         return individuosCruzadosTmp;
    } 
    //para identificar que deneracion es y el cual fue el individuo mejor de la denaracion anterior
    public ArrayList<individuo> cruzedeUnpuntoManeraApaptativa(ArrayList<individuo> poblacionSelecta,int generacion,int numeroDeGenes){
        
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        int []cromosomaCortes=null;
        
        //generacion == 1 significa que ya no es la generacion inicial si no la segunda 
        //emtpomces el punto de corte es es aleatorio 
        if(generacion == 1){ 
                //System.out.println("ES LA PRIMERA GENERACION ");
                for (int x = 0; x < poblacionSelecta.size(); x++) {
                        if (x % 2 == 0 || x == 0) {
                            //System.out.println("\n"+x);
                            //System.out.println("\n"+(x+1));
                            /*rango que incia desde desde 0 a 7*/
                            Random aleatorio = new Random();
                            int puntoDecorte = (int) (aleatorio.nextDouble() * (numeroDeGenes-1) +1);
                            //int puntoDecorte = (int) (Math.random() * numeroDeGenes );

                            System.out.println("\n\npc=" + puntoDecorte);
                            individuo1 = new individuo();  
                            individuo2 = new individuo();
                            cromosomaHijo1tmp = new int[numeroDeGenes];
                            cromosomaHijo2tmp = new int[numeroDeGenes];
                            cromosomaCortes = new int[numeroDeGenes];
                            cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                            cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                            
                            
                            for (int j = 0; j < numeroDeGenes; j++) {
                                System.out.print(cromosomaPadre1tmp[j]);
                            }
                            System.out.println(""); 
                            for (int j = 0; j < numeroDeGenes; j++) {
                                System.out.print(cromosomaPadre2tmp[j]);
                            }
                            /*para individuo 1*/
                            System.out.print("\nNuevo inviduo 1:\t");

                            for (int j = 0; j < puntoDecorte; j++) {
                                    cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                    cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                    System.out.print(cromosomaHijo1tmp[j]);
                            }
                            System.out.print("\t");
                            for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                                    cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                    cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                    System.out.print(cromosomaHijo1tmp[j]);
                            }
                            
                            /*para individuo 2*/
                            System.out.print("\nNuevo inviduo 2:\t");

                            for (int j = 0; j < puntoDecorte; j++) {
                                    //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                    System.out.print(cromosomaHijo2tmp[j]);
                            }
                            System.out.print("\t");
                            for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                                    //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                    System.out.print(cromosomaHijo2tmp[j]);
                            }
                            
                            /*****asociacion de punto de corte individuos*****************/
                            for (int i = 0; i < numeroDeGenes; i++) {
                                if(i==puntoDecorte){
                                        cromosomaCortes[i-1]=1; //pendiente ya que esa en los cortes
                                    }else{
                                        cromosomaCortes[i]=0;
                                    }
                            }
                            /*****asociacion de punto de corte individuos*****************/

                            individuo1.setCromosoma(cromosomaHijo1tmp);
                            individuo2.setCromosoma(cromosomaHijo2tmp);
                            individuo1.setCromosomaAsociativo(cromosomaCortes);
                            individuo2.setCromosomaAsociativo(cromosomaCortes);
                            individuosCruzadosTmp.add(individuo1);
                            individuosCruzadosTmp.add(individuo2);
                        }
                }
                //solo se muestra la generacion anterior
                System.out.println("\n");
                System.out.println("Cromosoma asociativo\tIndividuo\t\tValor decimal\t\tValor Aptitud");
                for (int i = 0; i < individuosCruzadosTmp.size(); i++) {
                    int[] cromosomaAsociativo = individuosCruzadosTmp.get(i).getCromosomaAsociativo();
                    for (int j = 0; j <  cromosomaAsociativo.length; j++) {            
                        System.out.print(cromosomaAsociativo[j]);
                    }
                    System.out.print("\t\t");
                    /*para saber cual es el corte que tiene el individuo*/
                    int[] cromosoma=individuosCruzadosTmp.get(i).getCromosoma();
                    for (int j = 0; j < cromosoma.length; j++) {
                        System.out.print(cromosoma[j]);
                    }
                    System.out.println("\t\t"+individuosCruzadosTmp.get(i).getValorDecimal()+"\t\t\t"+individuosCruzadosTmp.get(i).getValorAptitud());  

                }
        }else{  
              //en caso contrario de que genetacion anterior ya se se halla obtenido el punto de corte de manera aleatoria
              //se buscara buscara el mejor individuo de la generacion anterior y se toma el corte que tuvo como su corte
              //System.out.println("El mejor individuos a tomar es:"+ mejorIndivioGA.getValorAptitud());//muestro su valor de aptitud
            
                System.out.println("");
                int puntoDecorte=0;
                int corteSeleccionado=0;
                double mayor = -1000000000;
                int posicion=0;
                for (int i = 0; i < poblacionSelecta.size(); i++) {
                    if(poblacionSelecta.get(i).getValorAptitud() >= mayor){
                        mayor = poblacionSelecta.get(i).getValorAptitud();
                        posicion=i;
                    }

                }
                System.out.println("Cromosoma asociativo\tIndividuo\t\tValor decimal\t\tValor Aptitud");
                int[] cromosomaAsociativo=poblacionSelecta.get(posicion).getCromosomaAsociativo();
                for (int j = 0; j <  cromosomaAsociativo.length; j++) {            
                    System.out.print(cromosomaAsociativo[j]);
                    if(cromosomaAsociativo[j] == 1){
                           corteSeleccionado=j;
                    }
                }
                System.out.print("\t\t");
                /*para saber cual es el corte que tiene el individuo*/
                int[] cromosoma=poblacionSelecta.get(posicion).getCromosoma();
                for (int j = 0; j < cromosoma.length; j++) {
                    System.out.print(cromosoma[j]);
                }
                System.out.println("\t\t"+poblacionSelecta.get(posicion).getValorDecimal()+"\t\t\t"+poblacionSelecta.get(posicion).getValorAptitud());  
                
                puntoDecorte=(corteSeleccionado+1);
                System.out.println("pc:"+puntoDecorte);
                
                for (int x = 0; x < poblacionSelecta.size(); x++) {
                            if (x % 2 == 0 || x == 0) {

                                individuo1 = new individuo();  
                                individuo2 = new individuo();
                                cromosomaHijo1tmp = new int[numeroDeGenes];
                                cromosomaHijo2tmp = new int[numeroDeGenes];
                                cromosomaCortes = new int[numeroDeGenes];
                                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                                
                                System.out.println(""); 
                                for (int j = 0; j < numeroDeGenes; j++) {
                                    System.out.print(cromosomaPadre1tmp[j]);
                                }
                                System.out.println(""); 
                                for (int j = 0; j < numeroDeGenes; j++) {
                                    System.out.print(cromosomaPadre2tmp[j]);
                                }
                                System.out.println("");
                                /*para individuo 1*/
                                System.out.print("\nNuevo inviduo 1:\t");

                                for (int j = 0; j < puntoDecorte; j++) {
                                        cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                        cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                        System.out.print(cromosomaHijo1tmp[j]);
                                }
                                System.out.print("\t");
                                for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                        System.out.print(cromosomaHijo1tmp[j]);
                                }

                                /*para individuo 2*/
                                System.out.print("\nNuevo inviduo 2:\t");

                                for (int j = 0; j < puntoDecorte; j++) {
                                        //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                        System.out.print(cromosomaHijo2tmp[j]);
                                }
                                System.out.print("\t");
                                for (int j = puntoDecorte; j < numeroDeGenes; j++) {
                                        //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                        System.out.print(cromosomaHijo2tmp[j]);
                                }

                                
                                //*****asociacion de punto de corte individuos*****************
                                for (int i = 0; i < numeroDeGenes; i++) {
                                    if(i==puntoDecorte){
                                            cromosomaCortes[i-1]=1; //pendiente ya que esa en los cortes
                                        }else{
                                            cromosomaCortes[i]=0;
                                        }
                                }
                                //*****asociacion de punto de corte individuos*****************

                                individuo1.setCromosoma(cromosomaHijo1tmp);
                                individuo2.setCromosoma(cromosomaHijo2tmp);
                                individuo1.setCromosomaAsociativo(cromosomaCortes);
                                individuo2.setCromosomaAsociativo(cromosomaCortes);
                                individuosCruzadosTmp.add(individuo1);
                                individuosCruzadosTmp.add(individuo2);

                            }
                }         
        }
        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuo> cruzeMultipuntoAleatorio(ArrayList<individuo> poblacionSelecta,int numeroDeGenes,int numeroCortes){
        
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        int numeroDepuntosAletoriosMaximos=numeroDeGenes;
        int numeroDepuntosAgenerar=numeroCortes;
        /*este parametro es cambiante lo da el usuario paro no debe de revasar
        la cantidad maxima de genes del cromosoma ni el la posicion menor ni en la mayor el cromosoma inicia
        desde la posicion 1 y termina el la pocion n-1 osea si el cromosoma es de 8 el maximo es 7*/
        //individuos = (int[][])redimencionarArreglo(individuos,numeroDeIndividuos);
        int corte;
        int puntosDecorte[]=new int [numeroDepuntosAgenerar];
        ArrayList  aleatorios = new ArrayList();
    
        System.out.println("");
        for (int x = 0; x < poblacionSelecta.size(); x++) {//x es el numero de individuos por deneracion
            if (x % 2 == 0 || x == 0) {//identificamos cada uno de los individuos en par para cruzar cada par de individuos padre
                
                individuo1 = new individuo();  
                individuo2 = new individuo();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
          
                for (int j = 0; j < numeroDeGenes; j++) {
                    System.out.print(cromosomaPadre1tmp[j]);
                }
                System.out.println(""); 
                for (int j = 0; j < numeroDeGenes; j++) {
                    System.out.print(cromosomaPadre2tmp[j]);
                }
                System.out.println(""); 
                
                usados.clear(); 
                aleatorios=generaNumerosAleatorios(numeroDepuntosAgenerar,numeroDepuntosAletoriosMaximos);
                 for (int k = 0; k < aleatorios.size(); k++) {
                     System.out.print(aleatorios.get(k)+",");
                     
                         /*Segmento inicial */
                           if(k==0){//k == 0 indica que es el primer corte 
                              int auxPC=(int)aleatorios.get(k);  
                                  for (int j = 0; j < auxPC; j++) {//j se utiliza para rocorrer entra cada cromosoma de indiduo
                                      cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                      cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                      System.out.print(cromosomaHijo1tmp[j]);
                                  }
                            }
                          /*Segmento inicial */
                          
                          /*segmentos intermedios*/
                          if(k != 0 && k < aleatorios.size()){ // si k es diferente de cero dice que es la siguiente corte despues del primero
                              int auxPC1=(int)aleatorios.get(k-1);
                              int auxPC2=(int)aleatorios.get(k);
                                    for (int j = auxPC1; j < auxPC2; j++) {
                                         cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                         cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                         System.out.print(cromosomaHijo1tmp[j]);
                                    }
                          } 
                          /*segmento intermedios*/
                          
                          /*segmento final */
                            if(k == aleatorios.size()-1){ //if k es igual al tamaño de aleatorio entonces es el ultimo corte
                                int auxPC3=(int)aleatorios.get(k); 
                                    for (int j = auxPC3; j < numeroDeGenes; j++) {
                                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                        System.out.print(cromosomaHijo1tmp[j]);
                                    }
                                
                            }
                          /*segmento final*/
                          /*
                            for (int j = 0; j < puntoDecorte1; j++) {
                            //cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                            System.out.print(cromosomaHijo2tmp[j]);
                            }

                            System.out.print("\t");
                            for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                                    //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                    System.out.print(cromosomaHijo2tmp[j]);
                            }

                            System.out.print("\t");
                            for (int j = puntoDecorte2; j < numeroDeGenes; j++) {
                                    //cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                    System.out.print(cromosomaHijo2tmp[j]);
                            }
                          */
                          System.out.println("");

                 }
                 individuo1.setCromosoma(cromosomaHijo1tmp);
                 individuo2.setCromosoma(cromosomaHijo2tmp);
                 individuosCruzadosTmp.add(individuo1);
                 individuosCruzadosTmp.add(individuo2);
                 System.out.println("\n----------");   
                 aleatorios.clear();
                 
            } 
            //usados.clear();
        }
        return individuosCruzadosTmp;
    }

    public ArrayList generaNumerosAleatorios(int numeroDepuntosAgenerar,int numeroDepuntosAletoriosMaximos){
        //arraylist temporal que alamcenara los numero aleatorios 
        //dependiente de cuantos aleatorios se necesiten
        ArrayList listaNumeros = new ArrayList  (numeroDepuntosAgenerar);
        int numeroTmp;
        for (int i = 0; i < numeroDepuntosAgenerar; i++) {
                //el metodo aleatorio3 es el que genera los numeros
                //iniciando desde 1 hasta el numero maximo de puntos de cortes posibles 
                //por el cromosoma
                numeroTmp=aleatorio3(1,numeroDepuntosAletoriosMaximos);
                listaNumeros.add(numeroTmp);
        }
        //por ultimo solo ordenamos los numeros generados
        Collections.sort(listaNumeros);
        return listaNumeros;
    }
    
     /*funcion de numeros aleatorios por rango especifico cercion 2*/
    public int aleatorio3(int minimo, int maximo){ 
        Random aleatorio = new Random();
        if (usados.size() != (maximo - minimo)) { 
            int numero=0;
            boolean repe = false;
            do {
                //numero =(int) Math.floor(Math.random()*(maximo-minimo+1))+minimo;
                numero =(int) (aleatorio.nextDouble() * (maximo-1) + minimo);
                repe=repetido(numero);
                if(repe==true){
                    //System.out.println("esta repetido");
                }
                //no sale del while hasta que el numero ya no sea repetido
            }while (repe != false);
            usados.add(numero);      
            return numero; 
        }else{
            return 0; 
        }
    }
    //metodo para verificar si el numero generado ya se repitio
    //o es uno nuevo sin repertirse se verifica en la lista 
    //arraylist usados si ya exite el numero 
    public boolean repetido(int numero){ 
        boolean repe = false;
        for (int i = 0; i < usados.size(); i++) {
            int auxRepe=((int)usados.get(i));
            if (numero == auxRepe) {
                repe = true; 
            }
        }
        return repe; 
    } 
    
    public ArrayList<individuo> cruzaMultipuntoUniforme(ArrayList<individuo> poblacionSelecta,int numeroDeGenes,int numeroCortes){
        //System.out.println("\ncruza uniforme ");
            ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
            int numeroDepuntosAletoriosMaximos=numeroDeGenes;
            int numeroDepuntosAgenerar=numeroCortes;/*este parametro es cambiante lo da el usuario paro no debe de revasar
            la cantidad maxima de genes del cromosoma ni el la posicion menor ni en la mayor el cromosoma inicia
            desde la posicion 1 y termina el la pocion n-1 osea si el cromosoma es de 8 el maximo es 7*/
            individuo individuo1 = null; 
            individuo individuo2 = null;
            int []cromosomaHijo1tmp=null;
            int []cromosomaHijo2tmp=null;
            int []cromosomaPadre1tmp=null;
            int []cromosomaPadre2tmp=null;
            
            int corte;
            int puntosDecorte[]=new int [numeroDepuntosAgenerar];
            ArrayList  aleatorios = new ArrayList();
            
            
            
            usados.clear();
            aleatorios=generaNumerosAleatorios(numeroDepuntosAgenerar,numeroDepuntosAletoriosMaximos);
            for (int x = 0; x < poblacionSelecta.size(); x++) {//x es el numero de individuos por deneracion
                if (x % 2 == 0 || x == 0) {//identificamos cada uno de los individuos en par para cruzar cada par de individuos padre
                    
                    individuo1 = new individuo();  
                    individuo2 = new individuo();
                    cromosomaHijo1tmp = new int[numeroDeGenes];
                    cromosomaHijo2tmp = new int[numeroDeGenes];
                    cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                    cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                    
                    for (int j = 0; j < numeroDeGenes; j++) {
                    System.out.print(cromosomaPadre1tmp[j]);
                    }
                    System.out.println(""); 
                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre2tmp[j]);
                    }
                    System.out.println(""); 
                    
                    for(int k=0;k<aleatorios.size();k++) {//inicio de recorrido de vector de cortes
                        System.out.print("\nPC"+k+":"+aleatorios.get(k)+",");//mostrar el vector de cortes generado
                        //System.out.println("K:"+k);
                                ///////////////////////////////////para hacer cruze multipunto///////////////////////////////////////////////////////////
                        /*para individuo 1*/
                              /*Segmento inicial */
                                if(k==0){//k == 0 indica que es el primer corte 
                                  int auxPC=(int)aleatorios.get(k);  
                                      for (int j = 0; j < auxPC; j++) {//j se utiliza para rocorrer entra cada cromosoma de indiduo
                                          cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                          cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                          System.out.print(cromosomaHijo1tmp[j]);
                                      }
                                }
                              /*Segmento inicial */

                              /*segmento intermedio*/
                              if(k != 0 && k < aleatorios.size()){ // si k es diferente de cero dice que es la siguiente corte despesu del primero
                                  int auxPC1=(int)aleatorios.get(k-1);
                                  int auxPC2=(int)aleatorios.get(k);
                                        for (int j = auxPC1; j < auxPC2; j++) {
                                             cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                             cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                             System.out.print(cromosomaHijo1tmp[j]);
                                        }

                              } 
                              /*segmento intermedio*/

                              /*segmento final */
                                if(k == aleatorios.size()-1){ //if k es igual al tamaño de aleatorio entonces es el ultimo corte
                                    int auxPC3=(int)aleatorios.get(k); 
                                           for (int j = auxPC3; j < numeroDeGenes; j++) {
                                                cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                                cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                                System.out.print(cromosomaHijo1tmp[j]);
                                           }
                                }
                              /*segmento final*/

                        /*para individuo 1*/

                    }///fin de recorrido de vector de cortes
                    individuo1.setCromosoma(cromosomaHijo1tmp);
                    individuo2.setCromosoma(cromosomaHijo2tmp);
                    individuosCruzadosTmp.add(individuo1);
                    individuosCruzadosTmp.add(individuo2);
                    System.out.println("\n----------");   
                   
                } 
            }

        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuo> cruzaMultipuntoAdaptativa(ArrayList<individuo> poblacionSelecta,int generacion,int numeroDeGenes,int numeroCortes){
        ArrayList<individuo> individuosCruzadosTmp = new ArrayList<individuo>();
        individuo individuo1 = null; 
        individuo individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        int []cromosomaCortes=null;
        
        int auxPC=0;
        int auxPC1=0;
        int auxPC2=0;
        int auxPC3=0;
        
        if(generacion == 1){
            int numeroDepuntosAletoriosMaximos=numeroDeGenes;
            int numeroDepuntosAgenerar=numeroCortes;/*este parametro es cambiante lo da el usuario paro no debe de revasar
            la cantidad maxima de genes del cromosoma ni el la posicion menor ni en la mayor el cromosoma inicia
            desde la posicion 1 y termina el la pocion n-1 osea si el cromosoma es de 8 el maximo es 7*/
            //individuos = (int[][])redimencionarArreglo(individuos,numeroDeIndividuos);
            int corte;
            int puntosDecorte[]=new int [numeroDepuntosAgenerar];
            ArrayList  aleatorios = new ArrayList();


            for (int x = 0; x < poblacionSelecta.size(); x++) {//x es el numero de individuos por deneracion
                if (x % 2 == 0 || x == 0) {//identificamos cada uno de los individuos en par para cruzar cada par de individuos padre
                    
                    individuo1 = new individuo();  
                    individuo2 = new individuo();
                    cromosomaHijo1tmp = new int[numeroDeGenes];
                    cromosomaHijo2tmp = new int[numeroDeGenes];
                    cromosomaCortes = new int[numeroDeGenes];
                    cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                    cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();

                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre1tmp[j]);
                    }
                    System.out.println(""); 
                    for (int j = 0; j < numeroDeGenes; j++) {
                        System.out.print(cromosomaPadre2tmp[j]);
                    }
                    System.out.println(""); 
                    
                    usados.clear();
                    aleatorios=generaNumerosAleatorios(numeroDepuntosAgenerar,numeroDepuntosAletoriosMaximos);
                    for(int k=0;k<aleatorios.size();k++) {///inicio de recorrido de vector de cortes
                        System.out.print("\nPC"+k+":"+aleatorios.get(k)+",");//mostrar el vector de cortes generado
                        //System.out.println("K:"+k);
                                ///////////////////////////////////para hacer cruze multipunto///////////////////////////////////////////////////////////
                        /*Segmento inicial */
                           
                           if(k==0){//k == 0 indica que es el primer corte 
                              auxPC=(int)aleatorios.get(k);
                                  for (int j = 0; j < auxPC; j++) {//j se utiliza para rocorrer entra cada cromosoma de indidu
                                      cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                      cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                      System.out.print(cromosomaHijo1tmp[j]);
                                  }
                            }
                          /*Segmento inicial */
                          
                          /*segmentos intermedios*/
                           
                           if(k != 0 && k < aleatorios.size()){ // si k es diferente de cero dice que es la siguiente corte despues del primero
                                    auxPC1=(int)aleatorios.get(k-1);
                                    auxPC2=(int)aleatorios.get(k);
                                    for (int j = auxPC1; j < auxPC2; j++) {
                                         cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                         cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                         System.out.print(cromosomaHijo1tmp[j]);
                                    }
                           } 
                          /*segmento intermedios*/
                          
                          /*segmento final */
                           
                           if(k == aleatorios.size()-1){ //if k es igual al tamaño de aleatorio entonces es el ultimo corte
                                    auxPC3=(int)aleatorios.get(k);
                                    for (int j = auxPC3; j < numeroDeGenes; j++) {
                                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                        System.out.print(cromosomaHijo1tmp[j]);
                                    }
                                
                           }
               
                            //*****asociacion de punto de corte individuos*****************
                                for (int i = 0; i < numeroDeGenes; i++) {
                                    if(i == auxPC || i == auxPC1 || i==auxPC2 || i==auxPC3){
                                        System.out.println("\t\t>>>>>>"+i);
                                        cromosomaCortes[i]=1; //pendiente ya que esa en los cortes
                                         //cromosomaCortes[i-1]=1; //pendiente ya que esa en los cortes
                                    }else{
                                        cromosomaCortes[i]=1;
                                    }
                                }
                            //*****asociacion de punto de corte individuos*****************
                           
                     }
                    
                     individuo1.setCromosoma(cromosomaHijo1tmp);
                     individuo2.setCromosoma(cromosomaHijo2tmp);
                     individuo1.setCromosomaAsociativo(cromosomaCortes);
                     individuo2.setCromosomaAsociativo(cromosomaCortes);
                     individuosCruzadosTmp.add(individuo1);
                     individuosCruzadosTmp.add(individuo2);
                     System.out.println("\n----------");     
                     aleatorios.clear();
                 }
            }
            
            //solo se muestra la generacion anterior
                System.out.println("\n");
                System.out.println("Cromosoma asociativo\tIndividuo\t\tValor decimal\t\tValor Aptitud");
                for (int i = 0; i < individuosCruzadosTmp.size(); i++) {
                    int[] cromosomaAsociativo = individuosCruzadosTmp.get(i).getCromosomaAsociativo();
                    for (int j = 0; j <  cromosomaAsociativo.length; j++) {            
                        System.out.print(cromosomaAsociativo[j]);
                    }
                    System.out.print("\t\t");
                    /*para saber cual es el corte que tiene el individuo*/
                    int[] cromosoma=individuosCruzadosTmp.get(i).getCromosoma();
                    for (int j = 0; j < cromosoma.length; j++) {
                        System.out.print(cromosoma[j]);
                    }
                    System.out.println("\t\t"+individuosCruzadosTmp.get(i).getValorDecimal()+"\t\t\t"+individuosCruzadosTmp.get(i).getValorAptitud());  

               }
        }else{
                System.out.println("");
                ArrayList  aleatorios = new ArrayList();
                int puntoDecorte=0;
                int corteSeleccionado=0;
                double mayor = -1000000000;
                int posicion=0;
                for (int i = 0; i < poblacionSelecta.size(); i++) {
                    if(poblacionSelecta.get(i).getValorAptitud() >= mayor){
                        mayor = poblacionSelecta.get(i).getValorAptitud();
                        posicion=i;
                    }

                }
                System.out.println("Cromosoma asociativo\tIndividuo\t\tValor decimal\t\tValor Aptitud");
                int[] cromosomaAsociativo=poblacionSelecta.get(posicion).getCromosomaAsociativo();
                for (int j = 0; j <  cromosomaAsociativo.length; j++) {            
                    System.out.print(cromosomaAsociativo[j]);
                    if(cromosomaAsociativo[j] == 1){
                           aleatorios.add(j);

                    }
                }
                System.out.print("\t\t");
                /*para saber cual es el corte que tiene el individuo*/
                int[] cromosoma=poblacionSelecta.get(posicion).getCromosoma();
                for (int j = 0; j < cromosoma.length; j++) {
                    System.out.print(cromosoma[j]);
                }
                System.out.println("\t\t"+poblacionSelecta.get(posicion).getValorDecimal()+"\t\t\t"+poblacionSelecta.get(posicion).getValorAptitud());  
                
                for (int i = 0; i < aleatorios.size(); i++) {
                    System.out.println(aleatorios.get(i)+",");
                }
                
                for (int x = 0; x < poblacionSelecta.size(); x++) {//x es el numero de individuos por deneracion
                    if (x % 2 == 0 || x == 0) {//identificamos cada uno de los individuos en par para cruzar cada par de individuos padre

                        individuo1 = new individuo();  
                        individuo2 = new individuo();
                        cromosomaHijo1tmp = new int[numeroDeGenes];
                        cromosomaHijo2tmp = new int[numeroDeGenes];
                        cromosomaCortes = new int[numeroDeGenes];
                        cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                        cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();

                        for (int j = 0; j < numeroDeGenes; j++) {
                            System.out.print(cromosomaPadre1tmp[j]);
                        }
                        System.out.println(""); 
                        for (int j = 0; j < numeroDeGenes; j++) {
                            System.out.print(cromosomaPadre2tmp[j]);
                        }
                        System.out.println(""); 

                        for(int k=0;k<aleatorios.size();k++) {///inicio de recorrido de vector de cortes
                            System.out.print("\nPC"+k+":"+aleatorios.get(k)+",");//mostrar el vector de cortes generado
                            //System.out.println("K:"+k);
                                    ///////////////////////////////////para hacer cruze multipunto///////////////////////////////////////////////////////////
                            /*Segmento inicial */

                               if(k==0){//k == 0 indica que es el primer corte 
                                  auxPC=(int)aleatorios.get(k);
                                      for (int j = 0; j < auxPC; j++) {//j se utiliza para rocorrer entra cada cromosoma de indidu
                                          cromosomaHijo1tmp[j] = cromosomaPadre1tmp[j];
                                          cromosomaHijo2tmp[j] = cromosomaPadre2tmp[j];
                                          System.out.print(cromosomaHijo1tmp[j]);
                                      }
                                }
                              /*Segmento inicial */

                              /*segmentos intermedios*/

                               if(k != 0 && k < aleatorios.size()){ // si k es diferente de cero dice que es la siguiente corte despues del primero
                                        auxPC1=(int)aleatorios.get(k-1);
                                        auxPC2=(int)aleatorios.get(k);
                                        for (int j = auxPC1; j < auxPC2; j++) {
                                             cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                             cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                             System.out.print(cromosomaHijo1tmp[j]);
                                        }
                               } 
                              /*segmento intermedios*/

                              /*segmento final */

                               if(k == aleatorios.size()-1){ //if k es igual al tamaño de aleatorio entonces es el ultimo corte
                                        auxPC3=(int)aleatorios.get(k);
                                        for (int j = auxPC3; j < numeroDeGenes; j++) {
                                            cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                                            cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                                            System.out.print(cromosomaHijo1tmp[j]);
                                        }

                               }
                               //*****asociacion de punto de corte individuos*****************
                                    for (int i = 0; i < numeroDeGenes; i++) {
                                        if(i == auxPC || i==auxPC1 || i==auxPC2 || i==auxPC3){
                                                cromosomaCortes[i]=1; //pendiente ya que esa en los cortes
                                                //cromosomaCortes[i-1]=1; //pendiente ya que esa en los cortes
                                        }else{
                                                cromosomaCortes[i]=0;
                                        }
                                    }
                                //*****asociacion de punto de corte individuos*****************
                            }
                            individuo1.setCromosoma(cromosomaHijo1tmp);
                            individuo2.setCromosoma(cromosomaHijo2tmp);
                            individuo1.setCromosomaAsociativo(cromosomaCortes);
                            individuo2.setCromosomaAsociativo(cromosomaCortes);
                            individuosCruzadosTmp.add(individuo1);
                            individuosCruzadosTmp.add(individuo2);
                            System.out.println("\n----------");     
                            //aleatorios.clear();
                        
                      }
                }
                
        }
        return individuosCruzadosTmp;
    }
    
    public static void copiarVector(int[] vectorPadre, int[] vectorHijo,int inicio,int fin) {
        System.arraycopy(vectorPadre,inicio,vectorHijo,inicio,fin);

    }
    
    public static void copiarMatriz(int[][] vectorPadre, int[][] vectorHijo,int inicio,int fin) {
            for (int i = 0; i < vectorPadre.length; i++) {
                System.arraycopy(vectorPadre[i], inicio, vectorHijo[i], inicio, fin);
            }
    }
    
    
    
    /*ejemplo para regimencionar matriz
     * cortesDecruzeAdaptativos = (int[][])redimencionarArreglo(cortesDecruzeAdaptativos,numeroDeIndividuos);
         for (int i=0; i<cortesDecruzeAdaptativos.length; i++) {
                    if (cortesDecruzeAdaptativos[i] == null)
                        cortesDecruzeAdaptativos[i] = new int[numeroDeGenes];
                    else cortesDecruzeAdaptativos[i] = (int[])redimencionarArreglo(cortesDecruzeAdaptativos[i], numeroDeGenes);
         }
    
     */
    
    private static Object redimencionarArreglo (Object oldArray, int newSize) {

        int oldSize = java.lang.reflect.Array.getLength(oldArray);

       Class elementType = oldArray.getClass().getComponentType();
       Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
       int preserveLength = Math.min(oldSize, newSize);
       if (preserveLength > 0)
          System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
       return newArray; 
    } 
}
