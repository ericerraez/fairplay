package com.example.futbol.controller

import com.example.futbol.model.Player
import com.example.futbol.service.PlayerService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.awt.print.Pageable

@RestController
@RequestMapping("/player")

class PlayerController {

    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping
    fun list ():ResponseEntity<*>{
        return ResponseEntity(playerService.list(), HttpStatus.OK)
    }
    @GetMapping("/world-cup")
    fun listAge(): List<Player>? {
        return playerService.listAgePlayer()
    }
    @GetMapping("/ages/{age}")
    fun listTotals (@PathVariable("age") age: Int ):ResponseEntity<*>{
       return ResponseEntity(playerService.listTotalMajorThan(age), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Valid player:Player):ResponseEntity<Player>{
        return ResponseEntity(playerService.save(player), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody player:Player):ResponseEntity<Player>{
        return ResponseEntity(playerService.update(player), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody player:Player):ResponseEntity<Player>{
        return ResponseEntity(playerService.updateName(player), HttpStatus.OK)
    }

   // @GetMapping
   // fun list (player:Player, pageable: Pageable):ResponseEntity<*>{
   //     val response= playerService.list(pageable,player)
  //      return ResponseEntity(response, HttpStatus.OK)
 //   }

}