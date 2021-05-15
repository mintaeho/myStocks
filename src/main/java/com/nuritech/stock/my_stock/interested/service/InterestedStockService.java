package com.nuritech.stock.my_stock.interested.service;

import com.nuritech.stock.my_stock.exercise.book.web.dto.PostsListResponseDto;
import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockRepository;
import com.nuritech.stock.my_stock.interested.dto.*;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListExpandedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InterestedStockService {

    private final InterestedStockRepository interestedStockRepository;

    @Transactional
    public String save(InterestedStockSaveRequestDto requestDto) {
        return interestedStockRepository.save(requestDto.toEntity()).getInterestedStockId().getTicker();
    }

    @Transactional
    public String update(InterestedStockId stockId, InterestedStockUpdateRequestDto requestDto) {
        InterestedStock stock = interestedStockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. 티커="+stockId.getTicker()));
        stock.update(stockId,
                     requestDto.getStockNm(),
                     requestDto.getBusinessCycle(),
                     requestDto.getNobilityStockYn(),
                     requestDto.getDividendPayMonth())
                    ;
        return stockId.getTicker();
    }

    @Transactional
    public void delete(InterestedStockId stockId) {
        InterestedStock stock = interestedStockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. 티커="+stockId.getTicker()));
        interestedStockRepository.delete(stock);
    }

    @Transactional(readOnly = true)
    public InterestedStockResponseDto findById(InterestedStockId stockId) {
        InterestedStock entity = interestedStockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. 티커="+stockId.getTicker()));
        return new InterestedStockResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<InterestedStockListResponseDto> findAllDesc() {
        return interestedStockRepository.findAllDesc().stream()
                .map(InterestedStockListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<InterestedStockListExapndedDto> selectInterestedStock(String email) {
        List<Object[]> list = interestedStockRepository.selectInterestedStock(email);
        InterestedStockListExapndedDto dto = InterestedStockListExapndedDto.builder().build();
        return dto.toDto(list);
    }

}
