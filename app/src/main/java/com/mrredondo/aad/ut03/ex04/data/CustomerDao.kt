package com.mrredondo.aad.ut03.ex04.data

import androidx.room.*

@Dao
interface CustomerDao {

    @Transaction
    @Query("SELECT * FROM customers")
    fun findAll(): List<CustomerEntity>

    @Transaction
    @Query("SELECT * FROM customers WHERE id = :customerId")
    fun findById(customerId: Int): CustomerEntity

    @Insert
    fun insert(customerEntity: CustomerEntity): Long

    @Delete
    fun delete(vararg customerEntity: CustomerEntity)

    @Update
    fun update(vararg customerEntity: CustomerEntity)
}