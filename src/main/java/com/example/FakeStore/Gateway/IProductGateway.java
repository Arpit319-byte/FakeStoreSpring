package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    public List<ProductDTO> getAllProduct() throws IOException;

    public List<ProductDTO> getProductById() throws IOException;

    public List<ProductDTO> getProductByCategory() throws IOException;
}
