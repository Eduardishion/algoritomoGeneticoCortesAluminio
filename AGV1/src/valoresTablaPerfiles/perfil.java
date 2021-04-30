/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoresTablaPerfiles;

/**
 *
 * @author DeveloperEdu
 */
public class perfil {
    
    int noPerfil;
    Double medida;
    String categoria;
    
    public perfil(){
        
    }
            
    public perfil(int noPerfil, Double medida, String categoria) {
        this.noPerfil = noPerfil;
        this.medida = medida;
        this.categoria = categoria;
    }

    public int getNoPerfil() {
        return noPerfil;
    }

    public void setNoPerfil(int noPerfil) {
        this.noPerfil = noPerfil;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
