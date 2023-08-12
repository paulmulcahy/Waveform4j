package ca.pmulcahy.waveform4j;

import ca.pmulcahy.waveform4j.enums.Codec;

public class WaveformGeneration {

  public static int[] generateWaveform(
      int[] pixelData, Options options, int inclusiveStartPixel, int exclusiveEndPixel) {
    int[] frameAudioSamples = new int[options.getNumInputChannels()];
    int[] minAndMaxValuesForChannelsInPixel = new int[2 * options.getNumInputChannels()];

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
        getIntFrameSamples(options, currentFrameByte, frameAudioSamples);
        updateMinAndMaxValuesForChannelsInPixel(
            minAndMaxValuesForChannelsInPixel, frameAudioSamples, options);
      }
      addPixel(pixelData, minAndMaxValuesForChannelsInPixel, pixelCounter);
      adjustPixel(
          pixelData, minAndMaxValuesForChannelsInPixel.length, pixelCounter, options.getCodec());
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

      switch (options.getCodec()) {
        case PCM_U8:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.unsignedByteToSignedInt(options.getAudioBytes()[currentSampleByte]);
          break;
        case PCM_S16LE:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.signedTwoLittleEndianBytesToInt(
                  options.getAudioBytes()[currentSampleByte],
                  options.getAudioBytes()[currentSampleByte + 1]);
          break;
        case PCM_S24LE:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.signedThreeLittleEndianBytesToInt(
                  options.getAudioBytes()[currentSampleByte],
                  options.getAudioBytes()[currentSampleByte + 1],
                  options.getAudioBytes()[currentSampleByte + 2]);
          break;
        case PCM_S32LE:
          frameAudioSamples[inputChannelCounter] =
              BitConverter.signedFourLittleEndianBytesToInt(
                  options.getAudioBytes()[currentSampleByte],
                  options.getAudioBytes()[currentSampleByte + 1],
                  options.getAudioBytes()[currentSampleByte + 2],
                  options.getAudioBytes()[currentSampleByte + 3]);
          break;
        default:
          throw new RuntimeException("Codec not implemented!");
      }
    }
  }

  private static void addPixel(
      int[] pixelData, int[] minAndMaxValuesForChannelsInPixel, int pixelNum) {
    int numChannelsTimesTwo = minAndMaxValuesForChannelsInPixel.length;
    for (int i = 0; i < numChannelsTimesTwo; i++) {
      pixelData[pixelNum * numChannelsTimesTwo + i] = minAndMaxValuesForChannelsInPixel[i];
    }
  }

  private static void adjustPixel(
      int[] pixelData, int numChannelsTimesTwo, int pixelNum, Codec codec) {
    switch (codec) {
      case PCM_U8:
        break;
      case PCM_S16LE:
        for (int i = 0; i < numChannelsTimesTwo; i++) {
          int sixteenBit = pixelData[pixelNum * numChannelsTimesTwo + i];
          int eightBit = sixteenBit / 256;
          pixelData[pixelNum * numChannelsTimesTwo + i] = eightBit;
        }
        break;
      case PCM_S24LE:
        for (int i = 0; i < numChannelsTimesTwo; i++) {
          int twentyFourBit = pixelData[pixelNum * numChannelsTimesTwo + i];
          int eightBit = twentyFourBit / 65536;
          pixelData[pixelNum * numChannelsTimesTwo + i] = eightBit;
        }
        break;
      case PCM_S32LE:
        for (int i = 0; i < numChannelsTimesTwo; i++) {
          int twentyFourBit = pixelData[pixelNum * numChannelsTimesTwo + i];
          int eightBit = twentyFourBit / 16777216;
          pixelData[pixelNum * numChannelsTimesTwo + i] = eightBit;
        }
        break;
      default:
        throw new RuntimeException("Codec not implemented!");
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
