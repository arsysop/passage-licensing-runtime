/*******************************************************************************
 * Copyright (c) 2018-2019 ArSysOp
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
package org.eclipse.passage.lic.integration.tests;

import org.eclipse.passage.lic.base.LicensingProperties;
import org.osgi.service.component.annotations.Component;

@Component(property = { LicensingProperties.LICENSING_FEATURE_IDENTIFIER + "=some.licensed.component",
		LicensingProperties.LICENSING_FEATURE_VERSION + '=' + "1.2.0",
		LicensingProperties.LICENSING_RESTRICTION_LEVEL + '=' + LicensingProperties.LICENSING_RESTRICTION_LEVEL_ERROR })
public class LicIntegrationComponent {

}