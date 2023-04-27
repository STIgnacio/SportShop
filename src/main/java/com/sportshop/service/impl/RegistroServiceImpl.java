package com.sportshop.service.impl;

import com.sportshop.dao.RegistroDao;
import com.sportshop.domain.Registro;
import com.sportshop.service.RegistroService;
import com.sportshop.dao.CreditoDao;
import com.sportshop.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistroServiceImpl implements RegistroService{
    
    //Crea una copia de un objeto
    @Autowired
    private RegistroDao registroDao;
    @Autowired
    private CreditoDao creditoDao;

    @Override
    public List<Registro> getRegistros() {
        return (List<Registro>) registroDao.findAll();
    }

    @Override
    public Registro getRegistro(Registro registro) {
        return registroDao.findById(registro.getIdRegistro()).orElse(null);
    }

    @Override
    public void deleteRegistro(Registro registro) {
        registroDao.delete(registro);
    }

    @Override
    public void saveRegistro(Registro registro) {
        registroDao.save(registro);
    }
    @Override
    public void guardarRegistroEditado(Registro registro) {
    registroDao.save(registro);
    }


    @Override
    public Registro autenticarUsuario(String usuario, String contraseña) {
        Registro registro = registroDao.validarUsuario(usuario, contraseña);
        //SI el existe un usuario con ese correo y contraseña lo retorna, si no retorna un objeto vacio
        if(registro != null){
            return registro;
        }else{
            return new Registro();
        }
    }

}
