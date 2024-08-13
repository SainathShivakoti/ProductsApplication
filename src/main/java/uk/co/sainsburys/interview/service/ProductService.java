package uk.co.sainsburys.interview.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sainsburys.interview.model.Product;
import uk.co.sainsburys.interview.model.ProductPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Value("${products.api.url}")
    private String productsApiUrl;

    @Value("${prices.api.url}")
    private String pricesApiUrl;

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts(String type) {
        logger.debug("Fetching products from API: {}", productsApiUrl);
        List<Product> products = fetchProducts();
        logger.debug("Fetched products: {}", products);

        logger.debug("Fetching prices from API: {}", pricesApiUrl);
        Map<String, ProductPrice> prices = fetchPrices();
        logger.debug("Fetched prices: {}", prices);

        // Merge prices into products
        products.forEach(product -> {
            if (product.getProductUid() != null) {
                ProductPrice price = prices.get(product.getProductUid());
                if (price != null) {
                    product.setUnitPrice(price.getPrice());
                    product.setUnitPriceMeasure(price.getMeasure());
                    product.setUnitPriceMeasureAmount(price.getMeasureAmount());
                }
            }
        });

        // Filter by type if provided
        if (type != null && !type.isEmpty()) {
            products = products.stream()
                    .filter(product -> type.equalsIgnoreCase(product.getProductType()))
                    .collect(Collectors.toList());
        }

        return products;
    }

    private List<Product> fetchProducts() {
        try {
            Product[] productsArray = restTemplate.getForObject(productsApiUrl, Product[].class);
            logger.debug("Raw API response for products: {}", Arrays.toString(productsArray));
            return (productsArray != null) ? List.of(productsArray) : new ArrayList<>();
        } catch (Exception e) {
            logger.error("Error fetching products", e);
            throw e;
        }
    }

    private Map<String, ProductPrice> fetchPrices() {
        try {
            ProductPrice[] pricesArray = restTemplate.getForObject(pricesApiUrl, ProductPrice[].class);
            logger.debug("Raw API response for prices: {}", Arrays.toString(pricesArray));
            return (pricesArray != null) ? Arrays.stream(pricesArray)
                    .filter(price -> price.getProductUid() != null)
                    .collect(Collectors.toMap(
                            ProductPrice::getProductUid,
                            price -> price,
                            (existing, replacement) -> existing)) // Handle duplicate keys
                    : Map.of();
        } catch (Exception e) {
            logger.error("Error fetching prices", e);
            throw e;
        }
    }
}
