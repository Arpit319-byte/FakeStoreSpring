package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.ProductDTO;

import java.util.List;

public interface IProductGateway {

    public List<ProductDTO> getAllProduct();
}
