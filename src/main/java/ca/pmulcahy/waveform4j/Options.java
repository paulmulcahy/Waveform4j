package ca.pmulcahy.waveform4j;

import ca.pmulcahy.waveform4j.enums.Codec;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Options {

  public int getNumInputChannels() {
    return numInputChannels;
  }

  public byte[] getAudioBytes() {
    return audioBytes;
  }

  public long getNumFrames() {
    return numFrames;
  }

  public long getNumSamples() {
    return numSamples;
  }

  public Codec getCodec() {
    return codec;
  }

  public Waveform4j getWaveform4j() {
    return waveform4j;
  }

  public int getNumOutputChannels() {
    return numOutputChannels;
  }

  public int getPixelsPerSecond() {
    return pixelsPerSecond;
  }

  public int getFramesPerPixel() {
    return framesPerPixel;
  }

  public int getPixelSizeInBytes() {
    return pixelSizeInBytes;
  }

  public int getFrameSizeInBytes() {
    return frameSizeInBytes;
  }

  public int getSampleSizeInBytes() {
    return sampleSizeInBytes;
  }

  public int getNumPixels() {
    return numPixels;
  }

  public int getSamplesPerPixel() {
    return samplesPerPixel;
  }

  public float getSamplesPerSecond() {
    return samplesPerSecond;
  }

  public float getFramesPerSecond() {
    return framesPerSecond;
  }

  public int getNumThreads() {
    return numThreads;
  }

  private final int numInputChannels;
  private final byte[] audioBytes;
  private final long numFrames;
  private final long numSamples;
  private final Codec codec;
  private final Waveform4j waveform4j;
  private final int numOutputChannels;
  private final int pixelsPerSecond;
  private final int framesPerPixel;
  private final int pixelSizeInBytes;
  private final int
      frameSizeInBytes; // Frame = 1 sample from each channel (PCM). Frame Size = Sample size *
  // Channels
  private final int sampleSizeInBytes;
  private final int numPixels;
  private final int samplesPerPixel;

  // For PCM the sample rate and the frame rate are the same since a frame consists of a sample from
  // each channel
  private final float samplesPerSecond; // Sample Rate = # of samples / second
  private final float framesPerSecond; // Frame Rate = # of frames / second

  private final int numThreads;

  public Options(WaveformBuilder builder) throws UnsupportedAudioFileException, IOException {
    try (AudioInputStream audioInputStream =
        AudioSystem.getAudioInputStream(builder.getInputFilePath /*Stream*/().toFile())) {
      final AudioFormat audioFormat = audioInputStream.getFormat();
      codec = getCodec(audioFormat);
      numInputChannels = audioFormat.getChannels();
      framesPerSecond = audioFormat.getFrameRate();
      samplesPerSecond = audioFormat.getSampleRate();
      numFrames = audioInputStream.getFrameLength();
      frameSizeInBytes = audioFormat.getFrameSize();
      sampleSizeInBytes = audioFormat.getSampleSizeInBits() / 8;
      audioBytes =
          new byte
              [(int)
                  (numFrames
                      * numInputChannels
                      * sampleSizeInBytes)]; // Number of bytes needed equals number of frames times
      // number of channels (per frame) times number of bytes
      // (per channel)
      audioInputStream.read(audioBytes);
      audioInputStream.close();
    } finally {
      // builder.getInputStream().close();
    }
    if (numFrames > Integer.MAX_VALUE) {
      throw new RuntimeException("File too big");
    }

    numOutputChannels = numInputChannels;
    this.waveform4j = builder.getWaveform4j();
    this.pixelsPerSecond = builder.getPixelsPerSecond();
    this.samplesPerPixel = (int) (samplesPerSecond / pixelsPerSecond);
    this.framesPerPixel = (int) (framesPerSecond / pixelsPerSecond);
    this.numPixels = (int) Math.ceil((double) numFrames / framesPerPixel);
    this.numSamples = numFrames * numInputChannels;
    this.pixelSizeInBytes = frameSizeInBytes * framesPerPixel;
    this.numThreads = Runtime.getRuntime().availableProcessors();
    // System.out.println(toString());
  }

  public static Codec getCodec(AudioFormat audioFormat) {
    if (audioFormat.getEncoding() == AudioFormat.Encoding.PCM_UNSIGNED
        && audioFormat.getSampleSizeInBits() == 8) {
      return Codec.PCM_U8;
    }

    // TODO: Add other Codecs

    throw new RuntimeException("Codec Not Supported");
  }

  // For debugging purposes
  @Override
  public String toString() {
    return new StringBuilder()
        .append("numInputChannels = ")
        .append(numInputChannels)
        .append("\nnumFrames = ")
        .append(numFrames)
        .append("\nnumSamples = ")
        .append(numSamples)
        .append("\ncodec = ")
        .append(codec)
        .append("\nnumOutputChannels = ")
        .append(numOutputChannels)
        .append("\npixelsPerSecond = ")
        .append(pixelsPerSecond)
        .append("\nframesPerPixel = ")
        .append(framesPerPixel)
        .append("\npixelSizeInBytes = ")
        .append(pixelSizeInBytes)
        .append("\nframeSizeInBytes = ")
        .append(frameSizeInBytes)
        .append("\nsampleSizeInBytes = ")
        .append(sampleSizeInBytes)
        .append("\nnumPixels = ")
        .append(numPixels)
        .append("\nsamplesPerPixel = ")
        .append(samplesPerPixel)
        .append("\nsamplesPerSecond = ")
        .append(samplesPerSecond)
        .append("\nframesPerSecond = ")
        .append(framesPerSecond)
        .append("\nnumThreads = ")
        .append(numThreads)
        .toString();
  }
}
