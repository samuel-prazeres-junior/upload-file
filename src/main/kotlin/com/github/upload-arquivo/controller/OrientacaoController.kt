package com.github.`upload-arquivo`.controller

import com.github.`upload-arquivo`.domain.dto.OrientacaoDTO
import com.github.`upload-arquivo`.service.OrientacaoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/orientacao/")
class OrientacaoController(val service: OrientacaoService) {

    @PostMapping("upload")
    @ResponseStatus(HttpStatus.CREATED)
    fun uploadArquivo(@RequestParam("arquivo") arquivo: MultipartFile){
        service.upload(arquivo)
    }

    @GetMapping
    fun findAll(): List<OrientacaoDTO>{
        return service.findAll()
    }

}