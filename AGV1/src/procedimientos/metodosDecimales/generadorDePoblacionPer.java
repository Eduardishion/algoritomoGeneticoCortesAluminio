
package procedimientos.metodosDecimales;
import procedimientos.metodosDecimales.seleccionPer;
import classesIndividuos.individuoPer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import valoresTablaPerfiles.perfil;

/**
 *
 * @author DeveloperEdu
 */
public class generadorDePoblacionPer {
  
    /**
     * mejoresIndividuosPoblacion arrayList para almacenar los mejores individuos 
     * promedioPorGeneracion arrayList para almacenar el promedio de cada generacion
     * todosLosidividuosGenerados arrayList opcional para almacenar todos los individos 
     * generados de todas las generaciones
     */
    ArrayList<individuoPer> mejoresIndividuosPoblacion = new ArrayList<>();
    ArrayList<individuoPer> promedioPorGeneracion = new ArrayList<>();
    ArrayList<individuoPer> todosLosidividuosGenerados = new ArrayList<>();
    
    //para numeros aleatorios emteros no repetidos
    ArrayList usados = new ArrayList();
    ArrayList aleatorios = new ArrayList();
    private ArrayList <perfil> vectorPerfiles = new ArrayList <>();
    
    //para la implementacion de hashmap para los perfiles 
    Map<Integer, Double> MedidaDePerfiles = new HashMap<>();
    
   /*
    *variables de la cantidad de individuos tanto su numero de genes que contiene
    */
    private int numeroDeIndividuos;
    private int numeroDeGenes;
    private int numeroGeneraciones;
    private String opcionDeSeleccion;
    private String opcionCruza;
    private String opcionMutacion;
    private double porcentaje;
    private int muestra;
    private double estandarPerfi;

    public generadorDePoblacionPer(){
        
    }
 
    public generadorDePoblacionPer(int numeroDeIndividuos, int numeroDeGenes, int numeroGeneraciones) {
        this.numeroDeIndividuos = numeroDeIndividuos;
        this.numeroDeGenes = numeroDeGenes;
        this.numeroGeneraciones = numeroGeneraciones;
    }

    public ArrayList<individuoPer> getPromedioPorGeneracion() {
        return promedioPorGeneracion;
    }

    public void setPromedioPorGeneracion(ArrayList<individuoPer> PromedioPorGeneracion) {
        this.promedioPorGeneracion = PromedioPorGeneracion;
    }

    public ArrayList<individuoPer> getTodosLosidividuosGenerados() {
        return todosLosidividuosGenerados;
    }

    public void setTodosLosidividuosGenerados(ArrayList<individuoPer> todosLosidividuosGenerados) {
        this.todosLosidividuosGenerados = todosLosidividuosGenerados;
    }
    
    public ArrayList<perfil> getVectorPerfiles() {
        return vectorPerfiles;
    }

    public void setVectorPerfiles(ArrayList<perfil> vectorPerfiles) {
        this.vectorPerfiles = vectorPerfiles;
    }

   
    public int getMuestra() {
        return muestra;
    }

    public void setMuestra(int muestra) {
        this.muestra = muestra;
    }
    
    public String getOpcionDeSeleccion() {
        return opcionDeSeleccion;
    }

    public void setOpcionDeSeleccion(String opcionDeSeleccion) {
        this.opcionDeSeleccion = opcionDeSeleccion;
    }

    public String getOpcionCruza() {
        return opcionCruza;
    }

    public void setOpcionCruza(String opcionCruza) {
        this.opcionCruza = opcionCruza;
    }

    public String getOpcionMutacion() {
        return opcionMutacion;
    }

