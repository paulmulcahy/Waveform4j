package ca.pmulcahy.waveform4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.sound.sampled.AudioFormat;

public class Concurrency {

  public static int[] generateWaveform(Options options) {
    ExecutorService executorService = options.getWaveform4j().getExecutorService();

    int minPixelsPerThread = options.getNumPixels() / options.getNumThreads();
    int numThreadsWithBonusPixel = options.getNumPixels() % options.getNumThreads();

    int[] pixelData = new int[options.getNumPixels() * 2 * options.getNumOutputChannels()];

    List<Callable<int[]>> tasks = new ArrayList<>();

    if (AudioFormat.Encoding.PCM_SIGNED.equals(options.getEncoding())
        || AudioFormat.Encoding.PCM_UNSIGNED.equals(options.getEncoding())) {
      for (int i = 0; i < options.getNumThreads(); i++) {
        int inclusiveStartPixel = i * minPixelsPerThread + Math.min(i, numThreadsWithBonusPixel);
        int exclusiveEndPixel =
            1 + (i + 1) * minPixelsPerThread + Math.min((i + 1), numThreadsWithBonusPixel) - 1;
        tasks.add(
            () ->
                WaveformGeneration.generateWaveform(
                    pixelData, options, inclusiveStartPixel, exclusiveEndPixel));
      }
    } else {
      for (int i = 0; i < options.getNumThreads(); i++) {
        int inclusiveStartPixel = i * minPixelsPerThread + Math.min(i, numThreadsWithBonusPixel);
        int exclusiveEndPixel =
            1 + (i + 1) * minPixelsPerThread + Math.min((i + 1), numThreadsWithBonusPixel) - 1;
        tasks.add(
            () ->
                WaveformGenerationFloatingPoint.generateWaveform(
                    pixelData, options, inclusiveStartPixel, exclusiveEndPixel));
      }
    }
    try {
      List<Future<int[]>> futures = executorService.invokeAll(tasks);
      for (Future<int[]> future : futures) {
        future.get();
      }
      return pixelData;
    } catch (InterruptedException | ExecutionException exception) {
      throw new RuntimeException(exception);
    }
  }
}
