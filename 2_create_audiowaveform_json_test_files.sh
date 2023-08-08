# must have audiowaveform installed and on path
# must have already downloaded test wave files

cd src/test/resources

mkdir -p testAudiowaveformFiles

# Copy Audio
mkdir -p testAudiowaveformFiles/copyAudio
audiowaveform -i testWaveFiles/copyAudio/stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/stereo_alaw_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/stereo_alaw_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_alaw_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_alaw_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_ulaw.wav -o testAudiowaveformFiles/copyAudio/stereo_ulaw_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_ulaw.wav -o testAudiowaveformFiles/copyAudio/stereo_ulaw_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_alaw_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_alaw.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_alaw_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_unsigned_8bit.wav -o testAudiowaveformFiles/copyAudio/stereo_unsigned_8bit_pps100_bits8.json --bits 8 --pixels-per-second 100 --split-channels
audiowaveform -i testWaveFiles/copyAudio/stereo_unsigned_8bit.wav -o testAudiowaveformFiles/copyAudio/stereo_unsigned_8bit_pps100_bits16.json --pixels-per-second 100 --split-channels
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_unsigned_8bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_unsigned_8bit_pps100_bits8.json --bits 8 --pixels-per-second 100 --split-channels
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_unsigned_8bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_unsigned_8bit_pps100_bits16.json --pixels-per-second 100 --split-channels
audiowaveform -i testWaveFiles/copyAudio/stereo_12bit.wav -o testAudiowaveformFiles/copyAudio/stereo_12bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_12bit.wav -o testAudiowaveformFiles/copyAudio/stereo_12bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_12bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_12bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_12bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_12bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_16bit.wav -o testAudiowaveformFiles/copyAudio/stereo_16bit_pps100_bits8.json --bits 8 
audiowaveform -i testWaveFiles/copyAudio/stereo_16bit.wav -o testAudiowaveformFiles/copyAudio/stereo_16bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_16bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_16bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_16bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_16bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_24bit.wav -o testAudiowaveformFiles/copyAudio/stereo_24bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_24bit.wav -o testAudiowaveformFiles/copyAudio/stereo_24bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_24bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_24bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_24bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_24bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_32bit.wav -o testAudiowaveformFiles/copyAudio/stereo_32bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_32bit.wav -o testAudiowaveformFiles/copyAudio/stereo_32bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bit_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bit.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bit_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/stereo_32bitfloat_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/stereo_32bitfloat_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bitfloat_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bitfloat_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/stereo_32bitfloat_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_32bitfloat.wav -o testAudiowaveformFiles/copyAudio/stereo_32bitfloat_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bitfloat.wav  -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bitfloat_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_32bitfloat.wav  -o testAudiowaveformFiles/copyAudio/waveextensible_stereo_32bitfloat_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/stereo_64bitfloat.wav  -o testAudiowaveformFiles/copyAudio/stereo_64bitfloat_pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/stereo_64bitfloat.wav  -o testAudiowaveformFiles/copyAudio/stereo_64bitfloat_pps100_bits16.json
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_64bitfloat.wav   -o testAudiowaveformFiles/copyAudio/waveextensible_stereo__pps100_bits8.json --bits 8
audiowaveform -i testWaveFiles/copyAudio/waveextensible_stereo_64bitfloat.wav   -o testAudiowaveformFiles/copyAudio/waveextensible_stereo__pps100_bits16.json

#GoldWave
mkdir -p testAudiowaveformFiles/goldwave

audiowaveform -i testWaveFiles/goldwave/goldwave_alaw.wav -o testAudiowaveformFiles/goldwave/goldwave_alaw_pps100_bits16.json
audiowaveform -i testWaveFiles/goldwave/goldwave_ulaw.wav -o testAudiowaveformFiles/goldwave/goldwave_ulaw_pps100_bits16.json
audiowaveform -i testWaveFiles/goldwave/goldwave_gsm_compressed.wav -o testAudiowaveformFiles/goldwave/goldwave_gsm_compressed_pps100_bits16.json


#Multi-Channel
mkdir -p testAudiowaveformFiles/multichannel

audiowaveform -i testWaveFiles/multichannel/six_channel.wav -o testAudiowaveformFiles/multichannel/six_channel_pps100_bits16.json
audiowaveform -i testWaveFiles/multichannel/six_channel.wav -o testAudiowaveformFiles/multichannel/six_channel_pps100_bits16.json

#Soundcard Attrition
mkdir -p testAudiowaveformFiles/soundcardAttrition

audiowaveform -i testWaveFiles/soundcardAttrition/longheader_waveextensible_stereo_16bit.wav -o testAudiowaveformFiles/soundcardAttrition/longheader_waveextensible_stereo_16bit_pps100_bits16.json
audiowaveform -i testWaveFiles/soundcardAttrition/longheader_waveextensible_stereo_32bit_float.wav -o testAudiowaveformFiles/soundcardAttrition/longheader_waveextensible_stereo_32bit_float_pps100_bits16.json
audiowaveform -i testWaveFiles/soundcardAttrition/lcrs.wav -o testAudiowaveformFiles/soundcardAttrition/lcrs_pps100_bits16.json
audiowaveform -i testWaveFiles/soundcardAttrition/drumPannedAmbisonically.wav -o testAudiowaveformFiles/soundcardAttrition/drumPannedAmbisonically_pps100_bits16.json


#Perverse
mkdir -p testAudiowaveformFiles/perverse

audiowaveform -i testWaveFiles/perverse/oddLengthIntermediateChunk.wav -o testAudiowaveformFiles/perverse/oddLengthIntermediateChunk_pps100_bits16.json
audiowaveform -i testWaveFiles/perverse/trailingJunkAfterRiff.wav -o testAudiowaveformFiles/perverse/trailingJunkAfterRiff_pps100_bits16.json
audiowaveform -i testWaveFiles/perverse/riffChunkLengthLongerThanFileSize.wav -o testAudiowaveformFiles/perverse/riffChunkLengthLongerThanFileSize_pps100_bits16.json
audiowaveform -i testWaveFiles/perverse/factChunkFollowingData.wav -o testAudiowaveformFiles/perverse/factChunkFollowingData_pps100_bits16.json


#Other
mkdir -p testAudiowaveformFiles/other

audiowaveform -i testWaveFiles/other/formatCode0x181C.wav -o testAudiowaveformFiles/other/formatCode0x181C_pps100_bits16.json
# Audiowaveform DOES NOT WORK


audiowaveform -i testWaveFiles/other/formatCode0x0022.wav -o testAudiowaveformFiles/other/formatCode0x0022_pps100_bits16.json
# Audiowaveform DOES NOT WORK

cd ../../..