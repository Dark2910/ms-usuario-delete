package com.eespindola.ms.delete.dao.imp;

import com.eespindola.ms.delete.dao.UsuarioDao;
import com.eespindola.ms.delete.models.UsuarioMl;
import com.eespindola.ms.delete.utils.ConstantesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Types;

@Repository
public class UsuarioDaoImp implements UsuarioDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    UsuarioDaoImp(
            @Qualifier(ConstantesUtils.HIKARI_DATA_SOURCE) DataSource dataSource
//            @Qualifier(ConstantesUtils.HIKARI_CONNECTION) JdbcTemplate jdbc
    ) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcTemplate = jdbc;
    }

    @Override
    public Integer usuarioDelete(UsuarioMl usuario) throws SQLException {

        String query = ConstantesUtils.USUARIO_DELETE;

        return jdbcTemplate.execute(query, (CallableStatementCallback<Integer>) callableStatementCallback -> {

            callableStatementCallback.setString(1, usuario.getFolioId());
            callableStatementCallback.registerOutParameter(2, Types.INTEGER);

            callableStatementCallback.execute();
            return callableStatementCallback.getInt(2);
        });
    }
}
