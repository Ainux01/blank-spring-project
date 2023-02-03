package com.example.demo1.jsonPlaceHolderComments;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
@FeignClient(
        value = "jsonplaceholdercomments",
        url = "https://jsonplaceholder.typicode.com/comments/"
)
public interface JSONPlaceHolderCommentsClient {

    @GetMapping
    List<Comment> getComments();

    @GetMapping("/{commentId}")
    Comment getCommentById(@PathVariable("commentId") Integer id);
}
