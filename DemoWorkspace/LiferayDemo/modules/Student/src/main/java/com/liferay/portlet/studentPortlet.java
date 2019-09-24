package com.liferay.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.constants.studentPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.studentservice.model.Student;
import com.liferay.studentservice.service.StudentLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.LiferayDemo",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=student",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + studentPortletKeys.STUDENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class studentPortlet extends MVCPortlet {
	
	private static final String MESSAGE_TEMPLATE = 
			"Dear %s,\r\n" + 
			"\r\n" + 
			"Thank you for registration with Liferay.\r\n" + 
			"The details you entered are listed below.\r\n" + 
			"\r\n" + 
			"Student ID: %s\r\n" + 
			"First Name: %s\r\n" + 
			"Last Name:  %s\r\n" + 
			"Date of Birth: %s\r\n" + 
			"Email: %s\r\n" + 
			"\r\n" + 
			"Cheers,\r\n" + 
			"Liferay Admin";
	private static final Log _log = LogFactoryUtil.getLog(studentPortlet.class);
	private static final String FROM_MAIL = "Admin@Liferay.com";
	private static final String MESSAGE_SUBJECT = "Student Registration Confirmation";
	private static final String HOME_URL = "http://innovate:8080";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
		renderResponse.setTitle("Student Registration Portal");
		super.doView(renderRequest, renderResponse);
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name="studentSubmit")
	public void studentSubmit(ActionRequest request, ActionResponse response) 
				throws IOException, PortletException {
		
	  try{
	      CaptchaUtil.check(request);
	  }
	  catch(Exception e){
        if (e instanceof CaptchaTextException || e instanceof CaptchaMaxChallengesException ){
        	System.out.println(e);
			_log.error(e, e);
			SessionErrors.add(request, e.getClass().getName());             
        }else{
              System.out.println("Captcha verification success::");
        }	           
	  }
  
	  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	  //Get the data from the form fields
	  String firstName = ParamUtil.getString(request, "firstname");
	  String lastName = ParamUtil.getString(request, "lastname");
	  Date   dob = ParamUtil.getDate(request, "dob", df);
	  String email = ParamUtil.getString(request, "email");
 
	  //Send the data to the database via the Service function provided by Liferay 
	  //The Student ID is auto-generated with the help the CountLocalServiceUtil provided by Liferay
	  try {
		  Student student = StudentLocalServiceUtil.createStudent(CounterLocalServiceUtil.increment());
	  
		  student.setFirstName(firstName);
		  student.setLastName(lastName);
		  student.setDOB(dob);
		  student.setEmail(email);
		  student.setCreatedDate(new Date());
		  student.setModifiedDate(new Date());
		  
		  //Add the student to the database
		  Student studentResp = StudentLocalServiceUtil.addStudent(student);
		  
		  //Send the mail...
		  String messageBody = String.format(MESSAGE_TEMPLATE, 
				  						studentResp.getFirstName(),
				  						String.valueOf(studentResp.getStudentID()),
				  						studentResp.getFirstName(),
				  						studentResp.getLastName(),
				  						df.format(studentResp.getDOB()),
				  						studentResp.getEmail());
		  
		   MailUtil.SendMail(FROM_MAIL, studentResp.getEmail(), MESSAGE_SUBJECT, messageBody);
		   response.sendRedirect(HOME_URL);
		   //response.setRenderParameter("mvcpath", "/confirmation.jsp");
	  }
	  catch(Exception e) {
		  System.out.println(e);
		  _log.error(e, e);
		  SessionErrors.add(request, e.getClass().getName());
	  }
	} 	
}