package com.myJava.util.version;

import java.net.URL;
import java.util.GregorianCalendar;

import com.myJava.util.EqualsHelper;
import com.myJava.util.HashHelper;

/**
 * Class containing various informations about a sotfware's version
 * <BR>
 * @author Olivier PETRUCCI
 * <BR>
 * <BR>Areca Build ID : 4945525256658487980
 */
 
 /*
 Copyright 2005-2007, Olivier PETRUCCI.
 
This file is part of Areca.

    Areca is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Areca is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Areca; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
public class VersionData {

    private String versionId;
    private URL downloadUrl;
    private GregorianCalendar versionDate;
    private String description;
    
    public VersionData() {
        super();
    }
    
    public VersionData(String versionId, GregorianCalendar versionDate, URL downloadUrl, String description) {
        super();
        
        this.versionId = versionId;
        this.downloadUrl = downloadUrl;
        this.versionDate = versionDate;
        this.description = description;
    }
    
    public VersionData(String versionId, GregorianCalendar versionDate, String description) {
        super();
        
        this.versionId = versionId;
        this.versionDate = versionDate;
        this.description = description;
    }
    
    public URL getDownloadUrl() {
        return downloadUrl;
    }
    
    public void setDownloadUrl(URL downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    
    public GregorianCalendar getVersionDate() {
        return versionDate;
    }
    
    public void setVersionDate(GregorianCalendar versionDate) {
        this.versionDate = versionDate;
    }
    
    public String getVersionId() {
        return versionId;
    }
    
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb
        	.append("VERSION : ")
        	.append(versionId)
        	.append("\n")
        	.append("DATE : ")
        	.append(versionDate)
        	.append('\n')
        	.append("URL : ")
        	.append(downloadUrl)
        	.append('\n')
        	.append("DESCRIPTION : ")
        	.append(description);        	
        
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (! (obj instanceof VersionData)) {
            return false;
        } else {
            VersionData other = (VersionData)obj;
            return EqualsHelper.equals(other.getVersionId(), this.getVersionId());
        }
    }
    
    public int hashCode() {
        int hash = HashHelper.initHash(this);
        hash = HashHelper.hash(hash, this.versionId);
        return hash;
    }
}