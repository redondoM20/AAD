package com.mrredondo.aad.ut03.ex04.data

import androidx.room.*
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.InvoiceLinesModel
import com.mrredondo.aad.ut03.ex04.domain.InvoiceModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel
import java.util.*

@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey @ColumnInfo(name="id") val customerId: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="surname") val surname: String,


) {
    fun toModel()=CustomerModel(
        customerId,
        name,
        surname
    )

    companion object {
        fun toEntity(customerModel: CustomerModel) = CustomerEntity(
            customerModel.id,
            customerModel.name,
            customerModel.surname
        )
    }
}

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val productId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "price") val price: Double,
) {
    fun toModel()=ProductModel(
        productId,
        name,
        model,
        price
    )

    companion object {
        fun toEntity(productModel: ProductModel) = ProductEntity(
            productModel.id,
            productModel.name,
            productModel.model,
            productModel.price
        )
    }
}

@Entity(tableName = "invoiceline")
data class InvoiceLineEntity(
    @PrimaryKey @ColumnInfo(name = "id") val invoiceLineId: Int,
    @ColumnInfo(name = "product_id") val productId: Int
) {
    fun toModel()=InvoiceLinesModel(invoiceLineId, )


    companion object{
        fun toEntity(invoiceLinesModel: InvoiceLinesModel, productId: Int) =
            InvoiceLineEntity(invoiceLinesModel.id, productId)
    }
}

data class InvoiceLineAndProduct(
    @Embedded val invoiceLineEntity: InvoiceLineEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "product_id"
    ) val productEntity: ProductEntity
)


@Entity(tableName = "invoice")
data class InvoiceEntity(
    @PrimaryKey @ColumnInfo(name = "id") val invoiceId: Int,
    @ColumnInfo(name = "date")val date: Date,
) {
    fun toModel(
        customerEntity: CustomerEntity,
        invoiceLineEntity: List<InvoiceLineEntity>
    ) = InvoiceModel(
        invoiceId,
        date,
        customerEntity.toModel(),
        invoiceLineEntity.map { it.toModel() }
    )
}
