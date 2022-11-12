package com.academy.service;

import com.academy.dto.BookDto;
import com.academy.dto.CreateBookDto;
import com.academy.dto.UpdateBookDto;
import com.academy.model.entity.Book;
import java.util.List;

public interface BookService {
  List<BookDto> getBooks();

  BookDto getBook(Integer id);

  void save(CreateBookDto createBookDto);

  void update(UpdateBookDto updateBookDto);

  void delete(Integer id);
}
