package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "book1", 500, "author1");
    Product book2 = new Book(2, "book2", 700, "author2");
    Product smartphone1 = new Smartphone(3, "samsung", 5000, "south korean");
    Product smartphone2 = new Smartphone(4, "zte", 2000, "china");


    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("author3");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone1() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone2() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("zte");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmartphone2() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("china");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmartphone1() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("south korean");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByManufacturerSmartphone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("taiwan");
        assertArrayEquals(expected, actual);
    }
}