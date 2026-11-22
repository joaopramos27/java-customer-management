package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
