/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos.metodosDecimales;

import procedimientos.metodosBinarios.*;
import classesIndividuos.*;
import java.util.Random;
import java.util.*;
import java.util.Queue;
import procedimientos.metodosDecimales.extras.CX;
import procedimientos.metodosDecimales.extras.OX;


/**
 *
 * @author DeveloperEdu
 */
public class cruzaPer{
    
    
   public ArrayList<individuoPer> cruzaPorEmparejamiento(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        /*por no saber cuanto numeros se tendran en encuenta*/
        ArrayList valoresExistentesH1 =null;
        ArrayList valoresExistentesH2 =null;
        
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
                //tamsubCro para saber el tamaño de subcadena del cromosoma 
                //del cromosma cortado se resta el punto de corte2 - corte1
                //se suma 1 para almecenar la el cromosoma justo de la sucadena creada
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                valoresExistentesH1 = new ArrayList();
                valoresExistentesH2 = new ArrayList();
                /*para individuo 1*/
                //System.out.print("\nNuevo inviduo 1:\t");
                
                //paso 1 parte media del cromosoma
                //System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        valoresExistentesH1.add(cromosomaPadre2tmp[j]);
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        valoresExistentesH2.add(cromosomaPadre1tmp[j]);
                        //System.out.print(cromosomaHijo1tmp[j]);
                }
                //paso2 parte inicial de cromosoma
                for (int j = 0; j < puntoDecorte1; j++) {//para recorrer la parte inicial del cromosoma
                    //exite una deficiencia cuando se vuelve a encontrar otro numero igual
                    //alque ya esta en el subcromosoma
                    int genPadre1=cromosomaPadre1tmp[j];
                    int genPadre2=cromosomaPadre2tmp[j];
                    boolean coincidencia= false;
                    int posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo1tmp[j]=cromosomaPadre1tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo1tmp[j] = (int)valoresExistentesH2.get(i);
                            }
                        }
  
                    }
                    //receteamos las banderas para el segundo individuo
                    coincidencia = false;
                    posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo2tmp[j]=cromosomaPadre2tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo2tmp[j] = (int)valoresExistentesH1.get(i);
                            }
                        }
  
                    }
   
                }

                //parte final de cromosoma
            
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {
                    
                    int genPadre1=cromosomaPadre1tmp[j];
                    int genPadre2=cromosomaPadre2tmp[j];
                    boolean coincidencia= false;
                    int posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo1tmp[j]=cromosomaPadre1tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo1tmp[j] = (int)valoresExistentesH2.get(i);
                            }
                        }
  
                    }
                    //receteamos las banderas para el segundo individuo
                    coincidencia = false;
                    posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo2tmp[j]=cromosomaPadre2tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo2tmp[j] = (int)valoresExistentesH1.get(i);
                            }
                        }
  
                    }
                    
                      
                }

                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuoPer> cruzaPorEmparejamiento2(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        /*por no saber cuanto numeros se tendran en encuenta*/
        ArrayList valoresExistentesH1 =null;
        ArrayList valoresExistentesH2 =null;
                                                  
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
                //tamsubCro para saber el tamaño de subcadena del cromosoma 
                //del cromosma cortado se resta el punto de corte2 - corte1
                //se suma 1 para almecenar la el cromosoma justo de la sucadena creada
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                valoresExistentesH1 = new ArrayList();
                valoresExistentesH2 = new ArrayList();
                /*para individuo 1*/
                //System.out.print("\nNuevo inviduo 1:\t");
                
                //paso 1 parte media del cromosoma
                //System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        valoresExistentesH1.add(cromosomaPadre2tmp[j]);
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        valoresExistentesH2.add(cromosomaPadre1tmp[j]);
                        //System.out.print(cromosomaHijo1tmp[j]);
                }
                //paso2 parte inicial de cromosoma
                for (int j = 0; j < puntoDecorte1; j++) {//para recorrer la parte inicial del cromosoma
                    //exite una deficiencia cuando se vuelve a encontrar otro numero igual
                    //alque ya esta en el subcromosoma
                    int genPadre1=cromosomaPadre1tmp[j];
                    int genPadre2=cromosomaPadre2tmp[j];
                    boolean coincidencia= false;
                    int posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo1tmp[j]=cromosomaPadre1tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo1tmp[j] = (int)valoresExistentesH2.get(i);
                            }
                        }
  
                    }
                    //receteamos las banderas para el segundo individuo
                    coincidencia = false;
                    posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo2tmp[j]=cromosomaPadre2tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo2tmp[j] = (int)valoresExistentesH1.get(i);
                            }
                        }
  
                    }
   
                }

                //parte final de cromosoma
            
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {
                    
                    int genPadre1=cromosomaPadre1tmp[j];
                    int genPadre2=cromosomaPadre2tmp[j];
                    boolean coincidencia= false;
                    int posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo1tmp[j]=cromosomaPadre1tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo1tmp[j] = (int)valoresExistentesH2.get(i);
                            }
                        }
  
                    }
                    //receteamos las banderas para el segundo individuo
                    coincidencia = false;
                    posicion=0;
                    
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            posicion = i;
                        }
                    }
                    //si bandera es falsa no hay considecia entre en gen del padre con 
                    //algun den del subcromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        cromosomaHijo2tmp[j]=cromosomaPadre2tmp[j];
                    }
                    if(coincidencia == true){
                        //si el gen del padre ya exite en la subacadena del hijo se busca el gen
                        //que esta emparejado en la misma posicion del otro subcromoma
                        //para usarlo como gen a guardar el el cromosma hijo
                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            if(i==posicion){
                                    cromosomaHijo2tmp[j] = (int)valoresExistentesH1.get(i);
                            }
                        }
  
                    }
                    
                      
                }

                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
   
   /**
    * //aun checar el operador de cruza he identificar el sigueinte error 
    * @param poblacionSelecta
    * @param numeroDeGenes
    * @return 
    */
   public ArrayList<individuoPer> cruzaPorOrden(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        //Stack<Integer> pilaP1 = null;
        //Stack<Integer> pilaP2 = null;
        Queue<Integer> colaP1 = null;
        Queue<Integer> colaP2 = null;
        Queue<Integer> colaP2copia = null;
        Queue<Integer> colaP1copia = null;
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        /*por no saber cuanto numeros se tendran en encuenta*/
        ArrayList valoresExistentesH1 =null;
        ArrayList valoresExistentesH2 =null;
        
        
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
               //System.out.print("\npc1: "+puntoDecorte1);//**************************desmarcar para ver proceso de cruza
                //System.out.print("\npc2: "+puntoDecorte2);//**************************desmarcar para ver proceso de cruza
                //System.out.println("");//**************************desmarcar para ver proceso de cruza
                //tamsubCro para saber el tamaño de subcadena del cromosoma 
                //del cromosma cortado se resta el punto de corte2 - corte1
                //se suma 1 para almecenar la el cromosoma justo de la sucadena creada
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                valoresExistentesH1 = new ArrayList();
                valoresExistentesH2 = new ArrayList();
                //pilaP1 = new Stack<Integer>();
                //pilaP2 = new Stack<Integer>();
                colaP1 =  new  LinkedList();
                colaP2 = new  LinkedList();
                colaP2copia = new  LinkedList();
                colaP1copia = new  LinkedList();
                
                /*para individuo 1*/
                //System.out.print("\nNuevo inviduo 1:\t");
                
                //paso 1 parte media del cromosoma
                //System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        
                        //original
                        cromosomaHijo1tmp[j] = cromosomaPadre2tmp[j];
                        valoresExistentesH1.add(cromosomaPadre2tmp[j]);
                        cromosomaHijo2tmp[j] = cromosomaPadre1tmp[j];
                        valoresExistentesH2.add(cromosomaPadre1tmp[j]);
                        //System.out.print(cromosomaHijo1tmp[j]);
                }
                /*
                 *uso de pila para llevar un orden de los numeros a comparar 
                 */
                for (int i = puntoDecorte2; i < numeroDeGenes; i++) {
                    //pilaP2.push(cromosomaPadre2tmp[i]);
                    //pilaP1.push(cromosomaPadre1tmp[i]);
                    colaP2.add(cromosomaPadre2tmp[i]);
                    colaP1.add(cromosomaPadre1tmp[i]);
                }
                
                for (int i = 0; i < puntoDecorte2; i++) {
                    //pilaP2.push(cromosomaPadre2tmp[i]);
                    //pilaP1.push(cromosomaPadre1tmp[i]);
                    colaP2.add(cromosomaPadre2tmp[i]);
                    colaP1.add(cromosomaPadre1tmp[i]);
                }
                /*
                System.out.println("");
                Iterator iterator = colaP1.iterator();
                while(iterator.hasNext()){
                  int gen = (int) iterator.next();
                  System.out.print(gen+",");
                }
                System.out.println("");
                Iterator iterator2 = colaP2.iterator();
                while(iterator2.hasNext()){
                  int gen2 = (int) iterator2.next();
                  System.out.print(gen2+",");
                }
                */
                
                //parte final de cromosoma 1
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    int genPadre2=colaP2.remove();
                    //System.out.println("-- "+genPadre2);
                    //se hace una comparacion del gen del padre y se verifica que si el gen 
                    //esta en la subcromosma de l hijo 
                    //si se encuentra o no se hacen las funciones sigueintes
                    boolean coincidencia= false;
                    //int posicion=0;
                   
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            //posicion = i;
                        }
                    }
                    //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                    //cromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        //System.out.println("\n:::"+genPadre2);
                        cromosomaHijo1tmp[j] = genPadre2;
                    }
                    
                    if(coincidencia == true){
                        
                        //pilaP2.push(genPadre2);
                        boolean coincidencia2=false;
                        do{
                            genPadre2=colaP2.remove();
                            for (int i = 0; i < valoresExistentesH1.size(); i++) {
                                int auxRepe=((int)valoresExistentesH1.get(i));
                                if (genPadre2 == auxRepe) {
                                    coincidencia2 = true; 
                                    //posicion = i;
                                }
                            }
                            //si no coinside con ningun valor del subcromosoma
                            if(coincidencia2 == false){
                                //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                //System.out.println("\n:::"+genPadre2);
                                cromosomaHijo1tmp[j] = genPadre2;
                            }
                        }while(coincidencia2 != false);
                    }
                    
                }
                //llenamos la copia de la cola2 para volver a usar los datos faltantes
                
                //System.out.println("");
                Iterator ite = colaP2.iterator();
                while(ite.hasNext()){
                  int gen = (int) ite.next();
                  colaP2copia.add(gen);
                  //System.out.print(gen+",");
                }
                
                //parte inicial del cromosma 1
                for (int j = 0; j < puntoDecorte2; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    
                    try {
                        
                        int genPadre2=colaP2copia.remove();
                        //System.out.println("-- "+genPadre2);
                        //se hace una comparacion del gen del padre y se verifica que si el gen 
                        //esta en la subcromosma de l hijo 
                        //si se encuentra o no se hacen las funciones sigueintes
                        boolean coincidencia= false;
                        //int posicion=0;

                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            int auxRepe=((int)valoresExistentesH1.get(i));
                            if (genPadre2 == auxRepe) {
                                coincidencia = true; 
                                //posicion = i;
                            }
                        }
                        //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                        //cromosoma del hijo
                        if(coincidencia == false){
                            //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                            //System.out.println("\n:::"+genPadre2);
                            cromosomaHijo1tmp[j] = genPadre2;
                        }

                        if(coincidencia == true){

                            try {
                                //pilaP2.push(genPadre2);
                                boolean coincidencia2=false;
                                do{
                                    genPadre2=colaP2copia.remove();
                                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                                        int auxRepe=((int)valoresExistentesH1.get(i));
                                        if (genPadre2 == auxRepe) {
                                            coincidencia2 = true; 
                                            //posicion = i;
                                        }
                                    }
                                    //si no coinside con ningun valor del subcromosoma
                                    if(coincidencia2 == false){
                                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                        //System.out.println("\n:::"+genPadre2);
                                        cromosomaHijo1tmp[j] = genPadre2;
                                    }
                                }while(coincidencia2 == false);
                            } catch (Exception e) {
                                //System.out.println("esta vacia la cola  "+ e);
                            }
                        } 
                    } catch (Exception e) {
                         //System.out.println("esta vacia la cola  "+ e);
                    }
                }
                
                //individuo 2
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    int genPadre1=colaP1.remove();
                    //System.out.println("-- "+genPadre2);
                    //se hace una comparacion del gen del padre y se verifica que si el gen 
                    //esta en la subcromosma de l hijo 
                    //si se encuentra o no se hacen las funciones sigueintes
                    boolean coincidencia= false;
                    //int posicion=0;
                   
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            //posicion = i;
                        }
                    }
                    //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                    //cromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        //System.out.println("\n:::"+genPadre1);
                        cromosomaHijo2tmp[j] = genPadre1;
                    }
                    
                    if(coincidencia == true){
                        
                        //pilaP2.push(genPadre2);
                        boolean coincidencia2=false;
                        do{
                            try {
                                genPadre1 = colaP1.remove();
                            } catch (Exception e) {
                                System.out.println("sin datos para desapilar");
                            }
                            for (int i = 0; i < valoresExistentesH2.size(); i++) {
                                int auxRepe=((int)valoresExistentesH2.get(i));
                                if (genPadre1 == auxRepe) {
                                    coincidencia2 = true; 
                                    //posicion = i;
                                }
                            }
                            //si no coinside con ningun valor del subcromosoma
                            if(coincidencia2 == false){
                                //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                //System.out.println("\n:::"+genPadre1);
                                cromosomaHijo2tmp[j] = genPadre1;
                            }
                        }while(coincidencia2 != false);
                    }
                    
                }
                
                //llenamos la copia de la cola2 para volver a usar los datos faltantes
                
                //System.out.println("");
                Iterator ite2 = colaP1.iterator();
                while(ite2.hasNext()){
                  int gen = (int) ite2.next();
                  colaP1copia.add(gen);
                  //System.out.print(gen+",");
                }
                
                //parte inicial del cromosma 1
                for (int j = 0; j < puntoDecorte2; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    
                    try {
                        
                        int genPadre1=colaP1copia.remove();
                        //System.out.println("-- "+genPadre2);
                        //se hace una comparacion del gen del padre y se verifica que si el gen 
                        //esta en la subcromosma de l hijo 
                        //si se encuentra o no se hacen las funciones sigueintes
                        boolean coincidencia= false;
                        //int posicion=0;

                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            int auxRepe=((int)valoresExistentesH2.get(i));
                            if (genPadre1 == auxRepe) {
                                coincidencia = true; 
                                //posicion = i;
                            }
                        }
                        //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                        //cromosoma del hijo
                        if(coincidencia == false){
                            //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                            //System.out.println("\n:::"+genPadre1);
                            cromosomaHijo2tmp[j] = genPadre1;
                        }

                        if(coincidencia == true){

                            try {
                                //pilaP2.push(genPadre2);
                                boolean coincidencia2=false;
                                do{
                                    genPadre1=colaP1copia.remove();
                                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                                        int auxRepe=((int)valoresExistentesH2.get(i));
                                        if (genPadre1 == auxRepe) {
                                            coincidencia2 = true; 
                                            //posicion = i;
                                        }
                                    }
                                    //si no coinside con ningun valor del subcromosoma
                                    if(coincidencia2 == false){
                                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                        //System.out.println("\n:::"+genPadre1);
                                        cromosomaHijo1tmp[j] = genPadre1;
                                    }
                                }while(coincidencia2 == false);
                            } catch (Exception e) {
                                //System.out.println("esta vacia la cola  "+ e);
                            }
                        } 
                    } catch (Exception e) {
                         //System.out.println("esta vacia la cola  "+ e);
                    }
                    
