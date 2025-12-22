package com.quyettienbn.book_store.web.test;

import com.tvd12.ezyhttp.server.boot.EzyHttpApplicationBootstrap;
import com.tvd12.ezyhttp.server.core.annotation.ComponentsScan;
import com.tvd12.ezyhttp.server.core.annotation.PropertiesSources;

@PropertiesSources({
    "config.properties",
    "setup.properties"
})
@ComponentsScan({
    "org.youngmonkeys.ezyplatform",
    "com.quyettienbn.book_store",
    "org.youngmonkeys.ecommerce",
    "org.youngmonkeys.ezyarticle"
})
public class BookStoreThemeStartupTest {

    public static void main(String[] args) throws Exception {
        EzyHttpApplicationBootstrap.start(BookStoreThemeStartupTest.class);
    }
}
