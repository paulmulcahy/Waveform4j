package ca.pmulcahy.waveform4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Concurrency {

  public static int[] generateWaveform(Options options) {
    ExecutorService executorService = options.getWaveform4j().getExecutorService();

    int minPixelsPerThread = options.getNumPixels() / options.getNumThreads();
    int numThreadsWithBonusPixel = options.getNumPixels() % options.getNumThreads();

    List<Callable<int[]>> tasks = new ArrayList<>();

    for (int i = 0; i < options.getNumThreads(); i++) {
      int inclusiveStartPixel = i * minPixelsPerThread + Math.min(i, numThreadsWithBonusPixel);
      int exclusiveEndPixel =
          1 + (i + 1) * minPixelsPerThread + Math.min((i + 1), numThreadsWithBonusPixel) - 1;
      tasks.add(
          () ->
              WaveformGeneration.generateWaveform(options, inclusiveStartPixel, exclusiveEndPixel));
    }

    try {
      List<Future<int[]>> futureResults = executorService.invokeAll(tasks);
      int[] currentResults =
          futureResults.stream()
              .flatMapToInt(
                  future -> {
                    try {
                      return Arrays.stream(future.get());
                    } catch (InterruptedException | ExecutionException exception) {
                      throw new RuntimeException(exception);
                    }
                  })
              .toArray();
      return currentResults;
    } catch (InterruptedException e) {
      System.out.println(e);
      throw new RuntimeException(e);
    }
  }
}
