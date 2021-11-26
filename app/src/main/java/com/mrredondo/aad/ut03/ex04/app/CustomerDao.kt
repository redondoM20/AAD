package com.mrredondo.aad.ut03.ex04.app

import androidx.room.*
import com.mrredondo.aad.ut03.ex04.data.CustomerEntity

@Dao
interface CustomerDao {

    @Transaction
    @Query("SELECT * FROM customers")
    fun findAll(): List<CustomerEntity>

    @Query("SELECT * FROM customers WHERE id = :customerId")
    fun findById(customerId: Int): CustomerEntity

    @Insert
    fun insert(customerEntity: CustomerEntity): Long

    @Delete
    fun delete(vararg customerEntity: CustomerEntity)

    @Update
    fun update(vararg customerEntity: CustomerEntity)
}