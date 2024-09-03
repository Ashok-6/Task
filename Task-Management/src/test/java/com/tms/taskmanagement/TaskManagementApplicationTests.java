package com.tms.taskmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tms.taskmanagement.dto.TaskDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskManagementApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/task/";
    }

    @Test
    void testGetTaskByTid() {
        ResponseEntity<TaskDTO> response = restTemplate.getForEntity(getBaseUrl().concat("gettask/{tid}"), TaskDTO.class, 1L);
        assertNotNull(response.getBody());
        assertEquals("crete user microservice", response.getBody().getTaskName());
    }

    @Test
    void testGetAllTasksByProjectId() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getalltasksbypid/{pid}"), List.class, 1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

   /* @Test
    void testGetAllTask() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getalltask"), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }


    @Test
    void testUpdateTaskStatus() {
        restTemplate.put(getBaseUrl().concat("updatetstatus/{uid}/{pid}/{taskid}/{tstatus}"), 20L, 1L, 3L, "completed");

        TaskDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("gettask/{tid}"), TaskDTO.class, 2L).getBody();
        assertEquals("completed", getResponse.getTaskStatus());
    }
*/

}
