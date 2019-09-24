package com.liferay.portlet;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import com.liferay.constants.studentPortletKeys;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;


@Component(property = { "javax.portlet.name=" + studentPortletKeys.STUDENT,
						"mvc.command.name=/captcha" }, service = MVCResourceCommand.class)
public class CaptchaMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(CaptchaMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			return false;
		} 
		catch (Exception e) {
			System.out.println(e);
			_log.error(e, e);
			SessionErrors.add(resourceRequest, e.getClass().getName());
			
			return true;
		}
	}
}