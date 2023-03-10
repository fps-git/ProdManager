import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldAddNew() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good1, good2, good3, good4};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNothing() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Book(3, "iPhone 13 Manual", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good3};
        Product[] actual = manager.searchBy("13");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTwo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good2, good4};
        Product[] actual = manager.searchBy("PRO");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByID() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        repo.removeById(2);
        repo.removeById(4);

        Product[] expected = {good1, good3};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);

    }

}