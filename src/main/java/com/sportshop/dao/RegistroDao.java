package com.sportshop.dao;
import com.sportshop.domain.Registro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroDao extends JpaRepository<Registro,Long>{
    //Se hace una query personalizada para buscar si existe un usuarios con ese correo y contraseña
    //?1 Se refiere al primer parametro que se pasa al metodo
    @Query(value = "SELECT r FROM Registro r WHERE r.correo=?1 and r.contraseña=?2")
    Registro validarUsuario(String correo, String contraseña);
}
