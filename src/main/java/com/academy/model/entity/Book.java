package com.academy.model.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String title;
  @Column
  private Integer year;
  @ManyToMany
  @JoinTable(
      name = "author_book",
      joinColumns = {@JoinColumn(name = "id_book")},
      inverseJoinColumns = {@JoinColumn(name = "id_author")}
  )
  private List<Author> authors;
}
