package jpabook.jpashop.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/kakao")
public class KakaoController {
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String REDIRECT_URL = "";

    @GetMapping("/auth")
    public String auth(@RequestParam String code) {
        OauthToken oauthToken = requestAuthCode(generateAuthCodeRequest(code)).getBody();
        return requestProfile(generateProfileRequest(oauthToken)).getBody();
    }

    private ResponseEntity<String> requestProfile(HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                request,
                String.class
        );
    }

    private HttpEntity<MultiValueMap<String, String>> generateProfileRequest(OauthToken oauthToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ oauthToken.getAccess_token());
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        return new HttpEntity<>(headers);
    }

    private ResponseEntity<OauthToken> requestAuthCode(HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                request,
                OauthToken.class
        );
    }

    private HttpEntity<MultiValueMap<String, String>> generateAuthCodeRequest(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return new HttpEntity<>(generateParam(code), headers);
    }

    private MultiValueMap<String, String> generateParam(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id",CLIENT_ID);
        params.add("redirect_uri", REDIRECT_URL);
        params.add("code", code);
        params.add("client_secret", CLIENT_SECRET);
        return params;
    }
}
