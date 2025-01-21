import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopRepositoryTest {
    private ShopRepository repository = new ShopRepository();
    private Product item1 = new Product(1, "Cola", 75);
    private Product item2 = new Product(2, "Lays", 100);

    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(2);

        Product[] expected = new Product[]{item1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}

