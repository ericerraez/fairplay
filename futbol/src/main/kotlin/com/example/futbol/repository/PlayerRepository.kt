package com.example.futbol.repository

import com.example.futbol.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface PlayerRepository:JpaRepository<Player, Long> {
    fun findById(id: Long?):Player?

    @Query(nativeQuery = true)
    fun findAvailableWorldCup():List<Player>?

    @Query(nativeQuery = true)
    fun findMajorThan(@Param ("age") age: Int?):List<Player>?

}
