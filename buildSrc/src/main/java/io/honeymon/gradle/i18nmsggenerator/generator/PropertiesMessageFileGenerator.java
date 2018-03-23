package io.honeymon.gradle.i18nmsggenerator.generator;

import com.google.api.services.sheets.v4.model.ValueRange;
import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;

public class PropertiesMessageFileGenerator extends AbstractMessageFileGenerator {
    public PropertiesMessageFileGenerator(I18nMsgGeneratorExtension extension) {
        super(extension);
    }

    @Override
    void generateDestinationPath(ValueRange sheet) {

    }

    @Override
    void generateMessageFile(ValueRange sheet) {

    }
}
