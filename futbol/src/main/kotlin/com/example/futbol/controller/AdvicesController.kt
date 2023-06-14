package com.example.futbol.controller

import com.example.futbol.model.Advices
import com.example.futbol.service.AdvicesService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advices")

class AdvicesController {

    @Autowired
    lateinit var advicesService: AdvicesService

    @GetMapping
    fun list ():ResponseEntity<*>{
        return ResponseEntity(advicesService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Valid advices: Advices):ResponseEntity<Advices>{
        return ResponseEntity(advicesService.save(advices), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody advices: Advices):ResponseEntity<Advices>{
        return ResponseEntity(advicesService.update(advices), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody advices: Advices):ResponseEntity<Advices>{
        return ResponseEntity(advicesService.updateName(advices), HttpStatus.OK)
    }
}