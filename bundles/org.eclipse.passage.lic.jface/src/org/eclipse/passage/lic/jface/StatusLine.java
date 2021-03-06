/*******************************************************************************
 * Copyright (c) 2018-2019 ArSysOp
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package org.eclipse.passage.lic.jface;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.passage.lic.jface.LicensingImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

public class StatusLine extends CLabel {
	
	private final LicensingImages images;

	public StatusLine(Composite parent, LicensingImages images) {
		super(parent, SWT.LEFT);
		this.images = images;
	}

    private String computeImageKey(IStatus status) {
    	int severity = status.getSeverity();
    	switch (severity) {
		case IStatus.ERROR:
			return LicensingImages.IMG_LEVEL_ERROR;
		case IStatus.WARNING:
			return LicensingImages.IMG_LEVEL_WARN;
		case IStatus.INFO:
			return LicensingImages.IMG_LEVEL_INFO;
		case IStatus.OK:
			return LicensingImages.IMG_LEVEL_OK;
		default:
			return LicensingImages.IMG_LEVEL_WARN;
		}
    }

    public void setStatus(IStatus status) {
    	if (status == null) {
    		setText(""); //$NON-NLS-1$
    		setImage(null);
    		return;
		}
    	String message = status.getMessage();
    	if (message != null) {
    		setText(message);
    	} else {
    		setText(""); //$NON-NLS-1$
    	}
    	setImage(images.getImage(computeImageKey(status)));
	}
}
