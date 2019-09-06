// Copyright (c) 2014-2019 Zephir Team
//
// This source file is subject the MIT license, that is bundled with
// this package in the file LICENSE, and is available through the
// world-wide-web at the following url:
//
// https://github.com/zephir-lang/idea-plugin/blob/master/LICENSE

package com.zephir.actions;

import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.zephir.ZephirIcons;

public class ZephirNewClassAction extends CreateFileFromTemplateAction {

    public ZephirNewClassAction() {
        super("Zephir Class", "Create new Zephir file", ZephirIcons.ZEPHIR);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle("New Zephir file");
        builder.addKind("Class", AllIcons.Nodes.Class, "Zephir Class");
        builder.addKind("Interface", AllIcons.Nodes.Interface, "Zephir Interface");
    }

    @Override
    protected String getActionName(PsiDirectory directory, String name, String template) {
        return "Creating new Zephir class";
    }

    @Override
    protected PsiFile createFile(String name, String templateName, PsiDirectory dir) {
        final FileTemplate template = FileTemplateManager.getInstance().getInternalTemplate(templateName);
        return createFileFromTemplate(name, template, dir);
    }
}
