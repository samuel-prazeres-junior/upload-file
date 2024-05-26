package com.github.`upload-arquivo`.service.impl

import com.github.`upload-arquivo`.domain.OrientacaoRepository
import com.github.`upload-arquivo`.domain.dto.OrientacaoDTO
import com.github.`upload-arquivo`.domain.entity.OrientacaoEntity
import com.github.`upload-arquivo`.service.OrientacaoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

@Service
class OrientacaoServiceImpl(val repository: OrientacaoRepository) : OrientacaoService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Transactional
    override fun upload(arquivo: MultipartFile) {
        if (arquivo.isEmpty) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        val itens: MutableList<OrientacaoEntity> = mutableListOf()
        runCatching {
            obterLinhasDoArquivo(arquivo)
                .drop(1)
                .forEach {
                    itens.add(converterLinhaParaDTO(it))
                }
            repository.saveAll(itens)
        }
    }

    override fun findAll(): List<OrientacaoDTO> {
        return repository.findAll().map { item -> OrientacaoDTO(item.seletor, item.id, item.descricao) }
    }

    private fun obterLinhasDoArquivo(arquivo: MultipartFile): List<String> {
        val linhas = mutableListOf<String>()
        val reader = BufferedReader(InputStreamReader(arquivo.inputStream))
        reader.useLines { linhas.addAll(it) }
        return linhas
    }

    private fun converterLinhaParaDTO(linha: String): OrientacaoEntity {
        val colunas = linha.split(",")
        validarArquivo(linha, colunas)
        return OrientacaoEntity(seletor = colunas[0], id = UUID.randomUUID(), descricao = colunas[1])
    }

    private fun validarArquivo(linha: String, colunas: List<String>) {
        require(colunas.size == 2) { logger.error("Ocorreu um erro na: $linha, número de colunas invalido") }
        require(colunas[0].isNotBlank()) { logger.error("O campo seletor não pode estar vazio") }
        require(colunas[1].isNotBlank()) { logger.error("O campo descricao não pode estar vazio") }
    }
}