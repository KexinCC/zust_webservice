package org.xiaoheshan.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.xiaoheshan.BootStrap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class Message {

    private static final BootStrap bootStrap = BootStrap.getInstance();

    public static String message() {
        // 创建一个HttpClient对象
        try (CloseableHttpClient httpclient = HttpClientBuilder
                .create()
                .disableCookieManagement()
                .build();
        ) {

            // 创建一个HttpPost对象，指定URL
            HttpPost httpPost = new HttpPost("https://api.xn--7gqr4f.com/v1/chat/completions");

            // 设置请求头
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer sk-nfAyWQrh1rj85KbG9854918e4b3945F4A8D5BeAf2746BfBc");
            httpPost.setHeader("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3");

            // 创建一个消息列表
            List<Map<String, String>> messages = new ArrayList<>();

            // 添加一个"system"消息
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "You are a helpful assistant.");
            messages.add(systemMessage);

            // 添加一个"user"消息
            Map<String, String> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", "Who won the world series in 2016?");
            messages.add(userMessage);

            // 创建请求体
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", messages);

            // 将请求体转换为JSON字符串
            String json = JSONObject.toJSONString(requestBody);

            // 设置请求体
            httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

            // 发送请求，获取响应
            CloseableHttpResponse response = httpclient.execute(httpPost);

            // 打印响应内容
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String message = message();
        JSONObject jsonObject = JSON.parseObject(message);
        System.out.println(jsonObject.get("id"));
        System.out.println(message);
    }
}

