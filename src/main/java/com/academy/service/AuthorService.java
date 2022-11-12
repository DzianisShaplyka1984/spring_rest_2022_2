package com.academy.service;

import com.academy.dto.AuthorDto;
import java.util.List;

public interface AuthorService {
  List<AuthorDto> getAuthors();
  AuthorDto getAuthor(Integer id);
}
