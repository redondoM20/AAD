package com.mrredondo.aad.ut03.ex04.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface InvoiceDao {
    @Insert
    fun insertInvoiceAndCustomerAndInvoiceLine(
        invoiceEntity: InvoiceEntity,
        customerEntity: CustomerEntity,
        invoiceLineEntities: List<InvoiceLineEntity>
    )
}