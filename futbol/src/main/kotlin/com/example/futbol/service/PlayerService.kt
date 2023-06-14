package com.example.futbol.service

import com.example.futbol.model.Player
import com.example.futbol.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException
import java.awt.print.Pageable

@Service

class PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    fun list(): List<Player>{
        return playerRepository.findAll()
    }

    fun save (player: Player): Player?{
        return playerRepository.save(player)
    }

    fun update(player:Player): Player {
        try {
            playerRepository.findById(player.id)
                    ?: throw Exception("ID no existe")

            return playerRepository.save(player)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(player:Player): Player {
        try{
            val response = playerRepository.findById(player.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=player.fullname
            }
            return playerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listAgePlayer(): List<Player>? {
        return playerRepository.findAvailableWorldCup()
    }
    fun listTotalMajorThan(age:Int?): List<Player>? {
       return playerRepository.findMajorThan(age)
    }

    //fun list (pageable: Pageable,player: Player):Page<Player>{
     //   val matcher = ExampleMatcher.matching()
     //           .withIgnoreNullValues()
     //           .withMatcher(("nationality"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
     //   return playerRepository.findAll(Example.of(player, matcher), Pageable)
 //   }

}