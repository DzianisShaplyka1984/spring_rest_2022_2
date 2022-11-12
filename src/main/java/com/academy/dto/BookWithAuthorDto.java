package com.academy.dto;

import java.util.List;
import lombok.Data;

@Data
public class BookWithAuthorDto {
  private Integer id;
  private String title;
  private List<AuthorDto> authors;
}
