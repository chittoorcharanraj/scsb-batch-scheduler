package org.recap.batch.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbCommonConstants;
import org.recap.ScsbConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.Silent.class)
@PrepareForTest
public class IdentifyPendingRequestServiceUT {

    @Mock
    CommonService commonService;

    @Value("${" + PropertyKeyConstants.SCSB_CIRC_URL + "}")
    protected String scsbCircUrl;

    @Mock
    IdentifyPendingRequestService mockidentifyPendingRequestService;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testidentifyPendingRequestService() throws Exception {
        ReflectionTestUtils.setField(mockidentifyPendingRequestService,"commonService",commonService);
       Mockito.when(commonService.pendingRequest(scsbCircUrl, ScsbConstants.CHECK_PENDING_REQUEST_IN_DB)).thenReturn(ScsbConstants.SUCCESS);
        Mockito.when(mockidentifyPendingRequestService.identifyPendingRequestService(scsbCircUrl)).thenCallRealMethod();
        String status=mockidentifyPendingRequestService.identifyPendingRequestService(scsbCircUrl);
        assertNotNull(status);
    }

}
