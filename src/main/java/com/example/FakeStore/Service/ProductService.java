package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Mapper.MapperClass;
import com.example.FakeStore.Repository.ProductRepository;
import com.example.FakeStore.model.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("ProductService")
public class ProductService implements IProductService {
    // This is a placeholder service implementation for ProductService.

    private final ProductRepository productRepository;

    public ProductService(ProductRepository _productRepository) {
        this.productRepository = _productRepository;
    }

    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method fetches all products from the repository layer
        List<Product> products = productRepository.findAll();
       return products.stream()
               .map(MapperClass::mapToProductDTO)
               .toList();
    }

    @Override
    public ProductDTO getProductById(long id) throws IOException {
        // This method can be implemented to fetch a product by its ID
        return productRepository.findById(id)
                .map(MapperClass::mapToProductDTO)
                .orElseThrow(() -> new IOException("Product not found for ID: " + id));
    }

    @Override
    public List<ProductDTO> getProductByCategory() throws IOException {
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {

        Product product = MapperClass.mapToProductEntity(productDTO);
        Product productSaved =productRepository.save(product);
        return MapperClass.mapToProductDTO(productSaved);
    }

    @Override
    public boolean deleteProductById(Long id) throws IOException {
        // This method can be implemented to delete a product by its ID
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true; // Return true if deletion was successful
        } else {
            throw new IOException("Product not found for ID: " + id);
        }
    }
}
