package com.example.demo.api;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {
  @RequestMapping("/test")
  public String test(){
    return "test";
  }

  @PostMapping(value = "/done")
  private String getUri(HttpEntity<byte[]>  requestEntity) {


    String url = "https://2129598a-07ca-4798-bce1-2421d1169d3a.mock.pstmn.io/digital-banking/v1/real-time-onboarding/evaluate-operation";
    RestTemplate restTemplate = new RestTemplate();
   /* Aqui simule hardcodeando los headers y el body, pero con un httpentity,
   tambien hubiera sido posible con Http Entity como esta ahora

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    Map<String, Object> map = new HashMap<>();
    map.put("alertCode", "310");
    map.put("date", "20240619");
    map.put("time", "143019");
    map.put("sessionId", "0a125843b3d6b634260b4c4d5cf31d9b8f674e4c81b4a1efaa4d59960487a762");

    Map<String, Object>  customer = new HashMap<>();
    customer.put("id", "0060916815");

    Map<String, Object>  identityDocument = new HashMap<>();
    identityDocument.put("id", "70199482");
    identityDocument.put("type", "1");

    customer.put("identityDocument", identityDocument);
    customer.put("personType", "N");

    map.put("customer", customer);
    map.put("amountOriginal", 8000.0);

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);*/

    // Aca me alto poner la clase JSON para no complicarme puse string para poder verlo rapidamente
    ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println("Request Successful");
      System.out.println(response.getBody());

    } else {
      System.out.println("Request Failed");
      System.out.println(response.getStatusCode());
    }
    return response.getBody();
  }

}
