package com.nuritech.stock.my_stock.scraping.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, String> {

    @Query("SELECT p FROM Stock p ORDER BY p.ticker DESC")
    List<Stock> findAllDesc();
}
