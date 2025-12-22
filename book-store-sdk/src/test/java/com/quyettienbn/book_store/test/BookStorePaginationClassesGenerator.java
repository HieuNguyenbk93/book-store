package com.quyettienbn.book_store.test;

import org.youngmonkeys.devtools.pagination.PaginationClassesGenerator;

public class BookStorePaginationClassesGenerator {

    public static void main(String[] args) throws Exception {
        new PaginationClassesGenerator(Object.class)
            .generate();
    }
}
