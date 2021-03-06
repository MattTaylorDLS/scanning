/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.scanning.test.event.queues.integration;

import org.eclipse.scanning.api.event.IEventService;
import org.eclipse.scanning.connector.activemq.ActivemqConnectorService;
import org.eclipse.scanning.event.EventServiceImpl;
import org.eclipse.scanning.event.queues.QueueService;
import org.eclipse.scanning.event.queues.ServicesHolder;
import org.junit.BeforeClass;

public class QueueServiceIntegrationTest extends QueueServiceIntegrationPluginTest {
	

	@BeforeClass
	public static void fakeOSGiSetup() {
		setUpNonOSGIActivemqMarshaller();
		
		IEventService evServ =  new EventServiceImpl(new ActivemqConnectorService());
		ServicesHolder.setEventService(evServ);
		
		QueueService qServ = new QueueService();
		ServicesHolder.setQueueService(qServ);
		ServicesHolder.setQueueControllerService(qServ);
		
	}

}
