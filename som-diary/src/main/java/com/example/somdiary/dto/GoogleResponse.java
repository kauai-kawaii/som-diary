package com.example.somdiary.dto;

import java.util.Map;

public class GoogleResponse implements OAuth2Response{

    private final Map<String, Object> attribute;

    public GoogleResponse(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getProviderId() {

        return attribute.get("sub").toString(); // 구글의 경우 키: sub
    }

    @Override
    public String getName() {

        return attribute.get("name").toString();
    }
}