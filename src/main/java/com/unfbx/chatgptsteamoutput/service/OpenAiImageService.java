package com.unfbx.chatgptsteamoutput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiurui
 * @description
 * @date 2023/3/27
 */
@Slf4j
@Service
public class OpenAiImageService {

    @Value("${chatgpt.apiKey}")
    private String apiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/images/generations";
    @Autowired
    private RestTemplate restTemplate;

    public String generateImages(String prompt, float temperature, int maxTokens, String stop, final int logprobs, final boolean echo,int n) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
// We are including only some of the parameters to the json request
        String requestJson = "{\"prompt\":\"" + prompt + "\",\"n\":" + n + "}";
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, request, String.class);
        log.info("generateImages response is:{}",response.getBody());
        return response.getBody();
    }

}
