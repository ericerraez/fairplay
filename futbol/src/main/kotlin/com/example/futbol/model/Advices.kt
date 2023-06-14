package com.example.futbol.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="advices")

class Advices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name= "player_id")
    var playerId: Long? = null
    @NotBlank(message="Campo obligatorio")
    @Column(name= "date_match")
    var dateMatch: String? = null
    @NotBlank(message="Campo obligatorio")
    @Column(name= "team_match")
    var teamMatch: String? = null
    @NotBlank(message="Campo obligatorio")
    @Column(name= "color_card")
    var colorCard: String? = null

}