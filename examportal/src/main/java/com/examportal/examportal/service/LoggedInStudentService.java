// com.examportal.examportal.service.LoggedInStudentService
package com.examportal.examportal.service;

import org.springframework.stereotype.Service;

@Service
public class LoggedInStudentService {

    private String loggedInEmail;

    public String getLoggedInEmail() {
        return loggedInEmail;
    }

    public void setLoggedInEmail(String email) {
        this.loggedInEmail = email;
    }
}
