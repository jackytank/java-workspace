package com.example.demo.redis.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RedisHash
public class Book {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String title;
    private String subtitle;
    private String description;
    private String language;
    private Long pageCount;
    private String thumbnail;
    private Double price;
    private String currency;
    private String infoLink;
    private Set<String> authors;
    @Reference
    private Set<Category> categories = new HashSet<>();

    public void addCategory(Category category) {
        categories.add(category);
    }
}
