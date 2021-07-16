package com.image.image.repository;

import com.image.image.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDbRepository extends MongoRepository<Image,String> {
}
