package ru.practicum.explore.clients.stat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.explore.clients.base.BaseClient;
import ru.practicum.explore.dto.client.EndpointHit;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StatClient extends BaseClient {

    @Autowired
    public StatClient(@Value("${stat-service.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    /*
    Метод передачи в stat-service endpoint для сохранения.
    */
    public ResponseEntity<Object> save(EndpointHit endpointHit) {

        return post("/hit", endpointHit);
    }

    /*
    Метод метод получения статистики.
    */
    public ResponseEntity<Object> getStats(String start, String end,
                                           List<String> uris, Boolean unique) {
        Map<String, Object> parameters = Map.of("start", start,
                "end", end,
                "uris", uris,
                "unique", unique);
        return get("/stats?start={start}&end={end}&uris={uris}&unique={unique}", parameters);
    }
}
