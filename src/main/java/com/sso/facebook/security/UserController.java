package com.sso.facebook.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            return Collections.singletonMap("name", principal.getAttribute("name"));
        } else {
            // Handle the case where principal is null
            return Collections.singletonMap("error", "User is not authenticated");
        }
    }
}