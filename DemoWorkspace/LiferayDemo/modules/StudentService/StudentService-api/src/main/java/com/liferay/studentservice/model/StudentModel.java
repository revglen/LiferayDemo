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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Student service. Represents a row in the &quot;Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.studentservice.model.impl.StudentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.studentservice.model.impl.StudentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
@ProviderType
public interface StudentModel extends BaseModel<Student> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a student model instance should use the {@link Student} interface instead.
	 */

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	public long getStudentID();

	/**
	 * Sets the student ID of this student.
	 *
	 * @param StudentID the student ID of this student
	 */
	public void setStudentID(long StudentID);

	/**
	 * Returns the first name of this student.
	 *
	 * @return the first name of this student
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this student.
	 *
	 * @param FirstName the first name of this student
	 */
	public void setFirstName(String FirstName);

	/**
	 * Returns the last name of this student.
	 *
	 * @return the last name of this student
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this student.
	 *
	 * @param LastName the last name of this student
	 */
	public void setLastName(String LastName);

	/**
	 * Returns the dob of this student.
	 *
	 * @return the dob of this student
	 */
	public Date getDOB();

	/**
	 * Sets the dob of this student.
	 *
	 * @param DOB the dob of this student
	 */
	public void setDOB(Date DOB);

	/**
	 * Returns the email of this student.
	 *
	 * @return the email of this student
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this student.
	 *
	 * @param Email the email of this student
	 */
	public void setEmail(String Email);

	/**
	 * Returns the created date of this student.
	 *
	 * @return the created date of this student
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this student.
	 *
	 * @param CreatedDate the created date of this student
	 */
	public void setCreatedDate(Date CreatedDate);

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this student.
	 *
	 * @param ModifiedDate the modified date of this student
	 */
	public void setModifiedDate(Date ModifiedDate);

}