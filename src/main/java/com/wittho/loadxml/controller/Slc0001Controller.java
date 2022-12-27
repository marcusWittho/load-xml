package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.Slc0001;
import com.wittho.loadxml.service.Slc0001Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sismsg")
public class Slc0001Controller {

  private final Slc0001Service slc0001Service;

  public Slc0001Controller(Slc0001Service slc0001Service) {
    this.slc0001Service = slc0001Service;
  }

  @PostMapping("load")
  public ResponseEntity<String> loadSisMsg() {

    return ResponseEntity.status(HttpStatus.OK).body(slc0001Service.buildSlc());
  }

  @GetMapping("list")
  public ResponseEntity<List<Slc0001>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(slc0001Service.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Slc0001> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(slc0001Service.getById(id));
  }
}
