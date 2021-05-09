package com.nuritech.stock.my_stock.daybook.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksListResponseDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksResponseDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksSaveRequestDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksUpdateRequestDto;
import com.nuritech.stock.my_stock.daybook.service.DaybooksService;
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
public class DaybooksApiController {

    private final DaybooksService daybooksService;

    @PostMapping("/api/v1/daybooks")
    public Long save(@RequestBody DaybooksSaveRequestDto requestDto,
                     @LoginUser SessionUser user) {
        if(user != null) requestDto.setEmail(user.getEmail());
        return daybooksService.save(requestDto);
    }

    @PutMapping("/api/v1/daybooks/{id}")
    public Long update(@PathVariable Long id,
                         @RequestBody DaybooksUpdateRequestDto requestDto,
                       @LoginUser SessionUser user) {
        if(user != null) requestDto.setEmail(user.getEmail());
        return daybooksService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/daybooks/{id}")
    public Long delete(@PathVariable Long id) {
        daybooksService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/daybooks/{id}")
    public DaybooksResponseDto findById(@PathVariable Long id) {
        return daybooksService.findById(id);
    }

    @GetMapping("/api/v1/daybooks/list")
    public List<DaybooksListResponseDto> findAll() {
        return daybooksService.findAllDesc();
    }

}
