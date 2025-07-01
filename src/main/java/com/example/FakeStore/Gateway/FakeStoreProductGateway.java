package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi _fakeStoreProductApi){
        this.fakeStoreProductApi=_fakeStoreProductApi;
    }


    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        FakeStoreProductResponseDTO response = fakeStoreProductApi.getAllProducts().execute().body();

        if(response == null) {
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
