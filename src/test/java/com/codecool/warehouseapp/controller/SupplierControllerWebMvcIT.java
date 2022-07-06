package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Supplier;
import com.codecool.warehouseapp.service.SupplierService;
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

@WebMvcTest(controllers = SupplierController.class)
public class SupplierControllerWebMvcIT {

    @MockBean
    SupplierService service;

    @Autowired
    MockMvc mvc;

    @Test
    void testFindAll() throws Exception {
        when(service.findAll())
                .thenReturn(List.of(new Supplier(1L, "sup1", "Poland", LocalDate.now(), 20), new Supplier()));

        mvc.perform(get("/supplier"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("sup1")));
    }

    @Test
    void testFindAllIfEmpty() throws Exception {
        mvc.perform(get("/supplier"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo(List.of())));
    }

    @Test
    void testUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/supplier/{id}", 1L)
                .content(asJsonString(new Supplier(1L, "sup1", "Poland", null, 20)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testSave() throws Exception {
        Supplier supplier = new Supplier(1L, "sup1", "Poland", null, 20);

        mvc.perform(MockMvcRequestBuilders
                        .post("/supplier")
                        .content(asJsonString(supplier))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void testSaveNotValid1() throws Exception {
        Supplier supplier = new Supplier(1L, "sup1", "Poland", null, 101);

        mvc.perform(MockMvcRequestBuilders
                        .post("/supplier")
                        .content(asJsonString(supplier))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSaveNotValid2() throws Exception {
        Supplier supplier = new Supplier(1L, "sup1", "Poland", null, -1);

        mvc.perform(MockMvcRequestBuilders
                        .post("/supplier")
                        .content(asJsonString(supplier))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSaveNotValid3() throws Exception {
        Supplier supplier = new Supplier(1L, "", "Poland", null, 10);

        mvc.perform(MockMvcRequestBuilders
                        .post("/supplier")
                        .content(asJsonString(supplier))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSaveNotValid4() throws Exception {
        Supplier supplier = new Supplier(1L, "sup1", "", null, -1);

        mvc.perform(MockMvcRequestBuilders
                        .post("/supplier")
                        .content(asJsonString(supplier))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDelete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/supplier/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindById() throws Exception {
        when(service.findById(1L))
                .thenReturn(new Supplier(1L, "sup1", "Poland", null, 20));

        mvc.perform(get("/supplier/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("sup1")));
    }

}
