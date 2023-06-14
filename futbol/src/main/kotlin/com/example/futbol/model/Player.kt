package com.example.futbol.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table(name="player")

class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio")
    var fullname: String? = null
    @NotNull(message="Campo obligatorio")
    var age: Int? = null
    var nationality: String? = null
    var weight: Double? = null
    var fairplay: Double?  = null
}