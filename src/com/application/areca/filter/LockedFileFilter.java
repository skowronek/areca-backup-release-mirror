package com.application.areca.filter;

import java.io.IOException;

import com.application.areca.RecoveryEntry;
import com.application.areca.impl.FileSystemRecoveryEntry;
import com.myJava.file.FileSystemManager;
import com.myJava.util.EqualsHelper;
import com.myJava.util.HashHelper;
import com.myJava.util.PublicClonable;
import com.myJava.util.log.Logger;

/**
 * 
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
public class LockedFileFilter extends AbstractArchiveFilter {
    
    public LockedFileFilter() {
    }
    
    public void acceptParameters(String parameters) {
    }
    
    /**
     * Cette condition ne s'applique que sur les r�pertoires (pour des raisons d'optimisation).
     * Les fichiers retournent syst�matiquement "true"
     */
    public boolean accept(RecoveryEntry entry) {
        FileSystemRecoveryEntry fEntry = (FileSystemRecoveryEntry)entry;      
        
        if (FileSystemManager.isDirectory(fEntry.getFile())) {
            return true;
        }
        
        if (fEntry == null) {
            return false;
        } else {
            try {
                if (FileSystemManager.isReadable(fEntry.getFile())) {
                    return exclude;
                } else {
                    return ! exclude;
                }
            } catch (IOException ex) {
                Logger.defaultLogger().error("Error during filtering of " + FileSystemManager.getAbsolutePath(fEntry.getFile()), ex);
                throw new IllegalArgumentException("Error during filtering of " + FileSystemManager.getAbsolutePath(fEntry.getFile()));
            }
        }
    }
    
    public PublicClonable duplicate() {
        LockedFileFilter filter = new LockedFileFilter();
        filter.exclude = this.exclude;
        return filter;
    }    
    
    public String getStringParameters() {
        return  null;
    }
    
    public boolean requiresParameters() {
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj == null || (! (obj instanceof LockedFileFilter)) ) {
            return false;
        } else {
            LockedFileFilter other = (LockedFileFilter)obj;
            return 
            	EqualsHelper.equals(this.exclude, other.exclude)
           	;
        }
    }
    
    public int hashCode() {
        int h = HashHelper.initHash(this);
        h = HashHelper.hash(h, this.exclude);
        return h;
    }
}