package com.gml.client.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gml.client.ClientsCrudApplication;
import com.gml.client.application.dto.ClientRequestDto;
import com.gml.client.builder.ClientBuilder;
import com.gml.client.domain.port.CreateClientRepository;

@AutoConfigureMockMvc
@SpringBootTest(classes = { ClientsCrudApplication.class })
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CreateClientRepository createClientRepository;

	@Test
	void createClientSuccessTest() throws Exception {
		ClientBuilder clientBuilder = new ClientBuilder();
		ClientRequestDto clientRequestDto = clientBuilder.builderRequestClientDto();

		Mockito.when(createClientRepository.execute(Mockito.any())).thenReturn(null);

		mockMvc.perform(post("/api/client").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(clientRequestDto))).andExpect(status().is2xxSuccessful());
	}

}
