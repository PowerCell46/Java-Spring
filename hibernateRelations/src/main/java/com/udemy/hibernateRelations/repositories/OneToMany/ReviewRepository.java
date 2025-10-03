package com.udemy.hibernateRelations.repositories.OneToMany;

import com.udemy.hibernateRelations.entities.OneToMany.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
