package com.example.futbol.service

import com.example.futbol.model.Advices
import com.example.futbol.repository.AdvicesRepository
import com.example.futbol.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service

class AdvicesService {

    @Autowired
    lateinit var advicesRepository: AdvicesRepository

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Autowired
    lateinit var playerService: PlayerService

    fun list(): List<Advices>{
        return advicesRepository.findAll()
    }

    fun save (advices: Advices):Advices?{
        try{
            val responsePlayer= playerRepository.findById(advices.playerId)
                    ?: throw Exception("Id no existe")

            val responseSanction = advicesRepository.save(advices)
            //paso adicionales antes de devlver
            //obtener el total de las amonstaciones
            var totalAdvices = getTotalAdvices(advices.playerId)
            //actulizar el player
            playerRepository.save(responsePlayer.apply {fairplay=totalAdvices})

            return responseSanction
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }


    }

    fun update(advices:Advices): Advices {
        try {
            advicesRepository.findById(advices.id)
                    ?: throw Exception("ID no existe")

            return advicesRepository.save(advices)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(advices:Advices): Advices {
        try{
            val response = advicesRepository.findById(advices.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                teamMatch=advices.teamMatch
            }
            return advicesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun getTotalAdvices(playerId: Long?): Double? {
        return advicesRepository.getTotalAdvices(playerId)
    }

}