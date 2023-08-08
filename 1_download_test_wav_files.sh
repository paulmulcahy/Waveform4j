# Gets Test Data For Unit Tests
 
# must have wget installed and on path

cd src/test/resources

mkdir -p testWaveFiles


# Copy Audio
mkdir -p testWaveFiles/copyAudio
cd testWaveFiles/copyAudio

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-Alaw-AFsp.wav -O stereo_alaw.wav
# VLC works
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-AlawWE-AFsp.wav -O waveextensible_stereo_alaw.wav
# VLC works
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-mulawWE-AFsp.wav -O stereo_ulaw.wav
# VLC works
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-mulawWE-AFsp.wav -O waveextensible_stereo_alaw.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-uint8-AFsp.wav -O stereo_unsigned_8bit.wav
# VLC works
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-uint8WE-AFsp.wav -O waveextensible_stereo_unsigned_8bit.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int12-AFsp.wav -O stereo_12bit.wav 
# VLC works 
# Windows Media Player DOES NOT WORK

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int12WE-AFsp.wav -O waveextensible_stereo_12bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int16-AFsp.wav -O stereo_16bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int16WE-AFsp.wav -O waveextensible_stereo_16bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int24-AFsp.wav -O stereo_24bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int24WE-AFsp.wav -O waveextensible_stereo_24bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int32-AFsp.wav -O stereo_32bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-int32WE-AFsp.wav -O waveextensible_stereo_32bit.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float32-AFsp.wav -O stereo_32bitfloat.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float32WE-AFsp.wav -O waveextensible_stereo_32bitfloat.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float32-AFsp.wav -O stereo_32bitfloat.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float32WE-AFsp.wav -O waveextensible_stereo_32bitfloat.wav 
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float64-AFsp.wav -O stereo_64bitfloat.wav 
# VLC works 
# Windows Media Player DOES NOT WORK

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/AFsp/M1F1-float64WE-AFsp.wav -O waveextensible_stereo_64bitfloat.wav 
# VLC works 
# Windows Media Player DOES NOT WORK

cd ../..


#GoldWave
mkdir -p testWaveFiles/goldwave
cd testWaveFiles/goldwave

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Goldwave/addf8-Alaw-GW.wav -O goldwave_alaw.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Goldwave/addf8-mulaw-GW.wav -O goldwave_ulaw.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Goldwave/addf8-mulaw-GW.wav -O goldwave_gsm_compressed.wav
# VLC works 
# Windows Media Player works

cd ../..

#Multi-Channel
mkdir -p testWaveFiles/multichannel
cd testWaveFiles/multichannel

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Microsoft/6_Channel_ID.wav -O six_channel.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Microsoft/8_Channel_ID.wav -O eight_channel.wav
# VLC works 
# Windows Media Player DOES NOT WORK

cd ../..


#Soundcard Attrition
mkdir -p testWaveFiles/soundcardAttrition
cd testWaveFiles/soundcardAttrition

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/SoundCardAttrition/stereol.wav -O longheader_waveextensible_stereo_16bit.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/SoundCardAttrition/stereofl.wav -O longheader_waveextensible_stereo_32bit_float.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/SoundCardAttrition/4ch.wav -O lcrs.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/SoundCardAttrition/drmapan.wav -O drumPannedAmbisonically.wav
# VLC works 
# Windows Media Player works

cd ../..


#Perverse
mkdir -p testWaveFiles/perverse
cd testWaveFiles/perverse
wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Perverse/Pmiscck.wav -O oddLengthIntermediateChunk.wav
# VLC DOES NOT WORK
# Windows Media Player DOES NOT WORK

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Perverse/Ptjunk.wav -O trailingJunkAfterRiff.wav
# VLC DOES NOT WORK
# Windows Media Player DOES NOT WORK

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Perverse/GLASS.WAV -O riffChunkLengthLongerThanFileSize.wav
# VLC works 
# Windows Media Player works

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/Perverse/Utopia%20Critical%20Stop.WAV -O factChunkFollowingData.wav
# VLC DOES NOT WORK
# Windows Media Player DOES NOT WORK

cd ../..

#Other
mkdir -p testWaveFiles/other
cd testWaveFiles/other

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/CCRMA/voxware.wav -O formatCode0x181C.wav
# VLC DOES NOT WORK
# Windows Media Player DOES NOT WORK

wget -nc https://www.mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/Samples/CCRMA/truspech.wav -O formatCode0x0022.wav
# VLC works 
# Windows Media Player DOES NOT WORK

cd ../../../../..