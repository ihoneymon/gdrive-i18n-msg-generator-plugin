package io.honeymon.gradle.i18nmsggenerator.generator;

import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;
import lombok.Getter;

/**
 * I18N Message 생성기
 */
@Getter
public class I18nMsgFileGenerator {
    private final I18nMsgGeneratorExtension extension;

    public I18nMsgFileGenerator(I18nMsgGeneratorExtension extension) {
        this.extension = extension;
    }

    public void generate() {
        System.out.println("Generate MessageFiles by " + getExtension());

        return;

//        try {
//            MessageFileGenerator messageFileGenerator = MessageFileGeneratorFactory.createGenerator(getExtension());
//
//            Sheets sheets = GoogleService.getSheetsService();
//            ValueRange sheet = sheets.spreadsheets().values().get(getExtension().getSpreadSheetId(), getExtension().getCellRange()).execute();
//            messageFileGenerator.generate(sheet);
//
//        } catch (IOException ioe) {
//            log.error("Occurred exception: " + ioe);
//        }
    }
}
