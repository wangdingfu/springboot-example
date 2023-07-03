package com.fuge.example.http;

import cn.hutool.http.HttpGlobalConfig;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wangdingfu
 * @date 2023-06-27 10:51:19
 */
@Slf4j
public class HttpRedirectTest {

    private static final List<HttpCookie> httpCookieList = new ArrayList<>();

    private static final String user_json = "{\n" +
            "    \"username\": \"admin\",\n" +
            "    \"password\": \"QAZwsx741=-\",\n" +
            "    \"execution\": \"+rlnwViFTe7gI/J88b1C1wXSsVvWZFQ81x9g0nc1B/wopkObU2doiDFh+MsliqrC\",\n" +
            "    \"remember_me\": 0\n" +
            "}";

    public static void main(String[] args) {
        HttpGlobalConfig.setMaxRedirectCount(1);
        //登录
        String redirectUrl = login();

        //调用重定向接口
        callback(redirectUrl);

        //获取token
        Optional<HttpCookie> jAuthToken = httpCookieList.stream().filter(f -> f.getName().equals("j_authToken")).findFirst();
        jAuthToken.ifPresent(httpCookie -> log.info("token:{}", httpCookie.getValue()));
    }


    private static String login() {
        HttpRequest httpRequest = HttpUtil.createPost("http://oacenter.live.dz11.com/login?response_type=code&client_id=118&redirect_uri=http%3A%2F%2Fcwsharing.live.dz11.com%3A80%2F__callback%3Fparam%3DY2FsbGJhY2s9aHR0cCUzQSUyRiUyRmN3c2hhcmluZy5saXZlLmR6MTEuY29tJTNBODAlMkYmc3JjX2lwPTE3Mi4xOS43Mi42MiZzcmNfaG9zdD1jd3NoYXJpbmcubGl2ZS5kejExLmNvbSZyZXF1ZXN0X3VyaT0lMkY%3D");
        httpRequest.cookie(httpCookieList);
        httpRequest.body(user_json);
        httpRequest.header("Referer","http://oacenter.live.dz11.com/login.html?response_type=code&client_id=118&redirect_uri=http%3A%2F%2Fcwsharing.live.dz11.com%3A80%2F__callback%3Fparam%3DY2FsbGJhY2s9aHR0cCUzQSUyRiUyRmN3c2hhcmluZy5saXZlLmR6MTEuY29tJTNBODAlMkYmc3JjX2lwPTE3Mi4xOS43Mi42MiZzcmNfaG9zdD1jd3NoYXJpbmcubGl2ZS5kejExLmNvbSZyZXF1ZXN0X3VyaT0lMkY%3D");
        HttpResponse httpResponse = httpRequest.execute();
        List<HttpCookie> cookies = httpResponse.getCookies();
        if (CollectionUtils.isNotEmpty(cookies)) {
            cookies.forEach(f -> log.info("cookie:name:{}. value:{}", f.getName(), f.getValue()));
            httpCookieList.addAll(cookies);
        }
        return JSONUtil.parse(httpResponse.body()).getByPath("data.redirect_url").toString();
    }


    private static void callback(String redirectUrl) {
        HttpRequest httpRequest = HttpUtil.createGet("http://oacenter.live.dz11.com" + redirectUrl);
        httpRequest.setMaxRedirectCount(1);
        httpRequest.cookie(httpCookieList);
        HttpResponse httpResponse = httpRequest.execute();
        List<HttpCookie> cookies = httpResponse.getCookies();
        if (CollectionUtils.isNotEmpty(cookies)) {
            cookies.forEach(f -> log.info("cookie:name:{}. value:{}", f.getName(), f.getValue()));
        }
    }


}
