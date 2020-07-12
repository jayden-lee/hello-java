package com.jayden.ch06.tacos.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jayden.ch06.tacos.entity.Taco;
import com.jayden.ch06.tacos.repository.TacoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DesignTacoController {

  private final TacoRepository tacoRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
    Optional<Taco> optionalTaco = tacoRepository.findById(id);
    if (optionalTaco.isPresent()) {
      return ResponseEntity.ok(optionalTaco.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Taco saveTaco(@RequestBody Taco taco) {
    return tacoRepository.save(taco);
  }
}
