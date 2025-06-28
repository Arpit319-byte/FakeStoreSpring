package com.example.FakeStore.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProductDTO {

    String productName;
    String productCategory;

}
