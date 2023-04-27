
package com.sportshop.service;

import com.sportshop.domain.Cliente;
import java.util.List;

/**
 *
 * @author Ignacio Barquero
 */
public interface ClienteService {
    
    //Obtiene los registros y los coloca en una lista de objetos
    public List<Cliente> getClientes();
    
    //Obtiene el ID del cliente
    public Cliente getCliente(Cliente cliente);
    
    //Elimina por ID
    public void deleteCliente(Cliente cliente);
    
    //Si el ID no existe se crea un registro nuevo 
    //Si el ID existe se actualizan los datos
    public void saveCliente(Cliente cliente);

    public boolean autenticarUsuario(String usuario, String contraseña);

    public void updateCliente(Cliente cliente);
    
}
