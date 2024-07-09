package com.SBproject.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SBproject.Main.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
