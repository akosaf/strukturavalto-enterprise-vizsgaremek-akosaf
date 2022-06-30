package com.codecool.warehouseapp.controller.location;

import com.codecool.warehouseapp.service.location.AisleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aisle")
public class AisleController {

    private final AisleService service;

    public AisleController(AisleService service) {
        this.service = service;
    }
}
