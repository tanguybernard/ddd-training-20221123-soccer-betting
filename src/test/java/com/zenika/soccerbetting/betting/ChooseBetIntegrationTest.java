package com.zenika.soccerbetting.betting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zenika.soccerbetting.betting.application.ChooseBetDto;
import com.zenika.soccerbetting.betting.domain.bet.Bet;
import com.zenika.soccerbetting.betting.domain.bet.BetId;
import com.zenika.soccerbetting.betting.domain.gambler.Gambler;
import com.zenika.soccerbetting.betting.domain.gambler.GamblerId;
import com.zenika.soccerbetting.betting.domain.match.MatchId;
import com.zenika.soccerbetting.betting.domain.ports.BetRepository;
import com.zenika.soccerbetting.betting.domain.ports.GamblerRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryGamblerRepository;
import com.zenika.soccerbetting.betting.ports.stubs.InMemoryValidateBetRepository;
import com.zenika.soccerbetting.betting.presentation.BetDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ChooseBetIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private BetRepository betRepository;

    @Autowired
    private GamblerRepository gamblerRepository;

    @Test
    public void chooseBet() throws Exception {


        betRepository.save(new Bet(new BetId("bet"), new MatchId("FRA#ENG"),"Score"));
        gamblerRepository.save(new Gambler(new GamblerId("gambler")));


        ChooseBetDto dto = new ChooseBetDto("bet", "gambler", 50, "€");

        byte[] contentAsBytes = objectMapper.writeValueAsBytes(dto);

        MockHttpServletResponse response = mockMvc
                .perform(post("/bet/choose").content(contentAsBytes)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(201);
        String responseBody = response.getContentAsString();
        BetDto responseDto
                = new Gson().fromJson(responseBody, BetDto.class);
        assertThat(responseDto.gamblerId()).isEqualTo("gambler");
    }
}
