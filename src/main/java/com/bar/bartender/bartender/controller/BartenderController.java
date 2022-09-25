package com.bar.bartender.bartender.controller;

import com.bar.bartender.bartender.service.BartenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/bartender")
public class BartenderController {

    private final BartenderService bartenderService;

    public BartenderController(BartenderService bartenderService) {
        this.bartenderService = bartenderService;
    }

    @GetMapping("/array_response")
    public ResponseEntity<Map<String,String>> getArrayResponse(@RequestParam Integer q, @RequestParam Integer id){
        Map<String, String> arrayResponse = bartenderService.getArrayResponse(q, id);
        if(arrayResponse.size() > 0){
            return ResponseEntity.ok(arrayResponse);
        }
        return new ResponseEntity<>(arrayResponse, HttpStatus.NOT_FOUND);
    }
}
