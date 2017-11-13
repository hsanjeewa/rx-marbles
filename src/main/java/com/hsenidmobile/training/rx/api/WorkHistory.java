package com.hsenidmobile.training.rx.api;

import java.util.List;

/**
 * Created by isuru on 11/14/2017.
 */
public class WorkHistory {

    private List<Entry> workHistory;

    public List<Entry> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<Entry> workHistory) {
        this.workHistory = workHistory;
    }

    public static class Entry {
        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
