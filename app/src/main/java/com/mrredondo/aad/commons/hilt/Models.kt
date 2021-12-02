package com.mrredondo.aad.commons.hilt

import com.google.gson.Gson
import javax.inject.Inject

data class CustomerModel @Inject constructor(val car: CarModel)

data class CarModel @Inject constructor(val engine: EngineModel,
                                        val pistons: PistonsModel,
                                        val cylinder: Cylinder)

class EngineModel @Inject constructor()

class PistonsModel @Inject constructor()

interface Cylinder {
    fun getType(): String
}

class TwoCylinder @Inject constructor(val gson: Gson) : Cylinder {
    override fun getType(): String = "2"
}

class FourCylinder @Inject constructor() : Cylinder {
    override fun getType(): String = "4"
}

class TenCylinder @Inject constructor() : Cylinder {
    override fun getType(): String = "10"
}

fun run() {
    val newCustomer = CustomerModel(CarModel(EngineModel(), PistonsModel(), TwoCylinder(Gson())))
}