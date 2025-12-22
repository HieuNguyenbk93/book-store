package com.quyettienbn.book_store.web.controller.service;

import com.quyettienbn.book_store.web.controller.decorator.WebBookModelDecorator;
import com.quyettienbn.book_store.web.response.WebBookResponse;
import com.tvd12.ezyhttp.server.core.annotation.Service;
import lombok.AllArgsConstructor;
import org.youngmonkeys.ecommerce.model.*;
import org.youngmonkeys.ecommerce.web.service.WebProductCategoryProductService;
import org.youngmonkeys.ecommerce.web.service.WebProductCategoryService;
import org.youngmonkeys.ecommerce.web.service.WebProductService;

import java.util.Collections;
import java.util.List;

import static com.quyettienbn.book_store.constant.BookStoreConstants.*;
import static com.tvd12.ezyfox.io.EzyLists.newArrayList;

@Service
@AllArgsConstructor
public class WebBookControllerService {

    private final WebProductService productService;
    private final WebProductCategoryService productCategoryService;
    private final WebProductCategoryProductService productCategoryProductService;
    private final WebBookModelDecorator bookModelDecorator;

    public List<WebBookResponse> getHighlightBooks(
        ProductCurrencyModel currency,
        int limit
    ) {
        return getBooksByCategoryName(
            CATEGORY_NAME_HIGHLIGHT_BOOK,
            currency,
            limit
        );
    }

    public List<WebBookResponse> getBooksByCategoryName(
            String categoryName,
            ProductCurrencyModel currency,
            int limit
    ) {
        ProductCategoryModel category = productCategoryService
            .getCategoryByName(categoryName);
        if (category == null) {
            return Collections.emptyList();
        }
        List<Long> productIds = newArrayList(
            productCategoryProductService.getProductCategoryProductsByCategory(
                    category.getId(),
                    limit
            ),
            ProductCategoryProductModel::getProductId
        );
        List<ProductModel> models = productService
            .getProductsByIds(productIds);
        return bookModelDecorator.decorateToBookResponses(
            models,
            currency
        );
    }
}