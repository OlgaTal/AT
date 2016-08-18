package com.at.repositories;

import com.at.models.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {

}