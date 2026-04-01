package pl.estrix.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import pl.estrix.backend.collector.service.CollectorService;
import pl.estrix.backend.user.service.UserService;
import pl.estrix.common.dto.GetCollectorDetailsDto;
import pl.estrix.common.dto.UserLoginRequest;
import pl.estrix.common.dto.model.ProductImageVersionRevisionDto;
import pl.estrix.common.dto.model.UserDto;
import pl.estrix.common.exception.ReturnParcelRESTException;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CollectorService collectorService;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public DeferredResult<GetCollectorDetailsDto> getSessiom(@RequestParam(value = "number", required = false, defaultValue = "") String number) {
        DeferredResult<GetCollectorDetailsDto> deferredResult = new DeferredResult<>();
        CompletableFuture<GetCollectorDetailsDto> completableFuture = collectorService.saveOrUpdate(number);
        completableFuture.whenComplete((res, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                deferredResult.setErrorResult(ex);
            } else {
                deferredResult.setResult(res);
            }
        });
        return deferredResult;
    }


    @Async
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserDto login(@RequestBody UserLoginRequest request
    ) {
        UserDto userDto = userService.getItem(request.getUsername());
        if (!request.getPin().equals(userDto.getPin())) {
            throw new ReturnParcelRESTException("Invalid username or pin");
        }
        return userDto;
    }

}
