package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.model.Shipment;
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
class ShipmentServiceTest {

    @Mock
    ShipmentService service;

    @Test
    void findAll() {
        List<Shipment> testList = List.of(new Shipment(), new Shipment(), new Shipment());
        when(service.findAll())
                .thenReturn(testList);
        List<Shipment> result = service.findAll();
        assertThat(result).isEqualTo(testList);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void save() {
        Shipment shipment = new Shipment();
        when(service.save(shipment)).thenReturn(shipment);
        assertThat(shipment).isEqualTo(service.save(shipment));
    }

    @Test
    void findById() {
        Shipment shipment = new Shipment(1L, null, 15, 200, new Supplier());

        when(service.findById(anyLong())).thenReturn(shipment);
        Shipment returned = service.findById(shipment.getId());
        verify(service).findById(shipment.getId());
        assertThat(returned).isEqualTo(shipment);

    }
}