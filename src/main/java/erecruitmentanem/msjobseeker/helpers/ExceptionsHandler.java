package erecruitmentanem.msjobseeker.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionsHandler {
    @Autowired
    ResponseHandler responseHandler;

    ResponseEntity<Object> notAuthorizedExceptions(){
        return responseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST ,
             "NotAuthorizedExceptions", 
             "message"
             );
    }

    ResponseEntity<Object> notAuthenticatedException(){
        return responseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "NotAuthenticatedException", 
            "message"
            );

    }

    ResponseEntity<Object> itemNotFoundException(){
        return responseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "ItemNotFoundException", 
            "message"
            );

    }

    ResponseEntity<Object> badRequestException(){
        return responseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "BadRequestException", 
            "message"
            );

    }
    
}
