package com.example.FakeStore.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    @Override
    public String getAllCategory(List<String> productByCategory) {
        return "";
    }
}
