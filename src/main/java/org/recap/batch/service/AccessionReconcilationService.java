package org.recap.batch.service;

import org.recap.RecapConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * Created by akulak on 19/5/17.
 */
@Service
public class AccessionReconcilationService {

    @Autowired
    protected CommonService commonService;

    /**
     * This method makes a rest call to scsb circ microservice to initiate the accession reconciliation process.
     *
     * @param scsbCircUrl    the scsb circ url
     * @return status of the accession reconciliation process
     */
    public String accessionReconcilation(String scsbCircUrl) {
        return commonService.executeService(scsbCircUrl,  RecapConstants.ACCESSION_RECOCILATION_URL, HttpMethod.POST);
    }
}