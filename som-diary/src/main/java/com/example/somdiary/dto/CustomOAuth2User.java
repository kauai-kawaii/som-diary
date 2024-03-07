package com.example.somdiary.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {

    private final OAuth2Response oAuth2Response;
    private final String role;

    public CustomOAuth2User(OAuth2Response oAuth2Response, String role) {

        this.oAuth2Response = oAuth2Response;
        this.role = role;
    }

    @Override
    public Map<String, Object> getAttributes() {
        // 로그인 진행 시 로그인 서버에서 주어지는 모든 데이터
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // role 값에 해당함

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return role;
            }
        });

        return collection;
    }

    @Override
    public String getName() {
        // 사용자 별명
        return oAuth2Response.getName();
    }

    public String getUsername() {
        // 구분자가 될 느낌?
//        return oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId(); -> 추후 다양한 소셜일 경우 앞에 수식어 붙여줌
        return oAuth2Response.getProviderId();
    }
}
