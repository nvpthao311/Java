package org.example;

public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {} // Constructor private để ngăn tạo instance bên ngoài.

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
