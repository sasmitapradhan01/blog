package com.danvega.blog.model.dto;

import com.danvega.blog.model.Author;
import com.danvega.blog.model.Post;

public record PostDetails(Post post, Author author) {
}
