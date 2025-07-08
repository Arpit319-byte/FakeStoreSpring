package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public List<ProductDTO> getAllProduct() throws IOException;

    public List<ProductDTO> getProductById() throws IOException;

    public List<ProductDTO> getProductByCategory() throws IOException;

    public ProductDTO createProduct(ProductDTO productDTO) throws IOException;
}
