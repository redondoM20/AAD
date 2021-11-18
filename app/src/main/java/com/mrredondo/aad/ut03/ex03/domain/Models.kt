package com.mrredondo.aad.ut03.ex03.domain

data class AlertModel(
    val id: String,
    val title: String,
    val type: Int,
    val summary: String,
    val datePublished: String,
    val body: String,
    val source: String,
    val files: MutableList<FileModel>
)

data class FileModel(val name: String, val url: String)