    public void setOpcionMutacion(String opcionMutacion) {
        this.opcionMutacion = opcionMutacion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public int getNumeroDeIndividuos() {
        return numeroDeIndividuos;
    }

    public void setNumeroDeIndividuos(int numeroDeIndividuos) {
        this.numeroDeIndividuos = numeroDeIndividuos;
    }

    public int getNumeroDeGenes() {
        return numeroDeGenes;
    }

    public void setNumeroDeGenes(int numeroDeGenes) {
        this.numeroDeGenes = numeroDeGenes;
    }

    public int getNumeroGeneraciones() {
        return numeroGeneraciones;
    }

    public void setNumeroGeneraciones(int numeroGeneraciones) {
        this.numeroGeneraciones = numeroGeneraciones;
    }

    public ArrayList<individuoPer> getMejoresIndividuosPoblacion() {
        return mejoresIndividuosPoblacion;
    }

    public void setMejoresIndividuosPoblacion(ArrayList<individuoPer> mejoresIndividuosPoblacion) {
        this.mejoresIndividuosPoblacion = mejoresIndividuosPoblacion;
    }

    public Map<Integer, Double> getMedidaDePerfiles() {
        return MedidaDePerfiles;
    }

    public void setMedidaDePerfiles(Map<Integer, Double> MedidaDePerfiles) {
        this.MedidaDePerfiles = MedidaDePerfiles;
    }

    public ArrayList getUsados() {
        return usados;
    }

    public void setUsados(ArrayList usados) {
        this.usados = usados;
    }

    public ArrayList getAleatorios() {
        return aleatorios;
    }

    public void setAleatorios(ArrayList aleatorios) {
        this.aleatorios = aleatorios;
    }

    public double getEstandarPerfi() {
        return estandarPerfi;
    }

    public void setEstandarPerfi(double estandarPerfi) {
        this.estandarPerfi = estandarPerfi;
    }

    /**
     * Metodo generador de poblacion del genetico, es la estructura basica del 
     * genetico que se conforma de los pasos principales del algoritmo genetico
     * 1.-generar poblacion inicial
     * 2.-evaluar pobalcion inicial
     * 3.-seleccionar los mejores individuos de la poblacion anterior   
     * 4.-cruzar los indiivduos selectos
     * 5.-mutar los individuos cruzados 
     * 6.-evaluar los individuos mutados y generar la nueva poblacion 
     */
    public void generarPoblacion(){
        /* variables para poblacion     
        * numero de generaciones que indica el numero de generaciones a generar
        * Arraylist para contener individuos
        */
       
       ArrayList<individuoPer> poblacion = new ArrayList<individuoPer>();
       ArrayList<individuoPer> poblacionSelecta = new ArrayList<individuoPer>();
       ArrayList<individuoPer> poblacionCruzada = new ArrayList<individuoPer>();
       ArrayList<individuoPer> poblacionMutada = new ArrayList<individuoPer>();
       individuoPer individuo = null;
       //objetos de clases de 
       cruzaPer cruza = new  cruzaPer();
       seleccionPer seleccion = new seleccionPer(); 
       mutacionPer mutacion = new mutacionPer();
       
       mejoresIndividuosPoblacion.clear();
       promedioPorGeneracion.clear();
       todosLosidividuosGenerados.clear();
       
       
       poblacion.clear();
       poblacionSelecta.clear();
       poblacionCruzada.clear();
       poblacionMutada.clear();
       
       for (int i = 0; i < numeroGeneraciones; i++) {
            System.out.println("Generacion: -------------------------------------------------------->>"+ (i+1));
            /*
             *si i es == 0 significa que es la generacion uno 
             *lo cual la primera generacion se debe generar aleatoriamente  
             */
            if(i == 0){ 
                poblacion=generadorDeIndividuosPrimeraGeneracion(poblacion,numeroDeIndividuos,numeroDeGenes);
                //para verificar que la suma es correcta
                //int padre1[]={1,2,3,4,5,6,7,8,9}; 
                //poblacion.get(0).setCromosoma(padre1);
                poblacion=evaluarIndividuos(poblacion);
                //para obtener El promedio general de cada generacion
                double SumaAptitudes=0;
                int totalIndividuos=0;
                for (int j = 0; j < poblacion.size(); j++) {
                     SumaAptitudes = SumaAptitudes + poblacion.get(j).getValorAptitud();
                     totalIndividuos++;
                     //para guardar todos los individuos
                     todosLosidividuosGenerados.add(poblacion.get(j));
                }
                //System.out.println("SumaAptitudes"+SumaAptitudes);
                double promedio =  SumaAptitudes / totalIndividuos;
                //System.out.println("promedio"+promedio);
                individuoPer indi = new individuoPer();
                indi.setValorDecimal(promedio);
                promedioPorGeneracion.add(indi);
                mejoresIndividuosPoblacion.add(buscarMejorIndividuo(poblacion));
                mostrarPoblacionPer(poblacion);
                SumaAptitudes=0;
                promedio=0;
                totalIndividuos=0;
                indi=null;
                
            }else{
                /*si la iteracion deja de ser cero las proximas generaciones siguen el algoritmo del algoritmo genetico
                 *seleccion, cruza, mutacion*/
                
                //seleccion para usar con interfaz
                poblacionSelecta=tipoSeleccion(opcionDeSeleccion,poblacion,numeroDeIndividuos,muestra);
                //poblacionSelecta = seleccion.seleccionAleatoria(poblacion,numeroDeIndividuos);
                //poblacionSelecta = seleccion.seleleccionPorRuleta(poblacion,numeroDeIndividuos);
                //poblacionSelecta = seleccion.seleccionPorTorneo(poblacion,numeroDeIndividuos,3);
                //poblacionSelecta = seleccion.seleleccionPorMuestreoEstocasticoUniversal(poblacion,numeroDeIndividuos);
            
                
                //cruza para usar con interfaz
                poblacionCruzada=tipoCruza(opcionCruza,poblacionSelecta,numeroDeGenes);
                //poblacionCruzada = cruza.cruzaPorEmparejamiento(poblacionSelecta,numeroDeGenes);
                //poblacionCruzada = cruza.cruzaPorOrden(poblacionSelecta,numeroDeGenes);
                //poblacionCruzada = cruza.cruzaPorCiclos(poblacionSelecta,numeroDeGenes);
                
                //mutacion
                poblacionMutada=tipoMutacion(opcionMutacion,poblacionCruzada,porcentaje,numeroDeGenes); 
                //poblacionMutada=mutacion.mutacionPorIntercambio(poblacionCruzada,porcentaje,numeroDeGenes);
                //poblacionMutada=mutacion.mutacionPorInsercion(poblacionCruzada,porcentaje,numeroDeGenes);
                
                poblacion=evaluarIndividuos(poblacionMutada);
                
                //para obtener El promedio general de cada generacion
                double SumaAptitudes=0;
                int totalIndividuos=0;
                for (int j = 0; j < poblacion.size(); j++) {
                     SumaAptitudes = SumaAptitudes + poblacion.get(j).getValorAptitud();
                     totalIndividuos++;
                     //para guardar todos los individuos
                     todosLosidividuosGenerados.add(poblacion.get(j));
                }
                //System.out.println("SumaAptitudes"+SumaAptitudes);
                double promedio =  SumaAptitudes / totalIndividuos;
                //System.out.println("promedio"+promedio);
                individuoPer indi = new individuoPer();
                indi.setValorDecimal(promedio);
                promedioPorGeneracion.add(indi);
                mejoresIndividuosPoblacion.add(buscarMejorIndividuo(poblacion));
                //mostrarPoblacionPer(poblacion);
                SumaAptitudes=0;
                promedio=0;
                totalIndividuos=0;
                indi=null;
            }
        }
        /*
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        for (int i = 0; i < mejoresIndividuosPoblacion.size(); i++) {
            System.out.println(formateador.format(mejoresIndividuosPoblacion.get(i).getValorAptitud()));
        }
        */
        /*para mostrar los perdiles
        if(vectorPerfiles != null){
            for (int i = 0; i < vectorPerfiles.size(); i++) {
                    System.out.println(vectorPerfiles.get(i).getNoPerfil()+" "+vectorPerfiles.get(i).getMedida());
                    
            }
        }
        */
        vectorPerfiles.clear();
        //mejoresIndividuosPoblacion.clear();
    }
    
    /**
     * generadorDeIndividuosPrimeraGeneracion metodo generador de la primera poblacion 
     * @param poblacion es un arrayList que representa y almacena poblacion de individuos
     * @param numeroDeIndividuos es mel numero de individuos a generar
     * @param numeroDeGenes es el numero de genes del cromosoma del individuo
     * @return poblacion que sera la poblacion generada aleatorimente
     */
    public ArrayList<individuoPer> generadorDeIndividuosPrimeraGeneracion(ArrayList<individuoPer> poblacion, int numeroDeIndividuos,int numeroDeGenes){
        
        individuoPer individuoTMP = null;//individuo temporal que guarda los valores del individuo es de tipo individuoPer
       
        for (int i = 0; i < numeroDeIndividuos; i++) {//dependiendo del numero de individuos sera el tamaño del arrarlist de poblacion
            individuoTMP =new individuoPer();
            //el metodo generadorDeGenesEnteros retorna un indiciduo generado aleatoriamente y almacenado en individuoTMP
            individuoTMP = generadorDeGenesEnteros(individuoTMP,numeroDeGenes);
            //el individuo generado aletoriamente es almacenado en la poblacion 
            poblacion.add(individuoTMP);
        }
        //metodos opcionales indepencientes del codigo funcional solo para pruevas
            //metodo para mostrar la poblacion
            //mostrarPoblacion(poblacion);
            //buscarMejorIndividuo(poblacion);
            //poblacion = generadorDeGenesDecimales(poblacion); 
        
        return poblacion;
    }
    
    
    /**
     * generadorDeGenesEnteros metodo generador de numeros enteros 1 hasta N numeros necesarios 
     * @param individuoTMP es un individuo temporal que almacenara los numeros generados aleatoriamente
     * @param numeroDeGenes es el tamaño que tendra el cromosoma del individuo
     * @return individuoTMP se retorna como un individuo generado aleatoriamente
     */
    public individuoPer generadorDeGenesEnteros(individuoPer individuoTMP,int numeroDeGenes){
        
        int cromosoma []=new int[numeroDeGenes];//cromosoma temporal del individuo
            //double valorDecimal=0; 
            //double valorAptitud=0; 
            cromosoma=generarEnteros(cromosoma);//la primera vercion del metodo generarEnteros
            //vervion 2 de generador de enteros metodo opcional 
            //cromosoma=generadorDenumerosAleatorios(numeroDeGenes);
            //valorDecimal=generaValorDecimal(cromosoma);
            //valorAptitud=generaValorAptitud(valorDecimal);
            
            //el cromosoma generado anteriormente se guarda en el individuo
            individuoTMP.setCromosoma(cromosoma);
            //individuoTMP.setValorDecimal(valorDecimal);
            //individuoTMP.setValorAptitud(valorAptitud);
            
            //se limpia el arrayList que se usa para generar numeros aleatorios 
            aleatorios.clear();
        return individuoTMP;
    }
    
    /*
     *metodo para generar numeros aleatorios binarios para el cromosoma
    */
    /**
     * generarEnteros se usa para generar numeros enteros aletorios
     * @param cromosoma se usa un vector de cromosoma para ser llenado aleatoriamente
     * @return cromosoma que es el cromosoma del individuo generado aleatoriamente
     */
    public int[] generarEnteros(int []cromosoma){
        
        //se limpia el array que se usa para generar numeros no repetidos
        usados.clear();
        /*Aqui se especifica la codificaion */
        //aleatorios=generaNumerosAleatorios(cromosoma.length,(cromosoma.length+3));//cambiar a +3 cuando 
        //aleatorios=generaNumerosAleatorios(cromosoma.length,(cromosoma.length+2));//cambiar a +3 cuando 
        aleatorios=generaNumerosAleatorios(cromosoma.length,(cromosoma.length+1));//cambiar a +3 cuando 
        //cuando en la funcion generaNumerosAleatorios en el metodo corte=aleatorio3 sta iniciado en 1

        for (int i = 0; i < aleatorios.size(); i++) {
                cromosoma[i]=(int)aleatorios.get(i);    
        }
        
        return cromosoma;
    }
    
    
    
    
    public ArrayList generaNumerosAleatorios(int numeroDepuntosAgenerar,int numeroDepuntosAletoriosMaximos){
        //System.out.println("entro al metodo");
        ArrayList  ale = new ArrayList  (numeroDepuntosAgenerar);
        int corte;
        for (int i = 0; i < numeroDepuntosAgenerar; i++) {
                /*
                 *Para qeu los numero aleatorios comiensen desde 1 usar 0 para inicia desde 0
                 */
                corte=aleatorio3(1,numeroDepuntosAletoriosMaximos);
                ale.add(corte);
        }
       
        //Collections.sort(ale);

        return ale;
    }
    
    /*funcion de numeros aleatorios por rango especifico cercion 2*/
    public int aleatorio3(int minimo, int maximo){ 
        Random aleatorio = new Random();
        if (usados.size() != (maximo - minimo)) { 
            int numero=0;
            boolean repe = false;
            do {
                //numero =(int) Math.floor(Math.random()*(maximo-minimo+1))+minimo;
                numero =(int) (aleatorio.nextDouble() * ((maximo)-1) +minimo);
                repe=repetido(numero);
                if(repe==true){
                    //System.out.println("esta repetido");
                }
            }while (repe != false);
            usados.add(numero);      
            return numero; 
        }else{
            return 0; 
        }
    }
    
    public boolean repetido(int numero){ 
        boolean repe= false;
        //System.out.println("en metodo");
        for (int i = 0; i < usados.size(); i++) {
            int auxRepe=((int)usados.get(i));
            if (numero == auxRepe) {
                repe = true; 
            }
        }
        return repe; 
    } 
    
    
    
    public ArrayList<individuoPer> evaluarIndividuos(ArrayList<individuoPer> poblacion){
        
        for (int i = 0; i < poblacion.size(); i++) {
            //poblacion.get(i).setValorDecimal(generaValorDecimal(poblacion.get(i).getCromosoma()));
            ////System.out.println("\nIndividuo: "+i);
            //double aptitud = funciondeActitud(poblacion.get(i).getCromosoma(),vectorPerfiles);
            //double aptitud = funciondeActitudPruevas(poblacion.get(i).getCromosoma(),vectorPerfiles);
            //double aptitud = funciondeActitudPruevas2(poblacion.get(i).getCromosoma(),vectorPerfiles);
            //double aptitud = funciondeActitudPruevas3(poblacion.get(i).getCromosoma(),vectorPerfiles);
            //la que imprime todo
            //double aptitud = funciondeActitudPruevas7(poblacion.get(i).getCromosoma(),vectorPerfiles);
            double aptitud = funciondeActitudPruevas8(poblacion.get(i).getCromosoma(), MedidaDePerfiles);
            //sin imprecion de nada
            //double aptitud = funciondeActitudPruevas6(poblacion.get(i).getCromosoma(),vectorPerfiles);

            poblacion.get(i).setValorAptitud(aptitud);
        }
        return poblacion;
    }
    
    
    /*
     *Se obtiene el valor decimal dependiendo del cromooma que su valor 
     *se obtiene a cuando es equivalente al numero en binario
     *se usa el metodo convertirBinarioaEntero para obtener su su simil en decimal
     *como parametro se usa el cromoma del individuo
     */
    /*
    public double generaValorDecimal(int []cromosoma){
        double valorDecimal=0;
            valorDecimal=convertirBinarioaEntero(cromosoma);
        return valorDecimal;
    }
    */
    /*
     *metodo para convertir el numero equivalente en binario en decimal se usa
     *como parametro el cromosoma del individuo
     */
    /*
    public int convertirBinarioaEntero(int[] cromosoma) {
        int valorDecimalTMP = 0;
        for (int i = 0; i < cromosoma.length; i++) {
            valorDecimalTMP=valorDecimalTMP+cromosoma[i]; 
        }
        return valorDecimalTMP;
    }
    */
    /*
     *metodo que obtiene el valor de la aptitud como parametro se usa
     *el valor decimal equivalente del comosoma en binario
     */
    /*
    public double generaValorAptitud(double valorDecimal){    
        double ValorAptitud=0;
            ValorAptitud=funciondeActitud(valorDecimal);
        return ValorAptitud;
    } 
    
    */
    /*
     *metodo que contiene la funcion de aptitud a evaluar aqui es donde se 
     *cambia la funcion de aptitud
     */
    //  ArrayList <perfil> vectorPerfiles
    public double funciondeActitud(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        /*solo se cambia el tipo de funcion al que quiera evaluar*/
        double valorAptitud = 0.0;
          
        
        //perfil de inicio
        //    pN     PC     Vericicacion
        //    6.10 > 0.20   true      perfil nuevo a 6.10
        //    5.9  > 0.80   true      se resta perfil 
        //    5.1  > 0.60   true      se resta perfil
        //    4.5  > 0.90   true      se resta perfil
        //    3.6  > 1.50   true      se resta perfil 
        //    3.6  > 1.10   true      se resta perfil
        //    2.5  > 2.10   true      se resta perfil
        //    0.4  < 0.90   false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //nuevo perfil se ha sumado un perfil
        //    pN      PC     Vericicacion
        //    6.10  > 2.30   true         perfil nuevo a 6.10
        //    3.8   > 1.90   true         se resta perfil 
        //    1.9   > 0.30   true         se resta perfil
        //    1.6   > 0.48   true         se resta perfil
        //    1.12  > 0.38   true         se resta perfil 
        //    0.74  > 0.90   false        false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //se  usa otro nuevo perfil asi susecivamnete...
        //System.out.println("perfilNuevo: "+perfilNuevo);
        
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        
        int x = 0;
        double perfilNuevoTmp = 6.10;
        double perfilNueavoFaltanteTmp = 0.0;
        double desperdicioDePerfilTmp=0.0;
        double desperdicioTotalPerfil=0.0;
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        do{ 
            //para dar formato de salida 
            
            //para obtener el tamaño del perfil a corcar
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //se da un salto de linea 
            System.out.println("");                                //para mostrar
            //se muestra el perfil existente 
            System.out.print(":"+formateador.format(perfilNuevoTmp));     //para mostrar
            
            /*
            //se ferifica si el perfil nuevo aun alcansa y si no es mas grande el perfil a cortar 
            if(medidaPerfilAcortar > desperdicioPorPerfilTmp){ 
                        System.out.println("ya no alcabsa...");
                        //para verificar desde antes si el perfil que se quiere cortar no revasa al perfil nuevo 
                        //si no para tomar otro 
                        perfilTmp = 6.10;
            }
            */
            //System.out.println(":"+medidaPerfilAcortar);
            //if(perfilNueavoTmp >= medidaPerfilAcortar){
                
                perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                perfilNueavoFaltanteTmp = perfilNuevoTmp;
                if(perfilNueavoFaltanteTmp < 0){
                    System.out.println("\nya no alcanso usar otro...");
                    System.out.println("");
                    //desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar; //sumamos la medida que se resto anteriormente para saber si se necesitaba otro perfil para saber el desperdico final 
                    desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar;
                    desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp;
                    System.out.println("desperdicio: "+desperdicioDePerfilTmp);
                    perfilNuevoTmp = 6.10;
                    System.out.print(formateador.format(perfilNuevoTmp));
                    perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                  }
            //}
            
             System.out.print(" - "+formateador.format(medidaPerfilAcortar)+" = "+formateador.format(perfilNuevoTmp)); //para mostrar
            
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNueavoFaltanteTmp)); //para mostrar
             System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); //para mostrar
             
