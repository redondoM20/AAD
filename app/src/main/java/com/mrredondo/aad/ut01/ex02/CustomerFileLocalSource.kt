package com.mrredondo.aad_playground.ut01.ex02

import androidx.appcompat.app.AppCompatActivity
import java.io.File


/**
 * Clase para persistir información en ficheros.
 */
class CustomerFileLocalSource(private val activity: AppCompatActivity) {

    private val file = File(activity.filesDir, "customerFile.txt")

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(customer: CustomerModel) {
        file.writeText(customer)
    }

    /**
     * Función que me permite guardar un listado de clientes en un fichero.
     */
    fun save(customers: List<CustomerModel>) {
        customers.forEach {
            save(it)
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
        //TODO
        return emptyList()
    }

    fun findById(customerId: Int): CustomerModel? {
        //TODO
        return null
    }
}