package io.honeymon.gradle.i18nmsggenerator.generator;

import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;

public class MessageFileGeneratorFactory {
    public static MessageFileGenerator createGenerator(I18nMsgGeneratorExtension extension) {
        switch (extension.getType()) {
            case PROPERTIES:
                return new PropertiesMessageFileGenerator(extension);

            case ANDROID:
                return new AndroidMessageFileGenerator(extension);

            case IOS:
                return new IosMessageFileGenerator(extension);

            default:
                throw new IllegalArgumentException("Not support type: " + extension.getType());
        }
    }
}
