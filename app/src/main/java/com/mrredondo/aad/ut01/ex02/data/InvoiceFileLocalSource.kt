package com.mrredondo.aad.ut01.ex02.data

import com.mrredondo.aad_playground.ut01.ex02.InvoiceModel

/**
 * Clase para persistir información en ficheros.
 */
class InvoiceFileLocalSource {

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(invoice: InvoiceModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove(invoiceId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<InvoiceModel> {
        //TODO
        return emptyList()
    }

    fun findById(invoiceId: Int): InvoiceModel? {
        //TODO
        return null
    }
}