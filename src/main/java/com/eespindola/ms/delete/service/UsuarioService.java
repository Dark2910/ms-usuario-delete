package com.eespindola.ms.delete.service;

import com.eespindola.ms.delete.models.dto.Result;

public interface UsuarioService {
    Result<Void> eliminarUsuario(String folioId);
}
