package com.mrredondo.aad.ut01.ex02.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.mrredondo.aad.ut01.ex02.app.JsonSerializer
import com.mrredondo.aad_playground.ut01.ex02.CustomerModel
import java.io.File


/**
 * Clase para persistir información en ficheros.
 */
class CustomerFileLocalSource(private val activity: AppCompatActivity, private val serializer: JsonSerializer) {

    private fun getFile(fileName: String): File {
        val file = File(activity.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val CUSTOMER_FILENAME: String = "aad_customer.txt"
        fun getAlertDetailFileName(customerId: Int): String = "aad_customer_$customerId.txt"
    }

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(customer: CustomerModel) {
        val file = getFile(getAlertDetailFileName(customer.id))
        file.writeText(serializer.toJson(customer, CustomerModel::class.java))
    }

    /**
     * Función que me permite guardar un listado de clientes en un fichero.
     */
    fun save(customers: List<CustomerModel>) {
        val file = getFile(CUSTOMER_FILENAME)
        customers.map { customerModel ->
            file.appendText(serializer.toJson(customerModel, CustomerModel::class.java) + System.lineSeparator())
        }
    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove(customerId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<CustomerModel> {
        val file = getFile(CUSTOMER_FILENAME)
        val customers: MutableList<CustomerModel> = mutableListOf()
        val lines = file.readLines()
        lines.map { line ->
            val customerModel = serializer.fromJson(line, CustomerModel::class.java)
            customers.add(customerModel)
        }
        return customers
    }

    fun findById(customerId: Int): CustomerModel? {
        val file = getFile(getAlertDetailFileName(customerId))
        if (file.exists()){
            return serializer.fromJson(file.readText(), CustomerModel::class.java)
        }
        return null
    }

}