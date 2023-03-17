
package com.sportshop.service.impl;

import com.sportshop.dao.ClienteDao;
import com.sportshop.domain.Cliente;
import com.sportshop.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ignacio Barquero
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    //Crea una copia de un objeto
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
    
}
