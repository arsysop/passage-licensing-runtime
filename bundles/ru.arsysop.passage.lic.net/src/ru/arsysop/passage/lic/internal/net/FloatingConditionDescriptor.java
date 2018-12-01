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
package ru.arsysop.passage.lic.internal.net;

import ru.arsysop.passage.lic.base.BaseLicensingCondition;

public class FloatingConditionDescriptor extends BaseLicensingCondition {

	public FloatingConditionDescriptor() {
		super("", "", "", "", "");
	}

	public FloatingConditionDescriptor(String id, String version, String rule, String type, String expression) {
		super(id, version, rule, type, expression);
	}

}