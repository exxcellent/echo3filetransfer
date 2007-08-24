/* 
 * This file is part of the Echo File Transfer Library.
 * Copyright (C) 2002-2007 NextApp, Inc.
 *
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 */

package nextapp.echo.filetransfer.webcontainer.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import nextapp.echo.filetransfer.webcontainer.UploadSPI;

/**
 * Base <code>UploadSPI</code> implementation.
 */
public abstract class AbstractFileUploadProvider implements UploadSPI {

    private static final int DEFAULT_MEMORY_CACHE_THRESHOLD = 16 * 1024; // 16 KB
    private static final File DEFAULT_TEMP_LOCATION = new File(System.getProperty("java.io.tmpdir", "."));
    private static final int DEFAULT_UPLOAD_SIZE_LIMIT  = 128 * 1024 * 1024; // 128 MB
    
    /**
     * @see UploadSPI#getDiskCacheLocation()
     */
    public File getDiskCacheLocation() throws IOException {
        return DEFAULT_TEMP_LOCATION;
    }

    /**
     * @see UploadSPI#getFileUploadSizeLimit()
     */
    public long getFileUploadSizeLimit() {
        return DEFAULT_UPLOAD_SIZE_LIMIT;
    }

    /**
     * @see UploadSPI#getMemoryCacheThreshold()
     */
    public int getMemoryCacheThreshold() {
        return DEFAULT_MEMORY_CACHE_THRESHOLD;
    }

    /**
     * @see nextapp.echo.webcontainer.WebContainerServlet.MultipartRequestWrapper#getWrappedRequest(HttpServletRequest)
     */
    public HttpServletRequest getWrappedRequest(HttpServletRequest request)
            throws IOException, ServletException {
        return request;
    }
}