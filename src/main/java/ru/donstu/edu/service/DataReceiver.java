package ru.donstu.edu.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource("classpath:url.properties")
public class DataReceiver {

    @Value("${groups}")
    private String groups;

    public JsonNode getGroups() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(groups);
        return mapper.readTree(url);
    }
}
