package com.dickli.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfiguration extends AbstractElasticsearchConfiguration {
    @Value("${es.hostname}")
    private String esHostName;
    @Value("${es.port}")
    private int esPort;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esHostName + ":" + esPort)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
