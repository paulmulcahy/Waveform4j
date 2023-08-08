package ca.pmulcahy.waveform4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Unit test for simple App. */
public class WaveformBuilderTest {

  @Test
  public void stereoUnsigned8BitPixelsPerSecond100Bits8()
      throws IOException, UnsupportedAudioFileException {
    Path inputWav =
        Paths.get("src/test/resources/testWaveFiles/copyAudio/stereo_unsigned_8bit.wav");
    Path expectedJson =
        Paths.get(
            "src/test/resources/testAudiowaveformFiles/copyAudio/stereo_unsigned_8bit_pps100_bits8.json");
    String expectedString = Files.readAllLines(expectedJson).get(0);

    WaveformBuilder builder = Waveform4j.builder().build().newWaveformBuilder();
    builder.setInput(inputWav);
    builder.setPixelsPerSecond(100);
    String actualString = builder.buildJson();

    Assertions.assertEquals(expectedString, actualString);
  }
}
