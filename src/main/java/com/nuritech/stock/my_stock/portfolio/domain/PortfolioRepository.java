package com.nuritech.stock.my_stock.portfolio.domain;

import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListExpandedDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, PortfolioId> {
    @Query("SELECT p FROM Portfolio p")
    List<Portfolio> findAllDesc();

    @Query(value = "SELECT v.ticker, v.stock_nm, business_cycle, sector," +
                         " current_price, avg_unit_price, total_stock_num, annual_payout, " +
                           "total_stock_num * annual_payout AS total_payout, " +
                           "annual_payout / avg_unit_price * 100 AS investment_div_yield, " +
                           "total_trading_amount, " +
                           "current_price * total_stock_num AS eval_amount," +
                           "(current_price * total_stock_num) - total_trading_amount AS earning_amount," +
                           "((current_price * total_stock_num) - total_trading_amount)/total_trading_amount AS earning_rate," +
                           "total_trading_amount/sum_trading_amount*100 AS protion, " +
                           "dividend_pay_month " +
                    " FROM (SELECT p.ticker, s.stock_nm, e.business_cycle, e.sector, " +
                           "       s.current_price, e.annual_payout, e.div_yield," +
                           "       s.dividend_pay_month, s.highest_price, s.lower_price, " +
                           "       ifnull(d.trading_amount, 0) AS trading_amount, " +
                           "       d.stock_num, d.unit_price, " +
                           "       avg(d.unit_price) OVER (PARTITION BY p.ticker) AS avg_unit_price, " +
                           "       sum(d.stock_num) OVER (PARTITION BY p.ticker) AS total_stock_num, " +
                           "       sum(d.trading_amount) OVER (PARTITION BY p.ticker) AS total_trading_amount, " +
                           "       sum(d.trading_amount) OVER (PARTITION BY p.email) AS sum_trading_amount" +
                           "  FROM portfolio p" +
                           "       LEFT OUTER JOIN stock s ON p.ticker = s.ticker" +
                           "       LEFT OUTER JOIN daybooks d ON p.ticker = d.ticker AND p.email = d.email" +
                           "       LEFT OUTER JOIN interested_stock e ON p.ticker = e.ticker AND p.email = e.email" +
                           " WHERE p.email = :email" +
                           ") v" +
                   " GROUP BY v.ticker" +
                   " ORDER BY business_cycle, sector, ticker", nativeQuery = true)
    List<Object[]> selectPortfolio(@Param("email") String email);

    @Query(value = "SELECT SUM(v.total_payout) AS total_payout, " +
                   "       SUM(v.total_trading_amount) AS total_trading_amount, " +
                   "       SUM(v.total_eval_amount) AS total_eval_amount, " +
                   "       SUM(v.total_eval_amount) - SUM(v.total_trading_amount) AS earning_amount, " +
                   "       (SUM(v.total_eval_amount) - SUM(v.total_trading_amount)) / SUM(v.total_trading_amount) * 100 AS earning_rate " +
                   "  FROM ( " +
                   "        SELECT p.ticker,  " +
                   "               sum(d.stock_num*e.annual_payout) AS total_payout, " +
                   "               sum(d.stock_num*d.unit_price) AS total_trading_amount , " +
                   "               sum(d.stock_num*s.current_price) AS total_eval_amount  " +
                   "          FROM portfolio p  " +
                   "               LEFT OUTER JOIN stock s ON p.ticker = s.ticker  " +
                   "               LEFT OUTER JOIN daybooks d ON p.ticker = d.ticker AND p.email = d.email  " +
                   "               LEFT OUTER JOIN interested_stock e ON p.ticker = e.ticker AND p.email = e.email" +
                   "         WHERE p.email = :email " +
                   "         GROUP BY p.ticker " +
                   "       ) v", nativeQuery = true)
    List<Object[]> selectSumPortfolio(@Param("email") String email);

    @Query(value =  "SELECT x.dividend_pay_month, " +
                    "       SUM(x.total_payout) AS total_payout, " +
                    "       SUM(x.total_payout)/ CASE WHEN x.dividend_pay_month='per months' THEN 12 ELSE 4 END AS payout_month " +
                    "  FROM( " +
                    "       SELECT v.ticker, v.stock_nm, business_cycle, sector," +
                    "              current_price, avg_unit_price, total_stock_num, annual_payout, " +
                    "              total_stock_num * annual_payout AS total_payout, " +
                    "              annual_payout / avg_unit_price * 100 AS investment_div_yield, " +
                    "              total_trading_amount, " +
                    "              current_price * total_stock_num AS eval_amount," +
                    "              (current_price * total_stock_num) - total_trading_amount AS earning_amount," +
                    "              ((current_price * total_stock_num) - total_trading_amount)/total_trading_amount AS earning_rate," +
                    "              total_trading_amount/sum_trading_amount*100 AS protion, " +
                    "              dividend_pay_month " +
                    "         FROM (SELECT p.ticker, s.stock_nm, e.business_cycle, e.sector, " +
                    "                      s.current_price, e.annual_payout, e.div_yield," +
                    "                      s.dividend_pay_month, s.highest_price, s.lower_price, " +
                    "                      ifnull(d.trading_amount, 0) AS trading_amount, " +
                    "                      d.stock_num, d.unit_price, " +
                    "                      avg(d.unit_price) OVER (PARTITION BY p.ticker) AS avg_unit_price, " +
                    "                      sum(d.stock_num) OVER (PARTITION BY p.ticker) AS total_stock_num, " +
                    "                      sum(d.trading_amount) OVER (PARTITION BY p.ticker) AS total_trading_amount, " +
                    "                      sum(d.trading_amount) OVER (PARTITION BY p.email) AS sum_trading_amount" +
                    "                 FROM portfolio p" +
                    "                      LEFT OUTER JOIN stock s ON p.ticker = s.ticker" +
                    "                      LEFT OUTER JOIN daybooks d ON p.ticker = d.ticker AND p.email = d.email" +
                    "                      LEFT OUTER JOIN interested_stock e ON p.ticker = e.ticker AND p.email = e.email" +
                    "                WHERE p.email = :email" +
                    "              ) v" +
                    "        GROUP BY v.ticker" +
                    "      ) x " +
                    " GROUP BY x.dividend_pay_month ", nativeQuery = true)
    List<Object[]> selectSummaryPayoutPerMonth(@Param("email") String email);

}
