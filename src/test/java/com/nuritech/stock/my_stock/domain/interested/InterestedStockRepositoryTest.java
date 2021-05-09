package com.nuritech.stock.my_stock.domain.interested;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InterestedStockRepositoryTest {

    @Autowired
    InterestedStockRepository interestedStockRepository;

    @Test
    @Transactional
    public void 관심종목저장_불러오기() {

        String email = "mintaeho75@gmail.com";
        String ticker = "TEST";
        String stockNm = "Coca Cola1";
        String nobilityStockYn = "Y";

        InterestedStockId interestedStockId = InterestedStockId.builder()
                                                                .email(email)
                                                                .ticker(ticker)
                                                                .build();

        interestedStockRepository.save(InterestedStock.builder()
                .interestedStockId(interestedStockId)
                .stockNm(stockNm)
                .nobilityStockYn(nobilityStockYn)
                .build());

        Optional<InterestedStock> interestedStock = interestedStockRepository.findById(interestedStockId);
        assertThat(interestedStock.get().getStockNm()).isEqualTo(stockNm);
    }
}
