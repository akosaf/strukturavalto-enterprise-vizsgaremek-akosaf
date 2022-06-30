package com.codecool.warehouseapp.controller.location;

import com.codecool.warehouseapp.service.location.BinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bin")
public class BinController {

    private final BinService service;

    public BinController(BinService service) {
        this.service = service;
    }

}
