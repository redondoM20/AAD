package com.mrredondo.aad.ut03.ex04.data

import androidx.room.*

interface ProductDao {

    @Transaction
    @Query("SELECT * FROM product")
    fun findAll(): List<ProductEntity>

    @Transaction
    @Query("SELECT * FROM product WHERE id = :productId")
    fun findById(productId: Int): ProductEntity

    @Insert
    fun insert(productEntity: ProductEntity): Long

    @Delete
    fun delete(vararg productEntity: ProductEntity)

    @Update
    fun update(vararg productEntity: ProductEntity)

}