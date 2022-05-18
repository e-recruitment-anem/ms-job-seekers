package erecruitmentanem.msjobseeker.helpers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ExceptionsHandler {

    public ResponseEntity<Object> notAuthorizedExceptions(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST ,
             "NotAuthorizedExceptions", 
             "message"
             );
    }

    public ResponseEntity<Object> notAuthenticatedException(){
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

    public ResponseEntity<Object> badRequestException(){
        return ResponseHandler.generateErrorResponse(
            HttpStatus.BAD_REQUEST , 
            "BadRequestException", 
            "message"
            );

    }
    
}
