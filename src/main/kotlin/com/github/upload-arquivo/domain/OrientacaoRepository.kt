package com.github.`upload-arquivo`.domain

import com.github.`upload-arquivo`.domain.entity.OrientacaoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrientacaoRepository: JpaRepository<OrientacaoEntity, String>