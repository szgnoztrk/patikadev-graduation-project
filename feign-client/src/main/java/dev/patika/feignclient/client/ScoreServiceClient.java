package dev.patika.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "CreditScoreServiceAPI", url = "http://localhost:8081")
public interface ScoreServiceClient {

    @RequestMapping("/api/credit-score")
    ResponseEntity<Map<String, Object>> getCreditScoreBySSID(@RequestParam String ssid);

}
