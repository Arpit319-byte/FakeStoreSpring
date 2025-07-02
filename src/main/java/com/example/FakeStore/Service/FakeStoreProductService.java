package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.IProductGateway;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreProductService.class);
    private final IProductGateway iProductGateway;

    public FakeStoreProductService(IProductGateway _iProductGateway){
        this.iProductGateway=_iProductGateway;
    }
    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method fetches all products from the gateway layer
        logger.info("Fetching all products from the FakeStoreProductService Layer");
        return iProductGateway.getAllProduct();
    }

    @Override
    public List<ProductDTO> getProductById() throws IOException {
        // This method can be implemented to fetch a product by its ID
        logger.info("Fetching product by ID from the FakeStoreProductService Layer");
        return iProductGateway.getProductById();
    }
}
