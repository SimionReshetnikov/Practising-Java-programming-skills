package com.example.blog.storage;

import com.example.blog.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStorage {

    private static final PostStorage INSTANCE = new PostStorage();
    private final AtomicInteger id = new AtomicInteger(1);
    private final List<Post> listPosts = new ArrayList<>();

    private PostStorage() {}

    public static PostStorage getInstance() {
        return INSTANCE;
    }

    public synchronized Post createPost(String headline, String text) {
        Post post = new Post(id.getAndIncrement(), headline, text);
        listPosts.add(post);
        return post;
    }

    public synchronized List<Post> getAll() {
        return new ArrayList<>(listPosts);
    }

    public synchronized Optional<Post> findById(int id) {
        return listPosts.stream().filter(p -> p.getId() == id).findFirst();
    }

}
