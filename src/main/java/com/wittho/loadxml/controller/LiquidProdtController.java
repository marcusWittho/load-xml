package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.LiquidProdt;
import com.wittho.loadxml.service.LiquidProdtService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("liquidprodt")
public class LiquidProdtController {

  private final LiquidProdtService liquidProdtService;

  public LiquidProdtController(LiquidProdtService liquidProdtService) {
    this.liquidProdtService = liquidProdtService;
  }

  @GetMapping("list")
  public ResponseEntity<List<LiquidProdt>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(liquidProdtService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<LiquidProdt> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(liquidProdtService.getById(id));
  }
}
