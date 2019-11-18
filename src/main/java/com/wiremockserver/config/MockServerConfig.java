package com.wiremockserver.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MockServerConfig {

    private static Logger logger = LoggerFactory.getLogger(MockServerConfig.class);

    @Value("${wireMock.address}")
    private String wireMockAddress;

    @Value("${wireMock.port}")
    private String wireMockPort;

    @Value("${wireMock.files.path}")
    private String wireMockFilesPath;


    @Bean
    public WireMockServer wireMockServer(){
        //创建wiremock对象
        FileSource filesRoot = new SingleRootFileSource(wireMockFilesPath);
        logger.info("wireMockFilesPath ====={}",wireMockFilesPath);
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options()
                .bindAddress(wireMockAddress).port(Integer.parseInt(wireMockPort)).fileSource(filesRoot));
        wireMockServer.start();
        return wireMockServer;
    }
}