             //la sigueinte condicion la he propuesto por un error que he encontrado al hacer las restas
             //la resta que ocaciona un numero menor a 0 guardadda en la variable llamada perfilNueavoFaltanteTmp, 
             //son contados las ocaciones las veses que susede, lo que pasa es la variable que almacena temporalmente el perfil faltante 
             //guarda el numero restado de la ultima opracion  por ejemplo se tiene en la variable perfilNuevoTmp =  0.63 
             //pero se le va hacer la resta del ultimo perfil que es mayor a la variable perfilNuevoTmp o sea que la variable medidaPerfilAcortar se va a restar y es mayo,
             //ejemplo de 1.5 la cual es ams grande, el resultado de esta operacion es de la siguiente manera 0.63 - 1.5 = -0.87
             //lo cual es un numero menor a cero este numero se almacena en la variable perfilNueavoFaltanteTmp
             //y como ya es el ultimo perfil ya no pueda pasar por la verificacion en la que se identifica que ya no alcanso 
             //y cambiar el contador perfilNuevoTmp he indique perfilNueavoFaltanteTmp que ya no es un numero mayor a cero 
             //lo cual como solucion si es la ultima pieza, y perfilNueavoFaltanteTmp es nemor a cero indica 
             //que es el ultimo perfil ya no hay mas que hcer pero la variable temporal perfilNueavoFaltanteTmp
             //dejo almacenada el numero menor y eso afecta al desprdicio si es el ultimo perfil a cortar
             //ya que si sobra perfil pero la variable ya no fue actializada por ya no pasar por la verificacion 
             //por ello quiero volver a sumar lo restado mas lo almacenado el la variable de perfil faltante y 
             //se tenga el valor correcto del desperdico que es el afectado 
             
             
             
