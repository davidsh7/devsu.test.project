package com.devsu.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.devsu.test.application.requests.ClientAddRequest;
import com.devsu.test.application.requests.ClientUpdateRequest;
import com.devsu.test.application.requests.GenderType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * The Class ClientControllerIT.
 * 
 * @author David Sepulveda
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientControllerIT {

    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;

    /** The object mapper. */
    @Autowired
    private ObjectMapper objectMapper;

    /** The client id. */
    private Long clientId;

    /**
     * Test A add client integration.
     *
     * @throws Exception the exception
     */
    @Test
    @SuppressWarnings("null")
    void testAAddClientIntegration() throws Exception {
        ClientAddRequest clientAddRequest = new ClientAddRequest("David Sepulveda", GenderType.MALE, 32, "1017198087",
                "Crr 51 98", "3046719891", "1234");

        String result = mockMvc
                .perform(post("/api/clients").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientAddRequest)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

        clientId = Long.valueOf(JsonPath.read(result, "$.clientId").toString());
    }

    /**
     * Test B get client integration.
     *
     * @throws Exception the exception
     */
    @Test
    void testBGetClientIntegration() throws Exception {

        mockMvc.perform(get("/api/clients/{id}", clientId).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name").value("David Sepulveda"))
                .andExpect(jsonPath("$.gender").value("MALE"));
    }

    /**
     * Test C get all clients integration.
     *
     * @throws Exception the exception
     */
    @Test
    void testCGetAllClientsIntegration() throws Exception {

        mockMvc.perform(get("/api/clients").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[?(@.clientId == " + clientId + ")]").exists());
    }

    /**
     * Test D update client integration.
     *
     * @throws Exception the exception
     */
    @Test
    @SuppressWarnings("null")
    void testDUpdateClientIntegration() throws Exception {

        ClientUpdateRequest request = new ClientUpdateRequest(clientId, "David Sepulveda", GenderType.MALE, 32,
                "1017198087", "Crr 51 98", "3046719891", "1234", false);

        mockMvc.perform(put("/api/clients").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());
    }

    /**
     * Test E delete client integration.
     *
     * @throws Exception the exception
     */
    @Test
    @SuppressWarnings("null")
    void testEDeleteClientIntegration() throws Exception {

        mockMvc.perform(delete("/api/clients/{id}", clientId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}