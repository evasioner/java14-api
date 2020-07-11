package newapi.newapi.controllers;

import io.swagger.annotations.Api;
import newapi.newapi.models.Members;
import newapi.newapi.requests.SignUpRequest;
import newapi.newapi.response.Response;
import newapi.newapi.services.MembersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@Api(tags = {"2. Member"})
@RestController
public class MembersController extends BaseController {
    final private MembersService membersService;

    MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    public Response<Members> signUp(@RequestBody SignUpRequest request) {
        return response(membersService.signUp(request));
    }

}
