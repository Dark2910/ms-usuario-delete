package com.eespindola.ms.delete.controller;

import com.eespindola.ms.delete.service.UsuarioService;
import com.eespindola.ms.delete.models.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    public final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(
            UsuarioService service
    ){
        this.usuarioService = service;
    }

    @PostMapping("/delete/{folioId}")
    public Result<Void> delete(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @PathVariable String folioId){
//        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioUtils.CrearFolioRequest() : folioRequest;
        return usuarioService.eliminarUsuario(folioId);
    }

}
