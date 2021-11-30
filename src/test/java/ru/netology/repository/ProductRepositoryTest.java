package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Product book1 = new Book(1, "book1", 500, "author1");
    Product book2 = new Book(2, "book2", 700, "author2");
    Product smartphone1 = new Smartphone(3, "samsung", 5000, "south korean");
    Product smartphone2 = new Smartphone(4, "zte", 2000, "china");

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
    }

    @Test
    public void shouldSaveAll() {
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = {book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}