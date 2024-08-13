package uk.co.sainsburys.interview.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import uk.co.sainsburys.interview.model.Product;
import uk.co.sainsburys.interview.model.ProductPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test") // Optional: specify a test profile if you have specific configurations
public class ProductServiceIntegrationTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private RestTemplate restTemplate;

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
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getProductType()).isEqualTo("BASIC");
        assertThat(result.get(0).getUnitPrice()).isEqualTo(5.99);
    }
}
