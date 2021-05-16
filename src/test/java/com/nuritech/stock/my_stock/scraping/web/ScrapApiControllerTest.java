package com.nuritech.stock.my_stock.scraping.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScrapApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles="USER")
    public void portfolio_메소드실행() throws Exception {
        // when
        //String body = this.restTemplate.getForObject("/api/v1/scrap", String.class);
        String url = "http://localhost:"+port+"/api/v1/scrap";
        MvcResult result = mvc.perform(post(url)
                   .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
        ;

        // then
        assertThat(result.getResponse().getContentAsString()).isEqualTo("SUCCESS");

    }


    @Test
    @WithMockUser(roles="USER")
    public void scrapManual_테스트() throws Exception {
        // when
        //String body = this.restTemplate.getForObject("/api/v1/scrap", String.class);
        String url = "http://localhost:"+port+"/api/v1/scrap/manual";
        String data = "{\"data\":[{\"id\":\"ENB\",\"attributes\":{\"log\":null,\"divYieldFwd\":7.07691365625036,\"divRate\":2.76,\"payoutRatio\":127.097529031695,\"divGrowRate5\":10.7150540420597,\"dividendGrowth\":3,\"divYieldTtm\":6.31376621309371,\"divDistribution\":\"Quarterly\",\"sectorname\":\"Energy\",\"dividends\":[{\"amount\":0.657145,\"date\":\"2021-02-11\",\"exDate\":\"2021-02-11\",\"payDate\":\"2021-03-01\",\"recordDate\":\"2021-02-12\",\"declareDate\":\"2020-12-08\"},{\"amount\":0.615276,\"date\":\"2020-11-12\",\"exDate\":\"2020-11-12\",\"payDate\":\"2020-12-01\",\"recordDate\":\"2020-11-13\",\"declareDate\":\"2020-11-04\"},{\"amount\":0.61136694,\"date\":\"2020-08-13\",\"exDate\":\"2020-08-13\",\"payDate\":\"2020-09-01\",\"recordDate\":\"2020-08-14\",\"declareDate\":\"2020-07-22\"},{\"amount\":0.575424,\"date\":\"2020-05-14\",\"exDate\":\"2020-05-14\",\"payDate\":\"2020-06-01\",\"recordDate\":\"2020-05-15\",\"declareDate\":\"2020-05-05\"}]}}]}";

        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                //.content(new ObjectMapper().writeValueAsString(data)))
                .content(data))
                .andExpect(status().isOk());
        ;
    }

}
