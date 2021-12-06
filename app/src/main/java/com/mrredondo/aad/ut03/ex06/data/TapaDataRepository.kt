package com.mrredondo.aad.ut03.ex06.data

import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.data.remote.RemoteDataSource
import com.mrredondo.aad.ut03.ex06.domain.TapaModel
import com.mrredondo.aad.ut03.ex06.domain.TapaRepository

class TapaDataRepository (val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) : TapaRepository{
    override fun fetchTapas(): Result<List<TapaModel>> {
        var tapas = localDataSource.findAll()
        if (tapas.isFailure){
            tapas = remoteDataSource.getTapas()
            localDataSource.saveAll(tapas)
        }
        return tapas
    }

    override fun fetchTapa(tapaId: String): Result<TapaModel> {
        var tapa = localDataSource.findById(tapaId)
        if (tapa.isFailure){
            tapa = remoteDataSource.getTapa(tapaId)
            localDataSource.save(tapa)
        }
        return tapa
    }
}