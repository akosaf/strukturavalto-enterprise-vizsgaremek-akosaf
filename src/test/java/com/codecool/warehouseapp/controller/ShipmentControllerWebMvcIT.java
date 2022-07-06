package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.model.Supplier;
import com.codecool.warehouseapp.service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static com.codecool.warehouseapp.controller.CategoryControllerWebMvcIT.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShipmentController.class)
public class ShipmentControllerWebMvcIT {

    @MockBean
    ShipmentService service;

    @Autowired
    MockMvc mvc;

    @Test
    void testFindAll() throws Exception {
        when(service.findAll())
                .thenReturn(List.of(new Shipment(1L, LocalDate.now(), 10, 200, new Supplier()), new Shipment()));

        mvc.perform(get("/shipment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].currency", equalTo(200)));
    }

    @Test
    void testFindAllIfEmpty() throws Exception {
        mvc.perform(get("/shipment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo(List.of())));
    }

    @Test
    void testUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/shipment/{id}", 1L)
                .content(asJsonString(new Shipment(1L, null, 15, 200, new Supplier())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testSave() throws Exception {
        Shipment shipment = new Shipment(1L, null, 10, 200, new Supplier());

        mvc.perform(MockMvcRequestBuilders
                .post("/shipment/")
                .content(asJsonString(shipment))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void testSaveIfInvalid1() throws Exception {
        Shipment shipment = new Shipment(1L, null, -1, 200, new Supplier());

        mvc.perform(MockMvcRequestBuilders
                .post("/shipment/")
                .content(asJsonString(shipment))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSaveIfInvalid2() throws Exception {
        Shipment shipment = new Shipment(1L, null, 10, -1, new Supplier());

        mvc.perform(MockMvcRequestBuilders
                .post("/shipment/")
                .content(asJsonString(shipment))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDelete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/shipment/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindById() throws Exception {

        when(service.findById(1L))
                .thenReturn(new Shipment(1L, LocalDate.now(), 10, 200, new Supplier()));

        mvc.perform(get("/shipment/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.weight", equalTo(10)));
    }


}
