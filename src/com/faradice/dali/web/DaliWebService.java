/*================================================================================
 * Faradice Firmware
 *
 * Copyright (c) 2016 Faradice ehf.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Faradice ehf. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Faradice.
 *================================================================================
 */
package com.faradice.dali.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DaliWebService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String servletPath = request.getServletPath();
			String contextPath = request.getContextPath();
			String query = request.getQueryString();
			System.out.println("pathInfo:" + servletPath);
			System.out.println("contextPath:" + contextPath);
			System.out.println("Req URI:" + request.getRequestURL());
			System.out.println("Query:" + query);
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/xml;charset=UTF-8");
			String output = "Hello\n";
			response.getWriter().println(output);
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			response.getWriter().close();
		}
	}

			
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			String soapInputContent = "";
			while ((line = reader.readLine()) != null) {
				soapInputContent += line;
			}
			System.out.println("Got POST:");
			System.out.println(soapInputContent);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/txt+xml"); // todo
			response.getWriter().println("DALI Post");
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			response.getWriter().close();
		}
	}

}
