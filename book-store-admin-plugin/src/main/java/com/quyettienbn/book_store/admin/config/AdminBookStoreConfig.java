/*
 * Copyright 2024 youngmonkeys.org
 *
 * Licensed under the ezyplatform, Version 1.0.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://youngmonkeys.org/licenses/ezyplatform-1.0.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.quyettienbn.book_store.admin.config;

import com.quyettienbn.book_store.constant.BookStoreProductCategoryType;
import com.quyettienbn.book_store.constant.BookStoreProductType;
import com.tvd12.ezyfox.bean.EzyBeanConfig;
import com.tvd12.ezyfox.bean.annotation.EzyConfigurationAfter;
import lombok.AllArgsConstructor;
import org.youngmonkeys.ecommerce.admin.manager.AdminProductCategoryTypeManager;
import org.youngmonkeys.ecommerce.admin.manager.AdminProductTypeManager;
import org.youngmonkeys.ezyplatform.admin.model.AddUserRoleNameModel;
import org.youngmonkeys.ezyplatform.admin.service.AdminSettingService;
import org.youngmonkeys.ezyplatform.admin.service.AdminUserRoleService;

import static com.quyettienbn.book_store.constant.BookStoreConstants.*;
import static com.tvd12.ezyfox.io.EzyLists.newArrayList;

@EzyConfigurationAfter
@AllArgsConstructor
public class AdminBookStoreConfig implements EzyBeanConfig {

    private final AdminProductTypeManager productTypeManager;
    private final AdminProductCategoryTypeManager productCategoryTypeManager;
    private final AdminSettingService settingService;
    private final AdminUserRoleService userRoleService;

    @Override
    public void config() {
        addBookAuthorRoleIfNotExists();
        registerProductTypes();
        registerProductCategoryTypes();
    }

    private void addBookAuthorRoleIfNotExists() {
        long savedBookAuthorRoleId = settingService.getLongValue(
            SETTING_NAME_BOOK_AUTHOR_ROLE_ID
        );
        if (savedBookAuthorRoleId <= 0) {
            long roleId = userRoleService.saveUserRoleNameIfNotExists(
                AddUserRoleNameModel.builder()
                    .name(ROLE_AUTHOR_NAME)
                    .displayName(ROLE_AUTHOR_DISPLAY_NAME)
                    .build()
            ).getId();
            settingService.setLongValue(
                SETTING_NAME_BOOK_AUTHOR_ROLE_ID,
                roleId
            );
        }
    }

    private void registerProductTypes() {
        productTypeManager.addProductTypes(
            newArrayList(
                BookStoreProductType.values(),
                Enum::toString
            )
        );
    }

    private void registerProductCategoryTypes() {
        productCategoryTypeManager.addProductCategoryTypes(
            newArrayList(
                BookStoreProductCategoryType.values(),
                Enum::toString
            )
        );
    }
}