package dev.sachin.ProductServiceNovember24.repositories;

import dev.sachin.ProductServiceNovember24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

//    @Override
//    List<Product> findAll();

    @Override
    Page<Product> findAll(Pageable pageable);
}
