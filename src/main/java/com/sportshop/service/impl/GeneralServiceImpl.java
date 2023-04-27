package com.sportshop.service.impl;

import com.sportshop.dao.ArticuloDao;
import com.sportshop.dao.GeneralDao;
import com.sportshop.domain.Articulo;
import com.sportshop.domain.General;
import com.sportshop.service.GeneralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralServiceImpl implements GeneralService {

    //Esto crea una única copia de un objeto
    @Autowired
    private GeneralDao generalDao;
    private ArticuloDao articuloDao;


    @Override
    public General getGenerales(General generales) {
        return generalDao.findById(generales.getIdGenerales()).orElse(null);
    }

    @Override
    public void deleteGenerales(General generales) {
        generalDao.delete(generales);
    }

    @Override
    public void saveGenerales(General generales) {
        generalDao.save(generales);
    }
}
