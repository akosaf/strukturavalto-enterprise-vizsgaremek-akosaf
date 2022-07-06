package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.model.Supplier;
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
class SupplierServiceTest {

    @Mock
    SupplierService service;

    @Test
    void testFindAll() {
        List<Supplier> testList = List.of(new Supplier(), new Supplier(), new Supplier());
        when(service.findAll())
                .thenReturn(testList);
        List<Supplier> result = service.findAll();
        assertThat(result).isEqualTo(testList);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void testSave() {
        Supplier supplier = new Supplier();
        when(service.save(supplier)).thenReturn(supplier);
        assertThat(supplier).isEqualTo(service.save(supplier));
    }

    @Test
    void findById() {
        Supplier supplier = new Supplier(1L, "sup1", "", null, 10);

        when(service.findById(anyLong())).thenReturn(supplier);
        Supplier returned = service.findById(supplier.getId());
        verify(service).findById(supplier.getId());
        assertThat(returned).isEqualTo(supplier);
    }
}