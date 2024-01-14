package org.xiaoheshan;


import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Slf4j
public class OpenAIAPI {
    public static String invokeApi(String message) {

        String res = null;
        String content = null;

        // 创建一个HttpClient对象
        try (CloseableHttpClient httpclient = HttpClientBuilder
                .create()
                .disableCookieManagement()
                .build();
        ) {
            // 创建一个HttpPost对象，指定URL
            HttpPost httpPost = getHttpPost(message);

            // 发送请求，获取响应
            CloseableHttpResponse response = httpclient.execute(httpPost);

            res = EntityUtils.toString(response.getEntity(), "UTF-8");
            content = JSONObject.parseObject(res).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
        } catch (IOException e) {
            log.error("invoke api error", e);
        }
        return content;
    }

    private static HttpPost getHttpPost(String message) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost("https://api.xn--7gqr4f.com/v1/chat/completions");

        // 设置请求头
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer sk-nfAyWQrh1rj85KbG9854918e4b3945F4A8D5BeAf2746BfBc");

        // 设置请求体
        String json = STR."""
                {
                  "model": "gpt-3.5-turbo",
                  "messages": [
                    {
                      "role": "user",
                      "content": "\{message}"
                    }
                  ],
                  "temperature": 0.7
                }
                """;
        httpPost.setEntity(new StringEntity(json));
        return httpPost;
    }
}
