package com.jjcdutra.domain.repository

interface RepositoryInterface<T> {
    fun create(entity: T)
    fun update(entity: T)
    fun find(id: String): T
    fun findAll(): List<T>
}