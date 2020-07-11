package com.jayden.ch06.tacos.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.jayden.ch06.tacos.entity.Taco;
import com.jayden.ch06.tacos.repository.TacoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
@RequiredArgsConstructor
public class RecentTacosController {

  private final TacoRepository tacoRepository;

  @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
  public ResponseEntity<Iterable<TacoModel>> recentTacos() {
    PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());

    List<Taco> tacos = tacoRepository.findAll(page).getContent();

    TacoModelAssembler tacoModelAssembler = new TacoModelAssembler();
    CollectionModel<TacoModel> tacoModels = tacoModelAssembler.toCollectionModel(tacos);

    tacoModels.add(WebMvcLinkBuilder.linkTo(methodOn(RecentTacosController.class).recentTacos()).withRel("recents"));

    return ResponseEntity.ok(tacoModels);
  }
}
