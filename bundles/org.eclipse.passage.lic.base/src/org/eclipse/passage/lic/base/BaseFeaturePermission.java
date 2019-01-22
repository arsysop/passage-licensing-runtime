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
package org.eclipse.passage.lic.base;

import static org.eclipse.passage.lic.base.LicensingProperties.*;

import java.util.Date;

import org.eclipse.passage.lic.runtime.FeaturePermission;
import org.eclipse.passage.lic.runtime.LicensingCondition;
import org.eclipse.passage.lic.runtime.LicensingConfiguration;

public class BaseFeaturePermission implements FeaturePermission {

	private final LicensingCondition licensingCondition;
	private final LicensingConfiguration licensingConfiguration;
	private final Date leaseDate;
	private final Date expireDate;

	BaseFeaturePermission(LicensingCondition condition, LicensingConfiguration configuration, Date lease, Date expire) {
		this.licensingCondition = condition;
		this.licensingConfiguration = configuration;
		this.leaseDate = lease;
		this.expireDate = expire;
	}

	@Override
	public LicensingCondition getLicensingCondition() {
		return licensingCondition;
	}
	
	public LicensingConfiguration getLicensingConfiguration() {
		return licensingConfiguration;
	}

	@Override
	public Date getLeaseDate() {
		return leaseDate;
	}

	@Override
	public Date getExpireDate() {
		return expireDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(licensingCondition).append(';');
		sb.append(LICENSING_LEASE_TIME).append('=').append(leaseDate).append(';');
		sb.append(LICENSING_EXPIRE_TIME).append('=').append(expireDate);
		return sb.toString();
	}

}