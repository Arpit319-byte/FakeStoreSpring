package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreProductApi;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreProductGateway.class);
    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi _fakeStoreProductApi) {
        this.fakeStoreProductApi = _fakeStoreProductApi;
    }


    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        logger.info("Fetching the response from FakeStoreProductApi");
        FakeStoreProductResponseDTO response = fakeStoreProductApi.getAllProducts().execute().body();

        if (response == null) {
            logger.error("Response returned from FakeStoreProductApi is Null");
            throw new IOException("Response is null");
        }
        return response.getProducts().stream()
                .map(product -> ProductDTO.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build())
                .toList();

    }

    @Override
    public List<ProductDTO> getProductById() throws IOException {

        logger.info("Fetching the response for a specific product by ID from FakeStoreProductApi");
        FakeStoreProductResponseDTO response = fakeStoreProductApi.getProductById().execute().body();

        if (response == null) {
            logger.error("Response returned from FakeStoreProductApi is Null for the specified product ID");
            throw new IOException("Response is null");
        }

        return response.getProducts().stream()
                .map(product -> ProductDTO.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build())
                .toList();
    }

    @Override
    public List<ProductDTO> getProductByCategory() throws IOException {

        logger.info("Fetching the response for products by category from FakeStoreProductApi");
        FakeStoreProductResponseDTO response = fakeStoreProductApi.getProductByCategory().execute().body();

        if (response == null) {
            logger.error("Response returned from FakeStoreProductApi is Null for the specified category");
            throw new IOException("Response is null");
        }

        return response.getProducts().stream()
                .map(product -> ProductDTO.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build())
                .toList();
    }
}