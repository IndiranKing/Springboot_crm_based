package com.infosys_api.infosys_api.repository;

import com.infosys_api.infosys_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
