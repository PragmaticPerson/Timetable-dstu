package ru.donstu.edu.service;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.donstu.edu.models.Group;

@Service
@PropertySource("classpath:url.properties")
public class DataReceiver {

    @Value("${groups}")
    private String groups;

    @Value("${rasp}")
    private String rasp;

    public JsonNode getGroups() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(groups);
        return mapper.readTree(url);
    }

    public JsonNode getTimetable(Group group, LocalDate date) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(String.format(rasp, group.getId(), date));
        return mapper.readTree(url);
    }
}
