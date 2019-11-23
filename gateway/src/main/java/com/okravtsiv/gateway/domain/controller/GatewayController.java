package com.okravtsiv.gateway.domain.controller;

import com.okravtsiv.gateway.domain.feign.ImgServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private ImgServiceClient imgServiceClient;

    @GetMapping("/images/{fileName}")
    public @ResponseBody ResponseEntity<byte[]> getImageByName(@PathVariable("fileName") String fileName) {
        return imgServiceClient.getImageByName(fileName);
    }

    @GetMapping("/images/msg")
    public @ResponseBody ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(imgServiceClient.getMessage());
    }
}
