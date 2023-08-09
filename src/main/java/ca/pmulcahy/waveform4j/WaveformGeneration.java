package ca.pmulcahy.waveform4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class WaveformGeneration {

  public static int[] generateWaveform(Options options) {
    ExecutorService executorService = options.getWaveform4j().getExecutorService();

    int minPixelsPerThread = options.getNumPixels() / options.getNumThreads();
    int numThreadsWithBonusPixel = options.getNumPixels() % options.getNumThreads();

    List<Callable<int[]>> tasks = new ArrayList<>();

    for (int i = 0; i < options.getNumThreads(); i++) {
      int inclusiveStartPixel = i * minPixelsPerThread + Math.min(i + 1, numThreadsWithBonusPixel);
      int exclusiveEndPixel =
          (i + 1) * minPixelsPerThread + Math.min((i + 1) + 1, numThreadsWithBonusPixel) - 1;
      tasks.add(() -> generateWaveform(options, inclusiveStartPixel, exclusiveEndPixel));
    }

    try {
      List<Future<int[]>> futureResults = executorService.invokeAll(tasks);
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
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    return generateWaveform(options, 0, options.getNumPixels());
  }

  public static int[] generateWaveform(
      Options options, int inclusiveStartPixel, int exclusiveEndPixel) {
    int[] pixelData = new int[options.getNumPixels() * 2 * options.getNumOutputChannels()];
    int[] frameAudioSamples = new int[options.getNumInputChannels()];
    int[] minAndMaxValuesForChannelsInPixel = new int[2 * options.getNumInputChannels()];

    for (int pixelCounter = 0; pixelCounter < options.getNumPixels(); pixelCounter++) {
      int currentPixelByte = pixelCounter * options.getPixelSizeInBytes();

      for (int j = 0; j < minAndMaxValuesForChannelsInPixel.length; j++) {
        minAndMaxValuesForChannelsInPixel[j] = 0;
      }

      for (int frameCounter = 0; frameCounter < options.getFramesPerPixel(); frameCounter++) {
        int currentFrameByte = currentPixelByte + frameCounter * options.getFrameSizeInBytes();
        if (currentFrameByte == options.getAudioBytes().length) {
          break;
        }
        getIntFrameSamples(options, currentFrameByte, frameAudioSamples);
        updateMinAndMaxValuesForChannelsInPixel(
            minAndMaxValuesForChannelsInPixel, frameAudioSamples, options);
      }
      addPixel(pixelData, minAndMaxValuesForChannelsInPixel, pixelCounter);
    }

    return pixelData;
  }

  private static void getIntFrameSamples(
      Options options, int currentFrameByte, int[] frameAudioSamples) {
    for (int inputChannelCounter = 0;
        inputChannelCounter < options.getNumInputChannels();
        inputChannelCounter++) {
      int currentSampleByte =
          currentFrameByte + inputChannelCounter * options.getSampleSizeInBytes();
      frameAudioSamples[inputChannelCounter] =
          BitConverter.unsignedByteToSignedInt(options.getAudioBytes()[currentSampleByte]);
    }
  }

  private static void addPixel(
      int[] pixelData, int[] minAndMaxValuesForChannelsInPixel, int pixelNum) {
    int numChannelsTimesTwo = minAndMaxValuesForChannelsInPixel.length;
    for (int i = 0; i < numChannelsTimesTwo; i++) {
      pixelData[pixelNum * numChannelsTimesTwo + i] = minAndMaxValuesForChannelsInPixel[i];
    }
  }

  private static void updateMinAndMaxValuesForChannelsInPixel(
      int[] minAndMaxValuesForChannelsInPixel, int[] frameAudioSamples, Options options) {
    for (int inputChannelCounter = 0;
        inputChannelCounter < options.getNumInputChannels();
        inputChannelCounter++) {
      if (frameAudioSamples[inputChannelCounter]
          < minAndMaxValuesForChannelsInPixel[2 * inputChannelCounter]) {
        minAndMaxValuesForChannelsInPixel[2 * inputChannelCounter] =
            frameAudioSamples[inputChannelCounter];
      }
      if (frameAudioSamples[inputChannelCounter]
          > minAndMaxValuesForChannelsInPixel[2 * inputChannelCounter + 1]) {
        minAndMaxValuesForChannelsInPixel[2 * inputChannelCounter + 1] =
            frameAudioSamples[inputChannelCounter];
      }
    }
  }
}
