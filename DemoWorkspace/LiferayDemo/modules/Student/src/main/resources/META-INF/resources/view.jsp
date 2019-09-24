<%@ include file="/init.jsp" %>
<%@taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@page import="com.liferay.portal.kernel.captcha.Captcha"%>

<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>

<portlet:actionURL name="studentSubmit" var="studentSubmit" />
<portlet:resourceURL id="/captcha" var="captchaURL" />

<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />

<aui:form name="studentRegistrationForm" action="${studentSubmit}">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Personal Information">
			<aui:row>
				<aui:col width="50">
					<aui:input label="First Name" name="firstname" type="text">
						<aui:validator name="required" />
					</aui:input>
				</aui:col>
				<aui:col width="50">
					<aui:input label="Last Name" name="lastname" type="text">
						<aui:validator name="required" />
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="Date of Bith" name="dob" type="date">
						<aui:validator name="required" />	
						<aui:validator errorMessage="Student must be over 18 years to register" name="custom">
				                function(val){
				                	var today = new Date();
								    var birthDate = new Date(val);
								    var age = today.getFullYear() - birthDate.getFullYear();
								    var m = today.getMonth() - birthDate.getMonth();
								    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
								        age--;
								    }    
								    if (age < 18)
								    	return false;
								    return true; 
				                }
				        </aui:validator>					
					</aui:input>
				</aui:col>
				<aui:col width="50">
					<aui:input label="Email" name="email" type="email">
						<aui:validator name="required" />
						<aui:validator errorMessage="Email should be in the following format - x@example.com" name="custom">
				                function(val, fieldNode, ruleValue) {
			                		var re = /\S+@\S+\.\S+/;
			                        var regex = new RegExp(re);
			
			                        return regex.test(val);
				                }
				        </aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
			   <aui:col width="50">	
			      <liferay-captcha:captcha url="<%= captchaURL %>" />
			   </aui:col> 			   
			</aui:row>
			
		</aui:fieldset>
	</aui:fieldset-group>
	
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>
<aui:script>
    $('#<portlet:namespace />refreshCaptcha').on("click",
            function(ev){
                $("#captchaImg").attr('src', '${captchaURL}&force=' + encodeURIComponent(Math.floor(Math.random() * Math.pow(2, 53))));
            });
</aui:script>
