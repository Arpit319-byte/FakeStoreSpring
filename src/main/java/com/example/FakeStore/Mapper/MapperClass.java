package com.example.FakeStore.Mapper;

import com.example.FakeStore.DTO.AddressDTO;
import com.example.FakeStore.DTO.GeoLocationDTO;
import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.model.Address;
import com.example.FakeStore.model.GeoLocation;
import com.example.FakeStore.model.Product;
import com.example.FakeStore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperClass {

    // This class is intended to map between different DTOs and entities.

    private final static Logger logger = LoggerFactory.getLogger(MapperClass.class);

    // Mapping ProductDTO to ProductEntity
    public static ProductDTO mapToProductDTO(Product product) {

        if (product == null) {
            logger.warn("Product entity is null, cannot map to ProductDTO");
            return null;
        }

        logger.info("Mapping Product entity to ProductDTO");
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImage())
                .brand(product.getBrand())
                .model(product.getModel())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .build();
    }

    // Mapping ProductEntity to ProductDTO
    public static Product mapToProductEntity(ProductDTO productDTO) {

        if (productDTO == null) {
            logger.warn("ProductDTO is null, cannot map to Product entity");
            return null;
        }

        logger.info("Mapping ProductDTO to Product entity");
        return Product.builder()
                .id(productDTO.getId())
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .image(productDTO.getImage())
                .brand(productDTO.getBrand())
                .model(productDTO.getModel())
                .popular(productDTO.isPopular())
                .discount(productDTO.getDiscount())
                .build();
    }


    // Mapping UserDTO to UserEntity
    public static User mapToUserEntity(UserDTO userDTO) {

        if (userDTO == null) {
            logger.warn("UserDTO is null, cannot map to User entity");
            return null;
        }

        logger.info("Mapping UserDTO to User entity");
        return User.builder()
                .firstName(userDTO.getFirstName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .address(mapToAddressEntity(userDTO.getAddress()))
                .build();
    }

    //Mapping AddressDTO to AddressEntity
    public static Address mapToAddressEntity(AddressDTO addressDTO) {

        if (addressDTO == null) {
            logger.warn("AddressDTO is null, cannot map to Address entity");
            return null;
        }

        logger.info("Mapping AddressDTO to Address entity");
        return Address.builder()
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .number(addressDTO.getNumber())
                .zipcode(addressDTO.getZipcode())
                .geolocation(mapToGeoLocationEntity(addressDTO.getGeoLocation()))
                .build();
    }

    // Mapping GeoLocationDTO to GeoLocationEntity
    public static GeoLocation mapToGeoLocationEntity(GeoLocationDTO geoLocationDTO) {

        if (geoLocationDTO == null) {
            logger.warn("GeoLocationDTO is null, cannot map to GeoLocation entity");
            return null;
        }

        logger.info("Mapping GeoLocationDTO to GeoLocation entity");
        return GeoLocation.builder()
                .lat(geoLocationDTO.getLat())
                .lng(geoLocationDTO.getLng())
                .build();
    }


}
