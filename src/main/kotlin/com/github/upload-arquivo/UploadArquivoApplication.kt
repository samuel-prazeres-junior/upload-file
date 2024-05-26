package com.github.`upload-arquivo`

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.github.upload-arquivo")
class UploadArquivoApplication

fun main(args: Array<String>) {
	runApplication<UploadArquivoApplication>(*args)
}
