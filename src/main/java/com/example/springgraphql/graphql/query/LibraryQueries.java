package com.example.springgraphql.graphql.query;

import com.example.springgraphql.protomodel.Author;
import com.example.springgraphql.protomodel.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class LibraryQueries implements GraphQLQueryResolver {

  public com.example.springgraphql.model.Book findBook(Long id){
    log.info("{}",id);
    com.example.springgraphql.model.Book book=getListOfBook().stream().filter(data->data.getId()==id).findFirst().get();
    return book;
  }

  public List<com.example.springgraphql.model.Book> getListOfBook(){
    List<com.example.springgraphql.model.Book> books = new ArrayList<>();
    com.example.springgraphql.model.Author autho1 = com.example.springgraphql.model.Author.builder().id(1L).firstName("abhishek").lastName("shenoy").build();
    com.example.springgraphql.model.Author author2 = com.example.springgraphql.model.Author.builder().id(2L).firstName("sasi").lastName("kumar").build();
    com.example.springgraphql.model.Author author3 = com.example.springgraphql.model.Author.builder().id(3L).firstName("rohit").lastName("pal").build();
    com.example.springgraphql.model.Author author4 = com.example.springgraphql.model.Author.builder().id(4L).firstName("sid").lastName("boy").build();
    List<com.example.springgraphql.model.Author> authorList1=new ArrayList<>();
    authorList1.add(autho1);
    authorList1.add(author2);
    List<com.example.springgraphql.model.Author> authorList2=new ArrayList<>();
    authorList2.add(author3);
    authorList2.add(author4);
    com.example.springgraphql.model.Book book1 = com.example.springgraphql.model.Book.builder().id(1L).title("Sapiens").authors(authorList1).build();
    com.example.springgraphql.model.Book book2 = com.example.springgraphql.model.Book.builder().id(2L).title("4 hour work week").authors(authorList2).build();
    books.add(book1);
    books.add(book2);
    return books;
  }

  public List<Book> getListOfBookProto(){
    List<Book> books = new ArrayList<>();
    Author autho1 = Author.newBuilder().setId(1L).setFirstName("abhishek").setLastName("shenoy").build();
    Author author2 = Author.newBuilder().setId(2L).setFirstName("sasi").setLastName("kumar").build();
    Author author3 = Author.newBuilder().setId(3L).setFirstName("rohit").setLastName("pal").build();
    Author author4 = Author.newBuilder().setId(4L).setFirstName("sid").setLastName("boy").build();

    List<Author> authorList1=new ArrayList<>();
    authorList1.add(autho1);
    authorList1.add(author2);

    List<Author> authorList2=new ArrayList<>();
    authorList2.add(author3);
    authorList2.add(author4);

    Book book1 = Book.newBuilder().setId(1L).setTitle("Sapiens").addAllAuthors(authorList1).build();
    Book book2 = Book.newBuilder().setId(2L).setTitle("4 hour work week").addAllAuthors(authorList2).build();

    books.add(book1);
    books.add(book2);

    return books;
  }

}
