package ca.pmulcahy.waveform4j;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Path;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WaveformBuilder {

  public WaveformBuilder(Waveform4j waveform4j) {
    this.waveform4j = waveform4j;
  }

  private Waveform4j waveform4j;

  // private InputStream inputStream;
  private int pixelsPerSecond;

  private Path inputFilePath;

  // TODO: there is a bug when AudioInputStream is created from an InputStream
  // TODO: overload setInput to accept byte array, use audioinputstream to find delta to first
  // frame, and make WaveformGenerator use delta

  public WaveformBuilder setInput(Path inputFilePath) throws IOException {
    this.inputFilePath = inputFilePath;
    // this.inputStream = null;
    // this.inputStream = Files.newInputStream(inputFilePath, StandardOpenOption.READ);
    return this;
  }

  /*public WaveformBuilder setInput(InputStream inputStream) {
  	this.inputStream = inputStream;
  	//this.inputFilePath = null;
  	return this;
  }*/

  public WaveformBuilder setPixelsPerSecond(int pixelsPerSecond) {
    this.pixelsPerSecond = pixelsPerSecond;
    return this;
  }

  public int getPixelsPerSecond() {
    return pixelsPerSecond;
  }

  /*public InputStream getInputStream() {
  	return inputStream;
  }*/

  public Waveform4j getWaveform4j() {
    return waveform4j;
  }

  public Path getInputFilePath() {
    return inputFilePath;
  }

  public Waveform build() throws UnsupportedAudioFileException, IOException {
    Options options = new Options(this);
    Waveform waveform = new Waveform();
    waveform.setBits(8);
    waveform.setChannels(options.getNumInputChannels());
    waveform.setData(Concurrency.generateWaveform(options));
    waveform.setLength(options.getNumPixels());
    waveform.setSampleRate(options.getSamplesPerSecond());
    waveform.setSamplesPerPixel(options.getSamplesPerPixel());
    waveform.setVersion(2);
    return waveform;
  }

  public String buildJson() throws UnsupportedAudioFileException, IOException {
    Waveform waveform = build();
    String json = new Gson().toJson(waveform);
    return json;
  }
}
