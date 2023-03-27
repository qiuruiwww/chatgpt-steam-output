package com.unfbx.chatgptsteamoutput.controller;

import com.unfbx.chatgptsteamoutput.entity.GenerateImagesRequest;
import com.unfbx.chatgptsteamoutput.service.OpenAiImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiurui
 * @description
 * @date 2023/3/27
 */
@Slf4j
@RestController
public class ChatImageController {
    @Autowired
    private OpenAiImageService openAiImageService;

    @PostMapping("/generateImages")
    public String generateImages(@RequestBody GenerateImagesRequest request) {
        return openAiImageService.generateImages(request.getPrompt(), request.getTemperature(), request.getMaxTokens(), request.getStop(),
                request.getLogprobs(), request.isEcho(), request.getN());
    }
}
