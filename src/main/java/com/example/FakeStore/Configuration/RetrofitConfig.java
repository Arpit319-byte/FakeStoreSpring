package com.example.FakeStore.Configuration;

import com.example.FakeStore.Gateway.Api.FakeStoreCategoryApi;
import com.example.FakeStore.Gateway.Api.FakeStoreProductApi;
import com.example.FakeStore.Gateway.Api.FakeStoreUserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
         return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }

    @Bean
    public FakeStoreUserApi fakeStoreUserApi(Retrofit retrofit){
        return retrofit.create(FakeStoreUserApi.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
