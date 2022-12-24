package com.wittho.loadxml.controller;

import com.wittho.loadxml.service.Slc0001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
