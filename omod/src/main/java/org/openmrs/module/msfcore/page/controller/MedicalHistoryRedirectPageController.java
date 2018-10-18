package org.openmrs.module.msfcore.page.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.module.msfcore.fragment.controller.LeftMenuFragmentController;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class MedicalHistoryRedirectPageController {
    public void controller(PageModel model, @RequestParam(value = "patientId", required = true) String patientId,
                    @RequestParam(value = "formUuid", required = true) String formUuid,
                    @RequestParam(value = "visitId", required = false) String visitId, HttpServletRequest request,
                    HttpServletResponse response) throws IOException {

        LeftMenuFragmentController controller = new LeftMenuFragmentController();
        controller.initializeLinks(patientId, null);
        response.sendRedirect("/openmrs/htmlformentryui/htmlform/" + controller.medicalHistoryLink);
    }
}