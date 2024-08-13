package uk.co.sainsburys.interview.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import uk.co.sainsburys.interview.model.Product;
import uk.co.sainsburys.interview.service.ProductService;

import java.util.List;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetProducts() throws Exception {
        // Prepare mock data
        Product product = new Product();
        product.setProductUid("123");
        product.setProductType("BASIC");
        List<Product> products = List.of(product);

        when(productService.getProducts("BASIC")).thenReturn(products);

        // Perform the GET request
        mockMvc.perform(get("/products").param("type", "BASIC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productType").value("BASIC"))
                .andExpect(jsonPath("$[0].unitPrice").value(0.0));
    }
}
