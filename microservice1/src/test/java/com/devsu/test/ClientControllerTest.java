package com.devsu.test;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.devsu.test.application.controllers.ClientController;
import com.devsu.test.application.requests.ClientAddRequest;
import com.devsu.test.application.requests.ClientUpdateRequest;
import com.devsu.test.application.requests.GenderType;
import com.devsu.test.application.responses.ClientIdResponse;
import com.devsu.test.application.responses.ClientResponse;
import com.devsu.test.application.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;

class ClientControllerTest {

    /** The mock mvc. */
    private MockMvc mockMvc;

    /** The object mapper. */
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private ClientController clientController;

    /** The employee service. */
    @Mock
    private ClientService clientService;

    public ClientControllerTest() {
        clientService = Mockito.mock(ClientService.class);
        clientController = new ClientController(clientService);
    }

    @BeforeEach
    void setUp() throws IOException {
        clientService = Mockito.mock(ClientService.class);
        clientController = new ClientController(clientService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    @SuppressWarnings("null")
    void addClient() throws Exception {

        ClientAddRequest clientAddRequest = new ClientAddRequest("Marianela Montalvo", GenderType.FEMALE, 25, "225487",
                "Amazonas y NNUU", "097548965", "5768");

        ClientIdResponse clientIdResponse = new ClientIdResponse();
        clientIdResponse.setClientId(1L);

        Mockito.when(clientService.addClient(any(ClientAddRequest.class))).thenReturn(clientIdResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                .content(objectMapper.writeValueAsString(clientAddRequest)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientId").exists());
    }
    
    @Test
    void getClient() throws Exception {

        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setClientId(1L);
        clientResponse.setName("Marianela Montalvo");
        clientResponse.setGender(GenderType.FEMALE.name());
        clientResponse.setAge(25);
        clientResponse.setIdentification("225487");
        clientResponse.setAddress("Amazonas y NNUU");
        clientResponse.setPhone("097548965");
        clientResponse.setStatus(true);

        final Long clientId = 1L;

        Mockito.when(clientService.getClient(clientId)).thenReturn(clientResponse);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/clients/{id}", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Marianela Montalvo"));
    }
    
    @Test
    void getAllClient() throws Exception {
        
        ClientResponse clientResponse1 = new ClientResponse();
        clientResponse1.setClientId(1L);
        clientResponse1.setName("Marianela Montalvo");

        ClientResponse clientResponse2 = new ClientResponse();
        clientResponse2.setClientId(2L);
        clientResponse2.setName("Jose Lema");

        List<ClientResponse> clients = new ArrayList<ClientResponse>();
        clients.add(clientResponse1);
        clients.add(clientResponse2);

        Mockito.when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/clients")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Jose Lema"));
    }
    
    @Test
    @SuppressWarnings("null")
    void updateClient() throws Exception {
        
        ClientUpdateRequest clientUpdateRequest = new ClientUpdateRequest(1L, "Marianela Montalvo", GenderType.FEMALE, 25, "225487",
                "Amazonas y NNUU", "097548965", "5768", false);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/clients")
                .content(objectMapper.writeValueAsString(clientUpdateRequest)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        
    }
    
    @Test
    @SuppressWarnings("null")
    void deleteClient() throws Exception {
        
        final Long clientId = 1L;
        clientService.deleteClient(clientId);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/clients/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
    }
}
