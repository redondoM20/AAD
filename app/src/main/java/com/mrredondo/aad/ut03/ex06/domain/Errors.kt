package com.mrredondo.aad.ut03.ex06.domain

sealed class Failure : Throwable(){
    object DataError : Failure()
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object FileError: Failure()

    abstract class FeatureFailure : Failure()
}