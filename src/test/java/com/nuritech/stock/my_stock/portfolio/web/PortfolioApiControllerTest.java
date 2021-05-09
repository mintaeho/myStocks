package com.nuritech.stock.my_stock.portfolio.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuritech.stock.my_stock.config.auth.SecurityConfig;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.portfolio.domain.Portfolio;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioRepository;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioSaveRequestDto;
import com.nuritech.stock.my_stock.user.domain.User;
import lombok.With;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PortfolioApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PortfolioRepository portfolioRepository;

    private MockMvc mvc;
    private final String email = "test@gmail.com";
    private final String ticker = "TEST";

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles="USER")
    public void portfolio_등록된다() throws Exception {
        // given
        PortfolioSaveRequestDto requestDto = PortfolioSaveRequestDto.builder()
                .ticker(ticker)
                .email(email)
                .build();
        String url = "http://localhost:"+port+"/api/v1/portfolio";

        // when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
        ;
        // then
        Optional<Portfolio> entity = portfolioRepository.findById(PortfolioId.builder()
                .email(email)
                .ticker(ticker)
                .build());
        assertThat(entity.get().getPortfolioId().getTicker()).isEqualTo(ticker);
    }
}
