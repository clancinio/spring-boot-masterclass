package com.example.springbootmasterclass.controller;

import static com.example.springbootmasterclass.common.TestConstant.FLIGHT_NUMBER;
import static com.example.springbootmasterclass.common.TestUtil.createFlight;
import static com.example.springbootmasterclass.constant.ApplicationConstant.BASE_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.service.FlightService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(FlightController.class)
class FlightControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FlightService flightService;

  @Test
  @SneakyThrows
  void shouldGetFlightByFlightNumber() {
    // Given
    Flight flight = createFlight();
    Mockito.when(flightService.getFlightByFlightNumber(FLIGHT_NUMBER)).thenReturn(flight);

    // When
    mockMvc.perform(get(BASE_URL + "/flightNumber/" + FLIGHT_NUMBER)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.flightNumber")
            .value(flight.getFlightNumber()))
        .andDo(print());
  }
}
