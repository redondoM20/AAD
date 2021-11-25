package com.jmperezra.aad_playground.ut02.ex04

import android.content.Context
import com.mrredondo.aad.ut02.exercise04.app.JsonSerializer

/**
 * Clase para persistir información en SharedPreferences Encriptado
 */
class CustomerSharPrefLocalSource(private val context: Context, private val serializer: JsonSerializer, private val nameXmlFile: String){

    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)

    /**
     * Función que me permite guardar un cliente en un SharedPreferences.
     */
    fun save(customer: CustomerModel, typeClass: Class<CustomerModel>) {
        val edit = sharedPref.edit()
        edit?.putString(customer.id.toString(), serializer.toJson(customer, typeClass))
    }

    /**
     * Función que me permite guardar un listado de clientes en un SharedPreferences.
     */
    fun save(customers: List<CustomerModel>, typeClass: Class<CustomerModel>) {
        customers.map { customerModel ->
            save(customerModel, typeClass)
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
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(customerId: Int, typeClass: Class<CustomerModel>) {
        val customer = findById(customerId, typeClass)
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    fun fetch(typeClass: Class<CustomerModel>): List<CustomerModel> {
        val jsonModels = sharedPref.all.values.toMutableList()
        if (jsonModels != null){
            return jsonModels.map { jsonModel ->
                serializer.fromJson(jsonModel.toString(), typeClass)
            }
        }else{
            return mutableListOf()
        }

    }

    fun findById(customerId: Int, typeClass: Class<CustomerModel>): CustomerModel? {
        val jsonModel = sharedPref.getString(customerId.toString(), "{}")
        return if (jsonModel != null){
            serializer.fromJson(jsonModel, typeClass)
        }else{
            null
        }
    }
}