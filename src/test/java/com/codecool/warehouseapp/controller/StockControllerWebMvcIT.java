package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Category;
import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.service.StockService;
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

@WebMvcTest(controllers = StockController.class)
public class StockControllerWebMvcIT {

    @MockBean
    StockService service;

    @Autowired
    MockMvc mvc;

    @Test
    void testFindAll() throws Exception {
        when(service.findAll())
                .thenReturn(List.of(new Stock(1L, "stock1", "desc", LocalDate.now(), 20, 100, "China", new Category(), new Shipment()), new Stock()));

        mvc.perform(get("/stock"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("stock1")));
    }

    @Test
    void testFindAllIfEmpty() throws Exception {
        mvc.perform(get("/stock"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo(List.of())));
    }

    @Test
    void testUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .put("/stock/{id}", 1L)
                        .content(asJsonString(new Stock(1L, "stock1", "desc", null, 20, 100, "China", new Category(), new Shipment())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testSave() throws Exception {
        Stock stock = new Stock(1L, "stock1", "desc", null, 20, 100, "China", new Category(), new Shipment());

        mvc.perform(MockMvcRequestBuilders
                .post("/stock")
                .content(asJsonString(stock))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void testDelete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/stock/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindById() throws Exception {
        when(service.findById(1L))
                .thenReturn(new Stock(1L, "stock1", "desc", null, 20, 100, "China", new Category(), new Shipment()));

        mvc.perform(get("/stock/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("stock1")));
    }

}
