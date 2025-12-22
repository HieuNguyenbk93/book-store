package com.quyettienbn.book_store.web.controller.api;

import com.tvd12.ezyfox.util.EzyMapBuilder;
import com.tvd12.ezyhttp.server.core.annotation.Api;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;

@Api
@Controller("/api/v1")
public class LuckyWheelController {

    @DoGet("/book-store")
    public Object info() {
        return EzyMapBuilder.mapBuilder()
            .put("name", "book-store")
            .build();
    }
}
