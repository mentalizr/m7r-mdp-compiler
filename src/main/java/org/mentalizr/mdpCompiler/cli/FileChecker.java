package org.mentalizr.mdpCompiler.cli;

import java.io.File;

public class FileChecker {

    public static File assertMdpFile(String file) throws FileSystemCheckerException {

        File mdpFile = new File(file);
        if (!mdpFile.getAbsolutePath().endsWith(".mdp"))
            throw new FileSystemCheckerException("[" + mdpFile.getAbsolutePath() + "] is no .mdp file.");
        if (!mdpFile.exists() || !mdpFile.isFile()) throw new FileSystemCheckerException("[" + mdpFile.getAbsolutePath() + "] does not exist.");

        return mdpFile;
    }

    public static File assertMdpProgramDir(String file) throws FileSystemCheckerException {

        File mdpFile = new File(file);
        if (!mdpFile.exists() || !mdpFile.isDirectory()) throw new FileSystemCheckerException("[" + mdpFile.getAbsolutePath() + "] is no mdp program directory: not existing.");

        // TODO Prüfung durch Consistency-Check ersetzen
        File programConfFile = new File(file, "program.conf");
        if (!programConfFile.exists()) throw new FileSystemCheckerException("[" + mdpFile.getAbsolutePath() + "] is not program directory: not a valid mdp program directory.");

        return mdpFile;
    }

}
