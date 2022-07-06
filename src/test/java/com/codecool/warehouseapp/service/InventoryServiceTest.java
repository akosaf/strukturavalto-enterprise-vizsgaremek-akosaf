package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.model.Category;
import com.codecool.warehouseapp.model.Shipment;
import com.codecool.warehouseapp.model.Stock;
import com.codecool.warehouseapp.model.Supplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InventoryServiceTest {

    @Mock
    InventoryService service;

    @Test
    void testConstructStockOneParam() {
        Stock stock = new Stock();
        when(service.constructStock(stock)).thenReturn(stock);
        Stock returned = service.constructStock(stock);
        assertThat(stock).isEqualTo(returned);
    }

    @Test
    void testConstructStockTwoParam() {
        Stock stock = new Stock();
        when(service.constructStock(stock, 1L)).thenReturn(stock);
        Stock returned = service.constructStock(stock, 1L);
        assertThat(stock).isEqualTo(returned);
    }

    @Test
    void testConstructCategoryOneParam() {
        Category category = new Category();
        when(service.constructCategory(category)).thenReturn(category);
        Category returned = service.constructCategory(category);
        assertThat(category).isEqualTo(returned);
    }

    @Test
    void testConstructCategoryTwoParam() {
        Category category = new Category();
        when(service.constructCategory(category, 1L)).thenReturn(category);
        Category returned = service.constructCategory(category, 1L);
        assertThat(category).isEqualTo(returned);
    }

    @Test
    void testConstructShipmentOneParam() {
        Shipment shipment = new Shipment();
        when(service.constructShipment(shipment)).thenReturn(shipment);
        Shipment returned = service.constructShipment(shipment);
        assertThat(shipment).isEqualTo(returned);
    }

    @Test
    void testConstructShipmentTwoParam() {
        Shipment shipment = new Shipment();
        when(service.constructShipment(shipment, 1L)).thenReturn(shipment);
        Shipment returned = service.constructShipment(shipment, 1L);
        assertThat(shipment).isEqualTo(returned);
    }

    @Test
    void testConstructSupplierOneParam() {
        Supplier supplier = new Supplier();
        when(service.constructSupplier(supplier)).thenReturn(supplier);
        Supplier returned = service.constructSupplier(supplier);
        assertThat(supplier).isEqualTo(returned);
    }

    @Test
    void testConstructSupplierTwoParam() {
        Supplier supplier = new Supplier();
        when(service.constructSupplier(supplier, 1L)).thenReturn(supplier);
        Supplier returned = service.constructSupplier(supplier, 1L);
        assertThat(supplier).isEqualTo(returned);
    }

}