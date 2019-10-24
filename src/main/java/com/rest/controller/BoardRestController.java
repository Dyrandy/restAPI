package com.rest.controller;

import com.rest.domain.Board;
import com.rest.repository.BoardRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.PagedModel.PageMetadata;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class BoardRestController {
    private BoardRepository boardRepository;

    public BoardRestController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @GetMapping("/board")
    public @ResponseBody CollectionModel<Board> simpleBoard(@PageableDefault Pageable pageable){
        Page<Board> boardList = boardRepository.findAll(pageable);

        PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), boardList.getNumber(), boardList.getTotalElements());

        PagedModel<Board> resources = new PagedModel<>(boardList.getContent(), pageMetadata);
        resources.add(linkTo(methodOn(BoardRestController.class).simpleBoard(pageable)).withSelfRel());
        return resources;
    }
}
