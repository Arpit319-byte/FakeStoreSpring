package com.example.FakeStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository implements JpaRepository<User,Long> {
}
