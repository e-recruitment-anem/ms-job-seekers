package erecruitmentanem.msjobseeker.helpers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ExceptionsHandler {

    public static ResponseEntity<Object> notAuthorizedExceptions(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST ,
             "NotAuthorizedExceptions", 
             "message"
             );
    }

    public static ResponseEntity<Object> notAuthenticatedException(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "NotAuthenticatedException", 
            "message"
            );

    }

    public static ResponseEntity<Object> itemNotFoundException(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "ItemNotFoundException", 
            "message"
            );
    }

    public static ResponseEntity<Object> badRequestException(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "BadRequestException", 
            "message"
            );

    }
    
}
