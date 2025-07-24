package com.eespindola.ms.delete.service.imp;

import com.eespindola.ms.delete.dao.UsuarioDao;
import com.eespindola.ms.delete.jpa.UsuarioRepository;
import com.eespindola.ms.delete.jpa.entities.UsuarioJpa;
import com.eespindola.ms.delete.mapper.UsuarioMapper;
import com.eespindola.ms.delete.models.UsuarioMl;
import com.eespindola.ms.delete.models.dto.Result;
import com.eespindola.ms.delete.models.dto.UsuarioDto;
import com.eespindola.ms.delete.service.UsuarioService;
import com.eespindola.ms.delete.utils.ConstantesUtils;
import com.eespindola.ms.delete.utils.FolioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(
            UsuarioRepository repository,
            UsuarioDao dao
    ) {
        this.usuarioRepository = repository;
        this.usuarioDao = dao;
    }

    @Override
    public Result<Void> eliminarUsuario(String folioId) {

        Result<Void> response = new Result<>();
        response.setFolioRequest(FolioUtils.createFolioRequest());

        try {
            UsuarioDto usuarioRecuperado = getByFolio(folioId);
            UsuarioMl usuarioMl = UsuarioMapper.toUsuarioMl(usuarioRecuperado);

//            UsuarioJpa usuarioJpa = UsuarioMapper.toUsuarioJpa(usuarioRecuperado);
//            usuarioRepository.delete(usuarioJpa);
//
//            response.setIsCorrect(true);
//            response.setMessage("Usuario eliminado correctamente");

            Integer resultDB = usuarioDao.usuarioDelete(usuarioMl);

            response.setIsCorrect((resultDB == 1));
            response.setMessage(switch (resultDB) {
                case 1 -> "Usuario eliminado correctamente";
                case 0 -> "No se logro eliminar el usuario";
                default -> "Error inesperado en base de datos";
            });
        } catch (Exception e) {
            response.setIsCorrect(false);
            response.setException(e);
            response.setMessage(e.getMessage());
        }
        return response;

    }

    private static UsuarioDto getByFolio(@PathVariable String folioId) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = String.format(ConstantesUtils.GET_BY_FOLIO, folioId);

        ResponseEntity<Result<UsuarioDto>> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody().getObject();
    }

}
