package uk.co.sainsburys.interview.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import uk.co.sainsburys.interview.model.Product;
import uk.co.sainsburys.interview.model.ProductPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ProductServiceTests {

    @InjectMocks
    private ProductService productService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProducts() {
        // Prepare mock data
        Product product = new Product();
        product.setProductUid("123");
        product.setProductType("BASIC");
        List<Product> products = new ArrayList<>();
        products.add(product);

        ProductPrice productPrice = new ProductPrice();
        productPrice.setProductUid("123");
        productPrice.setPrice(5.99);
        Map<String, ProductPrice> prices = Map.of("123", productPrice);

        when(restTemplate.getForObject(anyString(), eq(Product[].class))).thenReturn(products.toArray(new Product[0]));
        when(restTemplate.getForObject(anyString(), eq(ProductPrice[].class))).thenReturn(prices.values().toArray(new ProductPrice[0]));

        // Call the method
        List<Product> result = productService.getProducts("BASIC");

        // Verify results
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("BASIC", result.get(0).getProductType());
        assertEquals(5.99, result.get(0).getUnitPrice());
    }
}
