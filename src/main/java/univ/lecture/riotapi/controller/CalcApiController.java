package univ.lecture.riotapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import univ.lecture.riotapi.calc.CalcApp;
import univ.lecture.riotapi.model.CalcRequest;
import univ.lecture.riotapi.model.CalcResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by corona10 on 2017. 4. 10..
 */

@RestController
@RequestMapping("/api/v1")
@Log4j
public class CalcApiController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${calc.api.endpoint}")
    private String calcEndpoint;

    @Value("${group_no}")
    private int groupNo;

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public CalcResponse queryCalc(@RequestBody String body) throws UnsupportedEncodingException {
        final String url = calcEndpoint;
        CalcApp calcApp = new CalcApp();
        body = URLDecoder.decode(body,"UTF-8");
        body = body.substring(0,body.length()-1);
        String[] infix = body.split(" ");
        double result = calcApp.calc(infix);
        long timestamp = System.currentTimeMillis();
        CalcRequest request = new CalcRequest(groupNo, timestamp, result);
        log.info(request);
        CalcResponse response = restTemplate.postForObject(url, request, CalcResponse.class);
        return response;
    }
}
