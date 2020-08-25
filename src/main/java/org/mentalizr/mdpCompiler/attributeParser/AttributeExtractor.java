package org.mentalizr.mdpCompiler.attributeParser;

import org.mentalizr.mdpCompiler.valueExtractor.ValueExtractor;

public class AttributeExtractor {

    private final String educt;

    private String name = null;
    private final String value;

    private final int stopIndex;


    public AttributeExtractor(String educt) throws AttributeParserException {
        this.educt = educt;
        ValueExtractor valueExtractor = new ValueExtractor(this.educt, '"', '\\');

        if (!valueExtractor.hasValue()) throw new TokenNotRecognizedException(educt);

        this.value = valueExtractor.getValue();
        this.stopIndex = valueExtractor.getStopIndex();

        String preValueString = educt.substring(0, valueExtractor.getStartIndex()).trim();
//        System.out.println(preValueString);

        if (preValueString.length() > 0) {

            if (!preValueString.endsWith("=")) throw new NoValidAssignmentException(preValueString);

            this.name = preValueString.substring(0, preValueString.length() - 1).trim();
            if (this.name.equals("")) throw new NoValidAssignmentException(preValueString);

//            System.out.println("Name: " + name);

        }
    }

    public String getShortenedEductString() {
        return this.educt.substring(this.stopIndex + 1).trim();
    }

    public boolean isAssignment() {
        return this.name != null;
    }

    public boolean hasName() {
        return this.name != null;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Liefert true wenn ein Wert gefunden wurde, unabhängig davon, ob es sich um eine
     * Zuweisung handelt oder nur einen einfachen Wert. Diese Methode liefert damit eine
     * Rückmeldung, ob überhaupt etwas gefunden wurde.
     *
     * @return
     */
    public boolean hasValue() {
        return this.value != null;
    }

    public String getValue() {
        return this.value;
    }

    public String getEduct() {
        return this.educt;
    }


}
