package com.application.areca;

import java.util.ArrayList;
import java.util.List;

import com.application.areca.context.ProcessContext;
import com.application.areca.metadata.manifest.Manifest;
import com.myJava.util.EqualsHelper;
import com.myJava.util.HashHelper;
import com.myJava.util.history.History;
import com.myJava.util.log.Logger;

/**
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
public abstract class AbstractMedium implements ArchiveMedium {

    protected AbstractRecoveryTarget target;
    
    /**
     * Historique
     */
    protected History history;     
    
    /**
     * Nom du fichier d'historique
     */
    protected static final String HISTORY_NAME = "history";
    
    public void install() throws ApplicationException {
        Logger.defaultLogger().info("Installing medium : " + this.toString());
    }
    
    protected void copyAttributes(Object clone) {
    }

    public void setTarget(AbstractRecoveryTarget target, boolean revalidate) {
        this.target = target;
    }
    
    public AbstractRecoveryTarget getTarget() {
        return this.target;
    }
    
    public String getHistoryName() {
        return HISTORY_NAME;
    } 
    
    public void open(Manifest manifest, ProcessContext context) throws ApplicationException {
        context.setManifest(manifest);
        this.open(context);
    } 
    
    /**
     * Construit une liste de EAD ordonn�e et dont les status sont � jour
     * � partir de la liste d'entr�e data.
     * 
     * @param data
     * @return
     */
    protected EntryArchiveData[] processEntryArchiveData(EntryArchiveData[] data) {
    	List list = new ArrayList();
    	
    	short prevStatus;
    	short status = EntryArchiveData.STATUS_UNKNOWN;
    	for (int i=0; i<data.length; i++) {
    		EntryArchiveData e = data[i];
    		prevStatus = status;
    		status = e.getStatus();
    		
    		if (status == EntryArchiveData.STATUS_EXISTANT || status == EntryArchiveData.STATUS_FIRST_BACKUP) {
				list.add(e);
    		} else {
	    		if (i == 0) {
	    			if (status == EntryArchiveData.STATUS_NONEXISTANT) {
	    				// no store
	    			} else if (status == EntryArchiveData.STATUS_CHANGED) {
	    				e.setStatus(EntryArchiveData.STATUS_FIRST_BACKUP);
	    				list.add(e);
	    			} else if (status == EntryArchiveData.STATUS_UNCHANGED) {
	    				e.setStatus(EntryArchiveData.STATUS_MISSING);
	    				list.add(e);
	    			}
	    		} else {
	    			if (status == EntryArchiveData.STATUS_NONEXISTANT) {
	    				if (! (prevStatus == EntryArchiveData.STATUS_NONEXISTANT)) {
	    					e.setStatus(EntryArchiveData.STATUS_DELETED);
	    					list.add(e);
	    				}
	    			} else if (status == EntryArchiveData.STATUS_CHANGED) {
	    				if (prevStatus == EntryArchiveData.STATUS_NONEXISTANT) {
	    					e.setStatus(EntryArchiveData.STATUS_CREATED);
	    				} else {
	    					e.setStatus(EntryArchiveData.STATUS_MODIFIED);
	    				}
						list.add(e);
	    			} else if (status == EntryArchiveData.STATUS_UNCHANGED) {
	    				// no store
	    			}
	    		}
    		}
    	}
    	
    	return (EntryArchiveData[])list.toArray(new EntryArchiveData[0]);
    }

	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		} else if (! (arg0 instanceof AbstractMedium)) {
			return false;
		} else {
			AbstractMedium other = (AbstractMedium)arg0;
			return (
				EqualsHelper.equals(other.getTarget(), this.getTarget())
			);
		}
	}

	public int hashCode() {
		int result = HashHelper.initHash(this);
		result = HashHelper.hash(result, this.getTarget());
		return result;
	}
}