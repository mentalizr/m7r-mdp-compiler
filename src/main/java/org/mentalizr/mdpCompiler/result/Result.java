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

public class Result {

    private List<String> stringList = new ArrayList<>();

    public void addLn(String line) {
        stringList.add(line);
    }

    public void addLn(int indentLevel, String line) {
        stringList.add(
                "    ".repeat(Math.max(0, indentLevel)) + line
        );
    }

    public List<String> getResultLines() {
        return this.stringList;
    }

    public void write(File file) throws FileNotFoundException {

        if (file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file))) {

            for (String string : stringList) {
                printWriter.println(string);
            }

            @SuppressWarnings("SpellCheckingInspection")
            String footer = "<!-- MDP build time: "
                    + this.getCurrentTimeStampFormatted() + ", "
                    + "host: " + getHostName() + ", "
                    + "MDPC version: " + Const.VERSION
                    + " -->";

            printWriter.println(footer);
        }

        this.stringList = new ArrayList<>();
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
