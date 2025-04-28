package com.eespindola.ms.delete.dao;

import com.eespindola.ms.delete.models.UsuarioML;
import com.eespindola.ms.delete.utils.Result;

import java.sql.SQLException;

public interface UsuarioDAO {

    Result UsuarioDelete(UsuarioML usuario) throws SQLException;

}
