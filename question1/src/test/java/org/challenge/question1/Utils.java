package org.challenge.question1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class build a java.lang.Process that run another class (which have a main method) as a subprocess
// credits: https://lankydan.dev/running-a-java-class-as-a-subprocess
class JavaProcess {

    private JavaProcess() {
    }

    public static ProcessBuilder exec(Class<?> clazz) {
        final List<String> args = Collections.emptyList();
        return JavaProcess.exec(clazz, args);
    }
    public static ProcessBuilder exec(Class<?> clazz, List<String> args) {
        final List<String> jvmArgs = Collections.emptyList();
        return JavaProcess.exec(clazz, jvmArgs, args);
    }
    public static ProcessBuilder exec(Class<?> clazz, List<String> jvmArgs, List<String> args) {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = clazz.getName();

        List<String> command = new ArrayList<>();
        command.add(javaBin);
        command.addAll(jvmArgs);
        command.add("-cp");
        command.add(classpath);
        command.add(className);
        command.addAll(args);

        return new ProcessBuilder(command);
    }
}
