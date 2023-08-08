package ca.pmulcahy.waveform4j;

import java.util.concurrent.ExecutorService;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;

public class Waveform4j {
	
	private ExecutorService executorService;
	private Logger logger;
	
	private Waveform4j() {};
	
	public static Builder builder() {
		return new Builder();
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
	public WaveformBuilder newWaveformBuilder() {
		return new WaveformBuilder(this);
	}
	
	public static class Builder {
		
		private Builder() {};
		
		private ExecutorService executorService;
		private Logger logger = NOPLogger.NOP_LOGGER;
		
		public Builder setExecutorService(ExecutorService executorService) {
			this.executorService = executorService;
			return this;
		}
		
		public Builder setLogger(Logger logger) {
			this.logger = logger;
			return this;
		}
		
		public Waveform4j build() {
			final Waveform4j waveform4j = new Waveform4j();
			waveform4j.executorService = this.executorService;
			waveform4j.logger = this.logger;
			return waveform4j;
		}
	}
}
