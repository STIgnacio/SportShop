package com.sportshop.service.impl;

import com.sportshop.dao.ArticuloDao;
import com.sportshop.dao.GeneralDao;
import com.sportshop.dao.SexoDao;
import com.sportshop.domain.Articulo;
import com.sportshop.domain.General;
import com.sportshop.domain.Sexo;
import com.sportshop.service.GeneralService;
import com.sportshop.service.SexoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SexoServiceImpl implements SexoService {

    //Esto crea una única copia de un objeto
    @Autowired
    private SexoDao sexoDao;
    private ArticuloDao articuloDao;


    @Override
    public Sexo getSexo(Sexo sexo) {
        return sexoDao.findById(sexo.getIdSexo()).orElse(null);
    }

    @Override
    public void deleteSexo(Sexo sexo) {
        sexoDao.delete(sexo);
    }

    @Override
    public void saveSexo(Sexo sexo) {
        sexoDao.save(sexo);
    }
}
