package com.SBproject.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SBproject.Main.model.Product;
@Repository
public interface ProductRespository extends JpaRepository<Product, Long>{

}