package com.github.`upload-arquivo`.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class OrientacaoEntity(

    @Id
    val seletor: String,
    @Column(nullable = false)
    val id: UUID,
    @Column(length = 100, nullable = false)
    val descricao: String)