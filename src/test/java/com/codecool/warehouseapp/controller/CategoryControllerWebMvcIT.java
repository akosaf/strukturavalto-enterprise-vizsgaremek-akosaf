package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.controller.CategoryController;
import com.codecool.warehouseapp.model.Category;
import com.codecool.warehouseapp.model.Supplier;
import com.codecool.warehouseapp.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerWebMvcIT {

    @MockBean
    CategoryService service;

    @Autowired
    MockMvc mvc;

    @Test
    void testFindAll() throws Exception {
        when(service.findAll())
                .thenReturn(List.of(new Category(1L, "cat1"), new Category(2L, "cat2")));

        mvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("cat1")));
    }

    @Test
    void testFindAllIfEmpty() throws Exception {
        mvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo(List.of())));
    }

    @Test
    void testSave() throws Exception {
        Category category = new Category(1L, "cat1");

        mvc.perform(MockMvcRequestBuilders
                .post("/category")
                .content(asJsonString(category))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void testSaveInvalid() throws Exception {
        Category category = new Category(1L, "");

        mvc.perform(MockMvcRequestBuilders
                .post("/category")
                .content(asJsonString(category))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/category/{id}", 1L)
                .content(asJsonString(new Category(1L, "cat1")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/category/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testFindById() throws Exception {
        when(service.findById(1L))
                .thenReturn(new Category(1L, "cat1"));

        mvc.perform(get("/category/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("cat1")));
    }

    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
