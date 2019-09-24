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

package com.liferay.studentservice.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.studentservice.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)obj;

		if (StudentID == studentCacheModel.StudentID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, StudentID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{StudentID=");
		sb.append(StudentID);
		sb.append(", FirstName=");
		sb.append(FirstName);
		sb.append(", LastName=");
		sb.append(LastName);
		sb.append(", DOB=");
		sb.append(DOB);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", CreatedDate=");
		sb.append(CreatedDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentID(StudentID);

		if (FirstName == null) {
			studentImpl.setFirstName("");
		}
		else {
			studentImpl.setFirstName(FirstName);
		}

		if (LastName == null) {
			studentImpl.setLastName("");
		}
		else {
			studentImpl.setLastName(LastName);
		}

		if (DOB == Long.MIN_VALUE) {
			studentImpl.setDOB(null);
		}
		else {
			studentImpl.setDOB(new Date(DOB));
		}

		if (Email == null) {
			studentImpl.setEmail("");
		}
		else {
			studentImpl.setEmail(Email);
		}

		if (CreatedDate == Long.MIN_VALUE) {
			studentImpl.setCreatedDate(null);
		}
		else {
			studentImpl.setCreatedDate(new Date(CreatedDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(ModifiedDate));
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		StudentID = objectInput.readLong();
		FirstName = objectInput.readUTF();
		LastName = objectInput.readUTF();
		DOB = objectInput.readLong();
		Email = objectInput.readUTF();
		CreatedDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(StudentID);

		if (FirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FirstName);
		}

		if (LastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LastName);
		}

		objectOutput.writeLong(DOB);

		if (Email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Email);
		}

		objectOutput.writeLong(CreatedDate);
		objectOutput.writeLong(ModifiedDate);
	}

	public long StudentID;
	public String FirstName;
	public String LastName;

	public long DOB;

	public String Email;
	public long CreatedDate;
	public long ModifiedDate;

}