package com.nuritech.stock.my_stock.daybook.service;

import com.nuritech.stock.my_stock.daybook.domain.Daybooks;
import com.nuritech.stock.my_stock.daybook.domain.DaybooksRepository;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksListResponseDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksResponseDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksSaveRequestDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DaybooksService {

    private final DaybooksRepository daybooksRepository;

    @Transactional
    public Long save(DaybooksSaveRequestDto requestDto) {
        return daybooksRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, DaybooksUpdateRequestDto requestDto) {
        Daybooks daybooks;
        daybooks = daybooksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 매매내역이 없습니다. id="+id));

        daybooks.update(requestDto.getTradingDate(),
                requestDto.getEmail(),
                requestDto.getTicker(),
                requestDto.getUnitPrice(),
                requestDto.getStockNum(),
                requestDto.getTradingType(),
                requestDto.getTradingAmount(),
                requestDto.getFee(),
                requestDto.getExchangeRate());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Daybooks stock = daybooksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 매매내역이 없습니다. id="+id));
        daybooksRepository.delete(stock);
    }

    @Transactional(readOnly = true)
    public DaybooksResponseDto findById(Long id) {
        Daybooks entity = daybooksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 매매내역이 없습니다. id="+id));
        return new DaybooksResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<DaybooksListResponseDto> findAllDesc() {
        return daybooksRepository.findAllDesc().stream()
                .map(DaybooksListResponseDto::new)
                .collect(Collectors.toList());
    }

}
