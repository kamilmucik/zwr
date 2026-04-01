package pl.estrix.frontend.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.estrix.backend.user.service.UserService;
import pl.estrix.common.dto.model.UserDto;

@Component
@Scope("session")
public class MySessionInfo {



    @Autowired
    private UserService userService;

    private UserDto user;



    public UserDto getCurrentUser() {

        if (user == null) {
            user = userService.getItem(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return user;
    }
}
