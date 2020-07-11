package newapi.newapi.services;

import lombok.RequiredArgsConstructor;
import newapi.newapi.models.Test;
import newapi.newapi.models.types.LangType;
import newapi.newapi.repositories.TestRepository;
import newapi.newapi.requests.RawDataRequest;
import newapi.newapi.utils.DataUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final DataUtil dataUtil;

    public List<Test> search(String query) {
        return testRepository.search(dataUtil.keyword(query));
    }

    public Test register(RawDataRequest request) {
        Test test = new Test();
        StringBuilder keyword = new StringBuilder();
        Map<String, String> rawData = request.getRawData().entrySet().stream().collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue()));
        test.setRawData(rawData);
        request.getRawData().forEach((key, value) -> {
            if (key.equals(LangType.ko))
                keyword.append(dataUtil.chosung(value)).append(" ").append(dataUtil.keyword(value));
            else
                keyword.append(" ").append(dataUtil.keyword(value));
        });
        test.setKeyword(keyword.toString());
        return testRepository.saveAndFlush(test);

    }
}
