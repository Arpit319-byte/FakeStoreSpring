package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStore.DTO.FakeStoreSingleProductResponseDTO;
import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreProductApi;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("FakeStoreProductGateway")
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
    public ProductDTO getProductById(long id) throws IOException {

        logger.info("Fetching the response for a specific product by ID from FakeStoreProductApi");
        FakeStoreSingleProductResponseDTO response = fakeStoreProductApi.getProductById(id).execute().body();

        if (response == null) {
            logger.error("Response returned from FakeStoreProductApi is Null for the specified product ID");
            throw new IOException("Response is null");
        }

        return response.getProduct();

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

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        logger.info("Creating a new product in the FakeStoreProductApi");
        FakeStoreSingleProductResponseDTO response = fakeStoreProductApi.createProduct(productDTO).execute().body();

        if (response == null || response.getProduct() == null ) {
            logger.error("Failed to create product or received null response from FakeStoreProductApi");
            throw new IOException("Failed to create product or received null response");
        }

        return response.getProduct() ;  // Assuming the API returns a list with one created product
    }

    @Override
    public boolean deleteProductById(Long id) throws IOException {
        return false;
    }
}