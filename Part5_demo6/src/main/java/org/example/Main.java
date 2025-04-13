//DAO

package org.example;

public class Main {
    public static void main(String[] args) {
        CategoryService service = new CategoryService(new SamsungCategory());
        CategoryService service1 = new CategoryService(new IphoneCategory());

    }
}