//                    colaP1.clear();
//                    colaP2.clear();
//                    colaP1copia.clear();
//                    colaP2copia.clear();
                }
                
                /*
                System.out.println("");
                Iterator iterator3 = colaP1.iterator();
                while(iterator3.hasNext()){
                  int gen = (int) iterator3.next();
                  System.out.print(gen+",");
                }
                System.out.println("");
                Iterator iterator4 = colaP2.iterator();
                while(iterator4.hasNext()){
                  int gen2 = (int) iterator4.next();
                  System.out.print(gen2+",");
                }
                */
                
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
                
            }
        }
        //System.out.println("\n");
        //generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        //muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
   
    public ArrayList<individuoPer> cruzaPorOrden2C(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        //Stack<Integer> pilaP1 = null;
        //Stack<Integer> pilaP2 = null;
        Queue<Integer> colaP1 = null;
        Queue<Integer> colaP2 = null;
        Queue<Integer> colaP2copia = null;
        Queue<Integer> colaP1copia = null;
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        /*por no saber cuanto numeros se tendran en encuenta*/
        ArrayList valoresExistentesH1 =null;
        ArrayList valoresExistentesH2 =null;
        
        
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
                //System.out.print("\npc1: "+puntoDecorte1);//**************************desmarcar para ver proceso de cruza
                //System.out.print("\npc2: "+puntoDecorte2);//**************************desmarcar para ver proceso de cruza
                //System.out.println("");//**************************desmarcar para ver proceso de cruza
                //tamsubCro para saber el tamaño de subcadena del cromosoma 
                //del cromosma cortado se resta el punto de corte2 - corte1
                //se suma 1 para almecenar la el cromosoma justo de la sucadena creada
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                valoresExistentesH1 = new ArrayList();
                valoresExistentesH2 = new ArrayList();
                //pilaP1 = new Stack<Integer>();
                //pilaP2 = new Stack<Integer>();
                colaP1 =  new  LinkedList();
                colaP2 = new  LinkedList();
                colaP2copia = new  LinkedList();
                colaP1copia = new  LinkedList();
                
                /*para individuo 1*/
                //System.out.print("\nNuevo inviduo 1:\t");
                
                //paso 1 parte media del cromosoma
                //System.out.print("\t");
                for (int j = puntoDecorte1; j < puntoDecorte2; j++) {
                        //modificacion
                        cromosomaHijo1tmp[j]=cromosomaPadre1tmp[j];
                        valoresExistentesH1.add(cromosomaPadre1tmp[j]);
                        cromosomaHijo2tmp[j]=cromosomaPadre2tmp[j];
                        valoresExistentesH2.add(cromosomaPadre2tmp[j]);
                      
                }
                /*
                 *uso de pila para llevar un orden de los numeros a comparar 
                 */
                for (int i = puntoDecorte2; i < numeroDeGenes; i++) {
                    //pilaP2.push(cromosomaPadre2tmp[i]);
                    //pilaP1.push(cromosomaPadre1tmp[i]);
                    colaP1.add(cromosomaPadre2tmp[i]);
                    colaP2.add(cromosomaPadre1tmp[i]);
                    
                }
                
                for (int i = 0; i < puntoDecorte2; i++) {
                    //pilaP2.push(cromosomaPadre2tmp[i]);
                    //pilaP1.push(cromosomaPadre1tmp[i]);
                    colaP1.add(cromosomaPadre2tmp[i]);
                    colaP2.add(cromosomaPadre1tmp[i]);
                   
                }
                
                System.out.println("");
                Iterator iterator = colaP1.iterator();
                while(iterator.hasNext()){
                  int gen = (int) iterator.next();
                  System.out.print(gen+",");
                }
                System.out.println("");
                Iterator iterator2 = colaP2.iterator();
                while(iterator2.hasNext()){
                  int gen2 = (int) iterator2.next();
                  System.out.print(gen2+",");
                }
                
                
                //parte final de cromosoma 1
                
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    int genPadre2=colaP1.remove();
                    //System.out.println("-- "+genPadre2);
                    //se hace una comparacion del gen del padre y se verifica que si el gen 
                    //esta en la subcromosma de l hijo 
                    //si se encuentra o no se hacen las funciones sigueintes
                    boolean coincidencia= false;
                    //int posicion=0;
                   
                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                        int auxRepe=((int)valoresExistentesH1.get(i));
                        if (genPadre2 == auxRepe) {
                            coincidencia = true; 
                            //posicion = i;
                        }
                    }
                    //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                    //cromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        //System.out.println("\n:::"+genPadre2);
                        cromosomaHijo1tmp[j] = genPadre2;
                    }
                    
                    if(coincidencia == true){
                        
                        //pilaP2.push(genPadre2);
                        boolean coincidencia2=false;
                        do{
                            try {
                                genPadre2=colaP1.remove();
                            
                                for (int i = 0; i < valoresExistentesH1.size(); i++) {
                                    int auxRepe=((int)valoresExistentesH1.get(i));
                                    if (genPadre2 == auxRepe) {
                                        coincidencia2 = true; 
                                        //posicion = i;
                                    }
                                }
                                //si no coinside con ningun valor del subcromosoma
                                if(coincidencia2 == false){
                                    //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                    //System.out.println("\n:::"+genPadre2);
                                    cromosomaHijo1tmp[j] = genPadre2;
                                }
                            } catch (Exception e) {
                                System.out.println("no hay nada que remover"+e);
                            }
                            
                        }while(coincidencia2 != false);
                    }
                    
                    
                }
                
                //llenamos la copia de la cola2 para volver a usar los datos faltantes
                /*
                System.out.println("");
                Iterator ite = colaP1.iterator();
                while(ite.hasNext()){
                  int gen = (int) ite.next();
                  colaP1copia.add(gen);
                  //System.out.print(gen+",");
                }
                */
                //parte inicial del cromosma 1
                /*
                for (int j = 0; j < puntoDecorte2; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    
                    try {
                        
                        int genPadre2=colaP1copia.remove();
                        //System.out.println("-- "+genPadre2);
                        //se hace una comparacion del gen del padre y se verifica que si el gen 
                        //esta en la subcromosma de l hijo 
                        //si se encuentra o no se hacen las funciones sigueintes
                        boolean coincidencia= false;
                        //int posicion=0;

                        for (int i = 0; i < valoresExistentesH1.size(); i++) {
                            int auxRepe=((int)valoresExistentesH1.get(i));
                            if (genPadre2 == auxRepe) {
                                coincidencia = true; 
                                //posicion = i;
                            }
                        }
                        //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                        //cromosoma del hijo
                        if(coincidencia == false){
                            //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                            //System.out.println("\n:::"+genPadre2);
                            cromosomaHijo1tmp[j] = genPadre2;
                        }

                        if(coincidencia == true){

                            try {
                                //pilaP2.push(genPadre2);
                                boolean coincidencia2=false;
                                do{
                                    genPadre2=colaP1copia.remove();
                                    for (int i = 0; i < valoresExistentesH1.size(); i++) {
                                        int auxRepe=((int)valoresExistentesH1.get(i));
                                        if (genPadre2 == auxRepe) {
                                            coincidencia2 = true; 
                                            //posicion = i;
                                        }
                                    }
                                    //si no coinside con ningun valor del subcromosoma
                                    if(coincidencia2 == false){
                                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                        //System.out.println("\n:::"+genPadre2);
                                        cromosomaHijo1tmp[j] = genPadre2;
                                    }
                                }while(coincidencia2 == false);
                            } catch (Exception e) {
                                //System.out.println("esta vacia la cola  "+ e);
                            }
                        } 
                    } catch (Exception e) {
                         //System.out.println("esta vacia la cola  "+ e);
                    }
                 }
                 */
                
                //individuo 2
                /*
                for (int j = puntoDecorte2; j < numeroDeGenes; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    int genPadre1=colaP1.remove();
                    //System.out.println("-- "+genPadre2);
                    //se hace una comparacion del gen del padre y se verifica que si el gen 
                    //esta en la subcromosma de l hijo 
                    //si se encuentra o no se hacen las funciones sigueintes
                    boolean coincidencia= false;
                    //int posicion=0;
                   
                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                        int auxRepe=((int)valoresExistentesH2.get(i));
                        if (genPadre1 == auxRepe) {
                            coincidencia = true; 
                            //posicion = i;
                        }
                    }
                    //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                    //cromosoma del hijo
                    if(coincidencia == false){
                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                        //System.out.println("\n:::"+genPadre1);
                        cromosomaHijo2tmp[j] = genPadre1;
                    }
                    
                    if(coincidencia == true){
                        
                        //pilaP2.push(genPadre2);
                        boolean coincidencia2=false;
                        do{
                            try {
                                genPadre1 = colaP1.remove();
                            } catch (Exception e) {
                                System.out.println("sin datos para desapilar");
                            }
                            for (int i = 0; i < valoresExistentesH2.size(); i++) {
                                int auxRepe=((int)valoresExistentesH2.get(i));
                                if (genPadre1 == auxRepe) {
                                    coincidencia2 = true; 
                                    //posicion = i;
                                }
                            }
                            //si no coinside con ningun valor del subcromosoma
                            if(coincidencia2 == false){
                                //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                //System.out.println("\n:::"+genPadre1);
                                cromosomaHijo2tmp[j] = genPadre1;
                            }
                        }while(coincidencia2 != false);
                    }
                    
                }
                
                //llenamos la copia de la cola2 para volver a usar los datos faltantes
                
                System.out.println("");
                Iterator ite2 = colaP1.iterator();
                while(ite2.hasNext()){
                  int gen = (int) ite2.next();
                  colaP1copia.add(gen);
                  //System.out.print(gen+",");
                }
                
                //parte inicial del cromosma 1
                for (int j = 0; j < puntoDecorte2; j++) {//para recorrer la parte inicial del cromosoma
                    
                    //se obtiene los genes del padre que se almacenaron previamente en
                    //una pila para llevar un orden
                    
                    try {
                        
                        int genPadre1=colaP1copia.remove();
                        //System.out.println("-- "+genPadre2);
                        //se hace una comparacion del gen del padre y se verifica que si el gen 
                        //esta en la subcromosma de l hijo 
                        //si se encuentra o no se hacen las funciones sigueintes
                        boolean coincidencia= false;
                        //int posicion=0;

                        for (int i = 0; i < valoresExistentesH2.size(); i++) {
                            int auxRepe=((int)valoresExistentesH2.get(i));
                            if (genPadre1 == auxRepe) {
                                coincidencia = true; 
                                //posicion = i;
                            }
                        }
                        //si no hay comsidencia de que existe en el subcromosoma solo de guarda el el 
                        //cromosoma del hijo
                        if(coincidencia == false){
                            //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                            //System.out.println("\n:::"+genPadre1);
                            cromosomaHijo2tmp[j] = genPadre1;
                        }

                        if(coincidencia == true){

                            try {
                                //pilaP2.push(genPadre2);
                                boolean coincidencia2=false;
                                do{
                                    genPadre1=colaP1copia.remove();
                                    for (int i = 0; i < valoresExistentesH2.size(); i++) {
                                        int auxRepe=((int)valoresExistentesH2.get(i));
                                        if (genPadre1 == auxRepe) {
                                            coincidencia2 = true; 
                                            //posicion = i;
                                        }
                                    }
                                    //si no coinside con ningun valor del subcromosoma
                                    if(coincidencia2 == false){
                                        //si el gen del padre no se encuentra en la subcromosoma del hijo se copia en directamete 
                                        //System.out.println("\n:::"+genPadre1);
                                        cromosomaHijo1tmp[j] = genPadre1;
                                    }
                                }while(coincidencia2 == false);
                            } catch (Exception e) {
                                //System.out.println("esta vacia la cola  "+ e);
                            }
                        } 
                    } catch (Exception e) {
                         //System.out.println("esta vacia la cola  "+ e);
                    }
                }
                */
                /*
                System.out.println("");
                Iterator iterator3 = colaP1.iterator();
                while(iterator3.hasNext()){
                  int gen = (int) iterator3.next();
                  System.out.print(gen+",");
                }
                System.out.println("");
                Iterator iterator4 = colaP2.iterator();
                while(iterator4.hasNext()){
                  int gen2 = (int) iterator4.next();
                  System.out.print(gen2+",");
                }
                */
                
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
                
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
   public ArrayList<individuoPer> cruzaPorCiclos(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        /*por no saber cuanto numeros se tendran en encuenta*/
        ArrayList valoresExistentesH1 =null;
        ArrayList valoresExistentesH2 =null;
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (/*x % 2 == 0 || */x == 0) {
                //para numeros aleatotitod y cantidad de ciclcs
                /*primer aleatorio para saber que posicion se tomara para empesar el ciclo*/
                Random aleatorio1 = new Random();
                int posicion = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                /*segundo aleatorio para saber cuantos ciclos hacer*/
                Random aleatorio2 = new Random();
                int ciclos=(int) (aleatorio2.nextDouble() * (numeroDeGenes-1) +1);

                System.out.print("\nposionInicio: "+posicion);
                System.out.print("\ncantidadCiclos: "+ciclos);
                System.out.println("\n");
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                valoresExistentesH1 = new ArrayList();
                valoresExistentesH2 = new ArrayList();
                
                /*para individuo 1*/
                //System.out.print("\nNuevo inviduo 1:\t");
                
                for (int i = 0; i < cromosomaPadre1tmp.length; i++) {
                    System.out.print(cromosomaPadre1tmp[i]+",");
                }
                System.out.println("");
                for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                    System.out.print(cromosomaPadre2tmp[i]+",");
                }
                
                
                int genInicioCiclo=cromosomaPadre1tmp[0];
                cromosomaHijo1tmp[0]=genInicioCiclo;
                
                
                int gen = 0;
                int genAux=0;
                
                System.out.println("\ngenCiclo: "+genInicioCiclo);
                
                gen=cromosomaPadre1tmp[0];
              

                for (int i = 0; i < numeroDeGenes; i++) {
                     genAux=cromosomaPadre2tmp[i];
                     if(genAux == gen){
                            //System.out.println("\ngenP2: "+ cromosomaPadre2tmp[i]);
                            //System.out.println("\ngenP1: "+ cromosomaPadre1tmp[i]);
                            gen=cromosomaPadre1tmp[i];
                            //cromosomaHijo1tmp[i]=cromosomaPadre1tmp[i];
                            System.out.println("gen: "+gen);
                     }
               }
             
                
                /*
                gen=cromosomaPadre1tmp[0];
                do {
                    //System.out.println(":"+genCiclo);
                    for (int i = 0; i < numeroDeGenes; i++) {
                        genAux=cromosomaPadre2tmp[i];
                        if(genAux == gen){
                            //System.out.println("\ngenP2: "+ cromosomaPadre2tmp[i]);
                            //System.out.println("\ngenP1: "+ cromosomaPadre1tmp[i]);
                            gen=cromosomaPadre1tmp[i];
                            //cromosomaHijo1tmp[i]=cromosomaPadre1tmp[i];
                            System.out.println("gen: "+gen);
                        }
                    }
                    
                } while (gen != genInicioCiclo);
                */
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
   
    public ArrayList<individuoPer> cruzaPorCiclosNueva(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
          for (int x = 0; x < poblacionSelecta.size(); x++) {
              if (x % 2 == 0 || x == 0) {
                  
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                
                int primeraVez=0;
                int aux=0;
                int inicioDelciclo=0;
                int numero=0;
                do{

                    if(primeraVez == 0){//significa que sera el inicio del ciclo
                        Random aleatorio1 = new Random();
                        int posicion = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                        
                        for (int i = 0; i < cromosomaPadre1tmp.length; i++) {
                            if(cromosomaPadre1tmp[i] == posicion){
                                cromosomaHijo1tmp[i]=cromosomaPadre1tmp[i]; 
                                aux=cromosomaPadre1tmp[i]; 
                                primeraVez=1;
                                inicioDelciclo=cromosomaPadre1tmp[i];
                            }
                        }
                    }
                    if(primeraVez == 1){//indica que ya no es la primera vez
                        for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                            if(cromosomaPadre2tmp[i] == aux){
                                cromosomaHijo1tmp[i] = cromosomaPadre1tmp[i]; 
                                aux=cromosomaPadre1tmp[i]; 
                                primeraVez=1;
                            }
                        }
                    }
                    
                    for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                            if(cromosomaPadre2tmp[i] == aux){
                                numero = cromosomaPadre1tmp[i]; 
                                
                            }
                    }
                    
                }while(numero == inicioDelciclo);
                
                
                individuo1.setCromosoma(cromosomaHijo1tmp);
                //individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                //individuosCruzadosTmp.add(individuo2);
                
              }
          }
            

        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuoPer> cruzaPorCiclos2(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                
                /*primer aleatorio para saber que posicion se tomara para empesar el ciclo*/
                Random aleatorio1 = new Random();
                //el valor generado sera para encontrar cual sera la posicion para inical el ciclo
                int posicion = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                int numeroCilcos = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                System.out.println("---------------------------------------------numero aleatorio"+posicion);
                int posicion2 = posicion;
                
                //System.out.println("\n");
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                

                
                int inicioCiclo=0;
                int CicloSiguiente=0;
                int nuevoPosicion=0;
                int aux=0;
                int primeraVez=0;
                
               // int inicioCiclo2=0;
               // int CicloSiguiente2=0;
               // int nuevoPosicion2=0;
               // int aux3=0;
               // int primeraVez2=0;
                
               
                    //padre1/////////////////////////////////////////////////////////////////////////////////////////
                    if(primeraVez == 0){//indicamos que sea la primera vez he inico de ciclo
                        //recorremos al padre1 para saber que posicon fue elegida  
                        for (int i = 0; i < cromosomaPadre1tmp.length; i++) {
                            if(i == posicion){
                                //se detiene en esa posicion para asignar el inicio de ciclo
                                //asigans el inicio de ciclo
                                inicioCiclo = cromosomaPadre1tmp[i];
                                System.out.println("inicioCiclo"+inicioCiclo);
                                //se asigna el valor al nuevo individuo
                                cromosomaHijo1tmp[i]=cromosomaPadre1tmp[i];
                                
                                //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                //mandamos a traer la funcion de busqueda de posicon 
                                aux=buscarPosicion(inicioCiclo,cromosomaPadre2tmp);
                                nuevoPosicion=cromosomaPadre1tmp[aux];
                                //System.out.println("numeroSiguientedelciclo"+nuevoPosicion);
                               
                            }
                        }
                        
                        
                        primeraVez = 1;
                    }
                    if(primeraVez == 1){

                            int num = 0;  
                            //el valor generado sera para encontrar cual sera la posicion para inical el ciclo
                            //int cantidadCiclos = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                            boolean sonIguales=false;
                            do{
                                num++;
                                for (int i = 0; i < cromosomaPadre1tmp.length; i++) {
                                    if(i == nuevoPosicion){
                                        CicloSiguiente = cromosomaPadre1tmp[i];
                                        System.out.println("cicloSiguiente"+CicloSiguiente);
                                        //se asigna el valor al nuevo individuo
                                        cromosomaHijo1tmp[i]=cromosomaPadre1tmp[i];
                                        
                                        //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                        //mandamos a traer la funcion de busqueda de posicon 
                                        aux=buscarPosicion(CicloSiguiente,cromosomaPadre2tmp);
                                        nuevoPosicion=cromosomaPadre1tmp[aux];
                                        System.out.println("--->"+nuevoPosicion);
                                    }
                                }
                                
                                
                                //verificar si el siguiente en encontrar es igual al inicio
                                int aux2=buscarPosicion(CicloSiguiente,cromosomaPadre2tmp);
                                int nuevoInio=cromosomaPadre1tmp[aux2];
                                if(inicioCiclo == nuevoInio){
                                    sonIguales=true;
                                }
                            //}while(/*inicioCiclo == CicloSiguiente && */ sonIguales != true);
                            }while(num == numeroCilcos && sonIguales != true);
                           
                        
                     }
                    
                     for (int i = 0; i < cromosomaHijo1tmp.length; i++) {
                         if(cromosomaHijo1tmp[i]==0){
                             cromosomaHijo1tmp[i] = cromosomaPadre2tmp[i];
                         }
                     }   
                    
                     
                     for (int i = 0; i < cromosomaHijo1tmp.length; i++) {
                         System.out.print(","+cromosomaHijo1tmp[i]);
                     }
                     System.out.println("");
                     for (int i = 0; i < cromosomaHijo2tmp.length; i++) {
                         System.out.print(","+cromosomaHijo2tmp[i]);
                     }
                    
                     //padre1/////////////////////////////////////////////////////////////////////////////////////////
                     
                     //int inicioCiclo2=0;
                     //int CicloSiguiente2=0;
                     //int nuevoPosicion2=0;
                     //int aux2=0;
                     //int primeraVez2=0;
                     //padre2/////////////////////////////////////////////////////////////////////////////////////////
                     /*
                     if(primeraVez2 == 0){//indicamos que sea la primera vez he inico de ciclo
                        //recorremos al padre1 para saber que posicon fue elegida  
                        for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                            if(i == posicion2){
                                //se detiene en esa posicion para asignar el inicio de ciclo
                                //asigans el inicio de ciclo
                                inicioCiclo2 = cromosomaPadre2tmp[i];
                                System.out.println("inicioCiclo2"+inicioCiclo2);
                                //se asigna el valor al nuevo individuo
                                cromosomaHijo2tmp[i]=cromosomaPadre2tmp[i];
                                //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                //mandamos a traer la funcion de busqueda de posicon 
                                aux2=buscarPosicion(inicioCiclo2,cromosomaPadre1tmp);
                                nuevoPosicion2=cromosomaPadre2tmp[aux];
                                //System.out.println("numeroSiguientedelciclo"+nuevoPosicion);
           
                            }
                        }
                        primeraVez2 = 1;
                     } 
                     */
                     /*
                     if(primeraVez2 == 1){

                            int num2 = 0;  
                            //el valor generado sera para encontrar cual sera la posicion para inical el ciclo
                            //int cantidadCiclos2 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                            boolean sonIguales2=false;
                            do{
                                num2++;
                                for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                                    if(i == nuevoPosicion2){
                                        CicloSiguiente2 = cromosomaPadre1tmp[i];
                                        System.out.println("cicloSiguiente2"+CicloSiguiente2);
                                        //se asigna el valor al nuevo individuo
                                        cromosomaHijo2tmp[i]=cromosomaPadre2tmp[i];
                                        //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                        //mandamos a traer la funcion de busqueda de posicon 
                                        aux2=buscarPosicion(CicloSiguiente2,cromosomaPadre1tmp);
                                        nuevoPosicion2=cromosomaPadre2tmp[aux2];
                                        System.out.println("--->"+nuevoPosicion2);
                                    }
                                }
                                //verificar si el siguiente en encontrar es igual al inicio
                                int aux3=buscarPosicion(CicloSiguiente2,cromosomaPadre1tmp);
                                int nuevoInio2=cromosomaPadre1tmp[aux3];
                                if(inicioCiclo2 == nuevoInio2){
                                    sonIguales2=true;
                                }
                          
                            }while(num2 == numeroCilcos && sonIguales2 != true);
                           
                        
                     }
                     for (int i = 0; i < cromosomaHijo2tmp.length; i++) {
                         if(cromosomaHijo2tmp[i]==0){
                             cromosomaHijo2tmp[i] = cromosomaPadre1tmp[i];
                         }
                         
                     }
                     for (int i = 0; i < cromosomaHijo2tmp.length; i++) {
                         System.out.print(","+cromosomaHijo2tmp[i]);
                     }
                     */
                     //padre2/////////////////////////////////////////////////////////////////////////////////////////
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
    public ArrayList<individuoPer> cruzaPorCiclos3(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        System.out.println("cruza por ciclos3");
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                
                
                
                //System.out.println("\n");
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                

                /*primer aleatorio para saber que posicion se tomara para empesar el ciclo*/
                Random aleatorio1 = new Random();
                //el valor generado sera para encontrar cual sera la posicion para inical el ciclo
                int posicionAleatoria = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                boolean primeraVez = true;
                int inicioDeCiclo=0;
                int nuevoCicloDeinicio=0;
                int pos=0;
                
          
                    //padre1/////////////////////////////////////////////////////////////////////////////////////////
                    if(primeraVez == true){//indicamos que sea la primera vez he inico de ciclo
                        //recorremos al padre1 para saber que posicon fue elegida  
                        for (int i = 0; i < cromosomaPadre1tmp.length; i++) {
                            if(i == posicionAleatoria){
                               pos=i;
                            }
                        }
                        //se detiene en esa posicion para asignar el inicio de ciclo
                        //asigans el inicio de ciclo
                         inicioDeCiclo = cromosomaPadre1tmp[pos];
                         System.out.println("inicioCiclo"+inicioDeCiclo);
                         //se asigna el valor al nuevo individuo
                         cromosomaHijo1tmp[pos]=inicioDeCiclo;
                         primeraVez=false;
                    }
                    if(primeraVez == false){
                        //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                        //mandamos a traer la funcion de busqueda de posicon 
                       /* 
                        do{
                            pos=buscarPosicion(inicioDeCiclo,cromosomaPadre2tmp);
                            System.out.println("pos"+pos);
                            nuevoCicloDeinicio=cromosomaPadre1tmp[pos];
                            System.out.println("pos"+nuevoCicloDeinicio);
                            cromosomaHijo1tmp[pos]=cromosomaPadre1tmp[pos];
                            
                            
                        }while();
                       */ 
                        
                     }
                     /*
                     for (int i = 0; i < cromosomaHijo1tmp.length; i++) {
                         if(cromosomaHijo1tmp[i]==0){
                             cromosomaHijo1tmp[i] = cromosomaPadre2tmp[i];
                         }
                     }   
                     */
                     
                     //for (int i = 0; i < cromosomaHijo1tmp.length; i++) {
                        // System.out.print(","+cromosomaHijo1tmp[i]);
                     //}
                    
                     //padre1/////////////////////////////////////////////////////////////////////////////////////////
                     
                     //int inicioCiclo2=0;
                     //int CicloSiguiente2=0;
                     //int nuevoPosicion2=0;
                     //int aux2=0;
                     //int primeraVez2=0;
                     //padre2/////////////////////////////////////////////////////////////////////////////////////////
                     /*
                     if(primeraVez2 == 0){//indicamos que sea la primera vez he inico de ciclo
                        //recorremos al padre1 para saber que posicon fue elegida  
                        for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                            if(i == posicion2){
                                //se detiene en esa posicion para asignar el inicio de ciclo
                                //asigans el inicio de ciclo
                                inicioCiclo2 = cromosomaPadre2tmp[i];
                                System.out.println("inicioCiclo2"+inicioCiclo2);
                                //se asigna el valor al nuevo individuo
                                cromosomaHijo2tmp[i]=cromosomaPadre2tmp[i];
                                //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                //mandamos a traer la funcion de busqueda de posicon 
                                aux2=buscarPosicion(inicioCiclo2,cromosomaPadre1tmp);
                                nuevoPosicion2=cromosomaPadre2tmp[aux];
                                //System.out.println("numeroSiguientedelciclo"+nuevoPosicion);
           
                            }
                        }
                        primeraVez2 = 1;
                     } 
                     */
                     /*
                     if(primeraVez2 == 1){

                            int num2 = 0;  
                            //el valor generado sera para encontrar cual sera la posicion para inical el ciclo
                            //int cantidadCiclos2 = (int) (aleatorio1.nextDouble() * (numeroDeGenes-1) +1);
                            boolean sonIguales2=false;
                            do{
                                num2++;
                                for (int i = 0; i < cromosomaPadre2tmp.length; i++) {
                                    if(i == nuevoPosicion2){
                                        CicloSiguiente2 = cromosomaPadre1tmp[i];
                                        System.out.println("cicloSiguiente2"+CicloSiguiente2);
                                        //se asigna el valor al nuevo individuo
                                        cromosomaHijo2tmp[i]=cromosomaPadre2tmp[i];
                                        //ahora se debe buscar la nuevaPosicion inicial para el siguiente ciclo
                                        //mandamos a traer la funcion de busqueda de posicon 
                                        aux2=buscarPosicion(CicloSiguiente2,cromosomaPadre1tmp);
                                        nuevoPosicion2=cromosomaPadre2tmp[aux2];
                                        System.out.println("--->"+nuevoPosicion2);
                                    }
                                }
                                //verificar si el siguiente en encontrar es igual al inicio
                                int aux3=buscarPosicion(CicloSiguiente2,cromosomaPadre1tmp);
                                int nuevoInio2=cromosomaPadre1tmp[aux3];
                                if(inicioCiclo2 == nuevoInio2){
                                    sonIguales2=true;
                                }
                          
                            }while(num2 == numeroCilcos && sonIguales2 != true);
                           
                        
                     }
                     for (int i = 0; i < cromosomaHijo2tmp.length; i++) {
                         if(cromosomaHijo2tmp[i]==0){
                             cromosomaHijo2tmp[i] = cromosomaPadre1tmp[i];
                         }
                         
                     }
                     for (int i = 0; i < cromosomaHijo2tmp.length; i++) {
                         System.out.print(","+cromosomaHijo2tmp[i]);
                     }
                     */
                     //padre2/////////////////////////////////////////////////////////////////////////////////////////
                individuo1.setCromosoma(cromosomaHijo1tmp);
                //individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                //individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
    
     public int buscarPosicion(int aux,int cromosomaPadre[]){
        int pos=0;
        for (int i = 0; i < cromosomaPadre.length; i++) {
            if(aux == cromosomaPadre[i]){
                pos=i;
            }
        }
        return pos;
    }
    /* 
    public void cruza(){
        Random rnd = new Random();
        System.out.println("\nCruza por ciclos");
        for (int X = 0; X < Mejores_Individuos_Padres.length; X += 2) {
            int a = rnd.nextInt(numeroDeGenes - 1);
            int inicio = (Mejores_Individuos_Padres[X][a]);
            int paro = inicio;
            int buscar = inicio;
            int i = 0;
            do {
                if (Mejores_Individuos_Padres[X][i] == buscar) {
                    IndividuosCruzados[X][i] = Mejores_Individuos_Padres[X][i];
                    IndividuosCruzados[X + 1][i] = Mejores_Individuos_Padres[X + 1][i];
                    buscar = Mejores_Individuos_Padres[X + 1][i];
                    if (Mejores_Individuos_Padres[X + 1][i] == paro) {
                        break;
                    } else {
                        i = 0;
                    }
                } else {
                    i++;
                }
            } while (true);

            for (int j = 0; j < numeroDeGenes; j++) {
                if (IndividuosCruzados[X][j] == 0) {
                    IndividuosCruzados[X][j] = Mejores_Individuos_Padres[X + 1][j];
                }
                if (IndividuosCruzados[X + 1][j] == 0) {
                    IndividuosCruzados[X + 1][j] = Mejores_Individuos_Padres[X][j];
                }
            }
        }
    }
    */
     
    public ArrayList<individuoPer> cruzaPorOrden3(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();

        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                
                OX cruzaOrden = new OX(cromosomaPadre1tmp,cromosomaPadre2tmp);
                
                int corte1=cruzaOrden.get_cutPoint1();
                int corte2=cruzaOrden.get_cutPoint2();
                System.out.println("corte1: "+corte1);
                System.out.println("corte2: "+corte2);
                
                cromosomaHijo1tmp=cruzaOrden.get_offspring1();
                cromosomaHijo2tmp=cruzaOrden.get_offspring2();

                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
            }
        }
        System.out.println("\n");
        generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return  individuosCruzadosTmp;
    } 
    
    public ArrayList<individuoPer> cruzaPorCiclos4(ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes) {
        ArrayList<individuoPer> individuosCruzadosTmp = new ArrayList<individuoPer>();
       
        individuoPer individuo1 = null; 
        individuoPer individuo2 = null;
        int []cromosomaHijo1tmp=null;
        int []cromosomaHijo2tmp=null;
        int []cromosomaPadre1tmp=null;
        int []cromosomaPadre2tmp=null;
        
        for (int x = 0; x < poblacionSelecta.size(); x++) {
            if (x % 2 == 0 || x == 0) {
                individuo1 = new individuoPer();  
                individuo2 = new individuoPer();
                cromosomaHijo1tmp = new int[numeroDeGenes];
                cromosomaHijo2tmp = new int[numeroDeGenes];
                cromosomaPadre1tmp = poblacionSelecta.get(x).getCromosoma();
                cromosomaPadre2tmp = poblacionSelecta.get(x+1).getCromosoma();
                
                CX cruzaCiclos = new CX(cromosomaPadre1tmp,cromosomaPadre2tmp);
                
                cromosomaHijo1tmp=cruzaCiclos.get_offspring1();
                cromosomaHijo2tmp=cruzaCiclos.get_offspring2();
                
                individuo1.setCromosoma(cromosomaHijo1tmp);
                individuo2.setCromosoma(cromosomaHijo2tmp);
                individuosCruzadosTmp.add(individuo1);
                individuosCruzadosTmp.add(individuo2);
                
            }
        }  
        //System.out.println("\n");
        //generadorDePoblacionPer muestra= new generadorDePoblacionPer();
        //muestra.mostrarPoblacionPer(individuosCruzadosTmp);
        return individuosCruzadosTmp;
    }
}


