package ca.pmulcahy.waveform4j;

import com.google.gson.annotations.SerializedName;

public class Waveform {
  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getChannels() {
    return channels;
  }

  public void setChannels(int channels) {
    this.channels = channels;
  }

  public float getSampleRate() {
    return sampleRate;
  }

  public void setSampleRate(float sampleRate) {
    this.sampleRate = (int) sampleRate;
  }

  public int getSamplesPerPixel() {
    return samplesPerPixel;
  }

  public void setSamplesPerPixel(int samplesPerPixel) {
    this.samplesPerPixel = samplesPerPixel;
  }

  public int getBits() {
    return bits;
  }

  public void setBits(int bits) {
    this.bits = bits;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int[] getData() {
    return data;
  }

  public void setData(int[] data) {
    this.data = data;
  }

  private int version;
  private int channels;

  @SerializedName("sample_rate")
  private int sampleRate;

  @SerializedName("samples_per_pixel")
  private int samplesPerPixel;

  private int bits;
  private int length;
  private int[] data;
}
