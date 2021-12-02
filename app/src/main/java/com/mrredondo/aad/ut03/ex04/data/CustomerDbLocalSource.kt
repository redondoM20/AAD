package com.mrredondo.aad.ut03.ex04.data

import android.content.Context
import com.mrredondo.aad.ut03.ex04.app.Ut03Ex03Database
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.InvoiceModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel

class CustomerDbLocalSource (private val appContext: Context){
    private val db = Ut03Ex03Database.getInstance(appContext)

    init {
        Thread{
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun findAllCustomer(): List<CustomerModel>{
        val customers = db.customerDao().findAll()
        return customers.map { customerEntity -> customerEntity.toModel() }
    }

    fun findByIdCustomer(customerId: Int): CustomerModel{
        val customer = db.customerDao().findById(customerId)
        return customer.toModel()
    }

    fun saveCustomer(customerModel: CustomerModel){
        db.customerDao().insert(CustomerEntity.toEntity(customerModel))
    }

    fun deleteCustomer(customerModel: CustomerModel){
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

    fun updateCustomer(customerModel: CustomerModel){
        db.customerDao().update(CustomerEntity.toEntity(customerModel))
    }

    fun findAllProduct(): List<ProductModel>{
        val products = db.productDao().findAll()
        return products.map { productEntity -> productEntity.toModel() }
    }

    fun findByIdProduct(productId: Int): ProductModel{
        val product = db.productDao().findById(productId)
        return product.toModel()
    }

    fun saveProduct(productModel: ProductModel){
        db.productDao().insert(ProductEntity.toEntity(productModel))
    }

    fun deleteProduct(productModel: ProductModel){
        db.productDao().delete(ProductEntity.toEntity(productModel))
    }

    fun updateProduct(productModel: ProductModel){
        db.productDao().update(ProductEntity.toEntity(productModel))
    }

    fun saveInvoice(invoiceModel: InvoiceModel){
        db.invoiceDao().insertInvoiceAndCustomerAndInvoiceLine(
            InvoiceEntity.toEntity(invoiceModel),
            CustomerEntity.toEntity(invoiceModel.customerModel),
            InvoiceLineEntity.toEntity( invoiceModel.invoiceLinesModel, )
        )
    }

}