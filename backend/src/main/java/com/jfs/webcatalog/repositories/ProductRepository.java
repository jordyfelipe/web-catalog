package com.jfs.webcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.webcatalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
