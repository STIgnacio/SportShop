package com.sportshop.dao;

import com.sportshop.domain.General;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralDao extends JpaRepository<General,Long> {
    
}