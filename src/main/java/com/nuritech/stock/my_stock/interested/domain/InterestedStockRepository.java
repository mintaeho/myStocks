package com.nuritech.stock.my_stock.interested.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterestedStockRepository extends JpaRepository<InterestedStock, InterestedStockId> {

    @Query("SELECT p FROM InterestedStock p ORDER BY p.stockNm DESC")
    List<InterestedStock> findAllDesc();

    @Query(value = "SELECT p.ticker, s.stock_nm, p.business_cycle, s.sector, " +
                   "       s.current_price, s.payout_ratio, s.annual_payout, s.div_yield," +
                   "       p.dividend_pay_month, s.highest_price, s.lower_price, " +
                   "       (s.highest_price+s.lower_price)/2 as avg_price, " +
                   "       (s.highest_price*0.9) as under_10_price, " +
                   "       (s.highest_price*0.8) as under_20_price, " +
                   "       (s.highest_price*0.7) as under_30_price, " +
                   "       CASE WHEN (SELECT count(*) " +
                   "                    FROM daybooks " +
                   "                   WHERE email = p.email " +
                   "                     AND ticker = p.ticker) > 0 " +
                   "                 THEN 'Y' " +
                   "                 ELSE 'N' END buying_yn, " +
                   "       p.nobility_stock_yn " +
                   "  FROM interested_stock p" +
                   "       LEFT OUTER JOIN stock s ON p.ticker = s.ticker" +
                   " WHERE p.email = :email" +
                   " ORDER BY div_yield desc", nativeQuery = true)
    List<Object[]> selectInterestedStock(@Param("email") String email);

}

