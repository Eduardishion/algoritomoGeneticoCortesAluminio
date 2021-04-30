/*G*//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv1;
import intefaz.interfaz;
import procedimientos.metodosBinarios.generadorDePoblacion;
import procedimientos.metodosDecimales.generadorDePoblacionPer;
/**
 *
 * @author DeveloperEdu
 */

public class AGV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //codificacion a mostrar 0 si es binaria o 1 si es entera
        int opcion=1; 
        if(opcion == 0){
            //para binarios
            generadorDePoblacion nuevoGenerador = new generadorDePoblacion(); 
            nuevoGenerador.generarPoblacion();
            //interfaz obj1 = new interfaz();
            //obj1.setVisible(true);
        }else{
            //para enteros
            //generadorDePoblacionPer nuevoGeneradorPer = new generadorDePoblacionPer();
            //generadorDePoblacionPer obj1 = new generadorDePoblacionPer(10,9,3);
            //obj1.generarPoblacion();
            
            interfaz obj2 = new interfaz();
            obj2.setVisible(true);
        }
    }
}
