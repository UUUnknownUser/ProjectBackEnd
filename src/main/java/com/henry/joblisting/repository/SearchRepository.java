package com.henry.joblisting.repository;

import com.henry.joblisting.model.Post;

import java.util.List;


public interface SearchRepository {

    List<Post> findByText(String text);
}
