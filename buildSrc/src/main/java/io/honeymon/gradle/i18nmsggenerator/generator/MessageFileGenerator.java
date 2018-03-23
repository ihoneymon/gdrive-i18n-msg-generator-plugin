package io.honeymon.gradle.i18nmsggenerator.generator;

import com.google.api.services.sheets.v4.model.ValueRange;
import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;

import java.io.IOException;

public interface MessageFileGenerator {

    /**
     * Generate Message files by {@link I18nMsgGeneratorExtension#type}
     *
     * @param sheet
     * @throws IOException
     */
    void generate(ValueRange sheet) throws IOException;
}
