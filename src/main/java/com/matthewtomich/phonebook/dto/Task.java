package com.matthewtomich.phonebook.dto;

import java.util.Date;

/**
 * Created by matthewtomich on 21/06/2014.
 */
public class Task {
    private final int id;
    private final String name;
    private final String description;
    private final Date startDate;

    public Task(int id, String name, String description, Date startDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }
}
