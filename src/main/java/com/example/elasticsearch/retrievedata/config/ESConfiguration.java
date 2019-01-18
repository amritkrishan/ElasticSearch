package com.example.elasticsearch.retrievedata.config;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch.retrievedata.repository")
public class ESConfiguration {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/6.5.4}")
    private String elasticsearchHome;

    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;

    @Bean
    public Client client() {
        Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName).build();
        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
        try {
            client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }


}

