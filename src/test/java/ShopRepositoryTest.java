import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {

        @Test
        public void shouldRemoveId() {
            ShopRepository repository = new ShopRepository();
            Product product = new Product(1, "Костюм", 50_000);
            Product product1 = new Product(2, "Жакет", 20_000);
            Product product2 = new Product(3, "Ремень", 10_000);
            repository.add(product);
            repository.add(product1);
            repository.add(product2);

            repository.removeById(1);

            Product[] expected = {product1, product2};
            Product[] actual = repository.findAll();

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldThrowNotFoundException() {
            ShopRepository repository = new ShopRepository();
            Product product = new Product(1, "Костюм", 50_000);
            Product product1 = new Product(2, "Жакет", 20_000);
            Product product2 = new Product(3, "Ремень", 10_000);
            repository.add(product);
            repository.add(product1);
            repository.add(product2);

            Assertions.assertThrows(NotFoundException.class, () -> {
                repository.removeById(4);
            });
        }
    }
