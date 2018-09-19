package com.edgardeng.sbfirst.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectProperties {
    @Value("${project.author}")
    private String author;

    public String getAuthor() {
        return author;
    }

}
