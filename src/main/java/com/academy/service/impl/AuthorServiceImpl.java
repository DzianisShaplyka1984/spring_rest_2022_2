package com.academy.service.impl;

import com.academy.dto.AuthorDto;
import com.academy.model.repository.AuthorRepository;
import com.academy.service.AuthorService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
  private final AuthorRepository authorRepository;

  @Override
  public List<AuthorDto> getAuthors() {
    var authors = authorRepository.findAll();

    var authorDtos = new ArrayList<AuthorDto>();

    authors.forEach(author -> {
      var authorDto = new AuthorDto();
      authorDto.setId(author.getId());
      authorDto.setName(author.getName());

      authorDtos.add(authorDto);
    });

    return authorDtos;
  }

  @Override
  public AuthorDto getAuthor(Integer id) {
    var author = authorRepository.getReferenceById(id);

    var authorDto = new AuthorDto();
    authorDto.setId(author.getId());
    authorDto.setName(author.getName());

    return authorDto;
  }
}
