/*******************************************************************************
 * Copyright (c) 2018 ArSysOp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package ru.arsysop.passage.lic.base.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

import ru.arsysop.passage.lic.base.BaseAccessManager;

public class BaseAccessManagerTest {
	
	private Map<String, Object> events = new HashMap<>();
	private Map<String, Object> log = new HashMap<>();
	
	private BaseAccessManager manager = new BaseAccessManager() {
		
		@Override
		protected void sendEvent(String topic, Object data) {
			events.put(topic, data);
		}
		
		@Override
		protected void postEvent(String topic, Object data) {
			events.put(topic, data);
		}
		
		@Override
		protected void logError(String message, Throwable e) {
			log.put(message, e);
		}
	};
	
	@After
	public void tearDown() {
		events.clear();
		log.clear();
	}

	@Test
	public void testEvaluateConditions() {
		manager.evaluateConditions(null);
		assertEquals(1, log.size());
		assertEquals(0, events.size());
	}


}