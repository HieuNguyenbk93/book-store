package com.quyettienbn.book_store.web.controller.view;

import com.tvd12.ezyhttp.server.core.annotation.Authenticated;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import org.youngmonkeys.ezyaccount.web.controller.view.AccountController;

@Authenticated
@Controller
public class WebBookStoreAccountController extends AccountController {}
