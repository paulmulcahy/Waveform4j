package ca.pmulcahy.waveform4j;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

// TODO: Move CLI App into its own project

@Command(
    mixinStandardHelpOptions = true,
    version = "0.1",
    description = "generates waveform data from WAV format audio files")
public class CommandLineInterfaceApp implements Callable<Integer> {
  @Spec CommandSpec spec;

  @ArgGroup(exclusive = false, multiplicity = "1")
  InputOutput inputOutput;

  @Override
  public Integer call() throws Exception {
    int numThreads = Runtime.getRuntime().availableProcessors();
    WaveformBuilder builder =
        Waveform4j.builder()
            .setExecutorService(Executors.newFixedThreadPool(numThreads))
            .build()
            .newWaveformBuilder();
    builder.setInput(inputOutput.inputFilePath);
    builder.setPixelsPerSecond(zoomLevelPixelsPerSecond);
    String waveformJson = builder.buildJson();

    Files.writeString(
        inputOutput.outputFilePath,
        waveformJson,
        StandardCharsets.UTF_8,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING);

    return 0;
  }

  public static void main(String[] args) {
    int exitCode =
        new CommandLine(new CommandLineInterfaceApp())
            .setCaseInsensitiveEnumValuesAllowed(true)
            .execute(args);
    System.exit(exitCode);
    // System.out.println( "Hello World!" );
  }

  @Option(
      names = "--pixels-per-second",
      defaultValue = "100",
      description = "zoom level (pixels per second)")
  private int zoomLevelPixelsPerSecond;

  static class InputOutput {

    @Option(
        names = {"-i", "--input-filename"},
        required = true,
        description = "input file name (.wav only)")
    private Path inputFilePath;

    @Option(
        names = {"-o", "--output-filename"},
        required = true,
        description = "output file name (.json only)")
    private Path outputFilePath;
  }
}
