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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
@ProviderType
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements Student, ModelWrapper<Student> {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("StudentID", getStudentID());
		attributes.put("FirstName", getFirstName());
		attributes.put("LastName", getLastName());
		attributes.put("DOB", getDOB());
		attributes.put("Email", getEmail());
		attributes.put("CreatedDate", getCreatedDate());
		attributes.put("ModifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long StudentID = (Long)attributes.get("StudentID");

		if (StudentID != null) {
			setStudentID(StudentID);
		}

		String FirstName = (String)attributes.get("FirstName");

		if (FirstName != null) {
			setFirstName(FirstName);
		}

		String LastName = (String)attributes.get("LastName");

		if (LastName != null) {
			setLastName(LastName);
		}

		Date DOB = (Date)attributes.get("DOB");

		if (DOB != null) {
			setDOB(DOB);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		Date CreatedDate = (Date)attributes.get("CreatedDate");

		if (CreatedDate != null) {
			setCreatedDate(CreatedDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}
	}

	/**
	 * Returns the created date of this student.
	 *
	 * @return the created date of this student
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the dob of this student.
	 *
	 * @return the dob of this student
	 */
	@Override
	public Date getDOB() {
		return model.getDOB();
	}

	/**
	 * Returns the email of this student.
	 *
	 * @return the email of this student
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this student.
	 *
	 * @return the first name of this student
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this student.
	 *
	 * @return the last name of this student
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	@Override
	public long getStudentID() {
		return model.getStudentID();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created date of this student.
	 *
	 * @param CreatedDate the created date of this student
	 */
	@Override
	public void setCreatedDate(Date CreatedDate) {
		model.setCreatedDate(CreatedDate);
	}

	/**
	 * Sets the dob of this student.
	 *
	 * @param DOB the dob of this student
	 */
	@Override
	public void setDOB(Date DOB) {
		model.setDOB(DOB);
	}

	/**
	 * Sets the email of this student.
	 *
	 * @param Email the email of this student
	 */
	@Override
	public void setEmail(String Email) {
		model.setEmail(Email);
	}

	/**
	 * Sets the first name of this student.
	 *
	 * @param FirstName the first name of this student
	 */
	@Override
	public void setFirstName(String FirstName) {
		model.setFirstName(FirstName);
	}

	/**
	 * Sets the last name of this student.
	 *
	 * @param LastName the last name of this student
	 */
	@Override
	public void setLastName(String LastName) {
		model.setLastName(LastName);
	}

	/**
	 * Sets the modified date of this student.
	 *
	 * @param ModifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date ModifiedDate) {
		model.setModifiedDate(ModifiedDate);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the student ID of this student.
	 *
	 * @param StudentID the student ID of this student
	 */
	@Override
	public void setStudentID(long StudentID) {
		model.setStudentID(StudentID);
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}