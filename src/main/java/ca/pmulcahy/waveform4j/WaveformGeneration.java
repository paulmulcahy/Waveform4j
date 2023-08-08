package ca.pmulcahy.waveform4j;

public class WaveformGeneration {

  public static int[] generateWaveform(Options options) {
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
