/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.studentservice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StudentSoap implements Serializable {

	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setStudentID(model.getStudentID());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setDOB(model.getDOB());
		soapModel.setEmail(model.getEmail());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(
			models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public long getPrimaryKey() {
		return _StudentID;
	}

	public void setPrimaryKey(long pk) {
		setStudentID(pk);
	}

	public long getStudentID() {
		return _StudentID;
	}

	public void setStudentID(long StudentID) {
		_StudentID = StudentID;
	}

	public String getFirstName() {
		return _FirstName;
	}

	public void setFirstName(String FirstName) {
		_FirstName = FirstName;
	}

	public String getLastName() {
		return _LastName;
	}

	public void setLastName(String LastName) {
		_LastName = LastName;
	}

	public Date getDOB() {
		return _DOB;
	}

	public void setDOB(Date DOB) {
		_DOB = DOB;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public Date getCreatedDate() {
		return _CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		_CreatedDate = CreatedDate;
	}

	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	private long _StudentID;
	private String _FirstName;
	private String _LastName;

	private Date _DOB;

	private String _Email;
	private Date _CreatedDate;
	private Date _ModifiedDate;

}