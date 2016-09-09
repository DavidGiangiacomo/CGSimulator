package cgsimulator;

import java.io.*;

public class JavaPlayer implements GameSimulator.GamePlayer {

    private final Process playerProcess;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public JavaPlayer(final String playerFileName) throws IOException {
        // TODO:Java executable need to be given at the execute time (in 1 arg or 2 args)
        final ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", playerFileName);
        playerProcess = processBuilder.start();

        final InputStream stdout = playerProcess.getInputStream();
        final OutputStream stdin = playerProcess.getOutputStream();

        reader = new BufferedReader(new InputStreamReader(stdout));
        writer = new BufferedWriter(new OutputStreamWriter(stdin));
    }

    @Override
    public void initialize(final String initInput) throws IOException {
        writeToProcess(initInput);
    }

    @Override
    public void setInput(final String input) throws IOException {
        writeToProcess(input);
    }

    private void writeToProcess(final String input) throws IOException {
        writer.write(input);
        writer.write("\n");
        // writer.flush();
    }

    @Override
    public String getOutput() throws IOException {
        return reader.readLine();
    }
}
