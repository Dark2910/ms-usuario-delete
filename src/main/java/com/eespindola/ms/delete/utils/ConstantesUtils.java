package com.eespindola.ms.delete.utils;

public class ConstantesUtils {

    public static final String USUARIO_DELETE = "{CALL SP_UsuarioDelete(?,?)}";

    public static final String JDBC_DATA_SOURCE = "jdbcDataSource";
    public static final String JDBC_CONNECTION = "jdbcTemplate";

    public static final String HIKARI_DATA_SOURCE = "hikariDataSource";
    public static final String HIKARI_CONNECTION = "hikariTemplate";

    public static final String GET_BY_FOLIO = "http://localhost:8082/usuarioAPI/%s";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

}
