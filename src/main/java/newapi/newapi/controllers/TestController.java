package newapi.newapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import newapi.newapi.models.Test;
import newapi.newapi.requests.RawDataRequest;
import newapi.newapi.response.Response;
import newapi.newapi.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tests")
@Api(tags = {"1. Tests"})
@RestController
@RequiredArgsConstructor
public class TestController extends BaseController {
    final private TestService testService;
    
    @ApiOperation(value = "키워드 조회", notes = "입력한 키워드의 데이터를 조회")
    @GetMapping("")
    public Response<List<Test>> search(@RequestParam String query) {
        return response(testService.search(query));
    }

    @PostMapping("")
    public Response<Test> register(@RequestBody RawDataRequest request) {
        return response(testService.register(request));
    }
}
