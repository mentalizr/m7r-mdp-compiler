package org.mentalizr.mdpCompiler.result;

import org.mentalizr.mdpCompiler.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO Umbauen in Compiler ziehen
 *
 */
public class ResultWriter implements Result {

    private List<String> stringList = new ArrayList<>();

    @Override
    public void addLn(String line) {

        // System.out.println("Writer addLn: " + line);

        stringList.add(line);
    }

    @Override
    public void addLn(int indentLevel, String line) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i<indentLevel; i++) {
            stringBuffer.append("    ");
        }
        stringBuffer.append(line);

        stringList.add(stringBuffer.toString());
    }

    @Override
    public void addResult(Result resultToBeAdded) {

        List<String> linesToBeAdded = resultToBeAdded.getResultLines();

        for (String string : linesToBeAdded) {
            addLn(string);
        }

    }

    @Override
    public List<String> getResultLines() {
        return this.stringList;
    }

    public void write(File file) throws FileNotFoundException {

        if (file.exists()) {
            file.delete();
        }

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));

        for (String string : stringList) {
            printWriter.println(string);
//            System.out.println(string);
        }

        String footer = "<!-- MDP build time: "
                + this.getCurrentTimeStampFormatted() + ", "
                + "host: " + getHostName() + ", "
                + "MDPC version: " + Const.VERSION
                + " -->";

        printWriter.println(footer);

        // TODO finally ...
        printWriter.close();

        stringList = new ArrayList<>();
    }


    public void out() {
        for (String string : stringList) {
            System.out.println(string);
        }
    }

    private String getCurrentTimeStampFormatted() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown";
        }
    }



}
