package com.henry.joblisting.repository;

import com.henry.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository  extends MongoRepository<Post,String> {

}
