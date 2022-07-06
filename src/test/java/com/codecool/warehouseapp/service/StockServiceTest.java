package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.model.Category;
import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.model.Stock;
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
class StockServiceTest {

    @Mock
    StockService service;

    @Test
    void testFindAll() {
        List<Stock> testList = List.of(new Stock(), new Stock(), new Stock());
        when(service.findAll())
                .thenReturn(testList);
        List<Stock> result = service.findAll();
        assertThat(result).isEqualTo(testList);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void save() {
        Stock stock = new Stock();
        when(service.save(stock)).thenReturn(stock);
        assertThat(stock).isEqualTo(service.save(stock));
    }

    @Test
    void findById() {
        Stock stock = new Stock(1L, "stock1", "desc", null, 20, 100, "China", new Category(), new Shipment());

        when(service.findById(anyLong())).thenReturn(stock);
        Stock returned = service.findById(stock.getId());
        verify(service).findById(stock.getId());
        assertThat(returned).isEqualTo(stock);
    }

}