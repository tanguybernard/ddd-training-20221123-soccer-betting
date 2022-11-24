package com.zenika.soccerbetting.betting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zenika.soccerbetting.betting.application.ChooseBetDto;
import com.zenika.soccerbetting.betting.presentation.BetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ChooseBetIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createNurse() throws Exception {

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
