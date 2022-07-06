package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CategoryServiceTest {

    @Mock
    CategoryService service;

    @Test
    void testFindAll() {
        List<Category> testList = List.of(new Category(1L, "cat1"), new Category(2L, "cat2"), new Category(3L, "cat3"));
        when(service.findAll())
                .thenReturn(testList);
        List<Category> result = service.findAll();
        assertThat(result).isEqualTo(testList);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void testSave() {
        Category category = new Category(1L, "cat1");
        when(service.save(category)).thenReturn(category);
        assertThat(category).isEqualTo(service.save(category));
    }

    @Test
    void testFindById() {
        Category category = new Category(1L, "cat1");

        when(service.findById(anyLong())).thenReturn(category);
        Category returned = service.findById(category.getId());
        verify(service).findById(category.getId());
        assertThat(returned).isEqualTo(category);
    }
}