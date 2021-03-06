package org.openmrs.module.msfcore.web.controller;

import java.util.List;

import org.openmrs.Obs;
import org.openmrs.module.msfcore.result.ResultRow;
import org.openmrs.module.msfcore.result.ResultsData;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + MSFCoreRestController.NAMESPACE + "/resultRow", supportedClass = ResultRow.class, supportedOpenmrsVersions = {"2.2.*"})
public class ResultRowResource extends BaseDataResource {

    /**
     * Disguising a result update as a create request
     */
    @Override
    public Object create(SimpleObject propertiesToCreate, RequestContext context) throws ResponseException {
        SimpleObject response = new SimpleObject();
        List<Obs> obs = ResultsData.updateResultRow(propertiesToCreate);
        response.add("uuid", obs.get(0).getUuid());
        return response;
    }
}
