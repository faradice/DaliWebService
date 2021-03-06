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

import com.faradice.faranet.FaraJettyServer;

public class DaliWebServer {
	public final static int defaultPort = 8085;
	public final static String path = "/Fara_occp";
	public final static String name = "/CentralSystemService/*";

	public static void main(String[] args) throws Exception {
		FaraJettyServer server = new FaraJettyServer(defaultPort, args);
		server.addServlet(path, name, new DaliWebService());
		System.out.println("Endpoint: http://" + FaraJettyServer.hostName() + ":" + defaultPort + path + name);
		server.run();
	}
}


