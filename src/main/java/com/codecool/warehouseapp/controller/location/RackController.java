package com.codecool.warehouseapp.controller.location;

import com.codecool.warehouseapp.service.location.RackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rack")
public class RackController {

    private final RackService service;

    public RackController(RackService service) {
        this.service = service;
    }
}
