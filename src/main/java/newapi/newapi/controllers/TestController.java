package newapi.newapi.controllers;

import newapi.newapi.models.Test;
import newapi.newapi.requests.RawDataRequest;
import newapi.newapi.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tests")
@RestController
public class TestController {
    final private TestService testService;

    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("")
    public List<Test> search(@RequestParam String query) {
        System.out.println("12313");
        return testService.search(query);
    }

    @PostMapping("")
    public Test register(@RequestBody RawDataRequest request) {
        return testService.register(request);
    }
}
