package com.nuritech.stock.my_stock.scraping.service;

import com.nuritech.stock.my_stock.scraping.domain.Stock;
import com.nuritech.stock.my_stock.scraping.domain.StockRepository;
import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import com.nuritech.stock.my_stock.scraping.dto.StockListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScrapService {
    private final StockRepository stockRepository;

    @Transactional
    public String stockSave(StockDto stockDto) {
        return stockRepository.save(stockDto.toEntity()).getTicker();
    }

    /*


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }



     */
    @Transactional(readOnly = true)
    public StockDto findById(String ticker) {
        Stock entity = stockRepository.findById(ticker)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. ticker="+ticker));
        return new StockDto(entity);
    }

    @Transactional(readOnly = true)
    public List<StockListDto> findAllDesc() {
        return stockRepository.findAllDesc().stream()
                .map(StockListDto::new)
                .collect(Collectors.toList());
    }
}
