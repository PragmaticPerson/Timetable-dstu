package ru.donstu.edu.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import ru.donstu.edu.dao.GroupJpaRepository;
import ru.donstu.edu.models.Group;

@Service
public class UpdateDatabaseService {

    private DataReceiver receiver;
    private GroupJpaRepository groupRepository;

    @Autowired
    public UpdateDatabaseService(DataReceiver receiver, GroupJpaRepository groupRepository) {
        super();
        this.receiver = receiver;
        this.groupRepository = groupRepository;
    }

    public void updateGroups() throws IOException {
        JsonNode node = receiver.getGroups();

        node = node.get("data").get("groups");

        node.forEach(smth -> {            
            String name = smth.get("groupName").textValue().trim();
            int id = smth.get("groupID").asInt();

            groupRepository.save(new Group(id, name));
        });
    }
}
