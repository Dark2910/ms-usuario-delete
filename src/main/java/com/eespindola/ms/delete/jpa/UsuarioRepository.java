package com.eespindola.ms.delete.jpa;

import com.eespindola.ms.delete.jpa.entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {
}
