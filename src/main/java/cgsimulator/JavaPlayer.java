package cgsimulator;

import java.io.*;

public class JavaPlayer implements GameSimulator.GamePlayer {

    private static final String SOLUTIONS_PATH = "";//TODO set PlayerSolution directory

    private final Process playerProcess;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public JavaPlayer(String playerFileName) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", playerFileName);
        processBuilder.directory(new File(SOLUTIONS_PATH));
        playerProcess = processBuilder.start();

        InputStream stdout = playerProcess.getInputStream();
        OutputStream stdin = playerProcess.getOutputStream();

        reader = new BufferedReader(new InputStreamReader(stdout));
        writer = new BufferedWriter(new OutputStreamWriter(stdin));
    }

    @Override
    public void initialize(String initInput) throws IOException {
        writeToProcess(initInput);
    }

    @Override
    public void setInput(String input) throws IOException {
        writeToProcess(input);
    }

    private void writeToProcess(String input) throws IOException {
        writer.write(input);
        writer.write("\n");
        writer.flush();
    }

    @Override
    public String getOutput() throws IOException {
        return reader.readLine();
    }
}
