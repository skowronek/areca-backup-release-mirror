package com.application.areca.context;

import java.io.File;
import java.util.Stack;

import com.application.areca.AbstractRecoveryTarget;
import com.application.areca.impl.FileSystemLevel;
import com.application.areca.metadata.content.ArchiveContentAdapter;
import com.application.areca.metadata.manifest.Manifest;
import com.application.areca.metadata.trace.ArchiveTrace;
import com.application.areca.metadata.trace.ArchiveTraceAdapter;
import com.myJava.file.archive.ArchiveWriter;

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
public class ProcessContext {
    
    /**
     * Fichier pointant sur l'archive zip en cours de construction (qui sera renomm�e � l'issue
     * du commit en archive d�finitive)
     */
    protected File currentArchiveFile;
    
    /**
     * Fichier pointant sur l'archive zip d�finitive (valid�e apr�s commit)
     */
    protected File finalArchiveFile;
    
    /**
     * Writer pour la trace
     */
    protected ArchiveTraceAdapter traceAdapter;
    
    /**
     * Archive content adapter (used for read/write operations)
     */
    protected ArchiveContentAdapter contentAdapter;
    
    /**
     * trace contenant les fichiers list�s lors de la derni�re ex�cution.
     */
    protected ArchiveTrace previousTrace;
    
    /**
     * Tells wether the context have been initialized or not
     */
    protected boolean isInitialized;
    
    /**
     * Archive dans laquelle sera faite le backup.
     */
    private ArchiveWriter archiveWriter;   
    
    /**
     * Manifest
     */
    protected Manifest manifest;
    
    /**
     * Report being built during the process
     */
    protected ProcessReport currentReport;
    
    protected Stack fileSystemLevels;
    protected FileSystemLevel currentLevel;    
    
    public ProcessContext(AbstractRecoveryTarget target) {
        this.currentReport = new ProcessReport(target);
        this.fileSystemLevels = new Stack();
    }
    
    
    public ArchiveContentAdapter getContentAdapter() {
        return contentAdapter;
    }
    
    public void setContentAdapter(ArchiveContentAdapter contentAdapter) {
        this.contentAdapter = contentAdapter;
    }
    
    public File getCurrentArchiveFile() {
        return currentArchiveFile;
    }
    
    public void setCurrentArchiveFile(File currentArchiveFile) {
        this.currentArchiveFile = currentArchiveFile;
    }
    
    public File getFinalArchiveFile() {
        return finalArchiveFile;
    }
    
    public void setFinalArchiveFile(File finalArchiveFile) {
        this.finalArchiveFile = finalArchiveFile;
    }
    
    public ArchiveTrace getPreviousTrace() {
        return previousTrace;
    }
    
    public void setPreviousTrace(ArchiveTrace previousTrace) {
        this.previousTrace = previousTrace;
    }

    public ArchiveTraceAdapter getTraceAdapter() {
        return traceAdapter;
    }
    
    public void setTraceAdapter(ArchiveTraceAdapter traceAdapter) {
        this.traceAdapter = traceAdapter;
    } 
    
    public boolean isInitialized() {
        return isInitialized;
    }
    
    public void setInitialized() {
        this.isInitialized = true;
    }
    
    public ArchiveWriter getArchiveWriter() {
        return archiveWriter;
    }
    
    public void setArchiveWriter(ArchiveWriter archive) {
        this.archiveWriter = archive;
    }
    
    public Manifest getManifest() {
        return manifest;
    }
    
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }
    
    public ProcessReport getReport() {
        return currentReport;
    }

    public FileSystemLevel getCurrentLevel() {
        return currentLevel;
    }
    
    public void setCurrentLevel(FileSystemLevel currentLevel) {
        this.currentLevel = currentLevel;
    }
    
    public Stack getFileSystemLevels() {
        return fileSystemLevels;
    }
}