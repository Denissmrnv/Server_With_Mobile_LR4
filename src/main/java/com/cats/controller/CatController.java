package com.cats.controller;

import com.cats.model.Cat;
import com.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping("/cats")
    public  ResponseEntity<List<Cat>> getCats() throws FileNotFoundException {
        return ResponseEntity.ok(catService.getCats());
    }

    @GetMapping("/cats/{name}")
    public  ResponseEntity<List<Cat>> getCatsByName(@PathVariable String name) throws FileNotFoundException {
        return ResponseEntity.ok(catService.getCatsByName(name));
    }
}
