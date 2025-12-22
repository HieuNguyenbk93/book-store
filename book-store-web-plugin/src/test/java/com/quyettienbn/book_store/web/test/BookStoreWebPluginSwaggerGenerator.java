package com.quyettienbn.book_store.web.test;

import org.youngmonkeys.devtools.swagger.SwaggerGenerator;

public class BookStoreWebPluginSwaggerGenerator {

    public static void main(String[] args) throws Exception {
        SwaggerGenerator swaggerGenerator = new SwaggerGenerator(
            "com.quyettienbn.book_store.web.controller"
        );
        swaggerGenerator.generateToDefaultFile();
    }
}
