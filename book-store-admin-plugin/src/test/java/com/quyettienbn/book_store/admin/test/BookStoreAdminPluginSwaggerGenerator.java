package com.quyettienbn.book_store.admin.test;

import org.youngmonkeys.devtools.swagger.SwaggerGenerator;

public class BookStoreAdminPluginSwaggerGenerator {

    public static void main(String[] args) throws Exception {
        SwaggerGenerator swaggerGenerator = new SwaggerGenerator(
            "com.quyettienbn.book_store.admin.controller"
        );
        swaggerGenerator.generateToDefaultFile();
    }
}
