package com.quyettienbn.book_store.test;

import org.youngmonkeys.devtools.repository.RepositoryClassesGenerator;

public class BookStoreRepositoryClassesGenerator {

    public static void main(String[] args) throws Exception {
        new RepositoryClassesGenerator(Object.class)
            .generate();
    }
}
