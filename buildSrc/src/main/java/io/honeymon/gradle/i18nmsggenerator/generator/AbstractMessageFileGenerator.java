package io.honeymon.gradle.i18nmsggenerator.generator;

import com.google.api.services.sheets.v4.model.ValueRange;
import io.honeymon.gradle.i18nmsggenerator.dsl.I18nMsgGeneratorExtension;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractMessageFileGenerator implements MessageFileGenerator {
    @Getter
    private I18nMsgGeneratorExtension extension;

    public AbstractMessageFileGenerator(I18nMsgGeneratorExtension extension) {
        this.extension = extension;
    }


    /**
     * Generate DestinationPath by {@link I18nMsgGeneratorExtension#type}
     *
     * @param sheet
     */
    abstract void generateDestinationPath(ValueRange sheet);

    /**
     * Generate MessageFile
     *
     * @param sheet
     */
    abstract void generateMessageFile(ValueRange sheet);


    @Override
    public void generate(ValueRange sheet) {

        try {
            if (sheet == null) {
                throw new IllegalArgumentException("`valueRange` must be not null.");
            }

            if (sheet.getValues() == null || sheet.size() == 0) {
                return;
            }

            if (extension.isPrintSheetInfo()) {
                printSheetInfo(sheet);
            }


            generateDestinationPath(sheet);
            generateMessageFile(sheet);
        } catch (Exception e) {

            throw e;
        }
    }

    /**
     * Print contents of ValueRange
     *
     * @param sheet
     */
    private void printSheetInfo(ValueRange sheet) {
        List<List<Object>> cellsOfSheet = sheet.getValues();


    }
}
