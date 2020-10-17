package com.example.springgraphql.graphql.mutation;


import com.example.springgraphql.protomodel.Book;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryMutations implements GraphQLMutationResolver {

  public Book addBookProto(Book book){
    log.info("{}",book);
    book.getAuthorsList().forEach(author->{
      log.info("Author Info : {}.{}",author.getFirstName(),author.getLastName());
    });
    return book;
  }

  public com.example.springgraphql.model.Book addBookNormal(com.example.springgraphql.model.Book book){
    log.info("{}",book);
    book.getAuthors().forEach(author->{
      log.info("Author Info : {}.{}",author.getFirstName(),author.getLastName());
    });
    return book;
  }
}
