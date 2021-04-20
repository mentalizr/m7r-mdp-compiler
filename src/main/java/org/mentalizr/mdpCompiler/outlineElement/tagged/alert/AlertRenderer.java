package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class AlertRenderer extends OutlineElementRenderer {

    private final AlertAttributes alertAttributes;
    private final AlertModel alertModel;

    public AlertRenderer(AlertAttributes alertAttributes, AlertModel alertModel) {
        super();
        this.alertAttributes = alertAttributes;
        this.alertModel = alertModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        result.addLn("<div class=\"alert alert-" + this.alertAttributes.getBootstrapAlertType() + " mb-4\">");
        result.addLn("    <div style=\"display: table; width: 100%\">");
        result.addLn("        <div style=\"display: table-cell; width: 24px; background-image: url(service/v1/mediaImg/" + getIconFileName() + "); background-repeat: no-repeat; background-position: center center; background-size: contain; width: 24px; height: 24px;\"></div>");
        result.addLn("        <div style=\"display: table-cell; width: 18px;\"></div>");
        result.addLn("        <div style=\"display: table-cell;\"" + getHeaderClassAttribute() + ">" + getPreprocessedText() + "</div>");
        result.addLn("    </div>");
        result.addLn("</div>");
    }

    private String getIconFileName() {
        if (this.alertAttributes.getType().equals(AlertAttributes.VALUE_INFO)) return "info.png";
        if (this.alertAttributes.getType().equals(AlertAttributes.VALUE_EXERCISE)) return "flag.png";
        throw new IllegalStateException();
    }

    private String getHeaderClassAttribute() {
        if (!this.alertAttributes.hasHeadersize()) return "";
        return " class=\"h" + this.alertAttributes.getHeadersize() + "\"";
    }

    private String getPreprocessedText() {
        String text = this.alertModel.getText();
        return this.inlineParserMDP.parse(text);
    }

}
