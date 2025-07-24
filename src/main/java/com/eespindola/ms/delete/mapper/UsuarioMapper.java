package com.eespindola.ms.delete.mapper;

import com.eespindola.ms.delete.jpa.entities.UsuarioJpa;
import com.eespindola.ms.delete.models.UsuarioMl;
import com.eespindola.ms.delete.models.dto.UsuarioDto;
import com.eespindola.ms.delete.utils.ConstantesUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper {

    public static UsuarioMl toUsuarioMl(UsuarioDto usuarioDto){
        UsuarioMl usuarioMl = new UsuarioMl();

        usuarioMl.setIdUsuario(usuarioDto.getIdUsuario());
        usuarioMl.setFolioId(usuarioDto.getFolioId());
        usuarioMl.setNombre(usuarioDto.getNombre());
        usuarioMl.setApellidoPaterno(usuarioDto.getApellidoPaterno());
        usuarioMl.setApellidoMaterno(usuarioDto.getApellidoMaterno());
        usuarioMl.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuarioMl.setUsername(usuarioDto.getUsername());
        usuarioMl.setEmail(usuarioDto.getEmail());
        usuarioMl.setPassword(usuarioDto.getPassword());
        usuarioMl.setStatus(usuarioDto.getStatus());

        return  usuarioMl;
    }

    public static UsuarioJpa toUsuarioJpa(UsuarioDto usuarioDto) throws ParseException {
        UsuarioJpa usuarioJpa = new UsuarioJpa();

        usuarioJpa.setIdUsuario(usuarioDto.getIdUsuario());
        usuarioJpa.setFolio(usuarioDto.getFolioId());
        usuarioJpa.setNombre(usuarioDto.getNombre());
        usuarioJpa.setApellidoPaterno(usuarioDto.getApellidoPaterno());
        usuarioJpa.setApellidoMaterno(usuarioDto.getApellidoMaterno());
        usuarioJpa.setFechaNacimiento(getFechaNacimiento(usuarioDto.getFechaNacimiento()));
        usuarioJpa.setUsername(usuarioDto.getUsername());
        usuarioJpa.setEmail(usuarioDto.getEmail());
        usuarioJpa.setPassword(usuarioDto.getPassword());
        usuarioJpa.setStatus(usuarioDto.getStatus());

        return  usuarioJpa;
    }
    private static Date getFechaNacimiento(String fecha) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantesUtils.DATE_FORMAT);
        return simpleDateFormat.parse(fecha);
    }
}
