package org.mentalizr.mdpCompilerTestResrc;

public class DiffHelper {

    public static void showDiff(String[] reference, String[] probe) {

        if (reference.length != probe.length) {
            System.out.println("Difference in length");
        }

        int i;
        for (i = 0; i < reference.length && i < probe.length; i++) {
            int differIndex = firstDiffIndex(reference[i], probe[i]);
            if (differIndex >= 0) {
                System.out.println("Found difference at index [" + i + "] position [" + differIndex + "]");
                System.out.println("reference: " + reference[i]);
                System.out.println("probe    : " + probe[i]);
            }
        }

    }

    public static int firstDiffIndex(String reference, String probe) {

        if (reference == null || probe == null) throw new IllegalArgumentException("parameter null");

        if (reference.equals(probe)) return -1;

        int i;
        for (i = 0; i < reference.length() && i < probe.length(); i++) {
            if (reference.charAt(i) != probe.charAt(i)) return i;
        }

        if (i < reference.length() || i < probe.length()) {
            return i;
        }

        return -1;
    }

}
