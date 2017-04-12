package univ.lecture.riotapi.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import univ.lecture.riotapi.calc.CalcApp;
import univ.lecture.riotapi.calc.Utility;
import univ.lecture.riotapi.model.CalcRequest;
import univ.lecture.riotapi.model.CalcResponse;
import univ.lecture.riotapi.model.EndPointResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
        String query = URLDecoder.decode(body, "UTF-8");
        query = Utility.deleteUrlLastEqual(query);
        String[] infix = query.trim().split(" +");
        double result = calcApp.calc(infix);
        long timestamp = System.currentTimeMillis();
        CalcRequest request = new CalcRequest(groupNo, timestamp, result);
        log.info("Destination IP: " + calcEndpoint);
        log.info(request);

        EndPointResponse response = restTemplate.postForObject(url, request, EndPointResponse.class);
        log.info(response);
        String msg = response.getMsg();
        return new CalcResponse(groupNo, timestamp, result, msg);
    }


}