             x++;
             
        }while(x < cromosoma.length);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(desperdicioTotalPerfil+perfilNueavoFaltanteTmp));
        System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil+perfilNuevoTmp)));
        
        /* 
        int numeroDePerfilesUsados=0;
        double perfilNuevo = 6.10;                          //servira como un contador pero hira decrementando
        double desperdicioTotal = 0.0; //servira como un contador de desperdicioTotal hora incrementando
        double desperdicioPorPerfil = 0.0; //desperdicio de cada perfil
        
        
        primera vercion de funcion aptitud
        int contadorDePerfilesFaltantes = cromosoma.length; //contador para saber cuantos perfiles faltas
        for (int i = 0; i < cromosoma.length; i++) {
            //buscar la medida del perfil identificado por el numero que el gen trae;
           double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[i],vectorPerfiles);
   
           // algoritmo para un solo perfil hasta que se acabe y si exite aun perfiles por cortar no los cuenta  ese es el error
           
           if(perfilNuevo >= medidaPerfilAcortar){
                DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
                System.out.println("");                                //para mostrar
                System.out.print(formateador.format(perfilNuevo));     //para mostrar
                perfilNuevo=perfilNuevo-medidaPerfilAcortar;
                System.out.print(" - "+formateador.format(medidaPerfilAcortar)+"="+formateador.format(perfilNuevo)); //para mostrar
               
            }else{
                desperdicioPorPerfil=perfilNuevo;
                DecimalFormat formateador = new DecimalFormat("#.##");
                System.out.println("\nDesperdicio == "+formateador.format(desperdicioPorPerfil));
                desperdicioTotal = desperdicioTotal + desperdicioPorPerfil;

                perfilNuevo=6.10;
                numeroDePerfilesUsados++;
                desperdicioPorPerfil = 0.0;  
            }
           
            
        }
        */
        //valorAptitud = (desperdicioTotalPerfil+perfilNueavoFaltanteTmp);
        valorAptitud = (desperdicioTotalPerfil+perfilNuevoTmp);
        return valorAptitud;
    }
    
    public double funciondeActitudPruevas4(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
       
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        
        int x = 0;
        double perfilNuevo  =6.10;
        double sumatoriaDeperfiles =0.0;
        double desperdicioPorPerfil=0.0;
        double desperdicioTotalDePerfiles=0.0;
        ArrayList<Double>  desperdicios = new ArrayList<Double>(); 
        
        do{ 
            
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            System.out.println("");                              
            System.out.print("PN: "+formateador.format(perfilNuevo));
            
            boolean verificacion = true;
            sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                  
            if(perfilNuevo > sumatoriaDeperfiles){
                verificacion = true;
            }else{
                verificacion = false;
            }
            int i=0;
            if(verificacion == false){
                      
                      //despues de saber que la sumatoria de perfilesa a cortar a sobre 
                      //pasado al perfil nuevo lo que se hace es restar el ultimo 
                      //perfil a cortar que indica que es mayor al perfil nuevo 
                      //para que se tenga la sumatoria anterior que no sobre pasa 
                      //al perfil nuevo para poder hacer la operacion correcto 
                      //y no obtener negativos 
                    sumatoriaDeperfiles=sumatoriaDeperfiles-medidaPerfilAcortar;
                      //despues de haber restado el ultimo perfil hasta ese momento 
                      //se hace la operacion de restar la sumatoria de perfiles 
                      //al perfil nuevo que dara como resultado el desperdicio
                    perfilNuevo=perfilNuevo-sumatoriaDeperfiles;
                      //lo que salga de ese ressultado lo agragamos a desperdicio de ese unico perfil
                    desperdicioPorPerfil=perfilNuevo;
                    desperdicios.add(desperdicioPorPerfil);
                    System.out.println("\ndesperdicio: "+desperdicioPorPerfil);
                      //despues ese desperdicio de ese unico perfil se almacena en el total de 
                      //de desperdicios de todos los perfiles
                    desperdicioTotalDePerfiles = desperdicioTotalDePerfiles + desperdicioPorPerfil;
                    
                      //los contadores de sumatoria y perdil nuevo toman su valor original
                    sumatoriaDeperfiles = 0.0;
                    perfilNuevo =6.10;
                        
                      /**********hasta este punto se ha receteado todo pero no se empesado a usar otro  perfil*/
                      //mas sin embargo exiten aun perfiles que cortar por ello se tiene comprendido que se
                      //resto un ultimo perfil a cortar que sobre pasaba la sumatoria 
                      //ese perfil debe de ser evaluado nuevamente pero con un nuevo perfil de la siguiente manera
                      //entonces se agregara a la nueva sumatoria de perfiles que atras se havia resetado 
                      //y quedado en cero hasta este puento se a iniciado una nueva comparacion 
                      //con otro nuevo perfil 
                      //y se inicia nuevamente el mismo procesimiento
                    System.out.print("PN: "+formateador.format(perfilNuevo));
                    sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                    //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
                    verificacion = true;
            }
            System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); 

             x++;
        }while(x < cromosoma.length);
        System.out.println("*********************");
        for (int i = 0; i < desperdicios.size(); i++) {
            System.out.println(","+desperdicios.get(i));
        }
        
        System.out.print("\nsumatoria"+sumatoriaDeperfiles);
        float ultimoDesperdicio =(float) (6.10-sumatoriaDeperfiles);
        System.out.print("\ndesperdicio ultimo perfil"+ ultimoDesperdicio);
        System.out.print("\ndesperdicio de primer perfil"+ desperdicios.get(0));
        
        //System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        //double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)));
        System.out.print("\nEl desperdicio total de perfiles usados2: "+formateador.format(desperdicioTotalDePerfiles));
        System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio: "+formateador.format(desperdicioTotalDePerfiles+ultimoDesperdicio));
        System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio menos el primer desperdicio: "+formateador.format((desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0)));
        
      
        //valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp));
        valorAptitud = desperdicioTotalDePerfiles;
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio);
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0);
        
        return valorAptitud;
    }
    
    public double funciondeActitudPruevas7(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
        /*
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        */  
      
        int x = 0;
        double perfilNuevo  =5.60;
        //double perfilNuevo  =6.10; original
        double desperdicioTotalDePerfiles=0.0;
        int cantidadperfiles=0;
        
        do{ 
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            boolean esMayor = true;
            double PN  = fijarNumero(perfilNuevo,2);
            double PAC = fijarNumero(medidaPerfilAcortar,2);
            //System.out.println("");                              
            //System.out.print("PN: "+PN);
            if(PN >= PAC){
                esMayor = true;
            }else{
                esMayor = false;
            }
            if(esMayor == true){
                perfilNuevo=perfilNuevo-PAC;
                //System.out.print("-PA:"+PAC+"   PN: al restar: "+PN);
            }else{
                //System.out.println("*****");
                double desperdicioPP=PN;
                double DESPP = fijarNumero(desperdicioPP,2);
                desperdicioTotalDePerfiles = fijarNumero(desperdicioTotalDePerfiles+DESPP,2);
                //System.out.print("desperdicio: "+desperdicioPP);
                //System.out.println("");
                cantidadperfiles++;
                //perfilNuevo=6.10; original
                perfilNuevo  = 5.60;
                //System.out.print("PN: "+perfilNuevo);
                perfilNuevo=perfilNuevo-PAC;
                //System.out.print("-PA:"+PAC+"   PN: al restar: "+PN);
                esMayor = true;
            }
            
             x++;
        }while(x < cromosoma.length);
        cantidadperfiles++;
        //System.out.print("\nPNF:"+formateador.format(perfilNuevo));
        //System.out.print("\nCantidad de perfiles:"+cantidadperfiles);
        //System.out.print("\ndesperdicioTotalDePerfilesSinUltimo: "+formateador.format(desperdicioTotalDePerfiles));
        //System.out.print("\ndesperdicioDetodosLosPerfilesUsados: "+formateador.format(desperdicioTotalDePerfiles+perfilNuevo));
        
        //valorAptitud = cantidadperfiles;
        //valorAptitud = desperdicioTotalDePerfiles;
        valorAptitud = desperdicioTotalDePerfiles+perfilNuevo;

        desperdicioTotalDePerfiles=0.0;
        cantidadperfiles=0;
        //perfilNuevo  =6.10; original 
        perfilNuevo  =5.60; 
        
        return valorAptitud;
    }
    
    //ya se agrego la medida desde la interfaz
    public double funciondeActitudPruevas8(int cromosoma[],Map<Integer, Double> MedidaDePerfiles) {
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
        /*
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        */  
      
        //for (int i = 0; i < MedidaDePerfiles.size(); i++) {
//            System.out.println(""+MedidaDePerfiles.get(i+1));
//        }
        
        
        int x = 0;
        double perfilNuevo  = estandarPerfi;
        //double perfilNuevo  =6.10; original
        double desperdicioTotalDePerfiles=0.0;
        int cantidadperfiles=0;
        
        do{ 
            double medidaPerfilAcortar = buscarMedidaPerfil2(cromosoma[x],MedidaDePerfiles);
            
            boolean esMayor = true;
            double PN  = fijarNumero(perfilNuevo,2);
            double PAC = fijarNumero(medidaPerfilAcortar,2);
            //System.out.println("");                              
            //System.out.print("PN: "+PN);
            if(PN >= PAC){
                esMayor = true;
            }else{
                esMayor = false;
            }
            if(esMayor == true){
                perfilNuevo=perfilNuevo-PAC;
                //System.out.print("-PA:"+PAC+"   PN: al restar: "+PN);
            }else{
                //System.out.println("*****");
                double desperdicioPP=PN;
                double DESPP = fijarNumero(desperdicioPP,2);
                desperdicioTotalDePerfiles = fijarNumero(desperdicioTotalDePerfiles+DESPP,2);
                //System.out.print("desperdicio: "+desperdicioPP);
                //System.out.println("");
                cantidadperfiles++;
                //perfilNuevo=6.10; original
                perfilNuevo  = estandarPerfi;
                //System.out.print("PN: "+perfilNuevo);
                perfilNuevo=perfilNuevo-PAC;
                //System.out.print("-PA:"+PAC+"   PN: al restar: "+PN);
                esMayor = true;
            }
            
             x++;
        }while(x < cromosoma.length);
        cantidadperfiles++;
        //System.out.print("\nPNF:"+formateador.format(perfilNuevo));
        //System.out.print("\nCantidad de perfiles:"+cantidadperfiles);
        //System.out.print("\ndesperdicioTotalDePerfilesSinUltimo: "+formateador.format(desperdicioTotalDePerfiles));
        //System.out.print("\ndesperdicioDetodosLosPerfilesUsados: "+formateador.format(desperdicioTotalDePerfiles+perfilNuevo));
        
        //valorAptitud = cantidadperfiles;
        //valorAptitud = desperdicioTotalDePerfiles;
        valorAptitud = desperdicioTotalDePerfiles+perfilNuevo;

        desperdicioTotalDePerfiles=0.0;
        cantidadperfiles=0;
        //perfilNuevo  =6.10; original 
        perfilNuevo  = estandarPerfi; 
        
        return valorAptitud;
    }
    
    public double fijarNumero(double numero, int digitos){
        double resultado;
            resultado = numero * Math.pow(10,digitos);
            resultado = Math.round(resultado);
            resultado = resultado/Math.pow(10,digitos);
        return resultado;
    }
    
    
    public double funciondeActitudPruevas6(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
       
        /*
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        */
        
        int x = 0;
        double perfilNuevo  =6.10;
        double sumatoriaDeperfiles =0.0;
        double desperdicioPorPerfil=0.0;
        double desperdicioTotalDePerfiles=0.0;
        ArrayList<Double>  desperdicios = new ArrayList<Double>(); 
        
        do{ 
            
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //System.out.println("");                              
            //System.out.print("PN: "+formateador.format(perfilNuevo));
            
            boolean verificacion = true;
            sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                  
            if(perfilNuevo > sumatoriaDeperfiles){
                verificacion = true;
            }else{
                verificacion = false;
            }
            int i=0;
            if(verificacion == false){
                      
                      //despues de saber que la sumatoria de perfilesa a cortar a sobre 
                      //pasado al perfil nuevo lo que se hace es restar el ultimo 
                      //perfil a cortar que indica que es mayor al perfil nuevo 
                      //para que se tenga la sumatoria anterior que no sobre pasa 
                      //al perfil nuevo para poder hacer la operacion correcto 
                      //y no obtener negativos 
                    sumatoriaDeperfiles=sumatoriaDeperfiles-medidaPerfilAcortar;
                      //despues de haber restado el ultimo perfil hasta ese momento 
                      //se hace la operacion de restar la sumatoria de perfiles 
                      //al perfil nuevo que dara como resultado el desperdicio
                    perfilNuevo=perfilNuevo-sumatoriaDeperfiles;
                      //lo que salga de ese ressultado lo agragamos a desperdicio de ese unico perfil
                    desperdicioPorPerfil=perfilNuevo;
                    desperdicios.add(desperdicioPorPerfil);
                    //System.out.println("\ndesperdicio: "+desperdicioPorPerfil);
                      //despues ese desperdicio de ese unico perfil se almacena en el total de 
                      //de desperdicios de todos los perfiles
                    desperdicioTotalDePerfiles = desperdicioTotalDePerfiles + desperdicioPorPerfil;
                    
                      //los contadores de sumatoria y perdil nuevo toman su valor original
                    sumatoriaDeperfiles = 0.0;
                    perfilNuevo =6.10;
                        
                      /**********hasta este punto se ha receteado todo pero no se empesado a usar otro  perfil*/
                      //mas sin embargo exiten aun perfiles que cortar por ello se tiene comprendido que se
                      //resto un ultimo perfil a cortar que sobre pasaba la sumatoria 
                      //ese perfil debe de ser evaluado nuevamente pero con un nuevo perfil de la siguiente manera
                      //entonces se agregara a la nueva sumatoria de perfiles que atras se havia resetado 
                      //y quedado en cero hasta este puento se a iniciado una nueva comparacion 
                      //con otro nuevo perfil 
                      //y se inicia nuevamente el mismo procesimiento
                    //System.out.print("PN: "+formateador.format(perfilNuevo));
                    sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                    //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
                    verificacion = true;
            }
            //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); 

             x++;
        }while(x < cromosoma.length);
        /*
        System.out.println("*********************");
        for (int i = 0; i < desperdicios.size(); i++) {
            System.out.println(","+desperdicios.get(i));
        }
        */
        //System.out.print("\nsumatoria"+sumatoriaDeperfiles);
        float ultimoDesperdicio =(float) (6.10-sumatoriaDeperfiles);
        //System.out.print("\ndesperdicio ultimo perfil"+ ultimoDesperdicio);
        //System.out.print("\ndesperdicio de primer perfil"+ desperdicios.get(0));
        
        //System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        //double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)));
        //System.out.print("\nEl desperdicio total de perfiles usados2: "+formateador.format(desperdicioTotalDePerfiles));
        //System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio: "+formateador.format(desperdicioTotalDePerfiles+ultimoDesperdicio));
        //System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio menos el primer desperdicio: "+formateador.format((desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0)));
        
      
        //valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp));
        valorAptitud = desperdicioTotalDePerfiles;
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio);
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0);
        
        return valorAptitud;
    }
    
    
    public double funciondeActitudPruevas5(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
       
        //System.out.println("--------------------------------------------------------------------------------------------------");
        /*
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        */
        int x = 0;
        double perfilNuevo  =6.10;
        double sumatoriaDeperfiles =0.0;
        double desperdicioPorPerfil=0.0;
        double desperdicioTotalDePerfiles=0.0;
         
        
        do{ 
            
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //System.out.println("");                              
            //System.out.print("PN: "+formateador.format(perfilNuevo));
            
            boolean verificacion = true;
            sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                  
            if(perfilNuevo > sumatoriaDeperfiles){
                verificacion = true;
            }else{
                verificacion = false;
            }
            
            if(verificacion == false){
                      //despues de saber que la sumatoria de perfilesa a cortar a sobre 
                      //pasado al perfil nuevo lo que se hace es restar el ultimo 
                      //perfil a cortar que indica que es mayor al perfil nuevo 
                      //para que se tenga la sumatoria anterior que no sobre pasa 
                      //al perfil nuevo para poder hacer la operacion correcto 
                      //y no obtener negativos 
                    sumatoriaDeperfiles=sumatoriaDeperfiles-medidaPerfilAcortar;
                      //despues de haber restado el ultimo perfil hasta ese momento 
                      //se hace la operacion de restar la sumatoria de perfiles 
                      //al perfil nuevo que dara como resultado el desperdicio
                    perfilNuevo=perfilNuevo-sumatoriaDeperfiles;
                      //lo que salga de ese ressultado lo agragamos a desperdicio de ese unico perfil
                    desperdicioPorPerfil=perfilNuevo;
                    //System.out.println("\ndesperdicio: "+desperdicioPorPerfil);
                      //despues ese desperdicio de ese unico perfil se almacena en el total de 
                      //de desperdicios de todos los perfiles
                    desperdicioTotalDePerfiles = desperdicioTotalDePerfiles + desperdicioPorPerfil;
                      //los contadores de sumatoria y perdil nuevo toman su valor original
                    sumatoriaDeperfiles = 0.0;
                    perfilNuevo =6.10;
                        
                      /**********hasta este punto se ha receteado todo pero no se empesado a usar otro  perfil*/
                      //mas sin embargo exiten aun perfiles que cortar por ello se tiene comprendido que se
                      //resto un ultimo perfil a cortar que sobre pasaba la sumatoria 
                      //ese perfil debe de ser evaluado nuevamente pero con un nuevo perfil de la siguiente manera
                      //entonces se agregara a la nueva sumatoria de perfiles que atras se havia resetado 
                      //y quedado en cero hasta este puento se a iniciado una nueva comparacion 
                      //con otro nuevo perfil 
                      //y se inicia nuevamente el mismo procesimiento
                    //System.out.print("PN: "+formateador.format(perfilNuevo));
                    sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                    //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
                    verificacion = true;
            }
            //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); 

             x++;
        }while(x < cromosoma.length);
        
        //System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        //double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)));
        //System.out.println("\nEl desperdicio total de perfiles usados2: "+formateador.format(desperdicioTotalDePerfiles));
        
      
        //valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp));
        valorAptitud = desperdicioTotalDePerfiles;
        
        return valorAptitud;
    }
    
    
    
    
    public double funciondeActitudPruevas3(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        /*solo se cambia el tipo de funcion al que quiera evaluar*/
        double valorAptitud = 0.0;
          
        
        //perfil de inicio
        //    pN     PC     Vericicacion
        //    6.10 > 0.20   true      perfil nuevo a 6.10
        //    5.9  > 0.80   true      se resta perfil 
        //    5.1  > 0.60   true      se resta perfil
        //    4.5  > 0.90   true      se resta perfil
        //    3.6  > 1.50   true      se resta perfil 
        //    3.6  > 1.10   true      se resta perfil
        //    2.5  > 2.10   true      se resta perfil
        //    0.4  < 0.90   false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //nuevo perfil se ha sumado un perfil
        //    pN      PC     Vericicacion
        //    6.10  > 2.30   true         perfil nuevo a 6.10
        //    3.8   > 1.90   true         se resta perfil 
        //    1.9   > 0.30   true         se resta perfil
        //    1.6   > 0.48   true         se resta perfil
        //    1.12  > 0.38   true         se resta perfil 
        //    0.74  > 0.90   false        false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //se  usa otro nuevo perfil asi susecivamnete...
        //System.out.println("perfilNuevo: "+perfilNuevo);
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        
        int x = 0;
        double perfilNuevoTmp = 6.10;
        double perfilNuevoTmp2 = 6.10;
        double perfilNueavoFaltanteTmp = 0.0;
        double desperdicioDePerfilTmp=0.0;
        double desperdicioDePerfilTmp2=0.0;
        double desperdicioTotalPerfil=0.0;
        //double desperdicioTotalPerfil2=0.0;
         
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double SumatoriaPerfiles=0.0;
        do{ 
            //System.out.println("X: >>>>"+x);
            //para dar formato de salida 
            
            //para obtener el tamaño del perfil a corcar
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //se da un salto de linea 
            System.out.println("");                                //para mostrar
            //se muestra el perfil existente 
            System.out.print(":"+formateador.format(perfilNuevoTmp));     //para mostrar
            
            /*
            //se ferifica si el perfil nuevo aun alcansa y si no es mas grande el perfil a cortar 
            if(medidaPerfilAcortar > desperdicioPorPerfilTmp){ 
                        System.out.println("ya no alcabsa...");
                        //para verificar desde antes si el perfil que se quiere cortar no revasa al perfil nuevo 
                        //si no para tomar otro 
                        perfilTmp = 6.10;
            }
            */
            //System.out.println(":"+medidaPerfilAcortar);
            //if(perfilNueavoTmp >= medidaPerfilAcortar){
                
                perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                perfilNueavoFaltanteTmp = perfilNuevoTmp;
                
                
                
                if(perfilNueavoFaltanteTmp < 0){
                    System.out.println("\nya no alcanso usar otro...");
                    System.out.println("");
                    //desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar; //sumamos la medida que se resto anteriormente para saber si se necesitaba otro perfil para saber el desperdico final 
                    desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar;
                    desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp;
                    System.out.println("desperdicio: "+desperdicioDePerfilTmp);
                    perfilNuevoTmp = 6.10;
                    System.out.print(formateador.format(perfilNuevoTmp));
                    perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                    
                    
                    
                    
                  }
                
                  
                  
                  
                  /*
                
                  
                  if(perfilNuevoTmp2 > SumatoriaPerfiles){
                      verificacion = true;
                        
                        //System.out.println("\t\t\tSumatoriaPerfiles---"+SumatoriaPerfiles);
                        //double sumatoria = SumatoriaPerfiles-medidaPerfilAcortar;
                        //desperdicioDePerfilTmp2 = perfilNuevoTmp2-sumatoria;
                        //desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp2;
                        //System.out.println("desperdicio: "+desperdicioDePerfilTmp2);

                        //System.out.println("");
                        //SumatoriaPerfiles = 0.0;
                        //SumatoriaPerfiles=SumatoriaPerfiles+medidaPerfilAcortar;
                  }else{
                      verificacion = false;
                      
                  }
                  */
                  boolean verificacion = true;
                  SumatoriaPerfiles = SumatoriaPerfiles + medidaPerfilAcortar;
                  
                  if(perfilNuevoTmp2 > SumatoriaPerfiles){
                      verificacion = true;
                  }else{
                      verificacion = false;
                  }
                  
                  if(verificacion == false){
                      //despues de saber que la sumatoria de perfilesa a cortar a sobre 
                      //pasado al perfil nuevo lo que se hace es restar el ultimo 
                      //perfil a cortar que indica que es mayor al perfil nuevo 
                      //para que se tenga la sumatoria anterior que no sobre pasa 
                      //al perfil nuevo para poder hacer la operacion correcto 
                      //y no obtener negativos 
                      SumatoriaPerfiles=SumatoriaPerfiles-medidaPerfilAcortar;
                      //despues de haber restado el ultimo perfil hasta ese momento 
                      //se hace la operacion de restar la sumatoria de perfiles 
                      //al perfil nuevo que dara como resultado el desperdicio
                      perfilNuevoTmp2=perfilNuevoTmp2-SumatoriaPerfiles;
                      //lo que salga de ese ressultado lo agragamos a desperdicio de ese unico perfil
                      desperdicioDePerfilTmp2=perfilNuevoTmp2;
                      System.out.println("desperdicio: "+desperdicioDePerfilTmp2);
                      //despues ese desperdicio de ese unico perfil se almacena en el total de 
                      //de desperdicios de todos los perfiles
                      desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp2;
                      //los contadores de sumatoria y perdil nuevo toman su valor original
                      SumatoriaPerfiles = 0.0;
                      perfilNuevoTmp2 =6.10;
                        
                      /**********hasta este punto se ha receteado todo pero no se empesado a usar otro  perfil*/
                      //mas sin embargo exiten aun perfiles que cortar por ello se tiene comprendido que se
                      //resto un ultimo perfil a cortar que sobre pasaba la sumatoria 
                      //ese perfil debe de ser evaluado nuevamente pero con un nuevo perfil de la siguiente manera
                      //entonces se agregara a la nueva sumatoria de perfiles que atras se havia resetado 
                      //y quedado en cero hasta este puento se a iniciado una nueva comparacion 
                      //con otro nuevo perfil 
                      //y se inicia nuevamente el mismo procesimiento
                      SumatoriaPerfiles = SumatoriaPerfiles + medidaPerfilAcortar;
                      verificacion = true;
                  }
                  
                
            //}
            
             System.out.print(" - "+formateador.format(medidaPerfilAcortar)+" = "+formateador.format(perfilNuevoTmp)); //para mostrar
            
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNueavoFaltanteTmp)); //para mostrar
             System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); //para mostrar
             System.out.println("\tSumatoriaPerfiles---"+SumatoriaPerfiles);
             //la sigueinte condicion la he propuesto por un error que he encontrado al hacer las restas
             //la resta que ocaciona un numero menor a 0 guardadda en la variable llamada perfilNueavoFaltanteTmp, 
             //son contados las ocaciones las veses que susede, lo que pasa es la variable que almacena temporalmente el perfil faltante 
             //guarda el numero restado de la ultima opracion  por ejemplo se tiene en la variable perfilNuevoTmp =  0.63 
             //pero se le va hacer la resta del ultimo perfil que es mayor a la variable perfilNuevoTmp o sea que la variable medidaPerfilAcortar se va a restar y es mayo,
             //ejemplo de 1.5 la cual es ams grande, el resultado de esta operacion es de la siguiente manera 0.63 - 1.5 = -0.87
             //lo cual es un numero menor a cero este numero se almacena en la variable perfilNueavoFaltanteTmp
             //y como ya es el ultimo perfil ya no pueda pasar por la verificacion en la que se identifica que ya no alcanso 
             //y cambiar el contador perfilNuevoTmp he indique perfilNueavoFaltanteTmp que ya no es un numero mayor a cero 
             //lo cual como solucion si es la ultima pieza, y perfilNueavoFaltanteTmp es nemor a cero indica 
             //que es el ultimo perfil ya no hay mas que hcer pero la variable temporal perfilNueavoFaltanteTmp
             //dejo almacenada el numero menor y eso afecta al desprdicio si es el ultimo perfil a cortar
             //ya que si sobra perfil pero la variable ya no fue actializada por ya no pasar por la verificacion 
             //por ello quiero volver a sumar lo restado mas lo almacenado el la variable de perfil faltante y 
             //se tenga el valor correcto del desperdico que es el afectado 
             
             /*
             SumatoriaPerfiles=SumatoriaPerfiles+medidaPerfilAcortar;
             if(perfilNuevoTmp2 < SumatoriaPerfiles){
                 desperdicioTotalPerfil2 = perfilNuevoTmp2-SumatoriaPerfiles;
                 //System.out.println("desperdicio: "+desperdicioDePerfilTmp);
                 SumatoriaPerfiles = 0.0;
                 SumatoriaPerfiles=SumatoriaPerfiles+medidaPerfilAcortar;
                 System.out.println("\t\tSumatoriaPerfiles---"+SumatoriaPerfiles);
             }
             
             System.out.println("\tSumatoriaPerfiles---"+SumatoriaPerfiles);
             */
             
             
             x++;
             
        }while(x < cromosoma.length);
        System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)));
        System.out.println("\nEl desperdicio total de perfiles usados2: "+desperdicioTotalPerfil);
        
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(desperdicioTotalPerfil+perfilNueavoFaltanteTmp));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil+perfilNuevoTmp)));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil)));
        
        /* 
        int numeroDePerfilesUsados=0;
        double perfilNuevo = 6.10;                          //servira como un contador pero hira decrementando
        double desperdicioTotal = 0.0; //servira como un contador de desperdicioTotal hora incrementando
        double desperdicioPorPerfil = 0.0; //desperdicio de cada perfil
        
        
        primera vercion de funcion aptitud
        int contadorDePerfilesFaltantes = cromosoma.length; //contador para saber cuantos perfiles faltas
        for (int i = 0; i < cromosoma.length; i++) {
            //buscar la medida del perfil identificado por el numero que el gen trae;
           double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[i],vectorPerfiles);
   
           // algoritmo para un solo perfil hasta que se acabe y si exite aun perfiles por cortar no los cuenta  ese es el error
           
           if(perfilNuevo >= medidaPerfilAcortar){
                DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
                System.out.println("");                                //para mostrar
                System.out.print(formateador.format(perfilNuevo));     //para mostrar
                perfilNuevo=perfilNuevo-medidaPerfilAcortar;
                System.out.print(" - "+formateador.format(medidaPerfilAcortar)+"="+formateador.format(perfilNuevo)); //para mostrar
               
            }else{
                desperdicioPorPerfil=perfilNuevo;
                DecimalFormat formateador = new DecimalFormat("#.##");
                System.out.println("\nDesperdicio == "+formateador.format(desperdicioPorPerfil));
                desperdicioTotal = desperdicioTotal + desperdicioPorPerfil;

                perfilNuevo=6.10;
                numeroDePerfilesUsados++;
                desperdicioPorPerfil = 0.0;  
            }
           
            
        }
        */
        valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp));
        //valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil);
        //valorAptitud = (desperdicioTotalPerfil+perfilNueavoFaltanteTmp);
        //valorAptitud = (desperdicioTotalPerfil+perfilNuevoTmp);
        //valorAptitud = (desperdicioTotalPerfil);
        return valorAptitud;
    }
    
    
    public double funciondeActitudPruevas2(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        /*solo se cambia el tipo de funcion al que quiera evaluar*/
        double valorAptitud = 0.0;
          
        
        //perfil de inicio
        //    pN     PC     Vericicacion
        //    6.10 > 0.20   true      perfil nuevo a 6.10
        //    5.9  > 0.80   true      se resta perfil 
        //    5.1  > 0.60   true      se resta perfil
        //    4.5  > 0.90   true      se resta perfil
        //    3.6  > 1.50   true      se resta perfil 
        //    3.6  > 1.10   true      se resta perfil
        //    2.5  > 2.10   true      se resta perfil
        //    0.4  < 0.90   false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //nuevo perfil se ha sumado un perfil
        //    pN      PC     Vericicacion
        //    6.10  > 2.30   true         perfil nuevo a 6.10
        //    3.8   > 1.90   true         se resta perfil 
        //    1.9   > 0.30   true         se resta perfil
        //    1.6   > 0.48   true         se resta perfil
        //    1.12  > 0.38   true         se resta perfil 
        //    0.74  > 0.90   false        false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //se  usa otro nuevo perfil asi susecivamnete...
        //System.out.println("perfilNuevo: "+perfilNuevo);
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        
        int x = 0;
        double perfilNuevoTmp = 6.10;
        double perfilNueavoFaltanteTmp = 0.0;
        double desperdicioDePerfilTmp=0.0;
        double desperdicioTotalPerfil=0.0;
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        do{ 
            //System.out.println("X: >>>>"+x);
            //para dar formato de salida 
            
            //para obtener el tamaño del perfil a corcar
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //se da un salto de linea 
            System.out.println("");                                //para mostrar
            //se muestra el perfil existente 
            System.out.print(":"+formateador.format(perfilNuevoTmp));     //para mostrar
            
            /*
            //se ferifica si el perfil nuevo aun alcansa y si no es mas grande el perfil a cortar 
            if(medidaPerfilAcortar > desperdicioPorPerfilTmp){ 
                        System.out.println("ya no alcabsa...");
                        //para verificar desde antes si el perfil que se quiere cortar no revasa al perfil nuevo 
                        //si no para tomar otro 
                        perfilTmp = 6.10;
            }
            */
            //System.out.println(":"+medidaPerfilAcortar);
            //if(perfilNueavoTmp >= medidaPerfilAcortar){
                
                perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                perfilNueavoFaltanteTmp = perfilNuevoTmp;
                if(perfilNueavoFaltanteTmp < 0){
                    System.out.println("\nya no alcanso usar otro...");
                    System.out.println("");
                    //desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar; //sumamos la medida que se resto anteriormente para saber si se necesitaba otro perfil para saber el desperdico final 
                    desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar;
                    desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp;
                    System.out.println("desperdicio: "+desperdicioDePerfilTmp);
                    perfilNuevoTmp = 6.10;
                    System.out.print(formateador.format(perfilNuevoTmp));
                    perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                  }
            //}
            
             System.out.print(" - "+formateador.format(medidaPerfilAcortar)+" = "+formateador.format(perfilNuevoTmp)); //para mostrar
            
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNueavoFaltanteTmp)); //para mostrar
             System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); //para mostrar
             
             //la sigueinte condicion la he propuesto por un error que he encontrado al hacer las restas
             //la resta que ocaciona un numero menor a 0 guardadda en la variable llamada perfilNueavoFaltanteTmp, 
             //son contados las ocaciones las veses que susede, lo que pasa es la variable que almacena temporalmente el perfil faltante 
             //guarda el numero restado de la ultima opracion  por ejemplo se tiene en la variable perfilNuevoTmp =  0.63 
             //pero se le va hacer la resta del ultimo perfil que es mayor a la variable perfilNuevoTmp o sea que la variable medidaPerfilAcortar se va a restar y es mayo,
             //ejemplo de 1.5 la cual es ams grande, el resultado de esta operacion es de la siguiente manera 0.63 - 1.5 = -0.87
             //lo cual es un numero menor a cero este numero se almacena en la variable perfilNueavoFaltanteTmp
             //y como ya es el ultimo perfil ya no pueda pasar por la verificacion en la que se identifica que ya no alcanso 
             //y cambiar el contador perfilNuevoTmp he indique perfilNueavoFaltanteTmp que ya no es un numero mayor a cero 
             //lo cual como solucion si es la ultima pieza, y perfilNueavoFaltanteTmp es nemor a cero indica 
             //que es el ultimo perfil ya no hay mas que hcer pero la variable temporal perfilNueavoFaltanteTmp
             //dejo almacenada el numero menor y eso afecta al desprdicio si es el ultimo perfil a cortar
             //ya que si sobra perfil pero la variable ya no fue actializada por ya no pasar por la verificacion 
             //por ello quiero volver a sumar lo restado mas lo almacenado el la variable de perfil faltante y 
             //se tenga el valor correcto del desperdico que es el afectado 
             
             
             
             x++;
             
        }while(x < cromosoma.length);
        System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(desperdicioTotalPerfil+perfilNueavoFaltanteTmp));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil+perfilNuevoTmp)));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil)));
        
        /* 
        int numeroDePerfilesUsados=0;
        double perfilNuevo = 6.10;                          //servira como un contador pero hira decrementando
        double desperdicioTotal = 0.0; //servira como un contador de desperdicioTotal hora incrementando
        double desperdicioPorPerfil = 0.0; //desperdicio de cada perfil
        
        
        primera vercion de funcion aptitud
        int contadorDePerfilesFaltantes = cromosoma.length; //contador para saber cuantos perfiles faltas
        for (int i = 0; i < cromosoma.length; i++) {
            //buscar la medida del perfil identificado por el numero que el gen trae;
           double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[i],vectorPerfiles);
   
           // algoritmo para un solo perfil hasta que se acabe y si exite aun perfiles por cortar no los cuenta  ese es el error
           
           if(perfilNuevo >= medidaPerfilAcortar){
                DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
                System.out.println("");                                //para mostrar
                System.out.print(formateador.format(perfilNuevo));     //para mostrar
                perfilNuevo=perfilNuevo-medidaPerfilAcortar;
                System.out.print(" - "+formateador.format(medidaPerfilAcortar)+"="+formateador.format(perfilNuevo)); //para mostrar
               
            }else{
                desperdicioPorPerfil=perfilNuevo;
                DecimalFormat formateador = new DecimalFormat("#.##");
                System.out.println("\nDesperdicio == "+formateador.format(desperdicioPorPerfil));
                desperdicioTotal = desperdicioTotal + desperdicioPorPerfil;

                perfilNuevo=6.10;
                numeroDePerfilesUsados++;
                desperdicioPorPerfil = 0.0;  
            }
           
            
        }
        */
        valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil);
        //valorAptitud = (desperdicioTotalPerfil+perfilNueavoFaltanteTmp);
        //valorAptitud = (desperdicioTotalPerfil+perfilNuevoTmp);
        //valorAptitud = (desperdicioTotalPerfil);
        return valorAptitud;
    }
    
    
    public double funciondeActitudPruevas(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        /*solo se cambia el tipo de funcion al que quiera evaluar*/
        double valorAptitud = 0.0;
          
        
        //perfil de inicio
        //    pN     PC     Vericicacion
        //    6.10 > 0.20   true      perfil nuevo a 6.10
        //    5.9  > 0.80   true      se resta perfil 
        //    5.1  > 0.60   true      se resta perfil
        //    4.5  > 0.90   true      se resta perfil
        //    3.6  > 1.50   true      se resta perfil 
        //    3.6  > 1.10   true      se resta perfil
        //    2.5  > 2.10   true      se resta perfil
        //    0.4  < 0.90   false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //nuevo perfil se ha sumado un perfil
        //    pN      PC     Vericicacion
        //    6.10  > 2.30   true         perfil nuevo a 6.10
        //    3.8   > 1.90   true         se resta perfil 
        //    1.9   > 0.30   true         se resta perfil
        //    1.6   > 0.48   true         se resta perfil
        //    1.12  > 0.38   true         se resta perfil 
        //    0.74  > 0.90   false        false se regresa el contador de perfil nuevo a 6.10 indicando que ta es otro y se suma el desperdicio al contador de desperdicio
        
        //se  usa otro nuevo perfil asi susecivamnete...
        //System.out.println("perfilNuevo: "+perfilNuevo);
        ////for (int i = 0; i < cromosoma.length; i++) {
        ////    System.out.print("["+cromosoma[i]+"]");
        ////}
        
        int x = 0;
        double perfilNuevoTmp = 6.10;
        double perfilNueavoFaltanteTmp = 0.0;
        double desperdicioDePerfilTmp=0.0;
        double desperdicioTotalPerfil=0.0;
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        do{ 
            //para dar formato de salida 
            
            //para obtener el tamaño del perfil a corcar
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            //se da un salto de linea 
            ////System.out.println("");                                //para mostrar
            //se muestra el perfil existente 
            ////System.out.print(":"+formateador.format(perfilNuevoTmp));     //para mostrar
            
            /*
            //se ferifica si el perfil nuevo aun alcansa y si no es mas grande el perfil a cortar 
            if(medidaPerfilAcortar > desperdicioPorPerfilTmp){ 
                        System.out.println("ya no alcabsa...");
                        //para verificar desde antes si el perfil que se quiere cortar no revasa al perfil nuevo 
                        //si no para tomar otro 
                        perfilTmp = 6.10;
            }
            */
            //System.out.println(":"+medidaPerfilAcortar);
            //if(perfilNueavoTmp >= medidaPerfilAcortar){
                
                perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                perfilNueavoFaltanteTmp = perfilNuevoTmp;
                if(perfilNueavoFaltanteTmp < 0){
                    ////System.out.println("\nya no alcanso usar otro...");
                    ////System.out.println("");
                    //desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar; //sumamos la medida que se resto anteriormente para saber si se necesitaba otro perfil para saber el desperdico final 
                    desperdicioDePerfilTmp = perfilNuevoTmp + medidaPerfilAcortar;
                    desperdicioTotalPerfil = desperdicioTotalPerfil + desperdicioDePerfilTmp;
                    ////System.out.println("desperdicio: "+desperdicioDePerfilTmp);
                    perfilNuevoTmp = 6.10;
                    ////System.out.print(formateador.format(perfilNuevoTmp));
                    perfilNuevoTmp = perfilNuevoTmp - medidaPerfilAcortar;
                  }
            //}
            
             ////System.out.print(" - "+formateador.format(medidaPerfilAcortar)+" = "+formateador.format(perfilNuevoTmp)); //para mostrar
            
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNueavoFaltanteTmp)); //para mostrar
             ////System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); //para mostrar
             
             //la sigueinte condicion la he propuesto por un error que he encontrado al hacer las restas
             //la resta que ocaciona un numero menor a 0 guardadda en la variable llamada perfilNueavoFaltanteTmp, 
             //son contados las ocaciones las veses que susede, lo que pasa es la variable que almacena temporalmente el perfil faltante 
             //guarda el numero restado de la ultima opracion  por ejemplo se tiene en la variable perfilNuevoTmp =  0.63 
             //pero se le va hacer la resta del ultimo perfil que es mayor a la variable perfilNuevoTmp o sea que la variable medidaPerfilAcortar se va a restar y es mayo,
             //ejemplo de 1.5 la cual es ams grande, el resultado de esta operacion es de la siguiente manera 0.63 - 1.5 = -0.87
             //lo cual es un numero menor a cero este numero se almacena en la variable perfilNueavoFaltanteTmp
             //y como ya es el ultimo perfil ya no pueda pasar por la verificacion en la que se identifica que ya no alcanso 
             //y cambiar el contador perfilNuevoTmp he indique perfilNueavoFaltanteTmp que ya no es un numero mayor a cero 
             //lo cual como solucion si es la ultima pieza, y perfilNueavoFaltanteTmp es nemor a cero indica 
             //que es el ultimo perfil ya no hay mas que hcer pero la variable temporal perfilNueavoFaltanteTmp
             //dejo almacenada el numero menor y eso afecta al desprdicio si es el ultimo perfil a cortar
             //ya que si sobra perfil pero la variable ya no fue actializada por ya no pasar por la verificacion 
             //por ello quiero volver a sumar lo restado mas lo almacenado el la variable de perfil faltante y 
             //se tenga el valor correcto del desperdico que es el afectado 

             x++;
             
        }while(x < cromosoma.length);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+(desperdicioTotalPerfil+perfilNueavoFaltanteTmp));
        ////System.out.println("\nEl desperdicio total de perfiles usados: "+(formateador.format(desperdicioTotalPerfil+perfilNuevoTmp)));
        
        /* 
        int numeroDePerfilesUsados=0;
        double perfilNuevo = 6.10;                          //servira como un contador pero hira decrementando
        double desperdicioTotal = 0.0; //servira como un contador de desperdicioTotal hora incrementando
        double desperdicioPorPerfil = 0.0; //desperdicio de cada perfil
        
        
        primera vercion de funcion aptitud
        int contadorDePerfilesFaltantes = cromosoma.length; //contador para saber cuantos perfiles faltas
        for (int i = 0; i < cromosoma.length; i++) {
            //buscar la medida del perfil identificado por el numero que el gen trae;
           double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[i],vectorPerfiles);
   
           // algoritmo para un solo perfil hasta que se acabe y si exite aun perfiles por cortar no los cuenta  ese es el error
           
           if(perfilNuevo >= medidaPerfilAcortar){
                DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
                System.out.println("");                                //para mostrar
                System.out.print(formateador.format(perfilNuevo));     //para mostrar
                perfilNuevo=perfilNuevo-medidaPerfilAcortar;
                System.out.print(" - "+formateador.format(medidaPerfilAcortar)+"="+formateador.format(perfilNuevo)); //para mostrar
               
            }else{
                desperdicioPorPerfil=perfilNuevo;
                DecimalFormat formateador = new DecimalFormat("#.##");
                System.out.println("\nDesperdicio == "+formateador.format(desperdicioPorPerfil));
                desperdicioTotal = desperdicioTotal + desperdicioPorPerfil;

                perfilNuevo=6.10;
                numeroDePerfilesUsados++;
                desperdicioPorPerfil = 0.0;  
            }
           
            
        }
        */
        //valorAptitud = (desperdicioTotalPerfil+perfilNueavoFaltanteTmp);
        valorAptitud = (desperdicioTotalPerfil+perfilNuevoTmp);
        return valorAptitud;
    }
    
    
    public double buscarMedidaPerfil(int noPerfil,ArrayList <perfil> vectorPerfiles){
        double medida=0.0;
        
        for (int i = 0; i < vectorPerfiles.size(); i++) {
            if(vectorPerfiles.get(i).getNoPerfil() == noPerfil){
                medida=vectorPerfiles.get(i).getMedida();
            }
        }
        return medida;
    }
    
    public double buscarMedidaPerfil2(int noPerfil,Map<Integer, Double> MedidaDePerfiles){
        double medida=0.0;
            //System.out.println(""+noPerfil);
            medida = MedidaDePerfiles.get(noPerfil);
            //System.out.println("pf: "+noPerfil+" "+medida);
        return medida;
    }
    
    
    
    public void mostrarPoblacionPer(ArrayList<individuoPer> poblacion){
        System.out.println("Individuo\t\t\tValor Aptitud");
        //System.out.println("Individuo\t\tValor decimal\t\tValor Aptitud");
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        for (int i = 0; i < poblacion.size(); i++) {
            System.out.print(i+".-");
            int[] cromosoma = poblacion.get(i).getCromosoma();
            System.out.print("[");
            for (int j = 0; j < cromosoma.length; j++) {
                System.out.print(cromosoma[j]+"|");
            }
            System.out.print("]");
            System.out.println("\t\t"+formateador.format(poblacion.get(i).getValorAptitud()));
            //System.out.println("\t\t"+poblacion.get(i).getValorDecimal()+"\t\t\t"+poblacion.get(i).getValorAptitud());
        }
    }
     
    public individuoPer buscarMejorIndividuo(ArrayList<individuoPer> poblacion){
        
        //double mayor = Double.MIN_VALUE;
        individuoPer mejorIndividuoGeneracion =null; 
                
        double menor = Double.MAX_VALUE;
        //double menor = 1000000000;
        
        for (int i = 0; i < poblacion.size(); i++) {
                if(poblacion.get(i).getValorAptitud() <=  menor){
                     mejorIndividuoGeneracion = new  individuoPer();
                     menor=poblacion.get(i).getValorAptitud();
                     mejorIndividuoGeneracion = poblacion.get(i);
                }
        }
        
        //System.out.println("El mejor de la generacion fue :"+menor);
        return mejorIndividuoGeneracion;//pendiente ver por que lo retorno 
        
    }
  
    
    
    
     public ArrayList<individuoPer> generadorDeIndividuosNuevos(ArrayList<individuoPer> poblacionCruzada){
       
        double valorDecimal=0; 
        double valorAptitud=0; 
        for (int i = 0; i < poblacionCruzada.size(); i++) {
             double aptitud = funciondeActitud(poblacionCruzada.get(i).getCromosoma(),vectorPerfiles);
             poblacionCruzada.get(i).setValorAptitud(valorAptitud);
        }
        
        //mostrarPoblacion(poblacionCruzada);
        //mejorIndivioGA=buscarMejorIndividuo(poblacionCruzada);
        
        return poblacionCruzada;
    }
     
    public ArrayList<individuoPer> tipoSeleccion(String opcionDeSeleccion,ArrayList<individuoPer> poblacion,int numeroDeIndividuos,int muestra){
        
        ArrayList<individuoPer> poblacionTMPselecta = new ArrayList<individuoPer>();
        seleccionPer seleccion = new seleccionPer(); 
    
        switch(opcionDeSeleccion){
            case"Aleatoria":
                poblacionTMPselecta = seleccion.seleccionAleatoria(poblacion,numeroDeIndividuos);
            break;
            case"Ruleta":
                poblacionTMPselecta = seleccion.seleleccionPorRuleta(poblacion,numeroDeIndividuos);
            break;
            case"Torneo":
                //poblacionTMPselecta = seleccion.seleccionPorTorneo(poblacion,numeroDeIndividuos,muestra);
                poblacionTMPselecta = seleccion.seleccionPorTorneoMinimo(poblacion,numeroDeIndividuos,muestra);
            break;
            case"MuestreoEstocastico":
                poblacionTMPselecta = seleccion.seleleccionPorMuestreoEstocasticoUniversal(poblacion,numeroDeIndividuos);
            break;
            default:
                poblacionTMPselecta = seleccion.seleccionAleatoria(poblacion,numeroDeIndividuos);
        }  
        return poblacionTMPselecta;
    }
    
    public ArrayList<individuoPer> tipoCruza(String opcionCruza,ArrayList<individuoPer> poblacionSelecta,int numeroDeGenes){
        
        ArrayList<individuoPer> poblacionTMPCruzada = new ArrayList<individuoPer>();
        cruzaPer cruzaPer = new  cruzaPer();
        
        switch(opcionCruza){
            case"cruzaPorEmparejamiento":
                poblacionTMPCruzada = cruzaPer.cruzaPorEmparejamiento(poblacionSelecta,numeroDeGenes);
            break;
            case"cruzaPorOrden":
                poblacionTMPCruzada = cruzaPer.cruzaPorOrden(poblacionSelecta,numeroDeGenes);
                //poblacionTMPCruzada = cruzaPer.cruzaPorOrden3(poblacionSelecta,numeroDeGenes);
                //poblacionTMPCruzada = cruzaPer.cruzaPorOrden2C(poblacionSelecta,numeroDeGenes);
            break;
            case"cruzaPorCiclos":
                 //poblacionTMPCruzada = cruzaPer.cruzaPorCiclos(poblacionSelecta,numeroDeGenes);
                 //poblacionTMPCruzada = cruzaPer.cruzaPorCiclos3(poblacionSelecta,numeroDeGenes);
                 poblacionTMPCruzada = cruzaPer.cruzaPorCiclos4(poblacionSelecta,numeroDeGenes);
            break;
            default:
                //poblacionTMPCruzada = cruzaPer.cruzaPorEmparejamiento(poblacionSelecta,numeroDeGenes);
        }  
        return poblacionTMPCruzada;
    }
    
    public ArrayList<individuoPer> tipoMutacion(String opcionCruza,ArrayList<individuoPer> poblacionCruzada,double porcentaje,int numeroDeGenes) {
        
        ArrayList<individuoPer> poblacionTMPmutada = new ArrayList<individuoPer>();
        mutacionPer mutacionPer = new  mutacionPer();    
            switch(opcionCruza){
                case"mutacionPorIntercambio":
                    poblacionTMPmutada=mutacionPer.mutacionPorIntercambio(poblacionCruzada,porcentaje,numeroDeGenes);
                break;
                case"mutacionPorInsercion":
                    //poblacionTMPmutada=mutacionPer.mutacionPorInsercion2(poblacionCruzada,porcentaje,numeroDeGenes);
                    poblacionTMPmutada=mutacionPer.mutacionPorInsercion3(poblacionCruzada,porcentaje,numeroDeGenes);
                break;
                default:
                    poblacionTMPmutada=mutacionPer.mutacionPorIntercambio( poblacionCruzada,porcentaje,numeroDeGenes);
            }  
        return poblacionTMPmutada;
    }
    
    public static int[] generadorDenumerosAleatorios(int numerosGenes){

        int n=numerosGenes;  //numeros aleatorios
        int k=n;  //auxiliar;
        int[] numeros=new int[n];
        int[] resultado=new int[n];
        Random rnd=new Random();
        int res;
        
        
        //se rellena una matriz ordenada del 1 al 31(1..n)
        for(int i=0;i<n;i++){
            numeros[i]=i+1;
        }
        
        for(int i=0;i<n;i++){
            res=rnd.nextInt(k);            
            resultado[i]=numeros[res];
            numeros[res]=numeros[k-1];
            k--;
            
        }
         //se imprime el resultado;
        //System.out.println("El resultado de la matriz es:");
        //for(int i=0;i<n;i++){
        //    System.out.println(resultado[i]);
        //}
       return resultado;
   }
   

   public double obtencionDeResultados(int cromosoma[],ArrayList <perfil> vectorPerfiles) {
        
        DecimalFormat formateador = new DecimalFormat("#.##"); //para mostrar
        double valorAptitud = 0.0;
       
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print("["+cromosoma[i]+"]");
        }
        
        int x = 0;
        double perfilNuevo  =6.10;
        double sumatoriaDeperfiles =0.0;
        double desperdicioPorPerfil=0.0;
        double desperdicioTotalDePerfiles=0.0;
        ArrayList<Double>  desperdicios = new ArrayList<Double>(); 
        int cantidadPerdiles=0; 
        
        do{ 
            
            double medidaPerfilAcortar = buscarMedidaPerfil(cromosoma[x],vectorPerfiles);
            System.out.println("");                              
            System.out.print("PN: "+formateador.format(perfilNuevo));
            
            boolean verificacion = true;
            sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                  
            if(perfilNuevo > sumatoriaDeperfiles){
                verificacion = true;
            }else{
                verificacion = false;
            }
            int i=0;
            if(verificacion == false){
                      
                      //despues de saber que la sumatoria de perfilesa a cortar a sobre 
                      //pasado al perfil nuevo lo que se hace es restar el ultimo 
                      //perfil a cortar que indica que es mayor al perfil nuevo 
                      //para que se tenga la sumatoria anterior que no sobre pasa 
                      //al perfil nuevo para poder hacer la operacion correcto 
                      //y no obtener negativos 
                    sumatoriaDeperfiles=sumatoriaDeperfiles-medidaPerfilAcortar;
                      //despues de haber restado el ultimo perfil hasta ese momento 
                      //se hace la operacion de restar la sumatoria de perfiles 
                      //al perfil nuevo que dara como resultado el desperdicio
                    perfilNuevo=perfilNuevo-sumatoriaDeperfiles;
                      //lo que salga de ese ressultado lo agragamos a desperdicio de ese unico perfil
                    desperdicioPorPerfil=perfilNuevo;
                    desperdicios.add(desperdicioPorPerfil);
                    cantidadPerdiles++;
                    System.out.println("Perfil: "+cantidadPerdiles);
                    System.out.println("\ndesperdicio: "+desperdicioPorPerfil);
                      //despues ese desperdicio de ese unico perfil se almacena en el total de 
                      //de desperdicios de todos los perfiles
                    desperdicioTotalDePerfiles = desperdicioTotalDePerfiles + desperdicioPorPerfil;
                    
                      //los contadores de sumatoria y perdil nuevo toman su valor original
                    sumatoriaDeperfiles = 0.0;
                    perfilNuevo =6.10;
                        
                      /**********hasta este punto se ha receteado todo pero no se empesado a usar otro  perfil*/
                      //mas sin embargo exiten aun perfiles que cortar por ello se tiene comprendido que se
                      //resto un ultimo perfil a cortar que sobre pasaba la sumatoria 
                      //ese perfil debe de ser evaluado nuevamente pero con un nuevo perfil de la siguiente manera
                      //entonces se agregara a la nueva sumatoria de perfiles que atras se havia resetado 
                      //y quedado en cero hasta este puento se a iniciado una nueva comparacion 
                      //con otro nuevo perfil 
                      //y se inicia nuevamente el mismo procesimiento
                    System.out.print("PN: "+formateador.format(perfilNuevo));
                    sumatoriaDeperfiles = sumatoriaDeperfiles + medidaPerfilAcortar;
                    //System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
                    verificacion = true;
            }
            System.out.print(" > SUMA: "+formateador.format(sumatoriaDeperfiles)+" ------>    MPA: "+formateador.format(medidaPerfilAcortar));
             //System.out.print("\nPerfil faltante: "+formateador.format(perfilNuevoTmp)); 

             x++;
        }while(x < cromosoma.length);
        System.out.println("*********************");
        for (int i = 0; i < desperdicios.size(); i++) {
            System.out.println(","+desperdicios.get(i));
        }
        
        System.out.print("\nsumatoria"+sumatoriaDeperfiles);
        float ultimoDesperdicio =(float) (6.10-sumatoriaDeperfiles);
        System.out.print("\ndesperdicio ultimo perfil"+ ultimoDesperdicio);
        System.out.print("\ndesperdicio de primer perfil"+ desperdicios.get(0));
        
        //System.out.println("ultimo perfil fue.>>>>>>>"+cromosoma[x-1]);
        //ultimo perfil 
        //double medidaDeUltimoPerfil = buscarMedidaPerfil(cromosoma[x-1],vectorPerfiles);
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)-medidaDeUltimoPerfil));
        //System.out.println("\nEl desperdicio total de perfiles usados: "+((desperdicioTotalPerfil+perfilNuevoTmp)));
        System.out.print("\nEl desperdicio total de perfiles usados2: "+formateador.format(desperdicioTotalDePerfiles));
        System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio: "+formateador.format(desperdicioTotalDePerfiles+ultimoDesperdicio));
        System.out.print("\nEl desperdicio total de perfiles usados2 mas el ultimo desperdicio menos el primer desperdicio: "+formateador.format((desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0)));
        
      
        //valorAptitud = ((desperdicioTotalPerfil+perfilNuevoTmp));
        valorAptitud = desperdicioTotalDePerfiles;
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio);
        //valorAptitud = (desperdicioTotalDePerfiles+ultimoDesperdicio)-desperdicios.get(0);
        
        return valorAptitud;
    }
     
}
