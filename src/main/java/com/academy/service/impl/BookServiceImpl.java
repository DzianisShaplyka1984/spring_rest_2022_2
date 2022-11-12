package com.academy.service.impl;

import com.academy.dto.BookDto;
import com.academy.dto.CreateBookDto;
import com.academy.dto.UpdateBookDto;
import com.academy.model.entity.Book;
import com.academy.model.repository.AuthorRepository;
import com.academy.model.repository.BookRepository;
import com.academy.service.BookService;
import com.academy.service.PriceService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final PriceService priceService;
  private final AuthorRepository authorRepository;

  @Override
  public List<BookDto> getBooks() {
    var books = bookRepository.findAll();

    var booksDto = new ArrayList<BookDto>();

    books.forEach(book -> {
      var price = priceService.getPrice(book.getId());

      var bookDto = new BookDto();
      bookDto.setId(book.getId());
      bookDto.setTitle(book.getTitle());
      bookDto.setPrice(price);

      booksDto.add(bookDto);
    });

    return booksDto;
  }

  @Override
  public BookDto getBook(Integer id) {
    var book = bookRepository.getReferenceById(id);

    var bookDto = new BookDto();
    bookDto.setId(book.getId());
    bookDto.setPrice(priceService.getPrice(book.getId()));
    bookDto.setTitle(book.getTitle());

    return bookDto;
  }

  @Override
  public void save(CreateBookDto createBookDto) {
    var book = new Book();

    book.setTitle(createBookDto.getTitle());
    book.setYear(createBookDto.getYear());

    var authorId = createBookDto.getAuthorId();
    if (authorId != null) {
      var author = authorRepository.getReferenceById(authorId);

      book.setAuthors(Collections.singletonList(author));
    }

    bookRepository.save(book);
  }

  @Override
  public void update(UpdateBookDto updateBookDto) {
    var book = new Book();

    book.setId(updateBookDto.getId());
    book.setTitle(updateBookDto.getTitle());
    book.setYear(updateBookDto.getYear());

    bookRepository.save(book);
  }

  @Override
  public void delete(Integer id) {

  }
}
