package com.application.areca.version;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.myJava.util.os.OSTool;
import com.myJava.util.version.VersionData;

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
public class VersionInfos {
    protected static ArrayList VERSIONS = new ArrayList();  
    protected static Map VERSION_BY_ID = new HashMap();
    
    protected static long BUILD_ID = -1;
    
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("MMMMMM yyyy", Locale.getDefault());
    
    public static String APP_NAME = "Areca";
    public static int[] REQUIRED_JAVA_VERSION = new int[] {1, 4, 2};
    public static String VERSION_MSG = APP_NAME + 
    						" requires Java version " 
    						+ OSTool.formatJavaVersion(REQUIRED_JAVA_VERSION) 
    						+ " to run properly.\nThe version which is currently installed on your system (v " 
    						+ OSTool.formatJavaVersion(OSTool.getJavaVersion()) 
    						+ ") does not meet this requirement.\n\nPlease go to http://java.sun.com/javase/downloads/ and get a newer version of Java.\n "; 
    
    static {
        
        // INIT BUILD ID - DO NOT MODIFY THE FOLLOWING COMMENT :
        BUILD_ID = 4945525256658487980L;
        
        // INIT VERSION DATA
        VERSIONS.add(new VersionData("1.0", new GregorianCalendar(2005, 4, 1), "Backup engine implementation."));
        VERSIONS.add(new VersionData("1.1", new GregorianCalendar(2005, 4,15), "GUI implementation"));
        VERSIONS.add(new VersionData("1.2", new GregorianCalendar(2005, 5, 1), "New storage mediums; XML processing improvement."));
        VERSIONS.add(new VersionData("1.2.1", new GregorianCalendar(2005, 5, 6), "History implementation."));
        VERSIONS.add(new VersionData("1.2.2", new GregorianCalendar(2005, 5, 21), "Minor GUI enhancements."));
        VERSIONS.add(new VersionData("2.0", new GregorianCalendar(2005, 6, 3), "Group / Target edition windows."));
        VERSIONS.add(new VersionData("2.1", new GregorianCalendar(2005, 6, 11), "Minor GUI enhancements. ('about' and 'help' dialogs)")); 
        VERSIONS.add(new VersionData("2.1.1", new GregorianCalendar(2005, 6, 13), "History improvement."));
        VERSIONS.add(new VersionData("2.1.2", new GregorianCalendar(2005, 6, 23), "Context menus implementation."));
        VERSIONS.add(new VersionData("2.2", new GregorianCalendar(2005, 9, 11), "Manifest implementation."));
        VERSIONS.add(new VersionData("2.2.1", new GregorianCalendar(2005, 11, 8), "Log history management."));
        VERSIONS.add(new VersionData("2.3", new GregorianCalendar(2005, 11, 18), "Backup / Merge / Recover pre-check improvements."));
        VERSIONS.add(new VersionData("2.3.1", new GregorianCalendar(2006, 0, 2), "Backup monitoring enhancement."));
        VERSIONS.add(new VersionData("2.4", new GregorianCalendar(2006, 1, 6), "Regex filters implementation."));
        VERSIONS.add(new VersionData("2.5", new GregorianCalendar(2006, 2, 9), "Commit / Rollback implementation for backups and merges."));  
        VERSIONS.add(new VersionData("2.6", new GregorianCalendar(2006, 2, 22), "Archive detail window."));  
        VERSIONS.add(new VersionData("2.7", new GregorianCalendar(2006, 3, 15), "Archive merge enhancement; Archive deletion implementation."));  
        VERSIONS.add(new VersionData("3.0", new GregorianCalendar(2006, 4, 7), "Backup simulation and single file recovery implementation."));  
        VERSIONS.add(new VersionData("3.1", new GregorianCalendar(2005, 4, 21), "Archive encryption implementation."));  
        VERSIONS.add(new VersionData("3.1.1", new GregorianCalendar(2006, 5, 12), "Incremental storage mediums now check that the data have really changed before backup."));
        VERSIONS.add(new VersionData("3.1.2", new GregorianCalendar(2006, 6, 2), "Minor GUI correction (the 'Help' window didn't open correctly under Windows 2000.)"));
        VERSIONS.add(new VersionData("3.1.3", new GregorianCalendar(2006, 6, 6), "Added references to the project's home page."));
        VERSIONS.add(new VersionData("3.1.4", new GregorianCalendar(2006, 6, 8), "Support for deep directories encryption on Windows (Windows limits paths length to 256 characters)."));
        VERSIONS.add(new VersionData("3.1.5", new GregorianCalendar(2006, 6, 12), "Added Java version check on startup and minor GUI enhancements."));  
        VERSIONS.add(new VersionData("3.2", new GregorianCalendar(2006, 6, 18), "Implemented process cancellation; added target Indicators."));
        VERSIONS.add(new VersionData("3.2.1", new GregorianCalendar(2006, 6, 20), "Target history enhancement."));
        VERSIONS.add(new VersionData("3.2.2", new GregorianCalendar(2006, 6, 27), "Added a check module for new releases."));
        VERSIONS.add(new VersionData("3.2.3", new GregorianCalendar(2006, 7, 2), "Minor bug fix."));
        VERSIONS.add(new VersionData("3.2.4", new GregorianCalendar(2006, 7, 4), "Added AES encryption algorithm; Minor GUI enhancements."));
        VERSIONS.add(new VersionData("3.2.5", new GregorianCalendar(2006, 7, 24), "Command line interface bug fix."));
        VERSIONS.add(new VersionData("3.2.6", new GregorianCalendar(2006, 7, 28), "Command line interface improvements - Backup pre-check improvements."));
        VERSIONS.add(new VersionData("3.2.7", new GregorianCalendar(2006, 7, 30), "Backup simulation bug fix."));
        VERSIONS.add(new VersionData("3.3", new GregorianCalendar(2006, 8, 7), "Internationalization, UTF8 support and various improvements."));
        VERSIONS.add(new VersionData("3.3.1", new GregorianCalendar(2006, 8, 9), "Internationalization bug fix."));
        VERSIONS.add(new VersionData("3.4", new GregorianCalendar(2006, 8, 12), "Empty directory tracking; Archive mediums refactoring; File size & date filters."));
        VERSIONS.add(new VersionData("3.5", new GregorianCalendar(2006, 9, 10), "New file filters; Major archive medium refactoring."));
        VERSIONS.add(new VersionData("3.5.1", new GregorianCalendar(2006, 9, 21), "Minor ZIP bug fix (This bug occured on empty archives)."));
        VERSIONS.add(new VersionData("4.0", new GregorianCalendar(2006, 10, 4), "Post-processors and user preferences; Various optimizations."));
        VERSIONS.add(new VersionData("4.0.5", new GregorianCalendar(2006, 10, 10), "Mail encoding bug fix; Workspace backup feature."));
        VERSIONS.add(new VersionData("4.1", new GregorianCalendar(2006, 10, 22), "Search feature; Toolbar; Minor enhancements & Bug fixes."));
        VERSIONS.add(new VersionData("4.1.5", new GregorianCalendar(2006, 11, 1), "Stronger encryption; Some bug fixes (shell post-processors)."));
        VERSIONS.add(new VersionData("4.1.6", new GregorianCalendar(2007, 0, 30), "Memory optimizations; Recovery enhancement (File last modification date is now preserved)."));
        VERSIONS.add(new VersionData("4.1.7", new GregorianCalendar(2007, 1, 4), "Merge bug fix."));
        VERSIONS.add(new VersionData("4.2", new GregorianCalendar(2007, 1, 7), "File attributes recovery (date & permissions); Authenticated SMTP support; Encrypted targets bug fix."));
        VERSIONS.add(new VersionData("4.2.1", new GregorianCalendar(2007, 2, 3), "Memory optimizations and improved controls on zip32 archive size."));
        VERSIONS.add(new VersionData("4.2.2", new GregorianCalendar(2007, 2, 6), "Various bug fixes."));
        VERSIONS.add(new VersionData("4.2.3", new GregorianCalendar(2007, 2, 7), "Some more bug fixes."));
        VERSIONS.add(new VersionData("4.5", new GregorianCalendar(2007, 3, 11), "Zip64 compression; FTP support; Improved archives controls; XML configuration backup; Log window."));
        VERSIONS.add(new VersionData("4.5.1", new GregorianCalendar(2007, 3, 29), "FTPs (implicit/explicit SSL/TLS) support."));
        VERSIONS.add(new VersionData("4.5.2", new GregorianCalendar(2007, 4, 1), "Some bug fixes; Target duplication feature."));
        VERSIONS.add(new VersionData("5.0", new GregorianCalendar(2007, 4, 12), "Graphical user interface refactoring (SWT is used instead of Swing)."));        

        Iterator iter = VERSIONS.iterator();
        while (iter.hasNext()) {
            VersionData infos = (VersionData)iter.next();
            VERSION_BY_ID.put(infos.getVersionId(), infos);
        }
    }
    
    public static VersionData getLastVersion() {
        return (VersionData)VERSIONS.get(VERSIONS.size() - 1);
    }

    public static List getVersions() {
        return VERSIONS;
    }
    
    public static String formatVersionDate(GregorianCalendar date) {
        return FORMAT.format(date.getTime());
    }
    
    public static VersionData getVersion(String id) {
        return (VersionData)VERSION_BY_ID.get(id);
    }
    
    public static long getBuildId() {
        return BUILD_ID;
    }
}