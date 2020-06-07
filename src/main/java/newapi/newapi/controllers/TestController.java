package newapi.newapi.controllers;

import newapi.newapi.models.Test;
import newapi.newapi.requests.RawDataRequest;
import newapi.newapi.response.Response;
import newapi.newapi.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tests")
@RestController
public class TestController extends BaseController {
    final private TestService testService;

    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("")
    public Response<List<Test>> search(@RequestParam String query) {
        System.out.println("12313");
        return response(testService.search(query));
    }

    @PostMapping("")
    public Response<Test> register(@RequestBody RawDataRequest request) {
        return response(testService.register(request));
    }
}
