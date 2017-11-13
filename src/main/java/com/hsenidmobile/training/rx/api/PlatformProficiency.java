package com.hsenidmobile.training.rx.api;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by isuru on 11/14/2017.
 */
public class PlatformProficiency {

    private List<Entry> platformProficiencies;

    public List<Entry> getPlatformProficiencies() {
        return platformProficiencies;
    }

    public void setPlatformProficiencies(List<Entry> platformProficiencies) {
        this.platformProficiencies = platformProficiencies;
    }

    public static class Entry {
        private String name;
        private BigDecimal rating;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getRating() {
            return rating;
        }

        public void setRating(BigDecimal rating) {
            this.rating = rating;
        }
    }
}
