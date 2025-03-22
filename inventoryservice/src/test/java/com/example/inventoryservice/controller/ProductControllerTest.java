package com.example.inventoryservice.controller;

import com.example.inventoryservice.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    private final MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    public ProductControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    // Test GET /api/products
    @Test
    void testGetAllProducts() throws Exception {
        this.mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())  // Expect HTTP 200
                .andExpect(jsonPath("$").isArray())  // Expect response to be an array
                .andExpect(jsonPath("$[0].name").exists()); // Check if 'name' field exists in the response
    }

    // Test POST /api/products
    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product(null, "Laptop", 1500.00);  // Product to be created

        this.mockMvc.perform(post("/api/products")
                        .contentType("application/json")
                        .content(this.objectMapper.writeValueAsString(product)))  // Convert product to JSON
                .andExpect(status().isOk())  // Expect HTTP 200
                .andExpect(jsonPath("$.name").value("Laptop"))  // Verify the 'name' field
                .andExpect(jsonPath("$.price").value(1500.00));  // Verify the 'price' field
    }
}
