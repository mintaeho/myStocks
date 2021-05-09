package com.nuritech.stock.my_stock.interested.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockListResponseDto;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockResponseDto;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockSaveRequestDto;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockUpdateRequestDto;
import com.nuritech.stock.my_stock.interested.service.InterestedStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class InterestedStockApiController {

    private final InterestedStockService interestedStockService;

    @PostMapping("/api/v1/interestedStock")
    public String save(@RequestBody InterestedStockSaveRequestDto requestDto,
                       @LoginUser SessionUser user) {
        if(user != null) requestDto.setEmail(user.getEmail());
        return interestedStockService.save(requestDto);
    }

    @PutMapping("/api/v1/interestedStock/{ticker}")
    public String update(@PathVariable String ticker,
                         @RequestBody InterestedStockUpdateRequestDto requestDto,
                         @LoginUser SessionUser user) {

        InterestedStockId interestedStockId = InterestedStockId.builder()
                                                                .email((user != null) ? user.getEmail() : "")
                                                                .ticker(ticker)
                                                                .build();
        return interestedStockService.update(interestedStockId, requestDto);
    }

    @DeleteMapping("/api/v1/interestedStock/{ticker}")
    public String delete(@PathVariable String ticker,
                       @LoginUser SessionUser user) {

        interestedStockService.delete(InterestedStockId.builder()
                                        .email((user != null) ? user.getEmail() : "")
                                        .ticker(ticker)
                                        .build());
        return ticker;
    }

    @GetMapping("/api/v1/interestedStock/{ticker}")
    public InterestedStockResponseDto findById(@PathVariable String ticker,
                                               @LoginUser SessionUser user) {

        return interestedStockService.findById(InterestedStockId.builder()
                .email((user != null) ? user.getEmail() : "")
                .ticker(ticker)
                .build());
    }

    @GetMapping("/api/v1/interestedStock/list")
    public List<InterestedStockListResponseDto> findAll() {
        return interestedStockService.findAllDesc();
    }

}
