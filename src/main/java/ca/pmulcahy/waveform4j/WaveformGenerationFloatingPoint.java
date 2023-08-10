package ca.pmulcahy.waveform4j;


public class WaveformGenerationFloatingPoint {

  public static int[] generateWaveform(
      Options options, int inclusiveStartPixel, int exclusiveEndPixel) {
    int[] pixelData =
        new int[(exclusiveEndPixel - inclusiveStartPixel) * 2 * options.getNumOutputChannels()];
    double[] frameAudioSamples = new double[options.getNumInputChannels()];
    double[] minAndMaxValuesForChannelsInPixel = new double[2 * options.getNumInputChannels()];

    for (int pixelCounter = inclusiveStartPixel; pixelCounter < exclusiveEndPixel; pixelCounter++) {
      int currentPixelByte = pixelCounter * options.getPixelSizeInBytes();

      for (int j = 0; j < minAndMaxValuesForChannelsInPixel.length; j++) {
        minAndMaxValuesForChannelsInPixel[j] = 0;
      }

      for (int frameCounter = 0; frameCounter < options.getFramesPerPixel(); frameCounter++) {
        int currentFrameByte = currentPixelByte + frameCounter * options.getFrameSizeInBytes();
        if (currentFrameByte == options.getAudioBytes().length) {
          break;
        }
        getFloatingPointFrameSamples(options, currentFrameByte, frameAudioSamples);
        updateMinAndMaxValuesForChannelsInPixel(
            minAndMaxValuesForChannelsInPixel, frameAudioSamples, options);
      }
      addPixel(pixelData, minAndMaxValuesForChannelsInPixel, pixelCounter - inclusiveStartPixel);
    }

    return pixelData;
  }

  private static void getFloatingPointFrameSamples(
      Options options, int currentFrameByte, double[] frameAudioSamples) {
    for (int inputChannelCounter = 0;
        inputChannelCounter < options.getNumInputChannels();
        inputChannelCounter++) {
      int currentSampleByte =
          currentFrameByte + inputChannelCounter * options.getSampleSizeInBytes();

      switch (options.getCodec()) {
        case PCM_F32LE:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.fourLittleEndianBytesToDouble(
                  options.getAudioBytes()[currentSampleByte],
                  options.getAudioBytes()[currentSampleByte + 1],
                  options.getAudioBytes()[currentSampleByte + 2],
                  options.getAudioBytes()[currentSampleByte + 3]);
          break;
        case PCM_F64LE:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.eightLittleEndianBytesToDouble(
                  options.getAudioBytes()[currentSampleByte],
                  options.getAudioBytes()[currentSampleByte + 1],
                  options.getAudioBytes()[currentSampleByte + 2],
                  options.getAudioBytes()[currentSampleByte + 3],
                  options.getAudioBytes()[currentSampleByte + 4],
                  options.getAudioBytes()[currentSampleByte + 5],
                  options.getAudioBytes()[currentSampleByte + 6],
                  options.getAudioBytes()[currentSampleByte + 7]);
          break;
        default:
          throw new RuntimeException("Codec not implemented!");
      }
    }
  }

  private static void addPixel(
      int[] pixelData, double[] minAndMaxValuesForChannelsInPixel, int pixelNum) {
    int numChannelsTimesTwo = minAndMaxValuesForChannelsInPixel.length;
    for (int i = 0; i < numChannelsTimesTwo; i++) {
      pixelData[pixelNum * numChannelsTimesTwo + i] =
          (int) (minAndMaxValuesForChannelsInPixel[i] * Short.MAX_VALUE / 256);
    }
  }

  private static void updateMinAndMaxValuesForChannelsInPixel(
      double[] minAndMaxValuesForChannelsInPixel, double[] frameAudioSamples, Options options) {
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
