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
package ru.arsysop.passage.lic.internal.equinox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.Logger;
import org.osgi.service.log.LoggerFactory;

import ru.arsysop.passage.lic.base.BaseConfigurationRequirement;
import ru.arsysop.passage.lic.base.ConfigurationRequirements;
import ru.arsysop.passage.lic.base.LicensingNamespaces;
import ru.arsysop.passage.lic.equinox.LicensingRuntimeWiring;
import ru.arsysop.passage.licensing.runtime.ConfigurationRequirement;
import ru.arsysop.passage.licensing.runtime.ConfigurationResolver;

@Component
public class BundleCapabilityResolver implements ConfigurationResolver {
	
	private Logger logger;
	private BundleContext bundleContext;
	private final String extractCrAudit = "Unable to extract configuration requirements: %s";
	
	@Reference
	public void bindLoggerFactory(LoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(BundleCapabilityResolver.class);
	}

	public void unbindLoggerFactory(LoggerFactory loggerFactory) {
		this.logger = null;
	}
	
	@Activate
	public void activate(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	@Deactivate
	public void deactivate() {
		this.bundleContext = null;
	}

	@Override
	public Iterable<ConfigurationRequirement> resolveConfigurationRequirements(Object configuration) {
		if (bundleContext == null) {
			logger.audit(String.format(extractCrAudit, BundleContext.class));
			return ConfigurationRequirements.createErrorIterable(LicensingNamespaces.LICENSING_ACCESS_MANAGER, this);
		}
		List<ConfigurationRequirement> result = new ArrayList<>();
		Bundle[] bundles = bundleContext.getBundles();
		for (Bundle bundle : bundles) {
			Iterable<BundleCapability> capabilities = LicensingRuntimeWiring.extractLicensingCapabilities(bundle);
			for (BundleCapability capability : capabilities) {
				Map<String, Object> attributes = capability.getAttributes();
				Map<String, String> directives = capability.getDirectives();
				BundleRevision resource = capability.getResource();
				BaseConfigurationRequirement extracted = ConfigurationRequirements.extractFromCapability(attributes, directives, resource);
				if (extracted != null) {
					result.add(extracted);
				} else {
					logger.audit(String.format(extractCrAudit, resource));
					result.add(ConfigurationRequirements.createError(LicensingNamespaces.LICENSING_ACCESS_MANAGER, resource));
					return result;
				}
			}
		}
		return result;
	}

}