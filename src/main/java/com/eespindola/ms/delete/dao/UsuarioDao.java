package com.eespindola.ms.delete.dao;

import com.eespindola.ms.delete.models.UsuarioMl;

import java.sql.SQLException;

public interface UsuarioDao {

    Integer usuarioDelete(UsuarioMl usuario) throws SQLException;

}
