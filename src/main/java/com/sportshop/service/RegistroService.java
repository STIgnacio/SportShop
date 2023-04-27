
package com.sportshop.service;

import com.sportshop.domain.Registro;
import java.util.List;


public interface RegistroService {
    
    //Obtiene los registros y los coloca en una lista de objetos
    public List<Registro> getRegistros();
    
    //Obtiene el ID del registro
    public Registro getRegistro(Registro registro);
    
    //Elimina por ID
    public void deleteRegistro(Registro registro);
    
    //Si el ID no existe se crea un registro nuevo 
    //Si el ID existe se actualizan los datos
    public void saveRegistro(Registro registro);

    public Registro autenticarUsuario(String usuario, String contraseña);
    
    public void guardarRegistroEditado(Registro registro); 
   

    
}
