package com.example.somdiary.service;

import com.example.somdiary.dto.CustomOAuth2User;
import com.example.somdiary.dto.GoogleResponse;
import com.example.somdiary.dto.OAuth2Response;
import com.example.somdiary.dto.UserDTO;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    // DefaultOAuth2UserService OAuth2UserService의 구현체
    // 응답 데이터 받기 위함

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        // 소셜 로그인 종류 조건 필터링
        if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            return null;
        }

        // dto 받아온 것들을 데이터 뽑아서 처리 (아래)

        String userId = oAuth2Response.getProviderId();
        Optional<User> existDataOptional = userRepository.findById(userId);
        String role = "ROLE_USER";

        if (existDataOptional.isPresent()) {
            User existData = existDataOptional.get();
            // User가 존재할 때의 로직
            existData.setUserName(oAuth2Response.getName());

            userRepository.save(existData);

            UserDTO userDTO = new UserDTO();
            userDTO.setId(existData.getId());
            userDTO.setUsername(oAuth2Response.getName());
            userDTO.setRole(existData.getRole());

            return new CustomOAuth2User(userDTO);

        } else {
            // User가 존재하지 않을 때의 로직
            User userEntity = new User();
            userEntity.setId(userId);
            userEntity.setUserName(oAuth2Response.getName());
            userEntity.setRole(role);

            userRepository.save(userEntity);

            UserDTO userDTO = new UserDTO();
            userDTO.setId(userId);
            userDTO.setUsername(oAuth2Response.getName());
            userDTO.setRole(role);

            return new CustomOAuth2User(userDTO);
        }
    }
}