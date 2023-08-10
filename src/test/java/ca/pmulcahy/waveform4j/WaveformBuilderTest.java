package ca.pmulcahy.waveform4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Unit test for simple App. */
public class WaveformBuilderTest {

  int numThreads = Runtime.getRuntime().availableProcessors();
  Waveform4j concurrentWaveform4j =
      Waveform4j.builder().setExecutorService(Executors.newFixedThreadPool(numThreads)).build();

  @Test
  public void concurrentStereoUnsigned8BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get("src/test/resources/testWaveFiles/copyAudio/stereo_unsigned_8bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/stereo_unsigned_8bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentExtensibleStereoUnsigned8BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get(
            "src/test/resources/testWaveFiles/copyAudio/waveextensible_stereo_unsigned_8bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/waveextensible_stereo_unsigned_8bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentStereoSigned16BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav = Paths.get("src/test/resources/testWaveFiles/copyAudio/stereo_16bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/stereo_16bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentExtensibleStereoSigned16BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get("src/test/resources/testWaveFiles/copyAudio/waveextensible_stereo_16bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/waveextensible_stereo_16bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentStereoSigned24BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav = Paths.get("src/test/resources/testWaveFiles/copyAudio/stereo_24bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/stereo_24bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentExtensibleStereoSigned24BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get("src/test/resources/testWaveFiles/copyAudio/waveextensible_stereo_24bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/waveextensible_stereo_24bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentStereoSigned32BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav = Paths.get("src/test/resources/testWaveFiles/copyAudio/stereo_32bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/stereo_32bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  public void concurrentExtensibleStereoSigned32BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get("src/test/resources/testWaveFiles/copyAudio/waveextensible_stereo_32bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = concurrentWaveform4j.newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    builder.setNumThreads(4);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }
}
