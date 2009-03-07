package com.application.areca.launcher.gui.postprocessors;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.application.areca.ApplicationException;
import com.application.areca.launcher.gui.Application;
import com.application.areca.launcher.gui.ProcessorEditionWindow;
import com.application.areca.launcher.gui.common.AbstractWindow;
import com.application.areca.processor.MailSendProcessor;
import com.application.areca.processor.Processor;

/**
 * <BR>
 * @author Olivier PETRUCCI
 * <BR>
 * <BR>Areca Build ID : 231019873304483154
 */

 /*
 Copyright 2005-2009, Olivier PETRUCCI.

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
public class MailSendProcessorComposite extends AbstractProcessorComposite {

    private Text txtRecipients;
    private Text txtSmtp;
    private Text txtUser;
    private Text txtPassword;
    private Text txtTitle;
    private Text txtIntro;
    private Text txtFrom;
    private Button btnTest;
    private Button btnOnlyError;
    private Button btnSMTPS;
    
    public MailSendProcessorComposite(Composite composite, Processor proc, ProcessorEditionWindow window) {
        super(composite, proc, window);
        this.setLayout(new GridLayout(2, false));
        
        // Title
        Label lblTitle = new Label(this, SWT.NONE);
        lblTitle.setText(RM.getLabel("procedition.mailtitle.label"));
        
        txtTitle = new Text(this, SWT.BORDER);
        txtTitle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtTitle);
        
        // Intro
        Label lblIntro = new Label(this, SWT.NONE);
        lblIntro.setText(RM.getLabel("procedition.mailintro.label"));
        txtIntro = new Text(this, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
        GridData dt = new GridData(SWT.FILL, SWT.FILL, true, true);
        dt.heightHint = AbstractWindow.computeHeight(50);
        dt.widthHint = AbstractWindow.computeWidth(200);
        txtIntro.setLayoutData(dt);
        window.monitorControl(txtIntro);
        
        // Example
        new Label(this, SWT.NONE);
        Label lblExample = new Label(this, SWT.NONE);
        lblExample.setText(RM.getLabel("procedition.dynparams.label"));
        lblExample.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        
        // Recipients
        Label lblRecipients = new Label(this, SWT.NONE);
        lblRecipients.setText(RM.getLabel("procedition.recipients.label"));
        
        txtRecipients = new Text(this, SWT.BORDER);
        txtRecipients.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtRecipients);
        
        // From
        Label lblFrom = new Label(this, SWT.NONE);
        lblFrom.setText(RM.getLabel("procedition.mailfrom.label"));
        
        txtFrom = new Text(this, SWT.BORDER);
        txtFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtFrom);
        
        // SMTP
        Label lblSmtp = new Label(this, SWT.NONE);
        lblSmtp.setText(RM.getLabel("procedition.smtp.label"));
        
        txtSmtp = new Text(this, SWT.BORDER);
        txtSmtp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtSmtp);
        
        // SMTPS
        new Label(this, SWT.NONE);
        btnSMTPS = new Button(this, SWT.CHECK);
        btnSMTPS.setText(RM.getLabel("procedition.smtps.label"));
        btnSMTPS.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
        window.monitorControl(btnSMTPS);
        
        // User
        Label lblUser = new Label(this, SWT.NONE);
        lblUser.setText(RM.getLabel("procedition.user.label"));
        
        txtUser = new Text(this, SWT.BORDER);
        txtUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtUser);
        
        // Password
        Label lblPassword = new Label(this, SWT.NONE);
        lblPassword.setText(RM.getLabel("procedition.password.label"));
        
        txtPassword = new Text(this, SWT.BORDER);
        txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        window.monitorControl(txtPassword);
        
        // Test
        new Label(this, SWT.NONE);
        btnTest = new Button(this, SWT.PUSH);
        btnTest.setText(RM.getLabel("procedition.smtp.test"));
        btnTest.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        btnTest.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                
                try {
                    MailSendProcessor testProc = new MailSendProcessor();
                    initProcessor(testProc);
                    testProc.sendMail("Areca mail report test", "Areca mail report test successfull !", ps, null);
                    
                    Application.getInstance().showInformationDialog(baos.toString(), RM.getLabel("procedition.ok.label"), true);                
                } catch (ApplicationException e1) {
                    Application.getInstance().showErrorDialog(e1.getMessage() + "\n\n" + baos.toString(), RM.getLabel("procedition.error.label"), true);
                }
            }
        });
        
        // Send only if in error
        btnOnlyError = new Button(this, SWT.CHECK);
        btnOnlyError.setText(RM.getLabel("procedition.onlyerror.label"));
        btnOnlyError.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
        window.monitorControl(btnOnlyError);
        
        if (proc != null) {
            MailSendProcessor mProc = (MailSendProcessor)proc;
            txtRecipients.setText(mProc.getRecipients());
            txtSmtp.setText(mProc.getSmtpServer());
            txtUser.setText(mProc.getUser());
            txtPassword.setText(mProc.getPassword());
            btnOnlyError.setSelection(mProc.isOnlyIfError());
            txtTitle.setText(mProc.getTitle());
            btnSMTPS.setSelection(mProc.isSmtps());
            if (mProc.getIntro() != null) {
                txtIntro.setText(mProc.getIntro());
            }
            if (mProc.getFrom() != null) {
                txtFrom.setText(mProc.getFrom());
            }
        }
    }

    public void initProcessor(Processor proc) {
        MailSendProcessor mProc = (MailSendProcessor)proc;
        mProc.setRecipients(txtRecipients.getText());
        mProc.setSmtpServer(txtSmtp.getText());
        mProc.setUser(txtUser.getText());
        mProc.setPassword(txtPassword.getText());
        mProc.setOnlyIfError(btnOnlyError.getSelection());
        mProc.setTitle(txtTitle.getText());
        mProc.setSmtps(btnSMTPS.getSelection());
        mProc.setIntro(txtIntro.getText());
        mProc.setFrom(txtFrom.getText());
    }
    
    public boolean validateParams() {
        this.window.resetErrorState(txtRecipients);
        this.window.resetErrorState(txtSmtp);
        this.window.resetErrorState(txtTitle);
        
        if (txtTitle.getText() == null || txtTitle.getText().trim().length() == 0) {
            this.window.setInError(txtTitle);
            return false;
        }
        
        if (txtRecipients.getText() == null || txtRecipients.getText().trim().length() == 0) {
            this.window.setInError(txtRecipients);
            this.btnTest.setEnabled(false);
            return false;
        }
        
        if (txtSmtp.getText() == null || txtSmtp.getText().trim().length() == 0) {
            this.window.setInError(txtSmtp);
            this.btnTest.setEnabled(false);
            return false;
        }

        this.btnTest.setEnabled(true);
        return true;
    }
}
