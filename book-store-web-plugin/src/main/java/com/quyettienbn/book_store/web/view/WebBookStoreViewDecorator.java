package com.quyettienbn.book_store.web.view;

import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import com.tvd12.ezyhttp.server.core.view.View;
import lombok.AllArgsConstructor;
import org.youngmonkeys.ecommerce.web.service.WebShoppingCartService;
import org.youngmonkeys.ezyarticle.web.manager.WebPageFragmentManager;
import org.youngmonkeys.ezyplatform.model.UserModel;
import org.youngmonkeys.ezyplatform.web.controller.service.WebLanguageControllerService;
import org.youngmonkeys.ezyplatform.web.view.WebViewDecorator;

import javax.servlet.http.HttpServletRequest;

@EzySingleton
@AllArgsConstructor
public class WebBookStoreViewDecorator extends WebViewDecorator {

    private final WebPageFragmentManager pageFragmentManager;
    private final WebShoppingCartService shoppingCartService;
    private final WebLanguageControllerService languageControllerService;

    @Override
    public void decorate(HttpServletRequest request, View view) {
        super.decorate(request, view);
        String languageCode = languageControllerService
            .getLanguageCodeOrDefault(request);
        view.setVariable(
            "commonFragments",
            pageFragmentManager.getPageFragmentMap(
                "common",
                languageCode
            )
        );
    }

    @Override
    protected void decorateWithUserData(
        HttpServletRequest request,
        View view,
        UserModel user
    ) {
        view.setVariable(
            "shoppingCartProductCount",
            shoppingCartService
                .getShoppingCartProductCountByOwnerId(
                        user.getId()
                )
        );
    }

    @Override
    protected boolean includeWebLanguages() {
        return true;
    }
}
