package newapi.newapi.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import newapi.newapi.models.Members;
import newapi.newapi.requests.SignUpRequest;
import newapi.newapi.response.Response;
import newapi.newapi.services.MembersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@Api(tags = {"2. Member"})
@RestController
@RequiredArgsConstructor
public class MembersController extends BaseController {
    final private MembersService membersService;

    @PostMapping("")
    public Response<Members> signUp(@RequestBody SignUpRequest request) {
        return response(membersService.signUp(request));
    }
}
