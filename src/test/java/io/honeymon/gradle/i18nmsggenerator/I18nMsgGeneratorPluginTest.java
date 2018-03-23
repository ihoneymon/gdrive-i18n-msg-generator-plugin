package io.honeymon.gradle.i18nmsggenerator;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class I18nMsgGeneratorPluginTest {

    @Test
    public void test() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("io.honeymon.gradle.i18nmsggenerator");

        assertTrue(project.getPluginManager().hasPlugin("io.honeymon.gradle.i18nmsggenerator"));
    }
}