package com.unfbx.chatgptsteamoutput.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiurui
 * @description
 * @date 2023/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerateImagesRequest implements Serializable {
    private static final long serialVersionUID = -8664093735109900477L;
    private String prompt;
    private float temperature;
    private int maxTokens;
    private String stop;
    private int logprobs;
    private boolean echo;
    private int n;
}
