package com.nuritech.stock.my_stock.daybook.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaybooksRepository extends JpaRepository<Daybooks, Long> {

    @Query("SELECT p FROM Daybooks p ORDER BY p.id DESC")
    List<Daybooks> findAllDesc();
}
