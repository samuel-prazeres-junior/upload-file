package com.github.`upload-arquivo`.service

import com.github.`upload-arquivo`.domain.dto.OrientacaoDTO
import org.springframework.web.multipart.MultipartFile

interface OrientacaoService {
    fun upload(arquivo: MultipartFile)
    fun findAll(): List<OrientacaoDTO>
}