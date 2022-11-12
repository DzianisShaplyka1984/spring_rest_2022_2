package com.academy.controller;

import com.academy.dto.AuthorDto;
import com.academy.dto.BookDto;
import com.academy.dto.CreateBookDto;
import com.academy.dto.UpdateBookDto;
import com.academy.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {
  private final BookService bookService;

  @GetMapping()
  public List<BookDto> getBooks() {
    return bookService.getBooks();
  }

  @GetMapping(value ="/{id}")
  public BookDto getBook(@PathVariable Integer id) {
    return bookService.getBook(id);
  }

  @PostMapping()
  public ResponseEntity createBook(@RequestBody CreateBookDto createBookDto) {
    bookService.save(createBookDto);

    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PutMapping()
  public void updateBook(@RequestBody UpdateBookDto updateBookDto) {
    bookService.update(updateBookDto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity deleteBook(@PathVariable Integer id) {
    bookService.delete(id);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value ="/{id}/authors")
  public List<AuthorDto> getAuthors(@PathVariable Integer id) {
    return null;
  }
}
