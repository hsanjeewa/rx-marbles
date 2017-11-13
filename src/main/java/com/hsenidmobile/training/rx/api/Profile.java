package com.hsenidmobile.training.rx.api;

/**
 * Created by isuru on 11/14/2017.
 */
public class Profile {
    private PlatformProficiency platformProficiency;
    private WorkHistory workHistory;

    public PlatformProficiency getPlatformProficiency() {
        return platformProficiency;
    }

    public void setPlatformProficiency(PlatformProficiency platformProficiency) {
        this.platformProficiency = platformProficiency;
    }

    public WorkHistory getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(WorkHistory workHistory) {
        this.workHistory = workHistory;
    }
}
