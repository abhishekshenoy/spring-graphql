package com.example.springgraphql.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Author {
  Long id;
  String firstName;
  String lastName;
}
