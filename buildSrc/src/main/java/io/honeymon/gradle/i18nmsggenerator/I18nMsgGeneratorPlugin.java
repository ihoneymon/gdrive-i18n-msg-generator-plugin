package io.honeymon.gradle.i18nmsggenerator;

import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class I18nMsgGeneratorPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        I18nMsgGeneratorExtension extension = project.getExtensions().create("i18nMsgGenerator", I18nMsgGeneratorExtension.class);

        //TODO
        project.task("generateCredential");

        project.task("generateMsg")
                .doFirst(task -> {
                    //TODO credential_client.json 파일이 있는지 확인
                    if(extension.getSpreadSheetId() == null || extension.getSpreadSheetId().isEmpty()) {
                        throw new IllegalArgumentException("Required `spreadSheetId`. Ex) `1hz6AnM60HX5VYEpz__2XQoScV4YE_r_v41utJNUzhYE`");
                    }

                    if(extension.getCellRange() == null || extension.getCellRange().isEmpty()) {
                        throw new IllegalArgumentException("Required `cellRange`. Ex) Sheet1!A1:Z");
                    }

                    if(extension.getType() == null) {
                        throw new IllegalArgumentException("Required `type`. Ex) `properties` or `android` or `ios`");
                    }
                })
                .doLast(task -> {
                    System.out.println("SpreadSheetId: " + extension.getSpreadSheetId());
                    System.out.println("Range: " + extension.getCellRange());
                    System.out.println("Type: " + extension.getType());
                });
    }
}
