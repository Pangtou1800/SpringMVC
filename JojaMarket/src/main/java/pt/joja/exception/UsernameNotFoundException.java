package pt.joja.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用户非管理员", value= HttpStatus.FORBIDDEN)
public class UsernameNotFoundException extends RuntimeException {
}
