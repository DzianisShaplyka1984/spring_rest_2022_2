package com.academy.dto;

import lombok.Data;

@Data
public class CreateBookDto {
  private String title;
  private Integer year;
  private Integer authorId;
}
