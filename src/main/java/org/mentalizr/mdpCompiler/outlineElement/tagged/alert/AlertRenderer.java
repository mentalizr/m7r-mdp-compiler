package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class AlertRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        AlertModel alertModel = (AlertModel) outlineElementModel;

        AlertAttributes alertAttributes = alertModel.getAlertAttributes();
        String iconFileName = getIconFileName(alertAttributes);
        String headerClassAttribute = getHeaderClassAttribute(alertAttributes);
        String preprocessedText = getPreprocessedText(alertModel);

        htmlBuilder.addLn("<div class=\"alert alert-" + alertAttributes.getBootstrapAlertType() + " mb-4\">");
        htmlBuilder.addLn("    <div style=\"display: table; width: 100%\">");
        htmlBuilder.addLn("        <div style=\"display: table-cell; width: 24px; background-image: url(service/v1/mediaImg/" + iconFileName + "); background-repeat: no-repeat; background-position: center center; background-size: contain; width: 24px; height: 24px;\"></div>");
        htmlBuilder.addLn("        <div style=\"display: table-cell; width: 18px;\"></div>");
        htmlBuilder.addLn("        <div style=\"display: table-cell;\"" + headerClassAttribute + ">" + preprocessedText + "</div>");
        htmlBuilder.addLn("    </div>");
        htmlBuilder.addLn("</div>");
    }

    private String getIconFileName(AlertAttributes alertAttributes) {
        if (alertAttributes.getType().equals(AlertAttributes.VALUE_INFO)) return "info.png";
        if (alertAttributes.getType().equals(AlertAttributes.VALUE_EXERCISE)) return "flag.png";
        throw new IllegalStateException();
    }

    private String getHeaderClassAttribute(AlertAttributes alertAttributes) {
        if (!alertAttributes.hasHeadersize()) return "";
        return " class=\"h" + alertAttributes.getHeadersize() + "\"";
    }

    private String getPreprocessedText(AlertModel alertModel) {
        String text = alertModel.getText();
        return this.inlineParserMDP.parse(text);
    }

}
