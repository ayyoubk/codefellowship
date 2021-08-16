package com.lab.codefellowship.repositories;

import com.lab.codefellowship.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}
