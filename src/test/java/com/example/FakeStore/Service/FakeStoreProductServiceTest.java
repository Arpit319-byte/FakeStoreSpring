package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.IProductGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FakeStoreProductServiceTest {

    @Mock
    private IProductGateway productGateway;

    @Mock
    private IProductGateway restTemplateGateway;

    @InjectMocks
    private FakeStoreProductService fakeStoreProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fakeStoreProductService = new FakeStoreProductService(productGateway, restTemplateGateway);
    }

    @Test
    void testGetAllProduct_ReturnsProductList() throws IOException {
        ProductDTO product1 = ProductDTO.builder().title("Product 1").build();
        ProductDTO product2 = ProductDTO.builder().title("Product 2").build();
        List<ProductDTO> mockProducts = Arrays.asList(product1, product2);
        when(restTemplateGateway.getAllProduct()).thenReturn(mockProducts);

        List<ProductDTO> result = fakeStoreProductService.getAllProduct();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
        assertEquals("Product 2", result.get(1).getTitle());
        verify(restTemplateGateway, times(1)).getAllProduct();
    }

    @Test
    void testGetProductById_ReturnsProduct() throws IOException {
        long productId = 1L;
        ProductDTO mockProduct = ProductDTO.builder().title("Product 1").build();
        when(restTemplateGateway.getProductById(productId)).thenReturn(mockProduct);

        ProductDTO result = fakeStoreProductService.getProductById(productId);

        assertNotNull(result);
        assertEquals("Product 1", result.getTitle());
        verify(restTemplateGateway, times(1)).getProductById(productId);
    }

    @Test
    void testGetProductByCategory_ReturnsProductList() throws IOException {
        ProductDTO product1 = ProductDTO.builder().title("Category Product 1").build();
        List<ProductDTO> mockProducts = Collections.singletonList(product1);
        when(productGateway.getProductByCategory()).thenReturn(mockProducts);

        List<ProductDTO> result = fakeStoreProductService.getProductByCategory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Category Product 1", result.get(0).getTitle());
        verify(productGateway, times(1)).getProductByCategory();
    }

    @Test
    void testCreateProduct_ReturnsCreatedProduct() throws IOException {
        ProductDTO inputProduct = ProductDTO.builder().title("New Product").build();
        ProductDTO createdProduct = ProductDTO.builder().title("New Product").build();
        when(productGateway.createProduct(inputProduct)).thenReturn(createdProduct);

        ProductDTO result = fakeStoreProductService.createProduct(inputProduct);

        assertNotNull(result);
        assertEquals("New Product", result.getTitle());
        verify(productGateway, times(1)).createProduct(inputProduct);
    }

    @Test
    void testCreateProduct_ReturnsNullIfCreationFails() throws IOException {
        ProductDTO inputProduct = ProductDTO.builder().title("Fail Product").build();
        when(productGateway.createProduct(inputProduct)).thenReturn(null);

        ProductDTO result = fakeStoreProductService.createProduct(inputProduct);

        assertNull(result);
        verify(productGateway, times(1)).createProduct(inputProduct);
    }

    @Test
    void testDeleteProductById_ReturnsTrueIfDeleted() throws IOException {
        Long productId = 1L;
        when(restTemplateGateway.deleteProductById(productId)).thenReturn(true);

        boolean result = fakeStoreProductService.deleteProductById(productId);

        assertTrue(result);
        verify(restTemplateGateway, times(1)).deleteProductById(productId);
    }

    @Test
    void testDeleteProductById_ReturnsFalseIfNotDeleted() throws IOException {
        Long productId = 2L;
        when(restTemplateGateway.deleteProductById(productId)).thenReturn(false);

        boolean result = fakeStoreProductService.deleteProductById(productId);

        assertFalse(result);
        verify(restTemplateGateway, times(1)).deleteProductById(productId);
    }
} 