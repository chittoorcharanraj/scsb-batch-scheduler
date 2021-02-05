package org.recap.batch.service;

import org.recap.RecapConstants;
import org.recap.model.jpa.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class StatusReconciliationService {

    @Autowired
    private CommonService commonService;

    
    public String statusReconcilation(String scsbCircUrl) {
        HttpHeaders headers = commonService.getHttpHeaders();
        HttpEntity<JobEntity> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = commonService.getRestTemplate().exchange(scsbCircUrl + RecapConstants.STATUS_RECOCILATION_URL, HttpMethod.GET, httpEntity, String.class);
        return responseEntity.getBody();
    }

}