package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.Liquid;
import com.wittho.loadxml.service.LiquidService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("liquid")
public class LiquidController {

  private final LiquidService liquidService;

  public LiquidController(LiquidService liquidService) {
    this.liquidService = liquidService;
  }

  @GetMapping("list")
  public ResponseEntity<List<Liquid>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(liquidService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Liquid> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(liquidService.getById(id));
  }
}
