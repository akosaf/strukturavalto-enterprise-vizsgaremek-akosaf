package com.codecool.warehouseapp.controller.location;

import com.codecool.warehouseapp.service.location.ShelfService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class ShelfController {

    private final ShelfService service;

    public ShelfController(ShelfService service) {
        this.service = service;
    }
}
