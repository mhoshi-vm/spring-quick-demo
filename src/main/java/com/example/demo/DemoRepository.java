package com.example.demo;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends ListCrudRepository<DemoEntity,Integer> {
}
