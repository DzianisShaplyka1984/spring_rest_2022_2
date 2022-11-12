package com.academy.dto;

import java.util.List;
import lombok.Data;

@Data
public class LibraryDto {
  private String address;
  private List<Integer> ids;
}
