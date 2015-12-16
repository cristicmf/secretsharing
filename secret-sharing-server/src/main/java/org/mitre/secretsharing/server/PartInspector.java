/*

Copyright 2014 The MITRE Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

This project contains content developed by The MITRE Corporation. If this 
code is used in a deployment or embedded within another project, it is 
requested that you send an email to opensource@mitre.org in order to let 
us know where this software is being used.

 */

package org.mitre.secretsharing.server;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mitre.secretsharing.Part;

public abstract class PartInspector {

	public static enum Field {
		version,
		length,
		required,
		modulus,
		x,
		y,
	}
	
	public static String get(Part part, Field field) {
		if(part == null)
			return "";
		switch(field) {
		case version: return String.valueOf(part.getVersion());
		case length: return String.valueOf(part.getLength());
		case required: return String.valueOf(part.getRequiredParts());
		case modulus: return String.valueOf(part.getModulus());
		case x: return String.valueOf(part.getPoint().getX());
		case y: return String.valueOf(part.getPoint().getY());
		}
		throw new IllegalArgumentException("no such field " + field);
	}

	private PartInspector() {}

}