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
package ru.arsysop.passage.lic.net.tests;

import java.util.Collections;

import org.junit.Test;

import ru.arsysop.passage.lic.internal.net.NtpConditionEvaluator;
import ru.arsysop.passage.lic.runtime.ConditionDescriptor;

@SuppressWarnings("restriction")
public class NtpConditionEvaluatorTest {

	@Test
	public void testEvaluateConditionNegative() throws Exception {
		NtpConditionEvaluator evaluator = new NtpConditionEvaluator();
		evaluator.evaluateConditions(null);
	}

	@Test
	public void testEvaluateConditionPositive() throws Exception {
		NtpConditionEvaluator evaluator = new NtpConditionEvaluator();
		ConditionDescriptor cond = new NetCondition(new String());
		evaluator.evaluateConditions(Collections.singleton(cond));
	}

	private final class NetCondition implements ConditionDescriptor {

		private final String expression;

		public NetCondition(String expression) {
			this.expression = expression;
		}

		@Override
		public String getConditionType() {
			return null;
		}

		@Override
		public String getConditionExpression() {
			return expression;
		}

		@Override
		public String getAllowedFeatureMatchVersion() {
			return null;
		}

		@Override
		public String getAllowedFeatureMatchRule() {
			return null;
		}

		@Override
		public String getAllowedFeatureId() {
			return null;
		}
	}
}
