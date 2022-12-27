package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.Prodt;
import com.wittho.loadxml.service.ProdtService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prodt")
public class ProdtController {

  private final ProdtService prodtService;

  public ProdtController(ProdtService prodtService) {
    this.prodtService = prodtService;
  }

  @GetMapping("list")
  public ResponseEntity<List<Prodt>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(prodtService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Prodt> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(prodtService.getById(id));
  }
}
