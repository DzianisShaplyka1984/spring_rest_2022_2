package com.academy.dto;

import lombok.Data;

@Data
public class UpdateBookDto {
  private Integer id;
  private String title;
  private Integer year;
}
