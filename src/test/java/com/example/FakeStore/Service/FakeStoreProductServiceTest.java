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

    private ProductDTO product1;
    private ProductDTO product2;
    private List<ProductDTO> productList;
    private List<ProductDTO> singleProductList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fakeStoreProductService = new FakeStoreProductService(productGateway, restTemplateGateway);

        // Arrange common test data
        product1 = ProductDTO.builder().title("Product 1").build();
        product2 = ProductDTO.builder().title("Product 2").build();
        productList = Arrays.asList(product1, product2);
        singleProductList = Collections.singletonList(product1);
    }

    @Test
    void testGetAllProduct_ReturnsProductList() throws IOException {
        when(restTemplateGateway.getAllProduct()).thenReturn(productList);

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
        when(restTemplateGateway.getProductById(productId)).thenReturn(product1);

        ProductDTO result = fakeStoreProductService.getProductById(productId);

        assertNotNull(result);
        assertEquals("Product 1", result.getTitle());
        verify(restTemplateGateway, times(1)).getProductById(productId);
    }

    @Test
    void testGetProductByCategory_ReturnsProductList() throws IOException {
        when(productGateway.getProductByCategory()).thenReturn(singleProductList);

        List<ProductDTO> result = fakeStoreProductService.getProductByCategory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
        verify(productGateway, times(1)).getProductByCategory();
    }

    @Test
    void testCreateProduct_ReturnsCreatedProduct() throws IOException {
        when(productGateway.createProduct(product1)).thenReturn(product1);

        ProductDTO result = fakeStoreProductService.createProduct(product1);

        assertNotNull(result);
        assertEquals("Product 1", result.getTitle());
        verify(productGateway, times(1)).createProduct(product1);
    }

    @Test
    void testCreateProduct_ReturnsNullIfCreationFails() throws IOException {
        when(productGateway.createProduct(product2)).thenReturn(null);

        ProductDTO result = fakeStoreProductService.createProduct(product2);

        assertNull(result);
        verify(productGateway, times(1)).createProduct(product2);
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