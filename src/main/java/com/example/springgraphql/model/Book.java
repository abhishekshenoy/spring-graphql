package com.example.springgraphql.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Book {
  Long id;
  String title;
  List<Author> authors;
}
