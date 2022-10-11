package com.danvega.blog;

import com.danvega.blog.model.Author;
import com.danvega.blog.model.Comment;
import com.danvega.blog.model.Post;
import com.danvega.blog.repository.AuthorRepository;
import com.danvega.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authors){
		return args -> {
		AggregateReference<Author, Integer> dan = AggregateReference.to(authors.save(new Author(null,"Dan","Vega","sasmitapradhan01@gmail.com","sp")).id());
		Post post = new Post("Hello, World!","Welcome to my blog!",dan);
		post.addComment(new Comment("Dan","This is my first comment"));
		posts.save(post);
		};
	}
}
