package com.nisum.sprint3day4.question2.controller;

import com.nisum.sprint3day4.question2.model.Product;
import com.nisum.sprint3day4.question2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String category,
                                @RequestParam(required = false) BigDecimal min,
                                @RequestParam(required = false) BigDecimal max,
                                @RequestParam(required = false) String sort,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = sort != null ? PageRequest.of(page, size, Sort.by(sort)) : PageRequest.of(page, size);

        if (category != null) return repository.findByCategory(category);
        if (min != null && max != null) return repository.findByPriceBetween(min, max);

        return repository.findAll(pageable).getContent();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setPrice(updated.getPrice());
            existing.setStockQuantity(updated.getStockQuantity());
            existing.setCategory(updated.getCategory());
            return repository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
