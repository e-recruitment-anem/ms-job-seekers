package erecruitmentanem.msjobseeker.services;

import org.springframework.beans.factory.annotation.Autowired;

import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;

public class JobSeekersService {
    @Autowired
    JobSeekersRepository jobSeekersRepository;

    @Autowired
    ResponseHandler responseHandler;

    @Autowired
    ExceptionsHandler exceptionsHandler;

    
}
