package com.example.futbol.repository

import com.example.futbol.model.Advices
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface AdvicesRepository:JpaRepository<Advices, Long> {
    fun findById(id: Long?):Advices?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun getTotalAdvices(@Param ("playerId") playerId: Long?): Double?
}