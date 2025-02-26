package net.springbootapp.banking.Exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp ,
		                        String message,
		                        String details,
		                        String errorCode) {

}
